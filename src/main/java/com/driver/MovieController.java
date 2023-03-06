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
    public ResponseEntity addMovie(@RequestBody Movie movie)
    {

        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);

    }

    //Adding director
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){


        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
    }

    //paring movie and director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("q") String movie_name, @RequestParam("s") String director_name){

         return new ResponseEntity<>(movieService.addMovieDirectorPair(movie_name,director_name),HttpStatus.CREATED);
    }
    //getting movie by name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.FOUND);
    }

    //Getting director by name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.FOUND);
    }
    //Getting list of movie by director name

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.FOUND);
    }

    //Getting list of all movies
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){

        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND) ;
    }

    //Deleting director and it's movies
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("q") String name){


        return new ResponseEntity(movieService.deleteDirectorByName(name),HttpStatus.ACCEPTED);
    }

    //Deleting all directors
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){

       ;
        return new ResponseEntity( movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
    }




}
