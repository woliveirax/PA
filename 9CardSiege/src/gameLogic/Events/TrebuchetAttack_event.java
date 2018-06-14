package gameLogic.Events;

import gameLogic.GameData;


public class TrebuchetAttack_event extends _Event {
    public TrebuchetAttack_event(GameData gameData)
    {
        super("Trebuchet Attack", "3 Trebuchet : - 2 Damage to wall\n"
                                + "2 Trebuchet : - 1 Damage to wall\n"
                                + "1 Trebuchet : - 1 Damage to wall", gameData);
    }

    @Override
    public void triggerEvent() {
        GameData data = getGameData();
        if(data.diceRoll() > 3)
            switch(data.getActiveTrebuchets()){
                case 3:
                    data.DamageWall();
                    data.DamageWall();
                    break;
                    
                default:
                    data.DamageWall();
                    break;
            }
    }
}
