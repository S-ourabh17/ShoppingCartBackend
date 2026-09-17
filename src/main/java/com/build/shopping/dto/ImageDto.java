package com.build.shopping.dto;


import lombok.Data;

@Data
public class ImageDto {
    private Long imageId;
    private String imageName;
    public String downloadUrl;
}
