package com.example.springbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;


//년월일을 입력하면 요일을 알려주는 원격 프로그램



// 년월일을 입력하면 요일을 알려주는 원격 프로그램
@Controller
public class YoilTeller {

    @RequestMapping("/yoil") // 뷰의 이름을 반환하는 return을 안하면 url을 이름으로 씀 -> void 사용
    public ModelAndView yoil(@RequestParam("year") int year,
        @RequestParam("month") int month,
        @RequestParam("day") int day) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("yoilError"); // 기본 뷰 이름 지정


        if(!isValid(year, month, day)) { 
            return mv; // 사용자가 요청한 날짜가 유효하지 않으면 yoilError를 보여준다
        }

        //2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
        cal.clear(); // cal의 모든 필드를 초기화
        cal.set(year, month - 1, day); // month -> 0~11

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        mv.setViewName("yoil");

        return mv;
        
            }
        private boolean isValid(int year, int month, int day) { // 메서드 만들기
            
            // 여기에 각 변수별 범위 설정하여 유효성 확인하는 코드 만들기

            return true;
        }
}


//return "yoil"; // templates/yoil.html - 뷰의 이름을 반환


// <나누면서 없어진 부분>

//  @RequestMapping("/getYoil")
//  public void getYoil(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      // 1. 입력으로부터 얻어서 변수에 저장
//      String year = request.getParameter("year");
//      String month = request.getParameter("month");
//      String day = request.getParameter("day");

//        //3. 출력 - 작업 결과를 브라우저에 전송 -> MVC에서 View에 해당
//      response.setContentType("text/html");
//      response.setCharacterEncoding("ms949"); // 한글 윈도우 MS 949(윈도우 계열 한글 인코딩) 인코딩 지정 
//      //인코딩,콘텐츠타입은 getWriter()호출 전에 지정    
//      // 보통 실무에서는 UTF-8 권장 -> 웹 표준에 가까움, 플랫폼/OS 상관없이 한글/이모지/다국어 안정적
//      // -> setContentType("text/html; charset=UTF-8") = contentType도 지정


//      PrintWriter out = response.getWriter();
//      out.println("<html>");
//      out.println("<head>");
//      out.println("</head>");
//      out.println("<body>");
//      out.println("year = " + yyyy + "<br>"); // 브라우저에 출력됨
//      out.println("month = " + mm + "<br>");  // html(실제 화면)에서 줄 나누려면 <br> 추가
//      out.println("day = " + dd + "<br>");
//      out.println("yoil = " + yoil + "<br>");
//      out.println("</body>");
//      out.println("</html>");