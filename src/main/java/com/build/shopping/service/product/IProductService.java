package com.build.shopping.service.product;

import com.build.shopping.model.Product;
import com.build.shopping.request.AddProductRequest;
import com.build.shopping.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(Product product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> countProductsByBrandAndName(String brand, String name);

}
