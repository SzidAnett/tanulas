import java.io.Serializable;

public class Car implements Serializable {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }


    public String drive(){

        return engine.sound();
    }
}
