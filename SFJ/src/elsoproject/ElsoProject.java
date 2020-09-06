package elsoproject;

import human.Human;

public class ElsoProject {

    public static void main(String[] args) {
        String result = censor("A kutya nagyon aranyos kutya", "kutya", "macska");
        System.out.println("próba: " + result);

    }
    static String censor(String text, String toChange, String newWord){
        if (text.contains(toChange)) {                      //ha a szöveg tartalmazza a kicserélendő szót, akkor menjen csak bele
            text = text.replaceAll(toChange, newWord);      //a text legyen egyenlő önmaga kicserélt verziójával, cserélje ki az összes megadott szót, az új szóra
        }
        return text;            //térjen vissza a szöveggel
    }
}
