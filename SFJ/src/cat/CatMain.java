package cat;

public class CatMain {
    public static void main(String[] args) {
        Cat macska = new Cat("Jakab", 4);
        //macska.setName("Gizi");

        System.out.println(macska.getName() + " " + macska.getWeight() + " kg");
        //macska.makeSound();
    }
}
