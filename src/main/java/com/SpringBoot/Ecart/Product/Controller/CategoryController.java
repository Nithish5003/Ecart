package com.SpringBoot.Ecart.Product.Controller;

import com.SpringBoot.Ecart.Product.Model.Category;
import com.SpringBoot.Ecart.Product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategory(){return  categoryService.getAllCategories();}

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    @PostMapping
    public  Category createCategory(@RequestBody Category category){return categoryService.createCategory(category);}

    @DeleteMapping("/{id}")
    public  ResponseEntity<String>deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory((id));
        return ResponseEntity.ok("deleted");
    }

}

