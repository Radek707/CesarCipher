package Cesar.TextOperations;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Text {

    public static void compareFrequencyOfLetters(Map<Character, Double> frequencyInText,
                                                 Map<Character, Double> frequencyInLanguage, ArrayList<Character> characters) {
        int arraySize = frequencyInText.size() * frequencyInLanguage.size();
        Double[][] compareArray = new Double[arraySize][3];
        int i = 0;

        for (Map.Entry<Character, Double> pair : frequencyInText.entrySet()) {
            for (Map.Entry<Character, Double> pair2 : frequencyInLanguage.entrySet()) {
                compareArray[i][0] = pair.getValue();
                compareArray[i][1] = pair2.getValue();
                compareArray[i][2] = chiSqr(pair.getValue(), pair2.getValue());
                i++;
            }
        }

        for (int j = 0; j < compareArray.length; j++) {
            System.out.println(compareArray[j][0] + " " + compareArray[j][1] + " " +
                    compareArray[j][2]);
        }

        double min = compareArray[0][2];

        for (int j = 0; j < compareArray.length; j++) {
            if (compareArray[j][2] < min) {
                min = compareArray[j][2];
            }
        }

        int indexOfMin = 0;

        for (int j = 0; j < compareArray.length; j++) {
            if (compareArray[j][2] == min) {
                indexOfMin = j;
            }
        }

        System.out.println("Min chiSqr: " + min + " at index: " + indexOfMin);

        char characterMatchText = '\u0000';
        char characterMatchLanguage = '\u0000';

        for (Map.Entry<Character, Double> pair : frequencyInText.entrySet()) {
            if (pair.getValue() == (compareArray[indexOfMin][0])) {
                characterMatchText = pair.getKey();
            }
        }

        for (Map.Entry<Character, Double> pair : frequencyInLanguage.entrySet()) {
            if (pair.getValue() == (compareArray[indexOfMin][1])) {
                characterMatchLanguage = pair.getKey();
            }
        }

        int indexOfCharMatchText = characters.indexOf(characterMatchText);
        int indexOfCharMatchLanguage = characters.indexOf(characterMatchLanguage);

        int shiftCalculated = indexOfCharMatchText - indexOfCharMatchLanguage;

        System.out.println("Character in text: " + characterMatchText + " Character in language: " + characterMatchLanguage +
                " shift: " + shiftCalculated);
    }

    private static double chiSqr(double o, double e) {
        return Math.pow((o - e), 2.0) / e;
    }

    public static Map<Character, Double> findLettersFrequencyInText(String text) {
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

    public static ArrayList<Character> findCharactersUsedInText(String text) {
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
