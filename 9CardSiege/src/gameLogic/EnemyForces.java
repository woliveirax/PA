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
    private int treebuchets;
    
    public EnemyForces(GameData data){
        ladder = new Enemy(data,2);
        batteringRam = new Enemy(data,3);
        tower = new Enemy(data,4);
        treebuchets = 3;
    }
    
    //TODO: repair Treebuchets...
    
    //TODO: destroy treebuchets...
    
    //TODO: move slowest (enemy or enemy forces on day)...
    
    public void removeTowerFromGame(){
        if(tower != null)
            tower = null;
    }

    public int getTreebuchets(){
        return treebuchets;
    }
    
    public void repairTreebuchet(){
        if(treebuchets < 3)
            treebuchets++;
    }
    
    public void destroyTreebuchet(){
        if(treebuchets > 0)
            treebuchets--;
    }
    
    private ArrayList<Enemy> getSlowestEnemies(){
        List<Enemy> temp = new ArrayList<>();
        
        int max = Math.max(Math.max(tower.getPos(), batteringRam.getPos()),ladder.getPos());
        
    }
    
    //Tower Functions
}
