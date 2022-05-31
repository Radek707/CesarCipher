package Cesar.Cryptography;

import Cesar.Language.Helper;
import Cesar.Language.Language;
import Cesar.TextOperations.Text;

import java.util.Map;

public class StatisticCrack implements CodeCracking {
    Helper characters;
    Language english;
    CesarCode cesarCode;
    String sampleText;

    public StatisticCrack(Helper characters, Language english,
                          CesarCode cesarCode, String sampleText) {
        this.characters = characters;
        this.english = english;
        this.cesarCode = cesarCode;
        this.sampleText = sampleText;
    }

    @Override
    public String codeCracking(String text) {
        //find frequency of each character in text;
        Map<Character, Double> lettersFrequencyInText = Text.findLettersFrequencyInText(text);

        //find frequency of each character in sample text;
        Map<Character, Double> lettersFrequencyInSampleText = Text.findLettersFrequencyInText(sampleText);

        //find best shift comparing characters frequency between text and sample text
        //5 most frequent characters are compared
        //the best shift is the most repeating shift in those 5
        cesarCode.shift = Text.findShiftByFrequencyOfLetters(lettersFrequencyInText,
                lettersFrequencyInSampleText, characters.characters);
        return cesarCode.deCrypt(text);
    }
}
