package com.jun.springboot.web.dto;
import lombok.Getter;
import com.jun.springboot.domain.posts.Posts;
import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {
    private Long id;
    private String hashtag;
    private String content;
    private String location;
    private LocalDateTime date_time;
    private String picture_list;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.hashtag = entity.getHashtag();
        this.content = entity.getContent();
        this.location = entity.getLocation();
        this.date_time = entity.getDate_time();
        this.picture_list = entity.getPicture_list();
    }
}
