package com.jun.springboot.web.dto;

import com.jun.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String hashtag;
    private String content;
    private String location;
    private LocalDateTime date_time;
    private String picture_list;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.hashtag = entity.getHashtag();
        this.content = entity.getContent();
        this.location = entity.getLocation();
        this.date_time = entity.getDate_time();
        this.picture_list = entity.getPicture_list();
    }
}
