import java.util.Random;
public class RandomHello {
    public static void main(String[] args) {
        RandomHello randomHello = new RandomHello();
        System.out.println(randomHello.sayHello());
    }
    public String sayHello() {
        Random randomGenerator = new Random();
        //make an array
        String[] greetings = new String[5];
        //adding  greetings to the array
        greetings[0] = "Howdy!";
        greetings[1] = "G’day mate!";
        greetings[2] = "Hiya!";
        greetings[3] = "Hey there!";
        greetings[4] = "Wotcha!";
        //generate a number between 0-4 inclusive
        return greetings[randomGenerator.nextInt(5)];
    }
}
