package com.example.springbootpractice.controller;

import java.util.Date;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RequestParamTest {
	@RequestMapping("/requestparam")
	public String main(HttpServletRequest request) { // 기본 형식, HttpServletRequest 타입으로 매개변수 선언
		String year = request.getParameter("year");
//		http://localhost/requestParam         ---->> year=null
//		http://localhost/requestParam?year=   ---->> year=""
//		http://localhost/requestParam?year    ---->> year=""
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestparam2")
//	public String main2(@RequestParam(name="year", required=false) String year) {   // 아래와 동일 
	public String main2(String year) {   // @RequestParam이 생략된 상태
//		http://localhost/requestParam2         ---->> year=null
//		http://localhost/requestParam2?year    ---->> year=""
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestparam3")
//		public String main3(@RequestParam(name="year", required=true) String year) {   // 아래와 동일 
		public String main3(@RequestParam String year) {   
//		http://localhost/requestParam3         ---->> year=null   400 Bad Request. required=true라서 
//		http://localhost/requestParam3?year    ---->> year=""
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";	
	}

	@RequestMapping("/requestparam4")
	public String main4(@RequestParam(required=false) String year) {   
//		http://localhost/requestParam4         ---->> year=null 
//		http://localhost/requestParam4?year    ---->> year=""   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestparam5")
	public String main5(@RequestParam(required=false, defaultValue="1") String year) {   
//		http://localhost/requestParam5         ---->> year=1   
//		http://localhost/requestParam5?year    ---->> year=1   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
// =======================================================================
	
	@RequestMapping("/requestparam6") 
//	public String main6(@RequestParam(required=false) int year) {   
	public String main6(int year) {    // year가 int라서 빈 문자열 받을 수 없다
//		http://localhost/requestParam6        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
//		http://localhost/requestParam6?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestparam7") 
	public String main7(@RequestParam int year) {   
//		http://localhost/requestParam7        ---->> 400 Bad Request, Required int parameter 'year' is not present
//		http://localhost/requestParam7?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestparam8") 
	public String main8(@RequestParam(required=false) int year) {   
	//	http://localhost/requestParam8        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
	//	http://localhost/requestParam8?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestparam9") 
	public String main9(@RequestParam(required=true) int year) {   
	//	http://localhost/requestParam9        ---->> 400 Bad Request, Required int parameter 'year' is not present
	//	http://localhost/requestParam9?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: "" 
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
	@RequestMapping("/requestparam10")   
	public String main10(@RequestParam(required=true, defaultValue="1") int year) {   // defaultValue -> 값이 안넘어왔을 때 넣어줄 기본값
	//	http://localhost/requestParam10        ---->> year=1   
	//	http://localhost/requestParam10?year   ---->> year=1   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}

	@RequestMapping("/requestparam11")   
	public String main11(@RequestParam(required=false, defaultValue="1") int year) {   
//		http://localhost/requestParam11        ---->> year=1   
//		http://localhost/requestParam11?year   ---->> year=1   
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
} // class