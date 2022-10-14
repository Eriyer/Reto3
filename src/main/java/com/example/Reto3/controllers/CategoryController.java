package com.example.Reto3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto3.entities.Category;
import com.example.Reto3.services.CategoryService;

@Service
@RestController
@RequestMapping("api/Category")

public class CategoryController {
    @Autowired
    CategoryService categoryservice;

    // CONSTRUCTOR**

    public CategoryController(CategoryService categoryservice) {
        this.categoryservice = categoryservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategorys() {
        return new ResponseEntity<List<Category>>(this.categoryservice.getListCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
        return new ResponseEntity<Category>(this.categoryservice.getCategory(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearCategory(@RequestBody Category category) {
        this.categoryservice.crearCategory(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategory(@PathVariable("id") int id) {
        this.categoryservice.eliminarCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarCategory(@RequestBody Category category) {
        System.out.println("id *******" + category.getId());
        System.out.println("name *******" + category.getName());
        System.out.println("description *******" + category.getDescription());
        this.categoryservice.actualizarCategory(category.getId(), category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
