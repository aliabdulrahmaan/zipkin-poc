package com.aliassad.service1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Slf4j
@ServletComponentScan
public class Service1Application {

	private final RestTemplate restTemplate;

	public Service1Application(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@PostMapping("/api")
	public ResponseEntity<?> findEmployee(){
log.debug("find employee");
		Employee e = new Employee(1l,"Ali Assad");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api",String.class);
		e.setDepartment(response.getBody());
		return ResponseEntity.ok(e);
}

//	@Bean
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}

//	@Bean
//	public AlwaysSampler defaultSampler() {
//		return new AlwaysSampler();
//	}

}
