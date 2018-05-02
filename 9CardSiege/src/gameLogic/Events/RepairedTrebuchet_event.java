/*
TODO: complete
 */
package gameLogic.Events;

import gameLogic.GameData;

/**
 *
 * @author Olympus
 */
public class RepairedTrebuchet_event extends _Event{

    public RepairedTrebuchet_event(GameData gameData) {
        super("Repaired Trebuchet","Add 1 Trebuchet (max 3)\n ...... \n+1 to Coupure action", gameData);
    }

    
    @Override
    public void triggerEvent() {
        getGameData().repairTrebuchets();
    }

    @Override
    public int getDRMCoupure() {
        return 1;
    }
}
