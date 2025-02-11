package com.penovatech.shopping.utils;

import com.penovatech.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.penovatech.shopping.exception.ShoppingExceptionMessage.CAN_NOT_DELETE_FILE;
import static com.penovatech.shopping.exception.ShoppingExceptionMessage.CAN_NOT_SAVE_FILE;

@Component
public class FileService {

    @Value("${image.upload.dir}")
    private String imageUploadDir;
    @Value("${image.base.url}")
    private String imageBaseUrl;

    public String saveFile(MultipartFile file, String fileName) {
        File uploadPath = new File(imageUploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        String filePath = imageUploadDir + File.separator + fileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new BusinessException(CAN_NOT_SAVE_FILE);
        }
        return imageBaseUrl + fileName;
    }

    public void deleteFile(String fileName) {
        String filePath = imageUploadDir + File.separator + fileName.replace(imageBaseUrl, "");
        File fileToDelete = new File(filePath);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (!isDeleted) {
                throw new BusinessException(CAN_NOT_DELETE_FILE);
            }
        } else {
            throw new BusinessException(CAN_NOT_DELETE_FILE);
        }
    }
}
