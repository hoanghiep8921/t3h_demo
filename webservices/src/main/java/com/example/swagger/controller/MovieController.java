package com.example.swagger.controller;

import com.example.swagger.model.Actor;
import com.example.swagger.model.Movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
@Api(tags = "Movie Rest Controller")
public class MovieController {
    public static List<Movie> listMovie = new ArrayList<>();

    static {
        try {
            Date birthDay = new SimpleDateFormat("yyyy-MM-dd").parse("1996-09-04");
            Actor johnWick = new Actor("John Wick",birthDay,1,true);
            birthDay =  new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-20");
            Actor bull = new Actor("Pit Bull",birthDay,0,false);
            Movie assassinJohn = new Movie(1,"Assassin John Wick 3",2019,"https://timesofindia.indiatimes.com/thumb/msid-68721293,imgsize-172358,width-800,height-600,resizemode-4/68721293.jpg",johnWick,4.5);
            Movie monsterDog = new Movie(2,"Man of Steel",2020,"http://henrycavill.org/images/Films/2013-Man-of-Steel/posters/3-Walmart-Superman-a.jpg",bull,5.0);
            Movie manOfSteel = new Movie(3,"Despicable Me 3",2019,"https://charliederry.files.wordpress.com/2015/07/minions1.jpg?w=800",johnWick,4.5);
            Movie minion = new Movie(4,"Avenger End Game",2020,"https://is3-ssl.mzstatic.com/image/thumb/Video113/v4/6e/47/f6/6e47f680-ac54-21ff-a37a-3aab1a9970b0/DIS_AV_ENDGAME_FINAL_ENGLISH_US_WW_WW_ARTWORK_EN_2000x3000_1OWPBJ00000GQ6.lsr/268x0w.jpg",bull,5.0);

            listMovie.add(assassinJohn);
            listMovie.add(monsterDog);
            listMovie.add(manOfSteel);
            listMovie.add(minion);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "Get All Movie")
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    public List<Movie> getAllMovie (){
        return listMovie;
    }

    @ApiOperation(value = "Get detail Movie By ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Movie getAllMovie(@PathVariable("id") int id){
        if(id < 0 || id > listMovie.size()){
            //some thing here
        }
        return listMovie.get(id);
    }

    @ApiOperation(value = "Add NEW Movie")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Movie createMovie(@RequestParam("name") String name,
                             @RequestParam("year") int year,
                             @RequestParam("actorName") String actorName,
                             @RequestParam("birthday") String birthday,
                             @RequestParam("image") String image){
        Movie movie = null;
        try {
            Date dateOfBirth = new SimpleDateFormat("dd/MM/YYYY").parse(birthday);
            Actor actor = new Actor(actorName,dateOfBirth,1,true);
            movie = new Movie(listMovie.size(),name,year,image,actor,0);
            listMovie.add(movie);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return movie;
    }


    @ApiOperation(value = "Edit Movie By ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT)
    public Movie editMovie(@PathVariable("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("year") int year,
                           @RequestParam("actorName") String actorName,
                           @RequestParam("birthday") String birthday){
        Movie movie = listMovie.get(--id);
        try {
            Date dateOfBirth = new SimpleDateFormat("dd/MM/YYYY").parse(birthday);
            Actor actor = new Actor(actorName,dateOfBirth,1,true);
            movie.setActor(actor);
            movie.setName(name);
            movie.setYear(year);
            listMovie.set(id,movie);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @ApiOperation(value = "Delete Movie By Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Movie editMovie(@PathVariable("id") int id){
        Movie movie = listMovie.get(--id);
        listMovie.remove(movie);
        return movie;
    }
}
