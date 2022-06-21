package com.test.multipledb;

import com.test.multipledb.sql.Entity.Book;
import com.test.multipledb.sql.Entity.User;
import com.test.multipledb.sql.Repository.BookRepository;
import com.test.multipledb.sql.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private  UserRepository userRepository;

    @Test
    public void addBook(){
        Book book = new Book("Java","Kartik");
        bookRepository.save(book);
    }
}
