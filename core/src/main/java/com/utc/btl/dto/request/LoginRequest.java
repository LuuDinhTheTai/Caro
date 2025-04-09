package com.utc.btl.dto.request;

import com.utc.btl.exception.GameException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.utc.btl.exception.ExceptionType.EMPTY_PASSWORD;
import static com.utc.btl.exception.ExceptionType.EMPTY_USERNAME;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;

    public void validate() {
        if (username.isEmpty()) {
            throw new GameException(EMPTY_USERNAME);
        }
        if (password.isEmpty()) {
            throw new GameException(EMPTY_PASSWORD);
        }
    }
}
