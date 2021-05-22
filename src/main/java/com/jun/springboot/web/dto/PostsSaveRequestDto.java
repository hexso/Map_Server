package com.jun.springboot.web.dto;

import com.jun.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String hashtag;
    private String content;
    private String location;
    private LocalDateTime date_time;
    private String picture_list;

    @Builder
    PostsSaveRequestDto(String hashtag, String content, String location, LocalDateTime date_time, String picture_list){
        this.hashtag = hashtag;
        this.content = content;
        this.location = location;
        this.date_time = date_time;
        this.picture_list = picture_list;
    }

    public Posts toEntity(){
        return Posts.builder()
            .hashtag(hashtag)
            .content(content)
            .location(location)
            .date_time(date_time)
            .picture_list(picture_list)
            .build();
    }
}
