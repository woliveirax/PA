package gameLogic.StateMachine;

import gameLogic.GameData;


public class BoilingAttackTrackSelection_state extends StateAdapter{

    public BoilingAttackTrackSelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }    

    @Override
    public IStates trackSelection(int track) {
        GameData d = getGameData();
        int res = 0;
        
        switch(track){
            case 1:
                if(d.getLadderPosition() != 1)
                    return getOldState();
                else
                {
                    if((res = d.diceRoll(d.getDRMBoillingWater() + d.getDRMCircleSpaces() + d.getDRMAttackLadders())) > 2){
                        d.enemyLadderRetreat();
                        d.setBoillingWaterUsed(true);
                    }
                    else if(res == 1)
                    {
                        d.ReduceMorale();
                    }
                }
                break;
                
            case 2:
                if(d.getBatteringRamPosition() != 1)
                    return getOldState();
                else
                {
                    if((res = d.diceRoll(d.getDRMBoillingWater() + d.getDRMCircleSpaces() + d.getDRMAttackBatteringRam())) > 3){
                        d.enemyBatteringRamRetreat();
                    }
                    else if(res == 1)
                    {
                        d.ReduceMorale();
                    }
                }
                break;
                
            case 3:
                if(!d.isTowerInGame())
                    return getOldState();
                
                if(d.getTowerPosition() != 1)
                    return getOldState();
                else
                {
                    if((res = d.diceRoll(d.getDRMBoillingWater() + d.getDRMCircleSpaces() + d.getDRMAttackSiegeTower())) > 4){
                        d.enemyTowerRetreat();
                    }
                    else if(res == 1)
                    {
                        d.ReduceMorale();
                    }
                }
                
                break;
        }
        
        d.setBoillingWaterUsed(true);
        
        if(d.inTurn_LoseCondition())
            return new AwaitRestart_state(d, false);
        
        d.reduceActionPoints();
        
        return getOldState();
    }
    
    @Override
    public IStates endOfAction() {
        return getOldState();
    }
    
    @Override
    public String toString() {
        return "Boiling Water:\n\tEnemy selection: (1)Ladders\t(2)Battering Ram\t(3)Siege Tower\n";
    }
}
