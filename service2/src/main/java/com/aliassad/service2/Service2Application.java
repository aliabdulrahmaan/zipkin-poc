package com.aliassad.service2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
public class Service2Application {

    private final DepService depService;

    public Service2Application(DepService depService) {
        this.depService = depService;
    }

    public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

	@GetMapping ("/api")
	public ResponseEntity<?> findDepartment(){
		log.debug("find department");
		return ResponseEntity.ok(depService.findDepartment());
	}
}
