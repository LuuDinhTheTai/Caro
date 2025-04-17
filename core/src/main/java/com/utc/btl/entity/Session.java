package com.utc.btl.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Session {

    private Long id;
    private int xWin;
    private int oWin;
    private int draw;

    public Session(int xWin, int oWin, int draw) {
        this.xWin = xWin;
        this.oWin = oWin;
        this.draw = draw;
    }
}
//CREATE TABLE `caro`.`session` (
//                                `id` INT NOT NULL AUTO_INCREMENT,
//  `xWin` INT NOT NULL DEFAULT 0,
//                                  `yWin` INT NOT NULL DEFAULT 0,
//                                                                  `draw` INT NOT NULL DEFAULT 0,
//PRIMARY KEY (`id`));
