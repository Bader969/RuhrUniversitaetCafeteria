package service;

import domain.Product;
import repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        product.setState("New");
        return productRepository.save(product);
    }

    public Product submitForApproval(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Awaiting_Approval");
        return productRepository.save(product);
    }

    public Product approveProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Available");
        return productRepository.save(product);
    }

    public Product rejectProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Rejected");
        return productRepository.save(product);
    }

    public Product restockProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Available");
        return productRepository.save(product);
    }

    public Product depleteStock(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Out_of_Stock");
        return productRepository.save(product);
    }

    public Product discontinueProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setState("Discontinued");
        return productRepository.save(product);
    }

    public void sendProductUpdate(Product product) {
    }
}
