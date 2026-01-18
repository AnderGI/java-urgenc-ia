package com.andergi.shared.domain;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Inherited
public @interface Service {
}
