/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import gameLogic.Events._Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day implements Serializable{
    private final int dayNumber;
    private int action_point;
    
    private final boolean moveSlowest; 
    private final _Event event;
    private final ArrayList<Enemy> movements;

    public Day(int number_day, int action_point, _Event event, ArrayList<Enemy> movements, boolean slowest) {
        this.dayNumber = number_day;
        this.action_point = action_point;
        this.event = event;
        this.movements = movements;
        moveSlowest = slowest;
    }
    
    public Day(int number_day, int action_point, _Event events) {
        this.dayNumber = number_day;
        this.action_point = action_point;
        this.event = events;
        movements = new ArrayList<>();
        moveSlowest = false;
    }
    
    public int getDayNumber() {
        return dayNumber;
    }
    
    public void moveEnemies()
    {
        if(moveSlowest)
            moveSlowestEnemies();
        else
            for(Enemy each : movements)
                each.advance();
    }

    public _Event getEvent() {
        return event;
    }
    
    public int getAction_point() {
        return action_point;
    }

    public void setAction_point(int action_point) {
        this.action_point = action_point;
    }
    
    private void moveSlowestEnemies(){
        System.out.println("SLOWEST !!! : " + getSlowestEnemies() + "");
        for(Enemy each : getSlowestEnemies())
            each.advance();
    }
    
    private List<Enemy> getSlowestEnemies(){
        List<Enemy> temp = new ArrayList<>();
        int max = -1;
        
        for(Enemy each : movements)
        {
            if(each.getPos() > max)
                max = each.getPos();
        }
        
        for(Enemy each : movements)
        {
            if(each.getPos() == max)
                temp.add(each);
        }
        
        return temp;
    }

    @Override
    public String toString() {
        return "Day: " + dayNumber + "\t" +
               "Action Points: " + action_point + "\n\n" +
               event.toString();
                
                
    }
}

