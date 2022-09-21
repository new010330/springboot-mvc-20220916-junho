package com.boot.mvc20220916junho.web.controller.api;

import com.boot.mvc20220916junho.web.dto.ResponseDataDto;
import com.boot.mvc20220916junho.web.dto.StudentRespDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResponseTestController {

    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "김준일");
        data.put("연락처", "010-9988-1916");
        return data;
    }

    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {
        return ResponseDataDto.builder()
                .value1("그냥 문자열")
                .value2(1000)
                .value3(true)
                .build();
    }

    @GetMapping("/api/v1/data3")
    public Object getData3() {
        return ResponseDataDto.builder()
                .value1("그냥 문자열")
                .value2(2000)
                .value3(false)
                .build();
    }

    @GetMapping("api/v1/students")
    public Object getData4() {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        List<StudentRespDto> studentList = new ArrayList<StudentRespDto>();

        StudentRespDto s1 = StudentRespDto.builder()
                .studentCode(20220001)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산진구")
                .studentPhone("010-9988-1916")
                .build();

        StudentRespDto s2 = StudentRespDto.builder()
                .studentCode(20220002)
                .studentName("김준이")
                .studentYear(4)
                .studentAddress("동래구")
                .studentPhone("010-9999-1234")
                .build();

        studentList.add(s1);
        studentList.add(s2);

        responseMap.put("students", studentList);

        return responseMap;
    }
}
