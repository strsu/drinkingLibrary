package com.anhae.drinkingLibrary.domain.Board;

import jakarta.persistence.*;

import lombok.*;

@Entity // entity는 primary key가 꼭 필요하다. (@Id로 지정), model로 만들기 위해서 필요하다.
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 200, nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String contents;
}