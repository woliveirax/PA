package gameLogic.Events;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class Faith extends _Event{

    public Faith(GameData gameData) {
        super("Faith","+1 to attacks on the Battering Ram, Ladders, and Morale action", gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return 1;
    }

    @Override
    public int getDRMAttackLadders() {
        return 1;
    }

    @Override
    public int getDRMMorale() {
        return 1;
    }
    
}
