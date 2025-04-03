package com.utc.btl.dto.request;

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

    public boolean validate() {
        return false;
    }
}
