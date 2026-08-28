package com.build.shopping.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import java.sql.Blob;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {
    private Long id;
    private String fileName;
    private String fileType;


    @Lob
    private Blob image;
    private String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
