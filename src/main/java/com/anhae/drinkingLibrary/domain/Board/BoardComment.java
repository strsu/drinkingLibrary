package com.anhae.drinkingLibrary.domain.Board;

import com.anhae.drinkingLibrary.domain.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Many = Board, User = One 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name="userId") // foreign key (userId) references User (id)
    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다. //참조 할 테이블

    @ManyToOne // Many = Board, comment = One
    @JoinColumn(name="boardId")
    private Board board;

    @Column(columnDefinition = "TEXT")
    private String contents;
}