package com.mong.book.springboot.web.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

// @Builder 는 생성자로 값을 채워 객체를 완성하는 목적으로 사용한다.
// 하지만 생성자로는 어느 필드에 어떤 값을 채워야할지 명확하게 인지하지 못하며
// 이로인해 발생하는 문제를 @Builder 로 해결할수 있다.