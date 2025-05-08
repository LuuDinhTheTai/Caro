package com.utc.btl.controller.impl;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;
import com.utc.btl.Main;
import com.utc.btl.constant.Assets;
import com.utc.btl.controller.ISoundController;
import com.utc.btl.controller.base.impl.BaseController;

public class SoundController extends BaseController implements ISoundController{

    public SoundController(Main main) {
        super(main);
        playBackgroundMusic();
    }

    @Override
    public void playBackgroundMusic() {
        Music backgroundMusic = Assets.backgroundMusic;
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
        backgroundMusic.setVolume(0.6f);
    }

    @Override
    public void moveSound() {
        Sound move = Assets.moveSound;
        move.play(1);
    }

    
    
    
}
