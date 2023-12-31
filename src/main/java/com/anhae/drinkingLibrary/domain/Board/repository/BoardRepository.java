package com.anhae.drinkingLibrary.domain.Board.repository;

import com.anhae.drinkingLibrary.domain.Board.Board;
import com.anhae.drinkingLibrary.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

// JpaRepository가 extends 되면 @Repository 필요 없음. IoC자동으로 됨.
public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Modifying
    @Query(value = "INSERT INTO board(user, contents) VALUES(?1, ?2)", nativeQuery = true)
    int mSave(User user, String contents);
}
