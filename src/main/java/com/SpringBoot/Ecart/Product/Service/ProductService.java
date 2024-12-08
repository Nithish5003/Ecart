package com.SpringBoot.Ecart.Product.Service;

import com.SpringBoot.Ecart.Config.UserContext;
import com.SpringBoot.Ecart.Product.Model.Category;
import com.SpringBoot.Ecart.Product.Model.Product;
import com.SpringBoot.Ecart.Product.Repository.CategoryRepository;
import com.SpringBoot.Ecart.Product.Repository.ProductRepository;
import com.SpringBoot.Ecart.User.Model.User;
import com.SpringBoot.Ecart.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;


    public Product addProduct(Product product) throws Exception {

        Long userId = UserContext.getUserId();
        Category category = categoryRepository.findById(product.getTempCategoryId()).orElse(new Category());
        product.setCategory(category);
        User user = userRepository.findById(userId).orElse(new User());

        product.setUser(user);
        return productRepository.save(product);

    }
    public  List<Product> getAllProducts()  {
        return productRepository.findAll();
    }
    public  Optional<Product>getProducedById(Integer id){return  productRepository.findById(Long.valueOf(id));}
    public  void  deleteproduct(Integer id){productRepository.deleteById(Long.valueOf(id));}
    public  void updateproduct(Integer id,Product updatedProduct) throws Exception {

        Optional<Product> maybeProduct = productRepository.findById(Long.valueOf(id));

        if (maybeProduct.isPresent()) {
            Product Oldproduct = maybeProduct.get();
            Oldproduct.setName(updatedProduct.getName());
            Oldproduct.setDescription(updatedProduct.getDescription());
            Oldproduct.setPrice(updatedProduct.getPrice());
            Oldproduct.setGst(updatedProduct.getGst());

            Category category = categoryRepository.findById(updatedProduct.getTempCategoryId()).orElseThrow(() -> new Exception("Category not found"));
            Oldproduct.setCategory(category);

            productRepository.save(Oldproduct);

        } else {
            throw new Exception("Product not found");
        }

    }


}





