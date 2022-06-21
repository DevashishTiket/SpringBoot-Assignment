package mongotest.resource;


import mongotest.model.BookM;
import mongotest.repository.brM;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private brM repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody BookM bookM){
        repository.save(bookM);
        return "Added book with id : "+ bookM.getId();
    }
    @GetMapping("/findAllBooks")
    public List<BookM> getBooks(){
        return repository.findAll();
    }
    @GetMapping("/findAllBooks/{id}")
    public Optional<BookM> getBook(@PathVariable int id){
        return repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
         repository.deleteById(id);
         return "Book deleted";
    }
    @PutMapping("/updateBook")
    public BookM updateBook(@RequestBody BookM bookM){
        BookM existingBookM =repository.findById(bookM.getId()).orElse(null);
        existingBookM.setBookName(bookM.getBookName());
        existingBookM.setCustomerName(bookM.getCustomerName());
        existingBookM.setReview(bookM.getReview());
      return repository.save(existingBookM);
    }
}
