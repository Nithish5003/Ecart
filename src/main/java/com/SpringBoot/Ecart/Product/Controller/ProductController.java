package com.SpringBoot.Ecart.Product.Controller;

import com.SpringBoot.Ecart.Product.Model.Product;
import com.SpringBoot.Ecart.Product.Repository.CategoryRepository;
import com.SpringBoot.Ecart.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> product = productService.getAllProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProducedById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception {
        try {
            productService.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"user does not exist",e);
        }
        return  ResponseEntity.ok((productService.addProduct(product)));

    }
    @PutMapping("/{id}")
    public  ResponseEntity<String>updateProduct(@PathVariable Integer id,@RequestBody Product productDetails)throws  Exception{
      productService.updateproduct(id,productDetails);
      return  ResponseEntity.ok("product Updated successfully");
    }

    public  ResponseEntity<String>deleteProduct(@PathVariable Integer id){
        productService.deleteproduct(id);
        return ResponseEntity.ok("product deleted successfully");
    }

}

