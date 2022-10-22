package com.mong.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}


// @Target(ElementType.PARAMETER) 가 뭐임 ?
// -이 어노테이션이 생설될 수 있는 위치를 지정.
// - PARAMETER 로 지정했으니 메소드의 파라미터로 선언딘 객체에서만 사용가능.