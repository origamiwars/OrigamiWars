package com.BreakthroughGames.OrigamiWars.stages;

import javax.microedition.khronos.opengles.GL10;

import com.BreakthroughGames.OrigamiWars.Adventure;
import com.BreakthroughGames.OrigamiWars.Draw;
import com.BreakthroughGames.OrigamiWars.EnemyFire;
import com.BreakthroughGames.OrigamiWars.Events;
import com.BreakthroughGames.OrigamiWars.HUD;
import com.BreakthroughGames.OrigamiWars.Player;
import com.BreakthroughGames.OrigamiWars.Pref;
import com.BreakthroughGames.OrigamiWars.R;
import com.BreakthroughGames.OrigamiWars.Screen;
import com.BreakthroughGames.OrigamiWars.Sound;
import com.BreakthroughGames.OrigamiWars.SoundPlayer;
import com.BreakthroughGames.OrigamiWars.Values;

public class Stage3_2 extends Adventure {
    private float leafData[][] = {{4.1f, 19.1f, 21f, 31.6f, 40.3f, 52.7f, 55.6f, 70.4f, 72.2f, 73f, 86.2f, 88.1f, 91.8f, 118f, 123.2f, 139.1f, 141.1f, 143.7f, 151.6f, 170.2f, 174.6f, 175f, 177f, 178.7f, 181.8f, 183.7f,},
            {3.5f, 5.5f, 6.3f, 5.2f, 8.2f, 4.3f, 6.7f, 4.4f, 3.7f, 6.6f, 4.8f, 6.7f, 7.6f, 3.8f, 5.5f, 4.1f, 5.7f, 7.7f, 6.3f, 4.1f, 3f, 7.5f, 4.6f, 8.1f, 6.2f, 4.5f,},
            {Values.PATH_WIND, EnemyFire.SHOT_NONE, 0, 0,}};

    private float dFlyData[][] = {{3.2f, 5.4f, 12.8f, 14.4f, 24.4f, 26.2f, 36f, 37.7f, 41.8f, 56.3f, 57.8f, 58.1f, 73.9f, 75.6f, 87.7f, 90f, 112.9f, 115.4f,},
            {5.8f, 7.3f, 5.7f, 7.3f, 5.4f, 4.1f, 7.4f, 6.8f, 1.7f, 4.1f, 5f, 2.3f, 4.5f, 6.7f, 2.8f, 2f, 3.3f, 1.9f,},
            {Values.PATH_AVOID, EnemyFire.SHOT_Small, EnemyFire.PATH_INTERCEPT_FAST, EnemyFire.FIRE_Twice,}};

    private float batsData[][] = {{6.3f, 11.6f, 23.5f, 34.4f, 45.9f, 48f, 48.3f, 97.6f, 98.9f, 102.1f, 128.1f, 129.2f, 131f, 160.3f, 163.4f,},
            {3.7f, 8f, 3.4f, 9f, 5.5f, 6.9f, 4.2f, 1.7f, 4.8f, 3.9f, 5.6f, 8f, 5f, 3f, 5.8f,},
            {Values.PATH_SINE_WAVE, EnemyFire.SHOT_Medium, EnemyFire.PATH_INTERCEPT_FAST, EnemyFire.FIRE_2ndTime,}};

    private float vultData[][] = {{15.7f, 27.5f, 38.5f, 49.9f, 59.3f, 76.3f, 89.8f, 102.4f, 115.5f, 132.3f, 141.3f, 144.2f, 156.1f, 164.1f,},
            {4.4f, 6.8f, 5.3f, 5.2f, 3.7f, 2.3f, 5f, 1.2f, 5.1f, 7f, 1.6f, 4.1f, 2.2f, 2.7f,},
            {Values.PATH_INTERCEPT_MED, EnemyFire.SHOT_Medium, EnemyFire.PATH_STRAIGHT_FAST, EnemyFire.FIRE_Twice,}};

    private float petrData[][] = {{32.7f, 65.6f, 67.6f, 69.8f, 119.4f, 121.4f, 124.2f, 148.6f, 151.4f, 154.7f, 167.5f, 167.9f, 168.2f,},
            {1.4f, 6.6f, 3.9f, 1.6f, 7.8f, 5.4f, 3.1f, 2.1f, 4f, 5.5f, 8.1f, 5.5f, 2.5f,},
            {Values.PATH_INTERCEPT_FAST, EnemyFire.SHOT_Medium, EnemyFire.PATH_STRAIGHT_FAST, EnemyFire.FIRE_Twice,}};


    private float dragData[][] = {{9f, 19.9f, 30.9f, 43.6f, 52f, 61f, 80.3f, 81.7f, 84.5f, 95.6f, 106.9f, 108.5f, 134.9f, 137.2f, 148.2f, 158.5f, 160.4f,},
            {2.4f, 1.7f, 8.3f, 8.3f, 1.6f, 2.3f, 2.1f, 4.1f, 2f, 7.2f, 2.1f, 6.3f, 2.1f, 5.6f, 5.6f, 4.9f, 7.5f,},
            {Values.PATH_INTERCEPT_FAST, EnemyFire.SHOT_DragFire, EnemyFire.PATH_INLINE_FAST, EnemyFire.FIRE_Always,}};


    /*============================================Start Class Methods=============================================================*/
    @Override
    public void resumeLevel() {
        BG_Sky.loadTexture(R.drawable.lvl2_bg_sky);
        BG_Front.loadTexture(R.drawable.lvl2_bg_front, GL10.GL_REPEAT);
        BG_Back.loadTexture(R.drawable.lvl2_bg_back, GL10.GL_REPEAT);
    }

    public void loadLevel() {
        BG_Sky.loadTexture(R.drawable.lvl2_bg_sky);
        BG_Front.loadTexture(R.drawable.lvl2_bg_front, GL10.GL_REPEAT);
        BG_Back.loadTexture(R.drawable.lvl2_bg_back, GL10.GL_REPEAT);

        LEVEL_ENEMIES = batsData[0].length + dFlyData[0].length + vultData[0].length + petrData[0].length + dragData[0].length;

        SoundPlayer.playSound(Sound.BG_MUSIC_LEVEL5);                            // Play Level Music
        super.reset();
        initObjects();                                                            // Initilize all object, items and weapons
    }/*-----------------------------------------------------End Method()------------------------------------------------------------*/

    public void runOneFrame() {
        calcLevelStats();                                                    // Calculate level speed and Maximum Enemies
        drawBackgrounds();
        moveObjects();
        detectCollision();
        headUpDisplay();
    }/*-----------------------------------------------------End Method()------------------------------------------------------------*/

    void headUpDisplay() {
        HUD.showStats();                                                // Show Stats HUD - Life, weapon, fire etc
        switch (events.iTimer) {
            case 2:
                events.dispatch(Events.STAGE3_LEVEL2);
                break;                            // level 2 Start
        }
        events.draw();
    }

    /************************************************************************************************************************
     *   METHOD- Init Objects
     ***********************************************************************************************************************/
    public void initObjects() {
        for (int i = 0; i < Values.ENEMY_END; i++)
            arIndex[i] = 0;            // Reset Indexes for enemy arrays
        for (int i = 0; i < Values.ENEMY_END; i++) arDistance[i] = null;    // Reset array

        arDistance[Values.ENEMY_LEAF] = leafData[0];
        arPosition[Values.ENEMY_LEAF] = leafData[1];
        arProperty[Values.ENEMY_LEAF] = leafData[2];

        arDistance[Values.ENEMY_DRAGONFLY] = dFlyData[0];
        arPosition[Values.ENEMY_DRAGONFLY] = dFlyData[1];
        arProperty[Values.ENEMY_DRAGONFLY] = dFlyData[2];

        arDistance[Values.ENEMY_BAT] = batsData[0];
        arPosition[Values.ENEMY_BAT] = batsData[1];
        arProperty[Values.ENEMY_BAT] = batsData[2];

        arDistance[Values.ENEMY_VULTURE] = vultData[0];
        arPosition[Values.ENEMY_VULTURE] = vultData[1];
        arProperty[Values.ENEMY_VULTURE] = vultData[2];

        arDistance[Values.ENEMY_PTEROSAUR] = petrData[0];
        arPosition[Values.ENEMY_PTEROSAUR] = petrData[1];
        arProperty[Values.ENEMY_PTEROSAUR] = petrData[2];

        arDistance[Values.ENEMY_DRAGON] = dragData[0];
        arPosition[Values.ENEMY_DRAGON] = dragData[1];
        arProperty[Values.ENEMY_DRAGON] = dragData[2];

        for (int i = 0; i < 8; i++)
            createEnemy(object[i]);

        for (int i = 8; i < MAX_OBJECTS; i++)
            object[i].create(Values.SCROLL_NORMAL, 0, 0, 0);
    }

    /************************************************************************************************************************
     *   METHOD- Draw Game BGs
     ***********************************************************************************************************************/
    public void drawBackgrounds() {
        // Draw Sky & Back Mountains
        Draw.transform(0.7f, 1, 0, 0);                                // Draw Sky
        BG_Sky.draw();

        Draw.transform(0.5f, 1, 0.8f, 0);
        BG_Back.draw(0.0f, BG_Back.scrollY);
        BG_Back.scrollY += Values.SCROLL_SPEED / 8;
        // Main foreground mountains
        if (BG_Front.scrollY == Float.MAX_VALUE)
            BG_Front.scrollY = 0f;
        Draw.transform(0.5f, 1, 1, 0);
        BG_Front.draw(0, BG_Front.scrollY);
        BG_Front.scrollY += Values.SCROLL_SPEED / 2;
        if (BG_Front.scrollY == Float.MAX_VALUE) BG_Front.scrollY = 0;

    }

    /************************************************************************************************************************
     *   METHOD- Check game status and return message to main game loop, GameRunning, GameOver, LevelComplete
     ***********************************************************************************************************************/
    public byte checkGameStatus() {
        if (!events.bEnable && Player.iLives == 0)                        // If player died, do events in sequence
            switch (iSequence) {
                case 0:
                    iSequence++;
                    Pref.getSet(Pref.GAME_OVER);
                    break;
                case 1:
                    iSequence++;
                    events.dispatch(Events.GAME_OVER);
                    break;
                case 2:
                    Screen.iMenu = Screen.MENU_GAME_OVER;
                    return Values.GAME_OVER;
            }
        else if (!events.bEnable && enemyDestroyed == LEVEL_ENEMIES)    // Level Complete
            switch (iSequence) {
                case 0:
                    SoundPlayer.setVolume(1.0f, 0.5f);                    // Lower Sound when Level Completes
                    iSequence++;
                    events.dispatch(Events.LEVEL_COMPLETE);
                    Values.LEVEL_STATS[iLevel][Values.LEVEL_COMPL_TIME] = (int) odoMeter;
                    break;
                case 1:
                    return Values.GAME_LEVEL_STATS;
            }

        return Values.GAME_RUNNING;
    }

    public void loadingScreen() {
        BG_Middle.loadTexture(R.drawable.event_loading, GL10.GL_CLAMP_TO_EDGE);
        Draw.transform(0.22f, 1, 2, 0);
        BG_Middle.draw(0.0f, 0);
    }

}/*END LEVEL */
