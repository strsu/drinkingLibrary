package com.anhae.drinkingLibrary.domain.Board.service;

import com.anhae.drinkingLibrary.domain.Board.Board;
import com.anhae.drinkingLibrary.domain.Board.repository.dto.BoardRequestDto;
import com.anhae.drinkingLibrary.domain.Board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(BoardRequestDto boardRequestDto) {
        this.boardRepository.mSave(boardRequestDto.getName(), boardRequestDto.getContents());
    }

    @Transactional
    public void 글쓰기2(BoardRequestDto boardRequestDto) {
        // data jpa 사용
        Board board = new Board();
        board.setName(boardRequestDto.getName());
        board.setContents(boardRequestDto.getContents());
        this.boardRepository.save(board);
    }
}
