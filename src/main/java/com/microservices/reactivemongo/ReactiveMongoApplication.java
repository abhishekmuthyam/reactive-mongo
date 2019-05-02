package com.microservices.reactivemongo;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.reactivemongo.model.Employee;
import com.microservices.reactivemongo.repository.EmployeeRepository;

@SpringBootApplication
public class ReactiveMongoApplication {
	
	/*@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository) {
		
		return args->{
			employeeRepository.deleteAll()
			.subscribe(null,null,()->{
				Stream.of(new Employee(UUID.randomUUID().toString(),"Abhishek",80000L),
						new Employee(UUID.randomUUID().toString(),"Muthyam",90000L),
						new Employee(UUID.randomUUID().toString(),"Chinna",95000L))
				.forEach(employee->{
					employeeRepository.save(employee)
					.subscribe(System.out::println);
				});
						
			});
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoApplication.class, args);
	}
}
