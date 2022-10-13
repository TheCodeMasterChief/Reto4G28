/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author @CjVm93
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save (Category category){
            if (category.getId() == null){
        return categoryRepository.save(category);
    }else{
    Optional<Category> category1 = categoryRepository.getCategory(category.getId());
    if(category1.isEmpty()){
        return categoryRepository.save(category);
    }else{
        return category;
    }
}
}  
    public Category update(Category category){
        if(category.getId() !=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
            if(category.getDescription()!=null){
                g.get().setDescription(category.getDescription());
            }
            if(category.getName()!=null){
                g.get().setName(category.getName());
            }
            return categoryRepository.save(g.get());
        }
        }
        return category;
    
        
        
    }
    public boolean deleteCategory(int id){
        Boolean d = getCategory(id).map(category ->{
            categoryRepository.delete(category);
            return true;
            
        }).orElse(false);
        return d;
    }
}
