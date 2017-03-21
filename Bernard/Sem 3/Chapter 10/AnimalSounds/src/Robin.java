/**
 * Created by bkintzing on 10/27/2015.
 */
public class Robin extends Bird{
    String name;
    public Robin(String name){
        this.name = name;
    }
    public void describe(){
        System.out.println(name + ", a breed of Bird called Robin.");
    }
    public void sound(){
        System.out.println("tweet tweet.");
    }
    public void sleep(){
        System.out.println(name + " the Robin sleeps with one eye open for the cat!");
    }
}
