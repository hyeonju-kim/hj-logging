package com.example.demo.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoggingScheduler {
//    private final LogRepository logRepository;

    @Scheduled(fixedRate = 10000) // 10초
    public void logDetector() throws Exception {
        String logFilePath = "C:/Users/khj/Desktop/hj.log";

        List<String> allLines = Files.readAllLines(Path.of(logFilePath));
        for (String allLine : allLines) {
            if (allLine.contains("LogAopComponent")){
                System.out.println(allLine);
            }
        }
    }
}
