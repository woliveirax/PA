package gameLogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable{
    int currentDay;
    int actionPoints;
    
    Card currentCard;
    List<Card> deck;
    List<Card> discardedCards;
    Dice dice;
    
    Castle castle;
    EnemyForces enemies;
    
    public GameData (){
        currentDay = 1;
        actionPoints = 0;
        dice = new Dice();
        castle = new Castle();
        deck = new ArrayList<>();
        discardedCards = new ArrayList<>();
        enemies = new EnemyForces(this);
    }
    
    public void enemyLineCheck()
    {
        //Roll dice if soldiers on enemy line, if roll == 1 unit is captured and reduce morale by 1.
    }
    
    public void applyEvent(){
        currentCard.getSpecificDay(currentDay).runEvent();
    }
    
    //TODO: if actionRestriction is true change state
    public void drawCardFromDeck()
    {
        //Remove top card from deck
        //apply event
        //Enemy movement
        //add player action points
    }
    
    public void endOfTurn_LoseCodition()
    {
        //if 2 enemy on close combat
        //One of status tracks are 0 in the end of the turn
    }
    
    public void inTurn_LoseCondition()
    {
        //A third enemy cube enters close combat.
        //Two status tracks reach 0
    }
    
    public int getActionPoints();
    
    public void removeActionPoints();
    
    public void addActionPoints();
    
    
    
    public void endOfDay()
    {
        //Reduce supplies by 1
        //check if soldiers on tunnel to castle and add tunnel supplies to castle
        //Check if soldiers are on the enemy lines and capture them reducing morale by 1
        //if not on 3 day shuffle cards else end game, WIN
        //add + 1 on day
    }
    
    private void createCards(){
    }
    
    private void cardOne(){

        Day[] days = new Day[3];
        
        
      //  days[0]=new Day(1,3,"Trebuchet Attack");
        
    }
    
    //Dice functions
    public int diceRoll()
    {
        return dice.roll_dice();
    }
    
    //#### Enemy functions
    //Get units position funcs
    public int getLadderPosition()
    {
        return enemies.getLadderPOS();
    }
    
    public int getBatteringRamPosition()
    {
        return enemies.getBatteringRamPOS();
    }
    
    public int getTowerPosition()
    {
        return enemies.getTowerPOS();
    }
    
    
    //Movement functions
    public void moveSlowestEnemyUnit()
    {
        enemies.moveSlowestEnemies();
    }
    
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
    
    public boolean isTowerInGame()
    {
        return enemies.isTowerInGame();
    }
    
    
    //#### Castle Functions
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
    
    
    //Tunnel Functions
    public void increaseTunnelSupplies()
    {
        castle.increaseTunnelSupplies();
    }
    
    public int getTunnelSupplies()
    {
        return castle.getTunnelSupplies();
    }
    
    
    //Tunnel Event
    public void captureTunnelForces()
    {
        castle.tunnelForcesCaptured();
    }
    
    
    //Movement functions
    public TunnelPos getTunnelPosition()
    {
        return castle.getTunnelPosition();
    }
    
    public void fastTravelToCastle()
    {
        castle.fastTravelToCastle();
    }
    
    public void fastTravelToEnemyLines()
    {
        castle.fastTravelToEnemyLines();
    }
    
    public void moveSoldiersTorwardsCastle()
    {
        castle.moveSoldiersTorwardsCastle();
    }
    
    public void moveSoldiersTorwardsEnemyLines()
    {
        castle.moveSoldiersTorwardsCastle();
    }
}