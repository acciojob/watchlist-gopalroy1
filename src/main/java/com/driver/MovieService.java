package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Service
public class MovieService {

    //Question
    //Add a movie: POST /movies/add-movie
    //Pass the Movie object as request body
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addMovie
    //
    //Add a director: POST /movies/add-director
    //Pass the Director object as request body
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addDirector
    //
    //Pair an existing movie and director: PUT /movies/add-movie-director-pair
    //Pass movie name and director name as request parameters
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addMovieDirectorPair
    //
    //Get Movie by movie name: GET /movies/get-movie-by-name/{name}
    //Pass movie name as path parameter
    //Return Movie object wrapped in a ResponseEntity object
    //Controller Name - getMovieByName
    //
    //Get Director by director name: GET /movies/get-director-by-name/{name}
    //Pass director name as path parameter
    //Return Director object wrapped in a ResponseEntity object
    //Controller Name - getDirectorByName
    //
    //Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
    //Pass director name as path parameter
    //Return List of movies name(List()) wrapped in a ResponseEntity object
    //Controller Name - getMoviesByDirectorName
    //
    //Get List of all movies added: GET /movies/get-all-movies
    //No params or body required
    //Return List of movies name(List()) wrapped in a ResponseEntity object
    //Controller Name - findAllMovies
    //
    //Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
    //Pass director’s name as request parameter
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - deleteDirectorByName
    //
    //Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
    //No params or body required
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - deleteAllDirectors
    //(Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)

    @Autowired
    MovieRepository movieRepository;

    public String addMovie( Movie movie){

        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){

        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair( String movie_name,  String director_name){
       return movieRepository.addMovieDirectorPair(movie_name,director_name);
    }

    //getting movie by name
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName( String name){

        return movieRepository.getDirectorByName(name);
    }

    public List getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List findAllMovies(){
        return movieRepository.findAllMovies();
    }

    //Deleting director and it's movies
    public String deleteDirectorByName( String name){
        return movieRepository.deleteDirectorByName(name);
    }

    //Deleting all directors
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }



}
