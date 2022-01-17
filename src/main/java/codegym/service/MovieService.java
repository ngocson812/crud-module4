package codegym.service;

import codegym.model.Movie;
import codegym.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovieService implements IMovieService{

    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) movieRepo.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void delete(int id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepo.findById(id);
    }
}
