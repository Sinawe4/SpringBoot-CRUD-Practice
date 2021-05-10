package com.example.member.advice;

import com.example.member.advice.exception.UserAlreadtExistsException;
import com.example.member.config.MessageConfiguration;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final MemberRepository memberRepository;
    private final MessageConfiguration messageConfiguration;

//    @ExceptionHandler(UserAlreadtExistsException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public
}