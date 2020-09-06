package human;

public class HumanMain {

    public static void main(String[] args) {
        Human first = new Human();
        Human second = new Human();
        //System.out.println(first.name);  //fontos, hogy azonos packageban legyen, különben nem látja
        first.writeMyName();
        first.setName("Margit");
        System.out.println(first.getName());
        System.out.println(second.getName());
        System.out.println(first.getAge());
        first.setName("Gyula");
        first.setAge(18);

        System.out.println(first.getName() == null ? "Üres" : "Nem üres, az értéke: " + first.getName());

       String firstName = first.getName();

        if (firstName == null){
            System.out.println("Nincs név");
        } else {
            System.out.println("Van név: " + firstName);
        }

    }
}
