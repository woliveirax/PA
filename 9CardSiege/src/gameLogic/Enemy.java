package gameLogic;

import java.io.Serializable;


public class Enemy implements Serializable{
    private GameData data;
    private final int defaultStrength;
    private int strength;
    private int pos;

    public Enemy(GameData data, int strength) {
        this.pos = 4;
        this.data = data;
        this.strength = defaultStrength = strength;
    }

    public int getPos() {
        return pos;
    }

    public int retreat() {
        if(pos > 3)
            return pos;
        
        if(pos == 0)
            leaveCloseCombat();
        
        pos++;
        return pos;
    }
    
    public int advance(){
        if(pos < 1)
            return pos;

        pos--;
        
        if(pos == 0)
            enterCloseCombat();
            
        return pos;
    }
    
    public int getStrength() {
        return strength;
    }

    private void enterCloseCombat() {
        strength = 4;
        data.ReduceMorale();
    }
    
    private void leaveCloseCombat(){
        strength = defaultStrength;
    }
}
