package com.microservices.reactivemongo.controller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.reactivemongo.model.Employee;
import com.microservices.reactivemongo.model.EmployeeEvent;
import com.microservices.reactivemongo.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {


	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/getall")
	public Flux<Employee> getaAll(){
		return	employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Employee> getID(@PathVariable("id") final String id){
		return employeeRepository.findById(id);
	}

	@GetMapping(value="{id}/events",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String id){
		return	employeeRepository.findById(id)
				.flatMapMany(employee -> {
					Flux<Long> interval=Flux.interval(Duration.ofSeconds(2));

					Flux<EmployeeEvent> employeeEventFlux= Flux.fromStream(
							Stream.generate(()-> new EmployeeEvent(employee,new Date()))
							);
					return Flux.zip(interval,employeeEventFlux)
							.map(Tuple2::getT2);
				});
	}
}
