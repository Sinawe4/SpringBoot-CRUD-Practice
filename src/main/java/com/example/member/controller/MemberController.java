package com.example.member.controller;

import com.example.member.domain.Member;
import com.example.member.domain.response.CommonResult;
import com.example.member.domain.response.ResponseService;
import com.example.member.domain.response.SingleResult;
import com.example.member.dto.MemberResponseDto;
import com.example.member.dto.MemberSaveRequestDto;
import com.example.member.dto.MemberSignInDto;
import com.example.member.dto.MemberUpdateRequest;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ResponseService responseService;

    @PostMapping("/save")
    public SingleResult<Long> saveMember(@RequestBody MemberSaveRequestDto requestDto){
        return responseService.getSingleResult(memberService.save(requestDto));
    }

    @GetMapping("/read/{id}")
    public SingleResult<MemberResponseDto> findByMemberId(@PathVariable Long id){
        return responseService.getSingleResult(memberService.findById(id));
    }

    @PutMapping("/update/{id}")
    public SingleResult<Long> update(@PathVariable Long id, @RequestBody MemberUpdateRequest requestDto){
        return responseService.getSingleResult(memberService.update(id,requestDto));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult deleteMember(@PathVariable Long id){
        return responseService.getSuccessResult();
    }

    @PostMapping("/login")
    public SingleResult<Map<String, String>> login (@Valid @RequestBody MemberSignInDto memberSignInDto){
        System.out.println("-----------------------------");
        final Member member = memberService.login(memberSignInDto.getName(),memberSignInDto.getPassword());
        Map<String, String> map = new HashMap<>();
        return responseService.getSingleResult(map);
    }
}
