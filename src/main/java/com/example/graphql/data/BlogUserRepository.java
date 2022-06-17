package com.example.graphql.data;

import com.example.graphql.data.entity.BlogUser;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;


@GraphQlRepository
public interface BlogUserRepository extends CrudRepository<BlogUser, Long>, QuerydslPredicateExecutor<BlogUser> {
}
