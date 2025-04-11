package com.utc.btl.dto.request;

import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private String username;
    private String password;
    private String confirmPassword;

    public void validate() {
        if (username.isEmpty()) {
            throw new GameException(ExceptionType.EMPTY_USERNAME_EXCEPTION);
        }
        if (password.isEmpty()) {
            throw new GameException(ExceptionType.EMPTY_PASSWORD_EXCEPTION);
        }
        if (confirmPassword.isEmpty()) {
            throw new GameException(ExceptionType.EMPTY_CONFIRM_PASSWORD_EXCEPTION);
        }
        if (!password.equals(confirmPassword)) {
            throw new GameException(ExceptionType.CONFIRM_PASSWORD_NOT_MATCH_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return "RegisterRequest [username=" + username
                   + ", password=" + password
                   + ", confirmPassword=" + confirmPassword + "]";
    }
}
