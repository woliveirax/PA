package gameLogic;

import java.io.Serializable;
import java.util.Objects;


public class Enemy implements Serializable{
    private GameData data;
    private final String name;
    private final int defaultStrength;
    private int strength;
    private int pos;
    private boolean active;

    public Enemy(GameData data, int strength, String name) {
        this.name = name;
        this.pos = 4;
        this.data = data;
        this.strength = defaultStrength = strength;
        this.active = true;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPos() {
        return pos;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public int retreat() {
        if(!active)
            return -1;
        
        if(pos > 3)
            return pos;
        
        if(pos == 0)
            leaveCloseCombat();
        
        pos++;
        return pos;
    }
    
    public int advance(){
        if(!active)
            return -1;
        
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
        data.enemyEnterCloseCombatArea(this);
        data.ReduceMorale();
    }
    
    private void leaveCloseCombat(){
        strength = defaultStrength;
        data.enemyLeavesCloseCombatArea(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enemy other = (Enemy) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
