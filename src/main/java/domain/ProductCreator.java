package domain;


import java.math.BigDecimal;

public class ProductCreator {
    public static Product createProduct(String name, BigDecimal price, String description, String category) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        return product;
    }
}
