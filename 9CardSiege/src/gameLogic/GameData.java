package gameLogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable{
    //IState state;
    int currentDay = 1;
    
    Card currentCard;
    ArrayList<Card> deck;
    Dice dice;
    
    Castle castle;
    
    //Criar ou não classe enemy forces
    Enemy ladder;
    Enemy batteringRam;
    Enemy tower;
    
    public GameData (){
       createEnemies();
       deckCreator();
    }
    
    private void deckCreator(){
        createCards();
    }
    
    private void createEnemies(){
        ladder = new Enemy(this,2);
        batteringRam = new Enemy(this,3);
        tower = new Enemy(this,4);
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

}