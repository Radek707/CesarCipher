package Cesar;

import java.util.ArrayList;

public class Key {
    //set of characters available for encryption
    ArrayList<Character> characters = new ArrayList<>();

    Key() {
        for (int i = 32; i <= 126; i++) {
            characters.add((char) i);
        }
    }

}
