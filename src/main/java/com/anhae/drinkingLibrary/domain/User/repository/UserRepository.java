package com.anhae.drinkingLibrary.domain.User.repository;

import com.anhae.drinkingLibrary.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
//    User findOneByEmail(@Param("email") String email);

    Optional<User> findByEmail(String email);
    User findByEmailAndUsername(String email, String username);
    User findOneWithAuthoritiesByEmail(String email);
}
