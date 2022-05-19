package Cesar;

public class CesarCode {
    static Key key = new Key();

    public static StringBuffer enCrypt(String text, int s) {
        StringBuffer result = new StringBuffer();
        int sizeOfKey = key.characters.size();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = (key.characters.indexOf(ch) + s) % sizeOfKey;
            char encryptedCh = key.characters.get(index);
            result.append(encryptedCh);
        }
        return result;
    }

    StringBuffer deCrypt(String text, int s) {
        StringBuffer result = new StringBuffer();


        return result;
    }

}
