package com.epam.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Aspect
@Component
public class AspectForLogging {
    @Around("@annotation(TimeLogging)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        final LocalTime start = LocalTime.now();
        System.out.println(joinPoint.getSignature() + "-- started at " + start.toString());
        Object proceed = joinPoint.proceed();
        final LocalTime end = LocalTime.now();
        System.out.println(joinPoint.getSignature() + "-- finished at " + end +
                " execution time " + start.until(end, ChronoUnit.NANOS));
        return proceed;
    }

    @AfterThrowing(
            pointcut = "@annotation(TimeLogging)",
            throwing = "excep")
    public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
        System.err.println(joinPoint.getSignature() + "-- Exception: ");
        System.err.println(excep.getMessage() + " " + excep);
    }

}
