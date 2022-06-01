package Cesar.Cryptography;

import Cesar.Language.Helper;
import Cesar.Language.Language;
import Cesar.TextOperations.Text;

import java.util.Arrays;
import java.util.Map;

public class CrackByLanguageRules implements CodeCracking {
    Helper characters;
    Language english;
    CesarCode cesarCode;

    public CrackByLanguageRules(Helper characters, Language english, CesarCode cesarCode) {
        this.characters = characters;
        this.english = english;
        this.cesarCode = cesarCode;
    }

    @Override
    public String codeCracking(String text) {
        //find frequency of each character in text;
        Map<Character, Double> lettersFrequencyInText = Text.findLettersFrequencyInText(text);

        //find most frequent character in text, assume that it might be 'space'
        //remove that character from the findLettersFrequncyInText 
        //because this characters in not a part of language frequency
        double[] lettersFrequenciesInTextArray = new double[lettersFrequencyInText.size()];
        int i = 0;

        for (Map.Entry<Character, Double> pair : lettersFrequencyInText.entrySet()) {
            lettersFrequenciesInTextArray[i] = pair.getValue();
            i++;
        }

        Arrays.sort(lettersFrequenciesInTextArray);

        char maxValueKey = '\u0000';
        for (Map.Entry<Character, Double> pair : lettersFrequencyInText.entrySet()) {
            if (pair.getValue() == lettersFrequenciesInTextArray[lettersFrequencyInText.size() - 1]) {
                maxValueKey = pair.getKey();
            }
        }

        lettersFrequencyInText.remove(maxValueKey);

        //find best shift comparing characters frequency between text and frequency of letters in language
        //5 most frequent characters are compared
        //the best shift is the most repeating shift in those 5
        cesarCode.shift = Text.findShiftByFrequencyOfLetters(lettersFrequencyInText,
                english.lettersFrequencyInLanguage, characters.characters);
        return cesarCode.deCrypt(text);
    }
}
