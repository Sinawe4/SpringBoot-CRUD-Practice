package com.example.member.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class MemberSignInDto {
    //@NotBlank(message = "name should be valid")
    private String name;

    //@NotBlank(message = "password should be valid")
    private String password;
}
