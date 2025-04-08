package com.utc.btl.dto.response;

import com.utc.btl.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountResponse {

    private long id;
    private String username;
    private long elo;
    private int win;
    private int loss;
    private int draw;

    public static AccountResponse from(Account account) {
        return new AccountResponse(
            account.getId(),
            account.getUsername(),
            account.getElo(),
            account.getWin(),
            account.getLoss(),
            account.getDraw()
        );
    }
}
