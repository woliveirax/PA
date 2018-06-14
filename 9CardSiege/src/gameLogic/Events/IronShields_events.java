package gameLogic.Events;

import gameLogic.GameData;


public class IronShields_events extends _Event{

    public IronShields_events(GameData gameData) {
        super("Iron Shields","-1 to attacks on the Siege Tower", gameData);
    }

    @Override
    public int getDRMAttackSiegeTower() {
        return -1; 
    }
    
    
    
}
