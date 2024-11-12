package org.koreait.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
//    @GetMapping("/member/login")
    //여러개 쓰는 경우 RequestMapping
    /*@RequestMapping(path={"/member/login", "/user/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {
        System.out.println("로그인 페이지 유입!");
        return "member/form";

    }*/

//    /member/login?type=어떤 값
//    @GetMapping(path="/login", params = {"type"}) // /member/login
//    headers는 요청 헤더에 Authorization 값이 있는 경우만 유입
//    @GetMapping(path="/login", headers = "Authorization")
    @GetMapping("/login")
//    produces = "application/json" - 응답 헤더 Content-Type: application/json
//    @GetMapping(path="/login", produces = "application/json")
    public String login() {

        System.out.println("로그인 양식!");

        return "member/form";
    }


    @PostMapping("/login") // /member/login
    public String loginPs() {

        return "member/form";
    }

    @GetMapping("/join") // /member/join
    public String join() { // 회원가입 양식

        return "member/joinForm";
    }

    @PostMapping("/join") // /member.join
    public String joinPs(RequestJoin form/*, Model model*/) { // 회원가입 처리
        System.out.println(form); // 커맨드 객체는 자동으로 EL 속성으로 추가, 속성명이 클래스명, 앞자는 소문자 RequestJoin -> requestJoin

//        List<String> hobby = form.getHobby();
//        System.out.println(Arrays.toString(hobby));
        //model.addAttribute("requestJoin", form);

        /*
        * 회원 가입 처리 완료 후 주소 이동(로그인 페이지)
        * 응답 헤더 Location: /springweb/member/login
        * HttpServletResponse
        * response.sendRedirect(request.getContextPath() + "/member/login");
        * */

        return "member/joinForm";
//        return "redirect:/member/login"; // 응답 헤더 Location: /springweb/member/login
//        return "forward:/member/login"; // RequestDispatcher rd = request.getRequestDispatcher("...."); rd.forward(request, response);...
    }

}

/*
* 게시판 - BoardController
* 게시글 목록 - /board/list : 게시판 전체 요약 정보 출력
*   - 게시판 아이디별 목록 : 특정 게시판의 목록
*       /board/list/게시판아이디
*       /board/list/freetalk : 자유게시판
*       /board/list/notice : 공지사항
*       :URL 경로에서 변경 가능한 부분 : 경로 변수
* 게시글 등록 - /board/write - 양식, 처리
*   - 게시판 아이디별 등록
*       /board/write/게시판 아이디
*       /board/write/freetalk : 자유게시판 쓰기
*       /board/write/notice : 공지사항 쓰기
*       :URL 경로에서 변경 가능한 부분 : 경로 변수
*
* 컨트롤러 정의 -> 뷰에 사용할 템플릿 jsp
*
 */