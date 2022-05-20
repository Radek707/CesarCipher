package Cesar;
/* This class is using Cesar cipher.
The list of available characters is created in Helper class as ArrayList<Character>.
If the text for encryption contains characters not included in the available characters list
 than it will be skipped from encryption
 */

public class CesarCode implements Crytpography {
    static Helper key = new Helper();
    static int sizeOfKey = key.characters.size();
    int shift;

    @Override
    public String enCrypt(String text, int shift) {
        this.shift = shift;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (key.characters.contains(ch)) {
                int index = (key.characters.indexOf(ch) + shift) % sizeOfKey;
                char encryptedCh = key.characters.get(index);
                result.append(encryptedCh);
            }
        }
        return result.toString();
    }

    @Override
    public String deCrypt(String text, int shift) {
        this.shift = shift;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = (key.characters.indexOf(ch) - shift) % sizeOfKey;
            char deCryptedChar = key.characters.get(index);
            result.append(deCryptedChar);
        }
        return result.toString();
    }

    @Override
    public String bruteCrack() {
        return null;
    }

    @Override
    public String statisticCrack() {
        return null;
    }
}
