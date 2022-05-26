package Cesar.Cryptography;
/* This class is using Cesar cipher.
The list of available characters is created in Helper class as ArrayList<Character>.
If the text for encryption contains characters not included in the available characters list
 than it will be skipped from encryption
 */

import Cesar.FileOperations;
import Cesar.Language.Language;
import Cesar.TextOperations.Text;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CesarCode implements Crytpography {
    public Helper key;
    int sizeOfKey;
    int shift;
    Language language;

    public Map<Character, Double> EnglishLettersFrequency = new TreeMap<>();

    private int shiftCalculated;

    public CesarCode(Helper key, Language language) {
        this.key = key;
        this.sizeOfKey = key.characters.size();
        this.language = language;
        EnglishLettersFrequency.putAll(language.lettersFrequencyInLanguage);
    }

    @Override
    public String enCrypt(String text, int shift) {
        this.shift = shift;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '\n') {
                result.append("\n");
            } else if (key.characters.contains(ch)) {
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

            if (ch == '\n') {
                result.append("\n");
            } else {
                int index = (key.characters.indexOf(ch) - shift) % sizeOfKey;
                if (index < 0) {
                    index = sizeOfKey + index;
                }
                char deCryptedChar = key.characters.get(index);
                result.append(deCryptedChar);
            }
        }
        return result.toString();
    }

    @Override
    public String bruteCrack(String text) {
        return null;
    }

    /*
    statisticCrack method is using e frequency of letters in English alphabet,
    */
    @Override
    public String statisticCrack(String text) {
        //find a list of characters used in the text
        ArrayList<Character> characters = new ArrayList<>();
        characters = Text.findCharactersUsedInText(text);

        //count how many times each character was used in the text

        Map<Character, Double> lettersFrequencyInText = new TreeMap<>();
        lettersFrequencyInText = Text.findLettersFrequencyInText(text);

        //compare the frequency with frequency of letters in English language


        Map<Character, Double> lettersFrequencyInSampleText = new TreeMap<>();
        FileOperations file = new FileOperations();
        String text2 = file.readFile("sample.txt");
        lettersFrequencyInSampleText = Text.findLettersFrequencyInText(text2);

        Text.compareFrequencyOfLetters(lettersFrequencyInText, lettersFrequencyInSampleText, key.characters);

        return null;
    }


}
