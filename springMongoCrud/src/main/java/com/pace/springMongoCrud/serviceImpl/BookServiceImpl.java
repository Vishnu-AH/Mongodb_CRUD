package com.pace.springMongoCrud.serviceImpl;

import com.pace.springMongoCrud.exception.BookNotFoundException;
import com.pace.springMongoCrud.model.Book;
import com.pace.springMongoCrud.repository.BookRepository;
import com.pace.springMongoCrud.service.BookService;
import com.pace.springMongoCrud.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> fetchBookById(int id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isPresent()){
            return bookOpt;
        }else{
            throw new BookNotFoundException("Book does not exist for given ID");
        }
    }

    @Override
    public Page<Book> fetchAllBooks(int page,int size,String sort,String order) {
        Pageable pageable = CommonUtil.getPageable(page,size,sort,order);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book deleteBook(int id) throws BookNotFoundException{
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()){
            Book book = bookOpt.get();
            bookRepository.delete(book);
            return book;
        }
        else{
            throw new BookNotFoundException("Book does not exist for given ID");
        }
    }

    @Override
    public Book updateBook(int id, Book book) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isPresent()){
            Book book1 = bookOpt.get();
            book1.setBookName(book.getBookName());
            book1.setAuthorName(book.getAuthorName());
            return bookRepository.save(book1);
        }else{
            throw new BookNotFoundException("Book does not exist for given ID");
        }
    }

}
