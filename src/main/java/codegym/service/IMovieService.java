package codegym.service;

import codegym.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    public List<Movie> findAll();
    public void save(Movie movie);
    public void delete(int id);
    public Optional<Movie> findById(int id);
}
