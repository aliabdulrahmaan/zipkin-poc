package com.aliassad.service1;

import com.aliassad.service1.domain.Department;
import com.aliassad.service1.domain.Employee;
import com.aliassad.service1.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
@ServletComponentScan
public class Service1Application {
	private final Map<Integer,Employee> employees= new HashMap<>();
	private final RestTemplate restTemplate;

	public Service1Application(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		employees.put(1,new Employee(1l,"Ali Assad"));
		employees.put(2,new Employee(2l,"Mohammad Assad"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@PostMapping("/api/employee")
	public ResponseEntity<?> findEmployee(@RequestBody EmployeeDTO employeeDTO){
        log.info("find employee by {}",employeeDTO);
		Employee e = employees.get(employeeDTO.getEmpId());
		ResponseEntity<Department> response = restTemplate.getForEntity("http://localhost:8080/api/"+employeeDTO.getDepId(),Department.class);
		e.setDepartment(response.getBody());
		log.info("Response - employee by {}",employeeDTO);
		return ResponseEntity.ok(e);
}



}
