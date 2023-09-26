package com.start.spring_boot.dto;

import com.start.spring_boot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
        // 검증하고 싶은 대상을 메소드 인자로 받습니다. isEqualTo()는 assertThat에 있는 값과 비교해서 같을 때만 성공입니다.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
