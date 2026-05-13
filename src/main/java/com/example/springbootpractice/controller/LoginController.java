package com.example.springbootpractice.controller;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/login") // 아래 Mapping과 합쳐져서 작용됨 -> 실제 URL은 /login/login으로 입력해야 함
public class LoginController {
    //@RequestMapping("/login") 
    //@RequestMapping(value="/login", method=RequestMethod.GET)
    @GetMapping("/login") // index.html의 login 버튼과 아래 redirect문에서 들어옴
    public String showLogin() { 
        return "login"; //login.html을 보여준다
    }
    
    //@RequestMapping(value="/login", method = RequestMethod.POST) // default = GET이기 때문에 사용, GET과 POST 둘다 사용할 경우 method= (~.GET, ~.POST0) 배열로 하면 됨
    @PostMapping("/login") // login.html에서 POST로 들어옴
    public String login(String id, String pwd, Model model) throws Exception { //예외처리 안하면 인코딩 못함
        //1. id, pwd를 확인
        if (loginCheck(id,pwd)) { // 일치하면
        model.addAttribute("id", id); // 모델에 담아주기
        model.addAttribute("pwd", pwd);
            return "userinfo"; // userinfo.html로 이동
        } else { // 일치하지 않으면
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "UTF-8"); // 한글 깨지지 않기 위해 인코딩 -> 만약에 한글이 안보인다면, 브라우저에서 소스 보기를 눌렀을때 한글이 안보이면 인코딩 해줘야 함
            return "redirect:/login/login?msg="+msg; //login.html으로 이동 //redirect는 GET요청 ->  /login/login (GET)으로 요청이 들어오기 때문에, LoginController의 @GetMapping이 받음
        }                                   //여기서 코드스페이스 중계주소 문제로, 포트번호 두번 들어가는 오류 있으니, 코드스페이스에서 활용할 때에는 두번째 포트번호 지우고 접속(/login/login으로 돌아갈 때)
    }                                       //GET 요청일 때 url 뒤에 쿼리스트링을 "~?msg="+msg 형식으로 작성하면 메세지를 띄울 수 있다 => <url 다시쓰기>: url 뒤에 정보를 붙인다
                                            // -> 여기서 또... 코드스페이스 문제로 URL 다시쓰기를 사용하면... localhost:8080주소로 들어가는 오류가 또있음... 그냥 무시하고 ㄲ
    private boolean loginCheck(String id, String pwd) {
        return "asdf".equals(id) && "123".equals(pwd);
    }   
}