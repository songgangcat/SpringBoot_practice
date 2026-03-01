package com.example.springbootpractice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


//년월일을 입력하면 요일을 알려주는 원격 프로그램
@RestController // 등록, RestController -> GET,POST 등 모든 HTTP 메서드를 다 받음 -> get만 받을거면 @GetMapping 쓰는게 일반적
public class YoilTeller {

    @RequestMapping("/getYoil")
    public void getYoil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력으로부터 얻어서 변수에 저장
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        //2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal -> getInstance()가 기본 시간대 기준으로 달력 생성

        int yyyy, mm, dd; // 정수 하나 만들어두고

        if (year == null || month == null || day == null) {
        // 파라미터가 없으면 오늘 날짜 사용
            yyyy = cal.get(Calendar.YEAR);
            mm = cal.get(Calendar.MONTH) + 1;
            dd = cal.get(Calendar.DAY_OF_MONTH);
        } else {
            yyyy = Integer.parseInt(year);//문자열을 정수 변수로 저장
            mm = Integer.parseInt(month);
            dd = Integer.parseInt(day);
            cal.clear(); // cal의 모든 필드를 초기화 -> 안해도 되지만, 정확한 계산 위해
            cal.set(yyyy, mm - 1, dd); // 달력에 날짜 설정, Calendar의 월(mm)은 0~11이기 때문에 사용자가 넣은 값에서 -1

        }

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일을 숫자로 1~7 반환 1:일요일
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); //문자열에서 글자 하나만 뽑음, 인덱스 맞추기 위해 1~7 => 0~6


        //3. 출력 - 작업 결과를 브라우저에 전송
        response.setCharacterEncoding("ms949"); // 한글 윈도우 MS 949(윈도우 계열 한글 인코딩) 인코딩 지정 
        //인코딩,콘텐츠타입은 getWriter()호출 전에 지정    
        // 보통 실무에서는 UTF-8 권장 -> 웹 표준에 가까움, 플랫폼/OS 상관없이 한글/이모지/다국어 안정적
        // -> setContentType("text/html; charset=UTF-8") = contentType도 지정


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("year = " + yyyy + "<br>"); // 브라우저에 출력됨
        out.println("month = " + mm + "<br>");  // html(실제 화면)에서 줄 나누려면 <br> 추가
        out.println("day = " + dd + "<br>");
        out.println("yoil = " + yoil + "<br>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
