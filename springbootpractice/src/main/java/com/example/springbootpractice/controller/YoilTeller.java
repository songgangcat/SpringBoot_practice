package com.example.springbootpractice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


//년월일을 입력하면 요일을 알려주는 원격 프로그램
@RestController // 등록
public class YoilTeller {

    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력으로부터 얻어서 변수에 저장
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year); //문자열을 정수로 변환
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        //2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
        cal.clear(); // cal의 모든 필드를 초기화 -> 안해도 되지만, 정확한 계산 위해
        cal.set(yyyy, mm-1, dd); // 월(mm)은 0부터 11이기 때문에 1을 뺌

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7을 반환 1:일요일
        char yoil = "일월화수목금토".charAt(dayOfWeek-1); // 1~7 => 0~6


        //3. 출력 - 작업 결과를 브라우저에 전송
        response.setCharacterEncoding("ms949"); // 한글 윈도우 MS 949 인코딩 지정


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("year = "+year); // 브라우저에 출력됨
        out.println("month = "+month);
        out.println("day = "+day);
        out.println("yoil = " + yoil);
        out.println("</body>");
        out.println("</html>");
    }
    
}
