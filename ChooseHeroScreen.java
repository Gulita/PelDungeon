package com.ema.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ema.game.Dungeon;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import javax.xml.soap.Text;

public class ChooseHeroScreen implements Screen {
    private Dungeon parent;
    private Stage stage;

    public ChooseHeroScreen(Dungeon game){
        parent = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = parent.assetManager.manager.get("skin/craftacular-ui.json");
        TextButton chooseYHero = new TextButton("CHOOSE YOUR HERO", skin);
        chooseYHero.setDisabled(true);
        table.add(chooseYHero).fillX().uniformX().colspan(2);

        Texture image1 = parent.assetManager.manager.get("images/hero.png");
        Texture image2 = parent.assetManager.manager.get("images/heroine.png");
        ImageButton hero1 = new ImageButton(new TextureRegionDrawable(image1));
        ImageButton hero2 = new ImageButton(new TextureRegionDrawable(image2));

        table.row().pad(20, 10, 20, 10);
        table.add(hero1).fillX().uniformX().size(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.5f);
        table.add(hero2).fillX().uniformX().size(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.5f);

        hero1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Dungeon.APPLICATION);
            }
        });
        hero2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Dungeon.APPLICATION);
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
    }

}
