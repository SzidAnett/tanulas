package human;

public class Human {
    private String name;
    private int age;

    void writeMyName(){
        System.out.println("Az én nevem: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String incomingName) {

        this.name = incomingName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int incomingAge) {
        this.age = incomingAge;
    }
}
