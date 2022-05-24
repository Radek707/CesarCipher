package Cesar;
/* This class is using Cesar cipher.
The list of available characters is created in Helper class as ArrayList<Character>.
If the text for encryption contains characters not included in the available characters list
 than it will be skipped from encryption
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
        characters = findCharactersUsedInText(text);

        //count how many times each character was used in the text

        Map<Character, Double> lettersFrequencyInText = new TreeMap<>();
        lettersFrequencyInText = findLettersFrequencyInText(text);

        //compare the frequency with frequency of letters in English language
        Map<Character, Double> EnglishLettersFrequency = new TreeMap<>();

        EnglishLettersFrequency.put('a', 0.084966);
        EnglishLettersFrequency.put('b', 0.02072);
        EnglishLettersFrequency.put('c', 0.045388);
        EnglishLettersFrequency.put('d', 0.03844);

        compareFrequencyOfLetters(lettersFrequencyInText, EnglishLettersFrequency);

        return characters.toString();
    }

    private void compareFrequencyOfLetters(Map<Character, Double> frequencyInText,
                                           Map<Character, Double> frequencyInLanguage) {
    }

    public Map<Character, Double> findLettersFrequencyInText(String text) {
        ArrayList<Character> charactersUsedInText = new ArrayList<>();
        charactersUsedInText = findCharactersUsedInText(text);

        Map<Character, Double> lettersFrequencyInText = new TreeMap<>();

        int lettersCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\r' || text.charAt(i) == '\n') continue;
            lettersCount++;
        }

        for (int i = 0; i < charactersUsedInText.size(); i++) {
            char tempChar = charactersUsedInText.get(i);
            double singleLetterCount = 0.0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == '\r' || text.charAt(j) == '\n') continue;
                if (tempChar == text.charAt(j)) {
                    lettersFrequencyInText.put(tempChar, ++singleLetterCount);
                }
            }
        }

        for (Map.Entry<Character, Double> pair : lettersFrequencyInText.entrySet()) {
            pair.setValue(pair.getValue() / lettersCount);
        }

        return lettersFrequencyInText;
    }

    private ArrayList<Character> findCharactersUsedInText(String text) {
        text = text.toLowerCase();
        ArrayList<Character> characters = new ArrayList<>();
        char tempChar = text.charAt(0);
        characters.add(tempChar);

        for (int i = 0; i < text.length(); i++) {
            tempChar = text.charAt(i);
            for (int j = i + 1; j < text.length() - 1; j++) {
                if (tempChar != text.charAt(j) && !characters.contains(text.charAt(j))) {
                    if (text.charAt(j) == '\r' || text.charAt(j) == '\n') continue;
                    characters.add(text.charAt(j));
                }
            }
        }

        return characters;
    }
}
