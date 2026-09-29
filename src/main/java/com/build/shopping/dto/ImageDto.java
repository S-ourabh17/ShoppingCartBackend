package com.build.shopping.dto;


import lombok.Data;

@Data
public class ImageDto {
    private Long id;
    private String fileName;
    public String downloadUrl;
}
