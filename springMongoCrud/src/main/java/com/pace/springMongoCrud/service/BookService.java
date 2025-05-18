package com.pace.springMongoCrud.service;

import com.pace.springMongoCrud.exception.BookNotFoundException;
import com.pace.springMongoCrud.model.Book;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookService {

    public Book saveBook(Book book);

    public Optional<Book> fetchBookById(int id);

    public Page<Book> fetchAllBooks(int page,int size,String sort,String order);

    public Book deleteBook(int id) throws BookNotFoundException;

    public Book updateBook(int id, Book book);

}
