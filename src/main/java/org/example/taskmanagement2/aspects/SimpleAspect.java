package org.example.taskmanagement2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.taskmanagement2.annotations.TrackExecutionTime;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {


    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint , TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try{
            return joinPoint.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();

            if(operation.isBlank()) {
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT : " +
                        "Time Taken by " +
                        operation  + ": " + duration);
            }
            else {
                System.out.println(
                        "Time Taken by " + operation  + ": " + duration);
            }
        }

    }

    @Before("execution(* *.findById(..))")
    public void logBeforeMethod(JoinPoint jointPoint) {
        System.out.println("Before method");
    }
}
