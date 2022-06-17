package com.example.graphql;

import com.example.graphql.data.*;
import com.example.graphql.data.entity.Blog;
import com.example.graphql.data.entity.BlogUser;
import com.example.graphql.service.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class BlogRepositoryInitializer implements ApplicationRunner {

    private final BlogRepository blogRepository;

    private final BlogUserService blogUserService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        var user = blogUserService.createUser(BlogUser.builder().name("Sam Smith").id(1L).createdDate(new Date()).build());


        List<Blog> blogList = Arrays.asList(
                Blog.builder().id(2L).title("First").blogUser(user).publishedDate(new Date()).content("<article><h1>This is first article header</h1><section>Article section</section></article>").build(),
                Blog.builder().id(3L).title("Second").blogUser(user).publishedDate(new Date()).content("<article><h1>This is second article header</h1><section>Article section</section></article>").build(),
                Blog.builder().id(4L).title("Third").blogUser(user).publishedDate(new Date()).content("<article><h1>This is third article header</h1><section>Article section</section></article>").build()
        );
        blogRepository.saveAll(blogList);
    }

}
