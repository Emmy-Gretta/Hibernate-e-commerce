package rca.ac.rw.mis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rca.ac.rw.mis.models.*;
import rca.ac.rw.mis.repo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository, UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository, ProductRepository productRepository){
		return args -> {
			Person p1 = new Person("John", "MUHIRE", "johnmuhire@gmail.com");
			Person p2 = new Person("Peter", "KALISA", "kalisapeter@gmail.com");
			Contacts contact3 = new Contacts("johdoe@gmail.com","0781677777");
			Contacts contact2 = new Contacts("singizwa@gmail.com","4567890987");
			Contacts contact1 = new Contacts("ellapa@gmail.com","9876543435");
			User user1 = new User("John Doe", contact3);
			User user2 = new User("Pacis Ellapa", contact1);
			User user3 = new User("Hope Singizwa", contact2);
			Category category1 = new Category("Electronics");
			Category category2 = new Category("Accessories");
			Category category3 = new Category("Clothing");
			Product product1 = new Product("Camera", 50000, category2);
			Product product2 = new Product("Book", 70000, category3);
			Product product3 = new Product("Laptop", 5000000, category1);
			Review review1 = new Review("Great Product! Highly recommended!", product1, user3);
			Review review2 = new Review("High quality product! Highly recommended!", product2, user1);
			Review review3 = new Review("Amazing Product! Highly recommended!", product3, user2);
			List<Product> productList1 = Arrays.asList(product1, product2);
			List<Product> productList2 = Arrays.asList(product3, product2);
			List<Product> productList3 = Arrays.asList(product1, product3);
			Orders order1 = new Orders(user1, productList1, LocalDateTime.now());
			Orders order2 = new Orders(user2, productList2, LocalDateTime.now());
			Orders order3 = new Orders(user3, productList3, LocalDateTime.now());
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			reviewRepository.save(review1);
			reviewRepository.save(review2);
			reviewRepository.save(review3);
			orderRepository.save(order1);
			orderRepository.save(order2);
			orderRepository.save(order3);
			personRepository.save(p1);
			personRepository.save(p2);
		};
	}

}
