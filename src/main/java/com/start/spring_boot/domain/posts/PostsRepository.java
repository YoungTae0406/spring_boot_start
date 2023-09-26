package com.start.spring_boot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts, Long>{ //Entity 클래스, PK 타입을 <> 안에 넣어준다.
                                                                    // 그러면 기본적인 CRUD 메소드가 자동으로 생성된다.
    // 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.
}
