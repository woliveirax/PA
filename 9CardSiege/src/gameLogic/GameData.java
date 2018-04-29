package gameLogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable{
    //IState state;
    int currentDay;
    
    Card currentCard;
    List<Card> deck;
    Dice dice;
    
    Castle castle;
    EnemyForces enemies;
    
    public GameData (){
        currentDay = 1;
        dice = new Dice();
        castle = new Castle();
        deck = new ArrayList<>();
        enemies = new EnemyForces(this);
    }
    
    private void deckCreator(){
        createCards();
    }
    
    private void createCards(){
//        cardOne();
//        cardTwo();
//        cardTree();
//        cardFour();
//        cardFive();
//        cardSix();
//        cardSeven();
    }
    
//    private void cardOne(){
//
//        Day[] days = new Day[3];
//        List<Event> events = new ArrayList<>();
//        List<Enemy> moves = new ArrayList<>();
//        
//        events.add(0,new Event(this));
//        
//      //  days[0]=new Day(1,3,"Trebuchet Attack");
//        
//    }
    
    public boolean ReduceMorale(int dmg)
    {
        return castle.reduceMorale(dmg);
    }
    
    public boolean ReduceSupplies(int dmg)
    {
        return castle.reduceSupplies(dmg);
    }
    
    public boolean DamageWall(int dmg)
    {
        return castle.reduceWallStrength(dmg);
    }
}