import java.util.*;
import java.util.Random;


public class SalesTeam {
    LinkedList<String> team = new LinkedList<String>();

    //Default constructor method
    public SalesTeam() {
        team.add("James");
        team.add("Mary");
        team.add("John");
        team.add("Patricia");
        team.add("Robert");
        team.add("Jennifer");
    }

    /*
    Gives a random sales team member
    @returns a seller from LinkedList 
    */
    public String seller() {
        Random rnd = new Random();
        int n = rnd.nextInt(team.size());
        return team.get(n);
    }

    /*
    returns the list of sales team members
    @return team - LinkedList<String>
    */
    public LinkedList<String> retList() {
        return team;
    }

    /*
    Returns a String of every sales team member
    @Return - String ret
    */
    public String meetTheTeam() {
        ListIterator iter = team.listIterator();
        String ret = "Meet the team!: ";
        while(iter.hasNext()) {
            ret += iter.next() + " ";
        }
        return ret;
    }
}