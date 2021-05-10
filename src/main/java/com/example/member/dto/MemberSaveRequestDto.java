package com.example.member.dto;

import com.example.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String name;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .password(password)
                .build();
    }
}