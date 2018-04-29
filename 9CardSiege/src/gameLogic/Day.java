/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import gameLogic.Events._Event;
import java.io.Serializable;
import java.util.ArrayList;


public class Day implements Serializable{
    private final int  number_day;
    int action_point;
    
    ArrayList<_Event> events;
    ArrayList<Enemy> movements;

    public Day(int number_day, int action_point, ArrayList<_Event> events, ArrayList<Enemy> movements) {
        this.number_day = number_day;
        this.action_point = action_point;
        this.events = events;
        this.movements = movements;
    }

    public int getNumber_day() {
        return number_day;
    }

    public int getAction_point() {
        return action_point;
    }

    public void setAction_point(int action_point) {
        this.action_point = action_point;
    }
    
    public _Event getCurrentEvent(int index){
        
        if(index < 0 || index > events.size())
            return null;
        
        return events.get(index);
    }
    
    public ArrayList<_Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<_Event> events) {
        this.events = events;
    }
    
    public Enemy getCurrentEnemyMove(int index){
        
        if(index < 0 || index > movements.size())
            return null;
        return movements.get(index);
    }

    public ArrayList<Enemy> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Enemy> movements) {
        this.movements = movements;
    }  
    
}

