package gameLogic.Events;

import gameLogic.GameData;

public class Rally_event extends _Event{
    
    public Rally_event(GameData gameData)
    {
        super("Rally!", "+1 to attacks on Close Combat or Circle Spaces", gameData);
    }

    @Override
    public int getDRMAttackCloseCombat() {
        return 1;
    }

    @Override
    public int getDRMCircleSpaces() {
        return 1;
    }
}
