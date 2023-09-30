package com.start.spring_boot.domain.posts;

import com.start.spring_boot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // JPA에서 제공하는 어노테이션. 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로
// 테이블 이름을 매칭합니다. ex) SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {
    @Id // JPA에서 제공하는 어노테이션. 해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA에서 제공하는 어노테이션. PK의 생성 규칙을 나타낸다. 이 옵션을 추가하면
    // auto_increment가 된다.
    private Long id;

    @Column(length=500, nullable = false) // JPA에서 제공하는 어노테이션. 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도
    // 해당 클래스의 필드는 모두 칼럼이 됩니다. 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
