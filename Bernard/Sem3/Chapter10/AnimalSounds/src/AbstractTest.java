/**
 * Created by bkintzing on 10/27/2015.
 */
public class AbstractTest {
    public static void main(String[] args){
        Cat cat = new Cat("Kitty", "Angora");
        Robin bird = new Robin("Rockin");

        System.out.println("For the Cat;");
        System.out.println("This is:  "); cat.describe();
        System.out.println("Sound:  "); cat.sound();
        System.out.println("Sleeping:  "); cat.sleep();
        System.out.println("Moving:  "); cat.move();
        System.out.println("\n");

        System.out.println("For the Bird;");
        System.out.println("This is:  "); bird.describe();
        System.out.println("Sound:  "); bird.sound();
        System.out.println("Sleeping:  "); bird.sleep();
        System.out.println("Moving:  "); bird.move();
        System.out.println("\n");

        System.out.println("End of Program");
    }
}
