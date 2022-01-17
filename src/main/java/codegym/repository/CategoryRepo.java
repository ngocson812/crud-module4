package codegym.repository;

import codegym.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository <Category, Integer> {

}
