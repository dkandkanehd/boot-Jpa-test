package com.bootjpa.test.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootjpa.test.service.MemberService;
import com.bootjpa.test.vo.MemberVo;

@RestController
@RequestMapping("member")
public class MemberController {
	
    @Autowired
    MemberService memberService;

    // 모든 회원 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<MemberVo>> getAllmembers() {
        List<MemberVo> member = memberService.findAll();
        return new ResponseEntity<List<MemberVo>>(member, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> getMember(@PathVariable("mbrNo") Long mbrNo) {
        Optional<MemberVo> member = memberService.findById(mbrNo);
        return new ResponseEntity<MemberVo>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) {
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
    @PutMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> updateMember(@PathVariable("mbrNo") Long mbrNo, MemberVo member) {
        memberService.updateById(mbrNo, member);
        return new ResponseEntity<MemberVo>(member, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping
    public ResponseEntity<MemberVo> save(MemberVo member) {
        return new ResponseEntity<MemberVo>(memberService.save(member), HttpStatus.OK);
    }

    // 회원 입력
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<MemberVo> save(HttpServletRequest req, MemberVo member){
        return new ResponseEntity<MemberVo>(memberService.save(member), HttpStatus.OK);
    }
}
