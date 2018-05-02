/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skully
 */
public class EnemyForces implements Serializable {
    private Enemy ladder;
    private Enemy batteringRam;
    private Enemy tower;
    private int trebuchets;
    
    public EnemyForces(GameData data){
        ladder = new Enemy(data,2);
        batteringRam = new Enemy(data,3);
        tower = new Enemy(data,4);
        trebuchets = 3;
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
    private List<Enemy> getSlowestEnemies(){
        List<Enemy> temp = new ArrayList<>();
        
        int max = Math.max(Math.max(tower.getPos(), batteringRam.getPos()),ladder.getPos());
        
        if(tower.getPos() == max)
            temp.add(tower);
        
        if(batteringRam.getPos() == max)
            temp.add(batteringRam);
        
        if(ladder.getPos() == max)
            temp.add(ladder);
        
        return temp;
    }
    
    
    //### Get positions functions
    public int getTowerPOS(){
        return tower.getPos();
    }
    
    public int getBatteringRamPOS(){
        return batteringRam.getPos();
    }
    
    public int getLadderPOS(){
        return ladder.getPos();
    }
    
    
    //### Enemy movement functions
    public void moveSlowestEnemies(){
        for(Enemy each : getSlowestEnemies())
            each.advance();
    }
    
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
            tower = null;
    }
    
    public boolean isTowerInGame(){
        return tower != null;
    }
}
