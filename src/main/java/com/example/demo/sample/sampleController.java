package com.example.demo.sample;

import com.example.demo.aop.Logging;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class sampleController {
    // localhost:8080/aop
    // 테스트 샘플
    /*
    {
    "name": "John Doe",
    "age": 30,
    "email": "john.doe@example.com",
    "address": {
        "street": "123 Main St",
        "city": "Anytown",
        "state": "CA",
        "zip": "12345"
    },
    "phones": [
        {
            "type": "home",
            "number": "555-555-5555"
        },
        {
            "type": "work",
            "number": "555-555-5556"
        }
    ],
    "active": true
}

     */
    @PostMapping("/aop")
    @Logging // 요청 시 로그 찍어주는 어노테이션 추가
    public Map<String,Object> test1(@RequestBody Map<String, Object> sampleMap) {

        int num = 0;
        for (int i = 0; i < 100000000; i++) {
            num += i;
        }
        System.out.println("num ======== "+num);
        return sampleMap;
    }

    @PostMapping("/aop2")
    @Logging // 요청 시 로그 찍어주는 어노테이션 추가
    public Map<String,Object> test2(@RequestBody Map<String, Object> sampleMap) {

        int num = 0;
        for (int i = 0; i < 100000000; i++) {
            num += i*2;
        }
        System.out.println("num ======== "+num);
        return sampleMap;
    }
}
