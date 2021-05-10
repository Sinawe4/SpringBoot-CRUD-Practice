package com.example.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class MemberSignInDto {
    @NotBlank(message = "name should be valid")
    private String name;

    @NotBlank(message = "password should be valid")
    private String password;
}
