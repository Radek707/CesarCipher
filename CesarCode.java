package Cesar;

public class CesarCode {
    static Helper key = new Helper();
    static int sizeOfKey = key.characters.size();

    static StringBuffer enCrypt(String text, int s) {
        StringBuffer result = new StringBuffer();


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = (key.characters.indexOf(ch) + s) % sizeOfKey;
            char encryptedCh = key.characters.get(index);
            result.append(encryptedCh);
        }
        return result;
    }

    static StringBuffer deCrypt(String text, int s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = (key.characters.indexOf(ch) - s) % sizeOfKey;
            char encryptedCh = key.characters.get(index);
            result.append(encryptedCh);
        }
        return result;
    }

}
