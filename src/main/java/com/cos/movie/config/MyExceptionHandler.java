package com.cos.movie.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;

@RestController
@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public CommonDto<String> exception(Exception e) {
		return new CommonDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}
}
