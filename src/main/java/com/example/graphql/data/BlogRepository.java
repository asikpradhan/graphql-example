package com.example.graphql.data;

import com.example.graphql.data.entity.Blog;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;


@GraphQlRepository
public interface BlogRepository extends CrudRepository<Blog, Long>, QuerydslPredicateExecutor<Blog> {
}
