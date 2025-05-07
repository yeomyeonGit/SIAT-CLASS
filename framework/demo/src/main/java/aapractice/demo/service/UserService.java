package aapractice.demo.service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aapractice.demo.dao.MemberRepository;
import aapractice.demo.domain.MemberRequestDto;
import aapractice.demo.domain.PostRequestDto;
import aapractice.demo.domain.PostResponseDto;
import aapractice.demo.domain.entity.MemberEntity;
import aapractice.demo.domain.entity.PostEntity;

@Service
public class UserService {

    @Autowired
    private MemberRepository memberRepository;


    // DTO에서 꺼내서 Entity에 담고 save로 DB 업데이트
    public void createUserService(MemberRequestDto params) {
       System.out.println("debug >>>> UserService createUserService");
       MemberEntity entity = MemberEntity.builder()
                                            .email(params.getEmail())
                                            .passwd(params.getPassword())
                                            .build() ;
        
        memberRepository.save(entity) ;   // 가입절차 끝
    }

    // Post 작성
    public PostResponseDto createPostService(String id, PostRequestDto params) {
        System.out.println("debug >>>> UserService createPostService");
        Optional<MemberEntity> op = memberRepository.findById(id) ;    // select
        PostEntity post = PostEntity.builder()
                                    .title(params.getTitle())
                                    .content(params.getContent())
                                    .build() ;
        
        if(op.isPresent()) {
            op.get().addPost(post);   // op의 MemberEntity 객체를 꺼냄[ .get()]. 이 객체의 addPost 메서드를 실행
            // MemberEntity = "회원"
            // 이 회원은 자기 가방에 게시글들을 담고 있어요 (List<PostEntity> posts)
            // addPost()는 그 가방에 게시글을 하나 더 넣는 행동입니다.
            // memberRepository.save(op.get()) ;
            return PostResponseDto.builder()
                                    .title(params.getTitle())
                                    .content(params.getContent())
                                    .build() ;
        }

        return null ;
    }

    // 작성한 Post 목록 보기
    public List<PostResponseDto> getUserPostsService(String id) {
        System.out.println("debug >>>> UserService getUserPostsService");
        Optional<MemberEntity> op = memberRepository.findById(id) ;    // select 작업
        if(op.isPresent()) {
            // .get()은 List를 반환 ;
            return op.get().getPosts().stream()
                        .map(PostResponseDto::new)    // stream map을 이용한 형변환
                        .toList() ;
        }
        return null ;
    }
    
}
