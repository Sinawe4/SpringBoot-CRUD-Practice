package com.example.member.dto;

import com.example.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    public Long id;
    public String name;
    public String password;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
    }
}
