package com.cloud.kitchen.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;


@Service
public class FileService {

    public String saveImage(MultipartFile imageFile, String uploadDirectory) throws IOException, java.io.IOException {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = timestamp + "_" + imageFile.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDirectory, filename);
            Files.write(uploadPath, imageFile.getBytes());
            String newPath = uploadPath.toString().split("static")[1];
            return newPath;
        } catch (IOException e) {
            // Handle file-related IO exceptions
            throw new IOException("Failed to save image: " + e.getMessage(), e);
        }
    }
}
