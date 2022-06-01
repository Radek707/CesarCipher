package Cesar.Language;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Language {
    public Map<Character, Double> lettersFrequencyInLanguage = new TreeMap<>();
    public ArrayList<String> wantedStrings = new ArrayList<>();
    public ArrayList<String> forbiddenStrings = new ArrayList<>();

    public Language() {
        lettersFrequencyInLanguage.put('a', 0.084966);
        lettersFrequencyInLanguage.put('b', 0.02072);
        lettersFrequencyInLanguage.put('c', 0.045388);
        lettersFrequencyInLanguage.put('d', 0.033844);
        lettersFrequencyInLanguage.put('e', 0.111607);
        lettersFrequencyInLanguage.put('f', 0.018121);
        lettersFrequencyInLanguage.put('g', 0.024705);
        lettersFrequencyInLanguage.put('h', 0.030034);
        lettersFrequencyInLanguage.put('i', 0.075448);
        lettersFrequencyInLanguage.put('j', 0.001965);
        lettersFrequencyInLanguage.put('k', 0.011016);
        lettersFrequencyInLanguage.put('l', 0.054893);
        lettersFrequencyInLanguage.put('m', 0.030129);
        lettersFrequencyInLanguage.put('n', 0.066544);
        lettersFrequencyInLanguage.put('o', 0.071635);
        lettersFrequencyInLanguage.put('p', 0.031671);
        lettersFrequencyInLanguage.put('q', 0.001962);
        lettersFrequencyInLanguage.put('r', 0.075809);
        lettersFrequencyInLanguage.put('s', 0.057351);
        lettersFrequencyInLanguage.put('t', 0.069509);
        lettersFrequencyInLanguage.put('u', 0.036308);
        lettersFrequencyInLanguage.put('v', 0.010074);
        lettersFrequencyInLanguage.put('w', 0.012899);
        lettersFrequencyInLanguage.put('x', 0.002902);
        lettersFrequencyInLanguage.put('y', 0.017779);
        lettersFrequencyInLanguage.put('z', 0.002722);

        wantedStrings.add("the");
        wantedStrings.add(", ");
        wantedStrings.add("and");
        wantedStrings.add("at");
        wantedStrings.add("on");
        wantedStrings.add("while");

        forbiddenStrings.add("aa");
    }
}
