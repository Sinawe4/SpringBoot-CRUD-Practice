package com.example.member.service;


import com.example.member.domain.Member;
import com.example.member.dto.MemberResponseDto;
import com.example.member.dto.MemberSaveRequestDto;
import com.example.member.dto.MemberUpdateRequest;
import com.example.member.advice.exception.UserAlreadtExistsException;
import com.example.member.advice.exception.UserNotFoundException;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //save
    public Long save(MemberSaveRequestDto requestDto) {
        if (memberRepository.findByName(requestDto.getName()) != null){
            throw new UserAlreadtExistsException();
        }
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    //read
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        return new MemberResponseDto(member);
    }

    @Transactional
    public Long update(Long id, MemberUpdateRequest requestDto){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        member.update(requestDto.getName(),requestDto.getPassword());
        return id;
    }

    public String delete (Long id){
        memberRepository.deleteById(id);
        return "deleted"+id+"ID member";
    }

    public Member login(String name, String password){
        Member member = memberRepository.findByName(name);
        System.out.println("--------------------------");
        System.out.println(member);
        System.out.println(name);
        return member;
    }


}
