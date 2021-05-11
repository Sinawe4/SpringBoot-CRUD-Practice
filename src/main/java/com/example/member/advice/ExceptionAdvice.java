package com.example.member.advice;

import com.example.member.advice.exception.UserAlreadtExistsException;
import com.example.member.advice.exception.UserLoginFailedException;
import com.example.member.advice.exception.UserNotFoundException;
import com.example.member.config.MessageConfiguration;
import com.example.member.domain.response.CommonResult;
import com.example.member.domain.response.ResponseService;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    private final MessageSource messageSource;

    // code정보에 해당하는 메시지를 조회합니다.
    private String getMessage(String code) {
        return getMessage(code, null);
    }
    // code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CommonResult userNotFoundException(HttpServletRequest request, UserNotFoundException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
    }

    @ExceptionHandler(UserAlreadtExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected CommonResult userAlreadtExistsException(HttpServletRequest request, UserAlreadtExistsException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseService.getFailResult(Integer.valueOf(getMessage("userAlreadyExists.code")), getMessage("userAlreadyExists.msg"));
    }

    @ExceptionHandler(UserLoginFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult userLoginFailedException(HttpServletRequest request, UserLoginFailedException e){
        return responseService.getFailResult(Integer.valueOf(getMessage("userLoginFailed.code")), getMessage("userLoginFailed.msg"));
    }


}