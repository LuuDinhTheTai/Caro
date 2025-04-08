package com.utc.btl.dto.request;

import com.utc.btl.exception.AppException;
import com.utc.btl.exception.CustomException;
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
            throw new AppException(CustomException.EMPTY_USERNAME);
        }
        if (password.isEmpty()) {
            throw new AppException(CustomException.EMPTY_PASSWORD);
        }
        if (confirmPassword.isEmpty()) {
            throw new AppException(CustomException.EMPTY_CONFIRM_PASSWORD);
        }
        if (!password.equals(confirmPassword)) {
            throw new AppException(CustomException.CONFIRM_PASSWORD_NOT_MATCH);
        }
    }
}
