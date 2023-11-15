package com.anhae.drinkingLibrary.domain.User.repository;

import com.anhae.drinkingLibrary.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
