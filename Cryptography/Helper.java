package Cesar.Cryptography;

import java.util.ArrayList;

public class Helper {
    //set of characters available for encryption
    public ArrayList<Character> characters = new ArrayList<>();

    public Helper() {
        for (int i = 32; i <= 125; i++) {
            if (i >= 35 && i <= 38 ||
                    i == 42 || i == 43 || i == 45 || i >= 47 && i <= 57
                    || i >= 60 && i <= 62 || i == 64 || i == 92 || i == 94
                    || i == 95 || i == 124) continue; //skipping some special chars, and all digits
            characters.add((char) i);
        }
    }

}
