package cat;

public abstract class Animal {                      //abstract, nem példányosítható
    private String name;
    private int weight;

    protected void makeSound() {                    //protected csak a "gyerekem" használhatja, aki extends
        System.out.println("AAAAAAARGH!");
    }

    public String getName() {
        return name;
    }

    public void setName(String incomingName) {
        this.name = incomingName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int incomingWeight) {
        this.weight = incomingWeight;
    }
}
