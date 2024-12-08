package com.SpringBoot.Ecart.Product.Service;

import com.SpringBoot.Ecart.Product.Model.Category;
import com.SpringBoot.Ecart.Product.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return  categoryRepository.save(category);
    }
    public  Category getCategory(Long id){
        Optional<Category>maybeCategory = categoryRepository.findById(id);
        return maybeCategory.orElse(null);
    }
    public Optional<Category>getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public List<Category>getAllCategories(){
        return categoryRepository.findAll();
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
