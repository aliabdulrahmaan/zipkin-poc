package com.aliassad.service2;

import com.aliassad.service2.domain.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Slf4j
@RestController
public class Service2Application {

private final Map<Integer,Department> departments= new HashMap<>();
public Service2Application(){
	departments.put(1,new Department(1l,"Development"));
	departments.put(2,new Department(2l,"Business"));
}
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

	@GetMapping ("/api/{id}")
	public ResponseEntity<?> findDepartment(@PathVariable int id){
    	log.info("find department {}",id);
		Department result= departments.get(id);
		log.info("response - department {}",result);
		return ResponseEntity.ok(result);
	}
}
