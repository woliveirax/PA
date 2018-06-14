package gameLogic.Events;

import gameLogic.GameData;

public class VolleyOfArrows_event extends _Event{
    
    public VolleyOfArrows_event(GameData gameData)
    {
        super("Volley of Arrows", "+1 to all attacks", gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return 1;
    }

    @Override
    public int getDRMAttackCloseCombat() {
        return 1;
    }

    @Override
    public int getDRMAttackLadders() {
        return 1;
    }

    @Override
    public int getDRMAttackSiegeTower() {
        return 1;
    }

    @Override
    public int getDRMCircleSpaces() {
        return 1;
    }

    @Override
    public int getDRMRaid() {
        return 1;
    }

    @Override
    public int getDRMSabotage() {
        return 1;
    }
}
