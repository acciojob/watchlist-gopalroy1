package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {



    @Autowired
    MovieService movieService;


    //Adding movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {

        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);

    }

    //Adding director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){


        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.OK);
    }

    //paring movie and director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("q") String movie_name, @RequestParam("s") String director_name){
         movieService.addMovieDirectorPair(movie_name,director_name);
         return new ResponseEntity("Director and move is paired",HttpStatus.OK);
    }
    //getting movie by name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.OK);
    }

    //Getting director by name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.OK);
    }
    //Getting list of movie by director name

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.OK);
    }

    //Getting list of all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK) ;
    }

    //Deleting director and it's movies
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("q") String name){

        movieService.deleteDirectorByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Deleting all directors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

        movieService.deleteAllDirectors();
        return new ResponseEntity(HttpStatus.OK);
    }




}
