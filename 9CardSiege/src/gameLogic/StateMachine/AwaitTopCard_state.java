package gameLogic.StateMachine;

import gameLogic.GameData;

public class AwaitTopCard_state extends StateAdapter{

    public AwaitTopCard_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    public AwaitTopCard_state(GameData gameData) {
        super(gameData,null);
    }
    
    
    @Override
    public IStates drawCard(){
        //Acrescentei getCurrentDay and Card to GameData
        if(getGameData().getCurrentCard().getSpecificDay(getGameData().getCurrentDay()).getCurrentEvent(0).actionRestriction())
            return new AwaitRestrictedAction_state(getGameData());
        
        else
            return getOldState();       
    }    
    
    @Override
    public String toString() {
        return "Obtain a card from deck.\n";
    }
}
