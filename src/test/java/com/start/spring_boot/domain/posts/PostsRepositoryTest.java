package com.start.spring_boot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest //H2 데이터베이스를 자동으로 실행해준다.
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정. 보통은 배포 전 전체 테스트를 수행할 때
    // 테스트간 데이터 침범을 막기 위해 사용합니다.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //테이블 posts에 insert/update 쿼리를 실행한다.
                // id 값이 있다면 update가, 없다면 insert 쿼리가 실행됩니다.
                .title(title)
                .content(content)
                .author("yeongtaekim@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드입니다.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,10,1,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
