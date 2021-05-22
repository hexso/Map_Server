package com.jun.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(columnDefinition = "TEXT")
    private String hashtag;
    
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String location;


    @Column(columnDefinition = "TEXT", nullable = false)
    private LocalDateTime date_time;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String picture_list;


    @Builder
    public Posts(String hashtag, String content, String location, LocalDateTime date_time, String picture_list) {
        this.hashtag = hashtag;
        this.content = content;
        this.location = location;
        this.date_time = date_time;
        this.picture_list = picture_list;
    }

    public void update(String hashtag, String content, String location, LocalDateTime date_time, String picture_list){
        this.hashtag = hashtag;
        this.content = content;
        this.location = location;
        this.date_time = date_time;
        this.picture_list = picture_list;
    }
}
