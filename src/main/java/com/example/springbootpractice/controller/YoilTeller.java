package com.example.springbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class YoilTeller {

    @RequestMapping("/getyoil") // 뷰의 이름을 반환하는 return을 안하면 url을 이름으로 씀 -> void 사용
    public String main(@ModelAttribute MyDate myDate, Model model) { // 입력은 매개변수
                        //@ModelAttribute -> mydate를 자동으로 Model에 저장

        return "yoil";
        //스프링 MVC 처리 과정에서 "모델 준비 단계"가 먼저 실행되기 때문에, 이 코드보다 @ModelAttribute 아래 메서드가 먼저 실행됨
            }

//메서드로 뽑아내기
//ModelAttribute -> 메서드의 결과값을 "yoil" 이름으로 모델에 저장
@ModelAttribute("yoil")
    private char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
        cal.clear(); // cal의 모든 필드를 초기화
        cal.set(myDate.getYear(), myDate.getMonth() - 1, myDate.getDay()); // month -> 0~11

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
        return yoil;
    }
}


