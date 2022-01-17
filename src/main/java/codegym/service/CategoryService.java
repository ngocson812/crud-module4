package codegym.service;

import codegym.model.Category;
import codegym.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }
}
