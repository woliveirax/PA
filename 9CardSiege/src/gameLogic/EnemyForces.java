package gameLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class EnemyForces implements Serializable {
    private Enemy ladder;
    private Enemy batteringRam;
    private Enemy tower;
    private int trebuchets;
    
    public EnemyForces(GameData data){
        ladder = new Enemy(data,2,"Ladder");
        batteringRam = new Enemy(data,3,"BatteringRam");
        tower = new Enemy(data,4,"Tower");
        trebuchets = 3;
    }
    
    //Get Enemy funcs
    public ArrayList<Enemy> getEnemies(boolean tower, boolean ram, boolean ladder)
    {
        ArrayList<Enemy> enemies = new ArrayList<>();
        
        if(tower)
            enemies.add(this.tower);
        if(ram)
            enemies.add(this.batteringRam);
        if(ladder)
            enemies.add(this.ladder);
        
        return enemies;        
    }
    
    //Treebuchet Funcs
    public int getTrebuchets(){
        return trebuchets;
    }
    
    public void repairTrebuchet(){
        if(trebuchets < 3)
            trebuchets++;
    }
    
    public void destroyTrebuchet(){
        if(trebuchets > 0)
            trebuchets--;
    }
    
    
    //##### Enemy movement functions
     
    //### Get positions functions
    public int getTowerPOS(){
        if(isTowerInGame())
            return tower.getPos();
        return -1;
    }
    
    public int getBatteringRamPOS(){
        return batteringRam.getPos();
    }
    
    public int getLadderPOS(){
        return ladder.getPos();
    }
    
    //### Enemy movement functions
    
    public boolean ladderAdvance(){
        return ladder.advance() != ladder.getPos();
    }
    
    public boolean ladderRetreat(){
        return ladder.retreat() != ladder.getPos();
    }
    
    public boolean batterringRamAdvance(){
        return batteringRam.advance() != batteringRam.getPos();
    }
    
    public boolean batteringRamRetreat(){
        return batteringRam.retreat() != batteringRam.getPos();
    }
    
    public boolean towerAdvance(){
        return tower.advance() != batteringRam.getPos();
    }
    
    public boolean towerRetreat(){
        return tower.retreat() != tower.getPos();
    }
    
    
    //Tower Functions
    public void removeTowerFromGame(){
        if(tower != null)
        {
            tower.setActive(false);
            tower = null;
        }
    }
    
    public boolean isTowerInGame(){
        return tower != null;
    }
}
