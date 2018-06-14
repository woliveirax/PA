package gameLogic.Events;

import gameLogic.GameData;

public class GateFortified_event extends _Event {
    
     public GateFortified_event(GameData gameData)
    {
        super("Gate Fortified","+1 to attacks on the Battering Ram",gameData);
    }

    @Override
    public int getDRMAttackBatteringRam() {
        return 1;
    }
}
