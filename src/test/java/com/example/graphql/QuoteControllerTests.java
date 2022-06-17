/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.graphql;

import com.example.graphql.controller.QuoteController;
import com.example.graphql.data.Quote;
import com.example.graphql.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

/**
 * GraphQL requests via {@link GraphQlTester}.
 */
@GraphQlTest(QuoteController.class)
public class QuoteControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private QuoteService quoteService;


    @Test
    void getQuote() {

        given(this.quoteService.getQuote(eq("site1")))
                .willReturn(new Quote("site1", 500));


        this.graphQlTester.documentName("quote")
                .variable("site", "site1")
                .execute()
                .path("quote.price")
                .entity(Integer.class).isEqualTo(500);

    }

    @Test
    void getQuotes() {
        given(this.quoteService.getQuotes()).willReturn(List.of(new Quote("site1", 500), new Quote("site2", 450)));
        this.graphQlTester.documentName("quotes")
                .execute()
                .path("quotes[*].site")
                .entityList(String.class).containsExactly("site1", "site2");
    }

}
