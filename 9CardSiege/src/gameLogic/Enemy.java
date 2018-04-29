package gameLogic;

import java.io.Serializable;


public class Enemy implements Serializable{
    private GameData data;
    private int pos;
    private int strenght;

    public Enemy(GameData data, int strenght) {
        this.pos = 4;
        this.data = data;
        this.strenght = strenght;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        
        if(pos < 0 || pos > 4)
            return;
        
        this.pos = pos;
    }
    
    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }
    
}
