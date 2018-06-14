package gameLogic;
import java.io.Serializable;

public class Card implements Serializable {
    private final int id;
    private Day[] days;

    public Card(int id, Day[] days){
        this.id = id;    
        this.days = days;
    }
    
    public int getId() {
        return id;
    }
    
    public Day getSpecificDay(int index)
    {
        if(index < 0 || index > days.length)
            return null;
        
        return days[index];
    }
    
    public Day[] getDays()
    {
        return days;
    }
    
    public String toStringCardOnly(){
        String a = new String();
        a = "###################ID "+id+"#\n" +
            "##########Card##########\n" +
            "########################\n";
        
        return a;
    }
    
    @Override
    public String toString() {
        String a = new String();
        a = "###################ID "+id+"#\n" +
            "##########Card##########\n" +
            "########################\n";
        
        for(Day day : days)
        {
            a += day.toString() + "\n\n";
        }
        
        return a;
    }
    
    
}
