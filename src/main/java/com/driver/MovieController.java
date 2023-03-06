package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/movies")

public class MovieController {



    @Autowired
    MovieService movieService;


    //Adding movie
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie)
    {
        String res = movieService.addMovie(movie);
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    //Adding director
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){

        String res = movieService.addDirector(director);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    //paring movie and director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("q") String movie_name, @RequestParam("s") String director_name){
        String res = movieService.addMovieDirectorPair(movie_name,director_name);
         return new ResponseEntity<>(res,HttpStatus.CREATED);
    }
    //getting movie by name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    //Getting director by name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    //Getting list of movie by director name

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String name){
        List<Movie> movieList = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movieList,HttpStatus.FOUND);
    }

    //Getting list of all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<Movie> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.FOUND) ;
    }

    //Deleting director and it's movies
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("q") String name){

        String res = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    //Deleting all directors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

       String res =movieService.deleteAllDirectors();
        return new ResponseEntity<>( res,HttpStatus.ACCEPTED);
    }




}
