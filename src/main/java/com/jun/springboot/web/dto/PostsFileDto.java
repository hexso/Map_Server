package com.jun.springboot.web.dto;

import javax.persistence.Access;

import com.jun.springboot.domain.posts.Posts;

import org.springframework.boot.json.GsonJsonParser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class PostsFileDto {
    private String filename;
    private byte[] data;
    @Builder
    PostsFileDto(String filename, byte[] data){
        this.filename = filename;
        this.data = data;
    }
}
