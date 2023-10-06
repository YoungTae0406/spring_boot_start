package com.start.spring_boot.web.dto;

import com.start.spring_boot.domain.posts.Posts;
import lombok.Getter;

@Getter // 선언된 모든 필드의 get 메소드를 생성해줍니다.
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
