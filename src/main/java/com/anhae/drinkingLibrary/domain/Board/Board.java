package com.anhae.drinkingLibrary.domain.Board;

import com.anhae.drinkingLibrary.domain.User.User;
import jakarta.persistence.*;

import lombok.*;

@Entity // entity는 primary key가 꼭 필요하다. (@Id로 지정), model로 만들기 위해서 필요하다.
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Many = Board, User = One 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name="userId") // foreign key (userId) references User (id)
    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다. //참조 할 테이블

    @Column(columnDefinition = "TEXT")
    private String contents;
}