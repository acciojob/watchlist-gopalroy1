package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MovieController {



    @Autowired
    MovieService movieService;


    //Adding movie
    @PostMapping("/movies/add-movie")
    public String addMovie( @RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    //Adding director
    @PostMapping("/movies/add-director")
    public String addDirector(@RequestBody Director director){
        return movieService.addDirector(director);
    }

    //paring movie and director pair
    @PutMapping("/movies/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("q") String movie_name, @RequestParam("s") String director_name){
        return movieService.addMovieDirectorPair(movie_name,director_name);
    }
    //getting movie by name
    @GetMapping("/movies/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name){
        return movieService.getMovieByName(name);
    }

    //Getting director by name
    @GetMapping("/movies/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String name){
        return movieService.getDirectorByName(name);
    }
    //Getting list of movie by director name

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public List getMoviesByDirectorName(@PathVariable("director") String name){
        return movieService.getMoviesByDirectorName(name);
    }

    //Getting list of all movies
    @GetMapping("/movies/get-all-movies")
    public List findAllMovies(){
        return movieService.findAllMovies();
    }

    //Deleting director and it's movies
    @DeleteMapping("/movies/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("q") String name){
        return deleteDirectorByName(name);
    }

    //Deleting all directors
    @DeleteMapping("/movies/delete-all-directors")
    public String deleteAllDirectors(){
        return movieService.deleteAllDirectors();
    }




}
