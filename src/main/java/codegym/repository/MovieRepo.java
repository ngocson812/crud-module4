package codegym.repository;

import codegym.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Integer> {

}
