package gameLogic.Events;

import gameLogic.GameData;

public class FlamingArrows_event extends _Event{
    
    public FlamingArrows_event(GameData gameData)
    {
        super("Framing Arrows","+1 to attacks on the Siege Tower",gameData);
    }

    @Override
    public int getDRMAttackSiegeTower() {
        return 1;
    }
}
