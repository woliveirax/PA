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
        getGameData().drawCardFromDeck();
        
        if(getGameData().inTurn_LoseCondition())
            return new AwaitRestart_state(getGameData(), false);
        
        if(getGameData().getCloseCombatArea().size() == 2){
            return new CloseCombatTrackSelection_state(getGameData(), getOldState());
        }
        
        if(getGameData().isActionRestricted()){
            if(getOldState() instanceof AwaitEnemyLineAction_state)
                return new AwaitRestrictedAction_state(getGameData());
            
            else
            {
                if(getGameData().getSizeOfDeck() == 0){
                    if(getGameData().getCurrentDay()==2)
                        return new AwaitRestart_state(getGameData(),true);

                    getGameData().endOfDay();
                }
                
                return this;
            }
        }
        
        if (getOldState() == null)
            return new AwaitGeneralAction_state(getGameData());
           
        
        return getOldState();
    }    
    
    @Override
    public String toString() {
        return "Obtain a card from deck.\n";
    }
}
