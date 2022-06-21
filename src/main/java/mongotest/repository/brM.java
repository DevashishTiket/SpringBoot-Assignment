package mongotest.repository;


import mongotest.model.BookM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface brM extends MongoRepository<BookM,Integer> {

}
