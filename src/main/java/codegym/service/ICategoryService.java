package codegym.service;

import codegym.model.Category;
import codegym.model.Movie;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
}
