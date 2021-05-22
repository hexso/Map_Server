package com.jun.springboot.service.posts;

import com.jun.springboot.domain.posts.Posts;
import com.jun.springboot.domain.posts.PostsRepository;
import com.jun.springboot.web.dto.PostsResponseDto;
import com.jun.springboot.web.dto.PostsSaveRequestDto;
import com.jun.springboot.web.dto.PostsUpdateRequestDto;
import com.jun.springboot.web.dto.PostsListResponseDto;
import com.jun.springboot.web.dto.PostsFileDto;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

@RequiredArgsConstructor
@Service
public class PostsService {


    private final PostsRepository postsRepository;

    public void check_dir(String dir_path){
        String path = dir_path; //폴더 경로
	    File Folder = new File(path);
         // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
         if (!Folder.exists()) {
            try{

                Folder.mkdirs(); //폴더 생성합니다.
                System.out.println("폴더가 생성되었습니다.");
                } 
                catch(Exception e){
                e.getStackTrace();
            }        
            }else {
        }
    }

    @Transactional
    public int file(PostsFileDto requestDto){
        int result = 0;
        LocalDate now_time = LocalDate.now();
        String filename = requestDto.getFilename();
        byte[] data = requestDto.getData();
        String file_dir= "picture/" + now_time;
        check_dir(file_dir);
        try{
            File f = new File(file_dir + "/" + filename);
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(data,0,data.length);
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getHashtag(), requestDto.getContent(), requestDto.getLocation(), requestDto.getDate_time(), requestDto.getPicture_list());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("헤당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        postsRepository.delete(posts);
    }
}
