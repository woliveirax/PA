package gameLogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable{
    //IState state;
    int currentDay;
    int actionPoints;
    
    Card currentCard;
    List<Card> deck;
    Dice dice;
    
    Castle castle;
    EnemyForces enemies;
    
    public GameData (){
        currentDay = 1;
        actionPoints = 0;
        dice = new Dice();
        castle = new Castle();
        deck = new ArrayList<>();
        enemies = new EnemyForces(this);
    }
    
    public void drawCardFromDeck();
    
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
    
    //Enemy movement functions
    public boolean enemyLadderAdvance()
    {
        return enemies.ladderAdvance();
    }
    
    public boolean enemyLadderRetreat()
    {
        return enemies.ladderRetreat();
    }
    
    public boolean enemyBatteringRamAdvance()
    {
        return enemies.batterringRamAdvance();
    }
    
    public boolean enemyBatteringRamRetreat()
    {
        return enemies.batteringRamRetreat();
    }
    
    public boolean enemyTowerAdvance()
    {
        return enemies.towerAdvance();
    }
    
    public boolean enemyTowerRetreat()
    {
        return enemies.towerRetreat();
    }
    
    //Treebuchets functions
    public int getActiveTrebuchets()
    {
        return enemies.getTrebuchets();
    }
    
    public void destroyTrebuchets()
    {
        enemies.destroyTrebuchet();
    }
    
    public void repairTrebuchets()
    {
        enemies.repairTrebuchet();
    }
    
    //Tower Functions
    public void removeTowerFromGame()
    {
        enemies.removeTowerFromGame();
    }
    
    public boolean towerInGame()
    {
        return enemies.isTowerInGame();
    }
    
    //Decrese point functions
    public boolean ReduceMorale()
    {
        return castle.reduceMorale();
    }
    
    public boolean ReduceSupplies()
    {
        return castle.reduceSupplies();
    }
    
    public boolean DamageWall()
    {
        return castle.reduceWallStrength();
    }
    
    //Increase points functions
    
    public boolean increaseSupplies()
    {
        return castle.increaseSupplies();
    }
    
    public boolean increaseMorale()
    {
        return castle.increaseSupplies();
    }
    
    public boolean increaseWallStrength()
    {
        return castle.increaseWallStrength();
    }
}