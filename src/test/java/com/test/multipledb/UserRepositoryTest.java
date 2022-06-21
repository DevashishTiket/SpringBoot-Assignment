package com.test.multipledb;

import com.test.multipledb.sql.Entity.Book;
import com.test.multipledb.sql.Entity.User;
import com.test.multipledb.sql.Repository.BookRepository;
import com.test.multipledb.sql.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveUser(){
        User user = new User("Kartik","kartik@gmail.com");
        userRepository.save(user);
    }

    @Test
    public void getList(){
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
    }

    @Test
    public void updateUserName(){
        userRepository.updateNameByUserName("Devashish","Kartik");
    }

    @Test
    public void updateEmail(){
        userRepository.updateEmailByUserName("dev123@mail.com","Devashish");
    }

    @Test
    public void issueBook(){

    }
}
