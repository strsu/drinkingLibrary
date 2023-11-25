package com.anhae.drinkingLibrary.domain.User.repository.dto;

import lombok.Data;


/*
* @Data
* -> @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 어노테이션을 한꺼번에 설정해주는 어노테이션
* */
@Data
public class UserDto {
    private String email;
    private String username;
    private String password;
}
