package com.enjoy.controller;

import com.enjoy.entity.Image;
import com.enjoy.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/images")
public class ImageController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadPage(@RequestParam("file") MultipartFile file, Model model) {
        String filename = UUID.randomUUID().toString();
        Path path = Paths.get(UPLOAD_DIR + filename + ".jpg");
        try {
            Files.createDirectories(path.getParent());
            file.transferTo(path);
            filename = filename + ".jpg";
            Image image = new Image();
            image.setFilename(filename);
            image.setUploadTime(LocalDateTime.now());
            image.setExpirationTime(LocalDateTime.now().plusMinutes(1));
            Image save = imageRepository.save(image);
            model.addAttribute("message", "Image_Uploaded_SuccessFully");
            model.addAttribute("imageUrl", UPLOAD_DIR + filename);
            model.addAttribute("imageId", save.getId());
        } catch (IOException e) {
            model.addAttribute("message", "Failed  to  upload  image:" + e.getMessage());
        }
        return "upload";
    }

    @PostMapping("/burn/{id}")
    public ResponseEntity<String> burnImage(@PathVariable Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            Path path = Paths.get("uploads/" + image.getFilename());
            try {
                Files.deleteIfExists(path);
                imageRepository.delete(image);
                return ResponseEntity.ok("Image  burned  successfully");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed  to  burn  image");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image  not  found");
    }

    @GetMapping("/uploads")
    public byte[] getImage(@PathVariable("id") String id) {
        System.out.println(id);
        return null;
    }

}
