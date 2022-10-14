package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Category;
import com.example.Reto3.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // METODOS CRUD
    // metogo GET que me trae todos los estudiantes
    public List<Category> getListCategories() {
        return this.categoryRepository.findAll();

    }

    // metodo GET que me trae un sólo estudiante
    public Category getCategory(int id) {
        return this.categoryRepository.findById(id).get();
    }

    // metodoo POST
    public Category crearCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    // metodo DELETE
    public void eliminarCategory(int id) {
        this.categoryRepository.deleteById(id);

    }

    // metodoo PUT
    public void actualizarCategory(int id, Category category) {
        if (this.categoryRepository.findById(id).isEmpty()) {
            Category categoryDB = this.categoryRepository.findById(id).get();

            this.categoryRepository.save(categoryDB);
        }

    }
}
