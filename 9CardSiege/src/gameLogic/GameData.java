package gameLogic;
import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable{
    int currentDay;
    
    Card currentCard;
    ArrayList<Card> deck;
    
    //Meter em classe Castle
    int supplies;
    int morale;
    int wallStrenght;
    
    //Meter em classe Enemy line
    Enemy batteringRam;
    Enemy tower;
    Enemy ladder;
    
    
}