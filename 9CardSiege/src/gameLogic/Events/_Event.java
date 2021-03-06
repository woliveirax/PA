package gameLogic.Events;
import gameLogic.GameData;
import java.io.Serializable;

public abstract class _Event implements Serializable{
    private String name;
    private String description;
    private GameData gameData;

    public _Event(String name, String description, GameData gameData) {
        this.name = name;
        this.description = description;
        this.gameData = gameData;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GameData getGameData() {
        return gameData;
    }
      
    public void triggerEvent(){}
    
    public boolean actionRestriction(){
        return false;
    }
    
    public int getDRMSabotage(){
        return 0;
    }
    
    public int getDRMRaid(){
        return 0;
    }
    
    public int getDRMMorale(){
        return 0;
    }
    
    public int getDRMCoupure(){
        return 0;
    }
    
    public int getDRMCircleSpaces(){
        return 0;
    }
    
    public int getDRMAttackLadders(){
        return 0;
    }
    
    public int getDRMAttackBatteringRam(){
        return 0;
    }
    
    public int getDRMAttackSiegeTower(){
        return 0;
    }
    
    public int getDRMAttackCloseCombat(){
        return 0;
    }

    @Override
    public String toString() {
        //return "" + name + "\ndescription:\n" + description;
        return "" + name + "\n----------------------\n" + description;
    }
    
}

