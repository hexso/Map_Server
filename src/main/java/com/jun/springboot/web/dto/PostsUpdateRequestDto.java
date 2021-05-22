package com.jun.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String hashtag;
    private String content;
    private String location;
    private LocalDateTime date_time;
    private String picture_list;

    @Builder
    public PostsUpdateRequestDto(String hashtag, String content, String location, LocalDateTime date_time, String picture_list){
        this.hashtag = hashtag;
        this.content = content;
        this.location = location;
        this.date_time = date_time;
        this.picture_list = picture_list;
    }
}
