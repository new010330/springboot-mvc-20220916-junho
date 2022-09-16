package com.boot.mvc20220916junho.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ResponseBodyController {

//    Logger LOGGER = LoggerFactory.getLogger(getClass());

    @GetMapping("/api/text") // CRUD 중 Read
    public String textGetReq(@RequestParam("value") String value, @RequestParam int num) {
        return "파라미터 값: " + value + "," + num;
    }

    @PostMapping("/api/text") // CRUD 중 Create
    public String textPostReq(@RequestParam String name, int age) {
        log.info("name: {}, {}, {}, {}", name, age, name, age);
        log.info("age: {}", age);
        return "name: " + name + ", age: " + age;
    }

    @PutMapping("/api/text") // CRUD 중 Update
    public String textPutReq() {
        log.info("put Request!!");
        return "풋 요청에 대한 응답";
    }

    @DeleteMapping("/api/text") // CRUD 중 D
    public String textDeleteReq() {
        log.info("delete Request!!");
        return "Delete 요청에 대한 응답";
    }
}
