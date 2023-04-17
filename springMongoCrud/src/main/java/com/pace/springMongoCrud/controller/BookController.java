package com.pace.springMongoCrud.controller;

import com.pace.springMongoCrud.model.Book;
import com.pace.springMongoCrud.repository.BookRepository;
import com.pace.springMongoCrud.responses.ApiSuccessResponse;
import com.pace.springMongoCrud.service.BookService;
import com.pace.springMongoCrud.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;
    @PostMapping()
    public ResponseEntity<Object> saveBook(@RequestBody Book book){
        bookService.saveBook(book);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK));
    }
    @GetMapping("/findAll")
    public ResponseEntity<Object> fetchAllBooks(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", required = false, defaultValue = Integer.MAX_VALUE + "") Integer size,
                                    @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                    @RequestParam(value = "order", required = false, defaultValue = "DESCENDING") String order){
        Page<Book> books = bookService.fetchAllBooks(page,size,sort,order);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,books));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchBookById(@PathVariable int id){
        Optional<Book> book = bookService.fetchBookById(id);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id){
        Book book = bookService.deleteBook(id);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,book));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id,@RequestBody Book book){
        Book updatedBook = bookService.updateBook(id,book);
        return CommonUtil.buildResponse(new ApiSuccessResponse(HttpStatus.OK,updatedBook));
    }
}
