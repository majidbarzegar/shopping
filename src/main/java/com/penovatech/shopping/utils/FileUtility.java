package com.penovatech.shopping.utils;

import com.penovatech.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.penovatech.shopping.exception.ShoppingExceptionMessage.CAN_NOT_SAVE_FILE;

public class FileUtility {

    @Value("${image.upload.dir}")
    private static String imageUploadDir;
    @Value("${image.base.url}")
    private static String imageBaseUrl;

    public static String saveFile(MultipartFile file, String fileName) {
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
}
