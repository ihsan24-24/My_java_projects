import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
public class Main {
    public static void main(String args[]){
        ArrayList<String> Part1 = new ArrayList<>();
        ArrayList<String> Part2 = new ArrayList<>();
        ArrayList<String> Teams = new ArrayList<>();
        ArrayList<String> TeamsList = new ArrayList<>();
        ArrayList<String> Fixture = new ArrayList<>();
        ArrayList<String> Fixture2 = new ArrayList<>();
        int count = 0;
        Random choose = new Random();
        Teams.add("Fenerbahce");
        Teams.add("Galatasaray");
        Teams.add("Besiktas");
        Teams.add("Trabzonspor");
        Teams.add("Sivasspor"); 
        if(Teams.size() % 2 == 1){ 
            Teams.add("Bay");
        }
        for(int i = 1; i<Teams.size(); i++){
            TeamsList.addAll(Teams);
            
            Fixture.add("Round " + Integer.toString(i));
            Fixture2.add("Round "+ Integer.toString(i + (Teams.size()-1)));
            while(!TeamsList.isEmpty()){
            count++;
            Integer Rindex = choose.nextInt(TeamsList.size());
            Integer Rindex2 = choose.nextInt(TeamsList.size());
            String FirstT = TeamsList.get(Rindex);
            String SecondT = TeamsList.get(Rindex2);
            if((!FirstT.equals(SecondT)) && (!Part1.contains(FirstT + " vs " + SecondT)) && (!Part1.contains(SecondT + " vs " + FirstT))){
                count = 0;
                Fixture.add(FirstT + " vs " + SecondT);
                Fixture2.add(SecondT + " vs " + FirstT);
                TeamsList.remove(FirstT);
                TeamsList.remove(SecondT);
            }
             if(count > 50){
                 Fixture.clear();
                 Fixture2.clear();
                 Fixture.add("Round " + Integer.toString(i));
                 Fixture2.add("Round "+ Integer.toString(i + (Teams.size()-1)));
                 TeamsList.addAll(Teams);
                 count = 0;
             }    
        }
            Part1.addAll(Fixture);
            Part2.addAll(Fixture2);
            TeamsList.clear();
            Fixture.clear();
            Fixture2.clear();
        }
        for(String s: Part1){
            System.out.println(s);
        }
        for(String a: Part2){
            System.out.println(a);
        }
        
        
        }
        

        
    } 