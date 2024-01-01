package com.azure.learning.udemy.in28minutes;

import com.azure.learning.udemy.in28minutes.storage.mysql.model.Todo;
//import com.azure.learning.udemy.in28minutes.storage.mysql.repositories.TodoRepository;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootWebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);



	}

//	@Bean
//	void basicsApplicationListener(TodoRepository repository) {
//
//		List<Todo> list = Stream.of("A", "B", "C").map(name->
//				new Todo("configuration",
//						"congratulations, you have set up correctly!", true)).collect(Collectors.toList());
//		repository.saveAll(list);
////		return event->repository
////				.saveAll()
////				.forEach(System.out::println));
//	}

//	@Bean
//	ApplicationListener<ApplicationReadyEvent> basicsApplicationListener(TodoRepository repository) {
////		ApplicationListener<ApplicationReadyEvent> output =  event->repository
////				.saveAll(Stream.of("A", "B", "C")
////						.map(name->new Todo(generateRandomLongvalue(),
////								"configuration",
////								"congratulations, you have set up correctly!", true))
////						.collect(Collectors.toList()))
////				.forEach(System.out::println);
//		List<Todo> listOfData = new ArrayList<>();
//		try {
//			for (int i = 0; i < 100; i++) {
//				Todo todo = new Todo(generateRandomLongvalue(),
//						"configuration",
//						"congratulations, you have set up correctly!", true);
//
//				listOfData.add(todo);
////				List<Todo> list = repository.findAll();
////				System.out.println("List is=>" + list);
//			}
//		}catch (Exception e) {
//			System.out.println("Exception raise"+ e);
//		}
////		repository.saveAll(listOfData);
//		return null;
//	}

	public Long generateRandomLongvalue() {
		Random random = new Random();

		// Generate a random long value
		long randomLong = random.nextLong();

		return randomLong;
	}

	@Bean
	public void fetchMongoDBData() {
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://rakeshyedlapalliazurelearning:XErL8zUNefFCrDcJCHlmIOqBPJ290TNTryYmmX0Sso72WCcuOAOoHPW0wLhjLL9p3PUuyFI9BmndACDbYGyKtw==@rakeshyedlapalliazurelearning.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@rakeshyedlapalliazurelearning@"));

		MongoDatabase database =  mongoClient.getDatabase("azure-cosmos-mongodb");
		MongoCollection<Document> mongoCollection =  database.getCollection("mongoDbFirstCollection");

		MongoCursor<Document> cursor = mongoCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document document = cursor.next();
				// Process fetched document
				System.out.println(document.toJson());
			}
		} finally {
			cursor.close();
		}

		// Close the connection to MongoDB
		mongoClient.close();

	}

}
