package org.example.taskmanagement2.annotations;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackExecutionTime {
    long warnAfter() default 0;
    String operation() default "";
}
