package com.enjoy.demo;

import com.enjoy.entity.Image;
import com.enjoy.enums.ImageType;

import java.io.IOException;
import java.lang.reflect.Field;

public class MyReflectionUtils {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, IOException {
        Class<Image> imageClass = Image.class;
        Field field = imageClass.getDeclaredField("imageType");
        Image image = new Image();
        field.setAccessible(true);
        field.set(image, ImageType.valueOf("PNG"));
        System.out.println(image);
        ImageType imageType = ImageType.valueOf("PNG");
    }
}
