package cat;

public class Cat extends Animal implements Pet {

    public Cat() {
        this.setName("Dániel");
    }
    public Cat(String incomingName) {
        this.setName(incomingName);
    }
    public Cat(String incomingName, int incomingWeight) {
        this.setName(incomingName);
        this.setWeight(incomingWeight);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void cuddle() {                      //felül kell írnia a Pet összes methodusát, kötelező

    }

    @Override
    public void sit() {

    }

    @Override
    public void layDown() {

    }
}
