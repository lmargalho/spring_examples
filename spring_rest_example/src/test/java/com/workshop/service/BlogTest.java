package com.workshop.service;

import com.workshop.model.BlogEntry;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlogTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BlogService blogService;

    @Before
    public void setup() {
        BDDMockito.given(blogService.getBlogEntry(ArgumentMatchers.eq(1L))).willReturn(
                new BlogEntry(null, "My First Post", "My First Post content"));

        BDDMockito.given(blogService.getBlogEntry(ArgumentMatchers.eq(2L))).willReturn(
                new BlogEntry(null, "My Second Post", "My First Post content"));
    }

    @Test
    public void first_test() {

        //restTemplate.postForEntity("/blog",
        //        new BlogEntry(null, "My First Post", "My First Post content"),
        //        Void.class );

        Assertions.assertThat(restTemplate.getForEntity("/blog/1", BlogEntry.class).getBody().getTitle())
                .isEqualTo("My First Post");
    }

    @Test
    public void second_test() {
        Assertions.assertThat(restTemplate.getForEntity("/blog/2", BlogEntry.class).getBody().getTitle())
                .isEqualTo("My Second Post");
    }

    @Test
    public void third_test() {
        Assertions.assertThat(restTemplate.getForEntity("/blog/3", BlogEntry.class).getBody())
                .isNull();
    }
}
