//package com.anhae.drinkingLibrary;
//
//
//import com.anhae.drinkingLibrary.repository.BoardRepository;
//import com.anhae.drinkingLibrary.service.BoardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//	private final BoardRepository boardRepository;
//
//	@Autowired
//	public SpringConfig(BoardRepository boardRepository) {
//		this.boardRepository = boardRepository;
//	}
//
//	@Bean
//	public BoardService boardService() {
//		return new BoardService(this.boardRepository);
//	}
//}