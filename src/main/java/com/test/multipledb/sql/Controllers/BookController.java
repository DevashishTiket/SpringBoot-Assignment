package com.test.multipledb.sql.Controllers;

import com.test.multipledb.sql.Entity.Book;
import com.test.multipledb.sql.Repository.BookRepository;
import com.test.multipledb.sql.Requests.CreateBook;
import com.test.multipledb.sql.Requests.DeleteBookRequest;
import com.test.multipledb.sql.Requests.UpdateBookDetails;
import com.test.multipledb.sql.Responses.DeleteBookResponse;
import com.test.multipledb.sql.Responses.UpdateBookDetailsResponse;
import com.test.multipledb.sql.Responses.createUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestBody CreateBook createBook){
        Book user = new Book(createBook.getBookName(), createBook.getBookAuthor());
        try {
            bookRepository.save(user);
            return ResponseEntity.ok().body(new createUserResponse(true,"book created successfully!"));
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new createUserResponse(false,"book cannot be created !"));
        }
    }

    @GetMapping("/getBookDetails")
    public ResponseEntity<?> getBookDetails(@RequestBody Long userId){
        try{
            Optional<Book> book = bookRepository.findById(userId);
            return ResponseEntity.ok().body(book);
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body("book could not be fetched!");
        }
    }

    @PutMapping("/updateBookDetails")
    public ResponseEntity<?> updateBookName(@RequestBody UpdateBookDetails updateBookDetails){
        try{
            bookRepository.updateNameByBookName(updateBookDetails.getUpdatedBookName(),updateBookDetails.getCurrentBookName());
            return ResponseEntity.ok().body(new UpdateBookDetailsResponse(true,"book name updated!"));
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new UpdateBookDetailsResponse(false, "book name could not be updated!"));
        }
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody DeleteBookRequest deleteBookRequest){
        try{
            bookRepository.deleteById(deleteBookRequest.getBookId());
            return ResponseEntity.noContent().build();
        }
        catch(Exception err){
            return ResponseEntity.internalServerError().body(new DeleteBookResponse(false,"book cannot be deleted!"));
        }
    }

}
