package com.aliassad.service2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepService {

    public String findDepartment(){
        log.info("find department");


        return "test";
    }
}
