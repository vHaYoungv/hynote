package com.hy.hynote.service.posts;

import com.hy.hynote.domain.posts.Posts;
import com.hy.hynote.domain.posts.PostsRepository;
import com.hy.hynote.web.dto.PostsResponseDto;
import com.hy.hynote.web.dto.PostsSaveRequestDto;
import com.hy.hynote.web.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(posts);
    }
}
