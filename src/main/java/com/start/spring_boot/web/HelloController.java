package com.start.spring_boot.web;

import com.start.spring_boot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.
RestController; // 컨트롤러를 json을 반환하는 컨트롤러로 만들어 준다.
@RestController
public class HelloController {
    @GetMapping("/hello") // HTTP 메소드인 GET의 요청을 받을 수 있는 API를 만들어 준다. /hello로 요청이 오면 문자열
    // hello를 반환하는 기능을 가지게 되었습니다.
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // @RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는
                                     //어노테이션입니다. 여기서는 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장하게 됩니다.
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);

    }

}
