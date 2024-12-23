package com.enjoy;

import com.enjoy.entity.Image;
import com.enjoy.repository.ImageRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class JpaTest {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void test(){
        List<Image> all = imageRepository.findAll();
        System.out.println(all);
    }
}
