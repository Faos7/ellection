package com.ellection.service;

import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

/**
 * Created by faos7 on 31.03.17.
 */
public interface ImageService {

    String encodeToString(MultipartFile file) ;
    BufferedImage decodeToImage(String imageString);
    boolean compareImages(BufferedImage imgA, BufferedImage imgB);

}
