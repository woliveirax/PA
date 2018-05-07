package gameLogic.StateMachine;

import gameLogic.GameData;

public class ArcherAttackTrackSelection_state extends StateAdapter{

    public ArcherAttackTrackSelection_state(GameData gameData,IStates state) {
        super(gameData,state);
    }

    @Override
    public IStates trackSelection(int track) {
        GameData data = getGameData();
        
        switch (track){
            case 1:
                if(data.diceRoll(data.getDRMAttackLadders()) > 2)
                    data.enemyLadderRetreat();
                break;
                
            case 2:
                if(data.diceRoll(data.getDRMAttackBatteringRam()) > 3)
                    data.enemyBatteringRamRetreat();
                break;
                
            case 3:
                if(data.isTowerInGame())
                    if(data.diceRoll(data.getDRMAttackSiegeTower()) > 4)
                        data.enemyTowerRetreat();
                break;
        }
        
        data.reduceActionPoints();
        
        return getOldState();
    }

    @Override
    public IStates endOfAction() {
        return getOldState();
    }

    @Override
    public String toString() {
        return "Archer Attack:\n\tEnemy selection: (1)Ladders\t(2)Battering Ram\t(3)Siege Tower\n";
    }

  
}
