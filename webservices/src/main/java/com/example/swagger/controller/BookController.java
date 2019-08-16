package com.example.swagger.controller;

import com.example.swagger.model.Book;
import com.example.swagger.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/book")
@Api(tags = "Book Rest Controller")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @ApiOperation(value = "Get All Book")
    public List<Book> getAllMovie(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @ApiOperation(value = "Get detail Book by ID")
    public Book getAllMovie(@PathVariable("id") int id){
        return bookRepository.findById(id).get();
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @ApiOperation(value = "Create New Book")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Book getAllMovie(@RequestParam("actor") String actor,
                            @RequestParam("year") int year,
                            @RequestParam("name") String name,
                            @RequestParam("category") int category){
        Book book = new Book();
        book.setActor(actor);
        book.setCategory(category);
        book.setName(name);
        book.setYear(year);
        bookRepository.save(book);
        return book;
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @ApiOperation(value = "Edit Book by ID")
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT)
    public Book getAllMovie(@PathVariable("id") int id,
                            @RequestParam("actor") String actor,
                            @RequestParam("year") int year,
                            @RequestParam("name") String name,
                            @RequestParam("category") int category){
        Book book = bookRepository.findById(id).get();
        book.setActor(actor);
        book.setCategory(category);
        book.setName(name);
        book.setYear(year);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @ApiOperation(value = "Delete Book by ID")
    public Boolean deleteBook(@PathVariable("id") int id){
        bookRepository.deleteById(id);
        return true;
    }
}
