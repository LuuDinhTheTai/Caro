package com.utc.btl.dto.request;

import com.utc.btl.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import static com.utc.btl.exception.CustomException.EMPTY_PASSWORD;
import static com.utc.btl.exception.CustomException.EMPTY_USERNAME;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {

    private String username;
    private String password;

    public void validate() {
        if (username.isEmpty()) {
            throw new AppException(EMPTY_USERNAME);
        }
        if (password.isEmpty()) {
            throw new AppException(EMPTY_PASSWORD);
        }
    }
}
