package mongotest;

import com.test.multipledb.MultipleDbApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MultipleDbApplication.class)

public class MongotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotestApplication.class, args);

	}

}
