package gameLogic.Events;

import gameLogic.GameData;

public class DeterminedEnemy_events extends _Event{

    public DeterminedEnemy_events(GameData gameData) {
        super("Determined Enemy","-1 to attacks on the Battering Ram", gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return -1;
    }
    
    
}
