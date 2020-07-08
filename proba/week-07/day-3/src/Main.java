import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car car1 = new Car(new ElectricEngine());
        System.out.println("Car1: " + car1.drive());

        Car car2 = new Car(new CombustionEngine());
        System.out.println("Car2: " + car2.drive());

        FileOutputStream fout = new FileOutputStream("car.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(car1);

        FileInputStream fin = new FileInputStream("car.ser");
        ObjectInputStream ois = new ObjectInputStream(fin);
        Car carBack = (Car) ois.readObject();
        System.out.println("car back: " + carBack.drive());
        }

}
