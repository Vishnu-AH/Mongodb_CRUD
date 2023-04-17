package com.pace.springMongoCrud.repository;

import com.pace.springMongoCrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
