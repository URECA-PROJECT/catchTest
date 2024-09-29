package com.ureca.myspring.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileStorageService {

    private final String fileStorageLocation = "./uploads";  // 파일 저장 경로

    public String storeBase64Image(String base64Image) {
        // "data:image/jpeg;base64," 부분 제거
        String[] parts = base64Image.split(",");
        String imageData = parts.length > 1 ? parts[1] : parts[0];  // Base64 인코딩된 이미지 데이터 부분

        // Base64 디코딩
        byte[] imageBytes = Base64.getDecoder().decode(imageData);

        // 파일 이름 생성 (고유성을 위해 UUID 사용)
        String fileName = "profileImage_" + UUID.randomUUID() + ".jpg";
        Path filePath = Paths.get(fileStorageLocation, fileName);  // 저장할 경로와 파일 이름 결합

        try {
            // 바이트 배열을 파일로 저장
            Files.createDirectories(filePath.getParent());  // 부모 디렉토리가 없으면 생성
            Files.write(filePath, imageBytes);
            return filePath.toString();  // 저장된 파일의 경로 반환
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save image");  // 파일 저장 실패 시 예외 처리
        }
    }
}
