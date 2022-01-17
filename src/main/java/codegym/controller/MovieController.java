package codegym.controller;

import codegym.model.Category;
import codegym.model.Movie;
import codegym.service.ICategoryService;
import codegym.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {
    @Autowired
    IMovieService movieService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/movie")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("movie",movieService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("movie", new Movie());
        modelAndView.addObject("createmovie",categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "movie") Movie movie, @RequestParam long idCate, @RequestParam MultipartFile upImg){
        Category newcategory = new Category();
       newcategory.setIdcate(idCate);
       movie.setCategories(newcategory);

        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\84374\\IdeaProjects\\jpa\\src\\main\\webapp\\img" + nameFile));
            movie.setImg("/img/"+nameFile);
            movieService.save(movie);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/movie";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
       Optional<Movie> movie = movieService.findById(id);
        List<Category> list = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("editmovie", movie);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute(value = "movie") Movie movie, @RequestParam MultipartFile upImg,@RequestParam Long idCate){
      Category category = new Category();
       category.setIdcate(idCate);
       movie.setCategories(category);
        if(upImg.getSize()!=0){
            File oldFile = new File("C:\\Users\\84374\\IdeaProjects\\jpa\\src\\main\\webapp\\img"+movie.getImg());
            oldFile.delete();
            String nameFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(),new File("C:\\Users\\84374\\IdeaProjects\\jpa\\src\\main\\webapp\\img"+nameFile));
                movie.setImg("/img/"+nameFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        movieService.save(movie);
        return new ModelAndView("redirect:/movie");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        Optional<Movie> movie = movieService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("deletemovie", movie);
        return modelAndView;
    }

    @PostMapping("delete/{id}")
    public ModelAndView delete(@PathVariable int id,@ModelAttribute Movie movie){
        File oldFile = new File("C:\\Users\\84374\\IdeaProjects\\jpa\\src\\main\\webapp\\img"+movie.getImg());
        oldFile.delete();
        movieService.delete(id);
        return new ModelAndView("redirect:/movie");
    }
}
