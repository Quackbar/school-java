/**
 * Created by bkintzing on 10/27/2015.
 */
public class Cat extends Animal {
    String name, breed;
    public Cat(String name, String breed){
        this.name = name;
        this.breed = breed;
    }
    public void describe(){
        System.out.println(name + ", a breed of Cat called " + breed + ".");
    }
    public void sound(){
        System.out.println("Meow.");
    }
    public void sleep(){
        System.out.println("Kitty is having purrfect dreams!");
    }
    public void move(){
        System.out.println("This little kitty moves fast!");
    }
}
