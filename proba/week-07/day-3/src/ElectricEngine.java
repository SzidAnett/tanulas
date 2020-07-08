import java.io.Serializable;

public class ElectricEngine implements Engine, Serializable {

    public String sound() {
        return "whoos";
    }
}
