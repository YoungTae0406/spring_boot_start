package com.start.spring_boot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long>{ //Entity 클래스, PK 타입을 <> 안에 넣어준다.
                                                                    // 그러면 기본적인 CRUD 메소드가 자동으로 생성된다.
    // 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  //SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로
    // 작성해도 되는 것을 보여드리고자 @Query를 사용함. 조회용 프레임워크를 추가로 사용하는 편. querydsl, jooq, MyBatis
    List<Posts> findAllDesc();

}
