package Cesar.TextOperations;

import Cesar.Language.Language;

import java.util.*;

public class Text {

    private static double matchFrequenciesByParsonChiSqr(double o, double e) {
        return ((o - e) * (o - e)) / e;
    }

    public static Map<Character, Double> findLettersFrequencyInText(String text) {
        ArrayList<Character> charactersUsedInText;
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
                //ignore digits, because they are not a part of key
                if (text.charAt(j) >= 48 && text.charAt(j) <= 57) continue;
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

    //Finds first 5 the most frequnet chracters in text and sample text and compares their position,
    //in the charactersInLanguage list.
    //Return an ArrayList with text description of the results, including the best shift;
    public static int findShiftByFrequencyOfLetters(Map<Character, Double> frequencyInText,
                                                    Map<Character, Double> frequencyInSample,
                                                    ArrayList<Character> charactersInLanguage) {
        //transferring TreeMap values into an ArrayList of values in order to sort in ascending
        ArrayList<Double> frequencyInTextList = new ArrayList<>();

        for (Map.Entry<Character, Double> pair : frequencyInText.entrySet()) {
            frequencyInTextList.add(pair.getValue());
        }

        Collections.sort(frequencyInTextList);
        Collections.reverse(frequencyInTextList);

        //create an Array list in sorted order
        ArrayList<Character> charactersInTextList = new ArrayList<>();

        for (Double frequency : frequencyInTextList) {
            for (Map.Entry<Character, Double> pair : frequencyInText.entrySet()) {
                if (pair.getValue().equals(frequency)) charactersInTextList.add(pair.getKey());
            }
        }

        ArrayList<Double> frequencyInSampleList = new ArrayList<>();
        ArrayList<Character> charactersInSampleList = new ArrayList<>();

        for (Map.Entry<Character, Double> pair : frequencyInSample.entrySet()) {
            frequencyInSampleList.add(pair.getValue());
        }

        Collections.sort(frequencyInSampleList);
        Collections.reverse(frequencyInSampleList);

//TODO make it more elegant, resultOfComparePrintList was only for testing purpose
        ArrayList<String> resultOfCompareToPrintList = new ArrayList<>();
        String resultOfCompare;
        ArrayList<Integer> shiftBetweenCharsList = new ArrayList<>();

        int charactersToCompare = 5;

        for (int i = 0; i < charactersToCompare; i++) {
            resultOfCompare = ("Compare result: ");

            for (Map.Entry<Character, Double> pair : frequencyInText.entrySet()) {
                if (pair.getValue().equals(frequencyInTextList.get(i))) {
                    resultOfCompare += " character in text: " + pair.getKey();
                    charactersInTextList.add(pair.getKey());
                    char characterInText = pair.getKey();
                }
            }

            for (Map.Entry<Character, Double> pair : frequencyInSample.entrySet()) {
                if (pair.getValue().equals(frequencyInSampleList.get(i))) {
                    resultOfCompare += " character in sample: " + pair.getKey();
                    charactersInSampleList.add(pair.getKey());
                    char characterInSample = pair.getKey();
                }
            }

            int shiftBetweenChars = findShiftBetweenCharacters(charactersInTextList.get(i),
                    charactersInSampleList.get(i), charactersInLanguage);
            resultOfCompare += " shift between characters: " + shiftBetweenChars;
            shiftBetweenCharsList.add(shiftBetweenChars);
            resultOfCompareToPrintList.add(resultOfCompare);
            resultOfCompare = null;
        }

        int bestShiftInCompare = findBestShiftInCompare(shiftBetweenCharsList);
        resultOfCompareToPrintList.add("Best shift: " + bestShiftInCompare);

        return bestShiftInCompare;
    }

    public static int findBestShiftInCompare(ArrayList<Integer> shiftBetweenCharsList) {

        int result = 0;
        Stack<Integer> shiftValuesStack = new Stack<>();
        ArrayList<Integer> egaulShiftCountList = new ArrayList<>();
        int countHowManyEquals = 0;

        //remove duplicates
        shiftValuesStack.push(shiftBetweenCharsList.get(0));
        for (int i = 1; i < shiftBetweenCharsList.size(); i++) {
            if (!shiftValuesStack.contains(shiftBetweenCharsList.get(i))) {
                shiftValuesStack.push(shiftBetweenCharsList.get(i));
            }
        }

        //count how many times shift value is repeated in shiftBetweenCharsList
        int[][] shiftEqualsArray = new int[shiftValuesStack.size()][2];
        int stackSize = shiftValuesStack.size();
        for (int i = 0; i < stackSize; i++) {
            int temp = shiftValuesStack.pop();
            for (int j = 0; j < shiftBetweenCharsList.size(); j++) {
                if (temp == shiftBetweenCharsList.get(j)) {
                    countHowManyEquals++;
                }
            }
            shiftEqualsArray[i][0] = temp;
            shiftEqualsArray[i][1] = countHowManyEquals;
            countHowManyEquals = 0;
        }

        //find which shift value is mostly repeated

        int max = shiftEqualsArray[0][1];

        for (int i = 0; i < stackSize; i++) {
            if (max < shiftEqualsArray[i][1]) {
                max = shiftEqualsArray[i][1];
            }
        }

        //return value of shift which is mostly repeated
        for (int i = 0; i < stackSize; i++) {
            if (shiftEqualsArray[i][1] == max) {
                result = shiftEqualsArray[i][0];
            }
        }

        return result;
    }

    public static int findShiftBetweenCharacters(char characterInText,
                                                 char characterInSample,
                                                 ArrayList<Character> charactersInLanguage) {
        int indexOfCharTextInCharactersInLanguage = 0;
        int indexOfCharSampleInCharactersInLanguage = 0;
        int shiftBetweenChars;

        for (int i = 0; i < charactersInLanguage.size(); i++) {
            if (charactersInLanguage.get(i).equals(characterInText)) {
                indexOfCharTextInCharactersInLanguage = i;
                break;
            }
        }

        for (int i = 0; i < charactersInLanguage.size(); i++) {
            if (charactersInLanguage.get(i).equals(characterInSample)) {
                indexOfCharSampleInCharactersInLanguage = i;
                break;
            }
        }


        shiftBetweenChars = indexOfCharTextInCharactersInLanguage - indexOfCharSampleInCharactersInLanguage;
        if (shiftBetweenChars < 0) shiftBetweenChars += charactersInLanguage.size();

        return shiftBetweenChars;
    }

    public static int checkIfTextIsReal(String text, Language language) {
        ArrayList<String> wantedStrings = new ArrayList<>(language.wantedStrings);
        ArrayList<String> forbiddenStrings = new ArrayList<String>(language.forbiddenStrings);

        int realityScore = 0;

        for (int i = 0; i < wantedStrings.size(); i++) {
            if (text.contains(wantedStrings.get(i))) {
                realityScore++;
            }
        }

        for (int i = 0; i < forbiddenStrings.size(); i++) {
            if (text.contains(forbiddenStrings.get(i))) {
                realityScore -= 5;
            }
        }

        return realityScore;
    }
}
