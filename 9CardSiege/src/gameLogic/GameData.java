package gameLogic;
import gameLogic.Events.BadWeather_event;
import gameLogic.Events.BoilingOil_event;
import gameLogic.Events.Collapsed_event;
import gameLogic.Events.CoverOfDarkness_event;
import gameLogic.Events.DeathOfALeader_event;
import gameLogic.Events.DeterminedEnemy_events;
import gameLogic.Events.EnemyFatigue_event;
import gameLogic.Events.Faith;
import gameLogic.Events.FlamingArrows_event;
import gameLogic.Events.GateFortified_event;
import gameLogic.Events.GuardsDistracted_event;
import gameLogic.Events.Illness_event;
import gameLogic.Events.IronShields_events;
import gameLogic.Events.Rally_event;
import gameLogic.Events.RepairedTrebuchet_event;
import gameLogic.Events.SuppliesSpoiled_event;
import gameLogic.Events.TrebuchetAttack_event;
import gameLogic.Events.VolleyOfArrows_event;
import gameLogic.Events._Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
    
    //Logic Functions
    public int getActionPoints(){
        return actionPoints;
    }
    
    public int getCurrentDay() {
        return currentDay;
    }

    public Card getCurrentCard() {
        return currentCard;
    }
    
    public void initializeData(){
        //TODO: restart
    }
    
    //TODO:::, get one card from top, suffle, put current card on discardedCards after use
    public void enemyLineCheck()
    {
        if(dice.roll_dice() == 1)
            castle.tunnelForcesCaptured();
    }
    
    public void applyEvent(){
        currentCard.getSpecificDay(currentDay).runEvent();
    }
    
    //TODO: if actionRestriction is true change state

    public void dicardCurrentCard()
    {
        discardedCards.add(currentCard);
    }
    
    public void drawCardFromDeck()
    {
        currentCard = deck.remove(0);
    }
    
    public void endOfDay()
    {
        //Reduce supplies by 1
        //check if soldiers on tunnel to castle and add tunnel supplies to castle
        //Check if soldiers are on the enemy lines and capture them reducing morale by 1
        //if not on 3 day shuffle cards else end game, WIN
        //add + 1 on day
    }
    //TODO: only called if day < 3
    public void endOfDay_()
    {
        castle.reduceSupplies();
        
        castle.tunnelForcesEndOfDayAction();
        
        for(Card card : discardedCards)
            deck.add(card);

        Collections.shuffle(deck);
        
        currentDay++;
    }
    
    public void drawCardFromDeck__()
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
    
    public void InitializeData(){
        //recomeçar
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
    public void tunnelEndOfDay()
    {
        castle.tunnelForcesEndOfDayAction();
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
        castle.moveSoldiersTorwardsEnemyLines();
    }
    
    //#######################################################
    //Card Creation section
    //#######################################################
    //TODO: Card creator
    
    private void createCards(){
    }
    
    private void card_1(){
        Day[] days = new Day[3];
        
        _Event event = new TrebuchetAttack_event(this);
        
        days[0] = new Day(1,3,event);
        days[1] = new Day(2,2,event);
        days[2] = new Day(3,1,event);
        
        Card card = new Card(1, days);
        deck.add(card);
    }
    
    private void card_2(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,2,new Illness_event(this),enemies.getEnemies(true, false, false),false);
        days[1] = new Day(2,2,new GuardsDistracted_event(this),enemies.getEnemies(true, true, true),true);
        days[2] = new Day(3,1,new TrebuchetAttack_event(this));
        
        Card card = new Card(2, days);
        deck.add(card);
    }
    
    
    private void card_3(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,2,new SuppliesSpoiled_event(this),enemies.getEnemies(false, false, true),false);
        days[1] = new Day(2,2,new BadWeather_event(this));
        days[2] = new Day(3,2,new BoilingOil_event(this),enemies.getEnemies(false ,true, true),false);
        
        Card card = new Card(3, days);
        deck.add(card);
    }
    
    private void card_4(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,2,new DeathOfALeader_event(this), enemies.getEnemies(true, false, true),false);
        days[1] = new Day(2,2,new GateFortified_event(this),enemies.getEnemies(false, true, true),false);
        days[2] = new Day(3,3,new FlamingArrows_event(this),enemies.getEnemies(true, false, false),false);
        
        Card card = new Card(4, days);
        deck.add(card);
    }
    
    private void card_5(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,3,new VolleyOfArrows_event(this),enemies.getEnemies(false, true, false),false);
        days[1] = new Day(2,2,new Collapsed_event(this),enemies.getEnemies(false, true, true),false);
        days[2] = new Day(3,2,new RepairedTrebuchet_event(this),enemies.getEnemies(false, false, true),false);
        
        Card card = new Card(5, days);
        deck.add(card);
    }
    
    private void card_6(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,3,new CoverOfDarkness_event(this),enemies.getEnemies(true, true, true),true);
        days[1] = new Day(2,3,new EnemyFatigue_event(this),enemies.getEnemies(false, false, true),false);
        days[2] = new Day(3,3,new Rally_event(this),enemies.getEnemies(true, true, false),false);
        
        Card card = new Card(6, days);
        deck.add(card);
    }
    
    private void card_7(){
        Day[] days = new Day[3];
        
        days[0] = new Day(1,2,new DeterminedEnemy_events(this),enemies.getEnemies(false, true, false),false);
        days[1] = new Day(2,2,new IronShields_events(this),enemies.getEnemies(true, false, false),false);
        days[2] = new Day(3,3,new Faith(this),enemies.getEnemies(true, true, true),false);
        
        Card card = new Card(7, days);
        deck.add(card);
    }
}