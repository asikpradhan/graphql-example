package com.example.graphql.service;

import com.example.graphql.data.entity.BlogUser;
import com.example.graphql.data.BlogUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogUserService {
    private final BlogUserRepository blogUserRepository;

    public BlogUser createUser(BlogUser blogUser) {
        return blogUserRepository.save(blogUser);
    }

}
