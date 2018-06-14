package gameLogic.Events;

import gameLogic.GameData;

public class BoilingOil_event extends _Event{

    public BoilingOil_event(GameData gameData) {
        super("Boiling Oil","+2 to attacks on enemy units in circle spaces",gameData);
    }

    @Override
    public int getDRMCircleSpaces() {
        return 2;
    }
}
