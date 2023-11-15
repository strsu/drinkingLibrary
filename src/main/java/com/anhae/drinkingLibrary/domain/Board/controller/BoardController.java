package com.anhae.drinkingLibrary.domain.Board.controller;

import com.anhae.drinkingLibrary.domain.Board.repository.dto.BoardRequestDto;
import com.anhae.drinkingLibrary.domain.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor // 생성자를 자동으로 생성할 때 이미 필요한 의존성을 주입받도록 생성자가 생성
@Controller
public class BoardController {

    //@Autowired
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseEntity<?> board(@RequestBody BoardRequestDto boardRequestDto) {
        /*
        * @RequestBody : 이걸 안 쓰면 form-data 형식으로 보내야 한다.
        *                이걸 쓰면 json으로 보내고 받을 수 있다.
        * */
        this.boardService.글쓰기2(boardRequestDto);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
