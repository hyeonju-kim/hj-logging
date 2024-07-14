package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAopComponent {
//    @Around("execution(* com.example.demo..*(..))")
    @Around("@annotation(com.example.demo.aop.Logging)") // 어노테이션 기반 어드바이스 생성
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder logMessage = new StringBuilder();

        logMessage.append("메서드 시작 || ");
        logMessage.append("메서드 명 출력: ").append(joinPoint.getSignature().getName()).append(" || ");

        long startTime = System.currentTimeMillis();
        logMessage.append("메서드 시작 시간 출력: ").append(startTime).append(" || ");

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        logMessage.append("메서드 끝 시간 출력: ").append(endTime).append(" || ");

        long execTime = endTime - startTime;
        logMessage.append("메서드 파라미터 출력: ").append(result).append(" || ");
        logMessage.append("메서드 수행 시간 출력: ").append(execTime).append(" ms\n");

        log.info(logMessage.toString());

        return result;
    }
}
