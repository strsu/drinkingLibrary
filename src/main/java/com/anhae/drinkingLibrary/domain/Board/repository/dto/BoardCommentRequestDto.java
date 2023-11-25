package com.anhae.drinkingLibrary.domain.Board.repository.dto;

import com.anhae.drinkingLibrary.domain.Board.Board;
import com.anhae.drinkingLibrary.domain.User.User;
import lombok.Data;

@Data
public class BoardCommentRequestDto {
    private User user;
    private Board board;
    private String contents;
}
