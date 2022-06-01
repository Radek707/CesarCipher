package Cesar.Cryptography;

import Cesar.Language.Helper;
import Cesar.Language.Language;
import Cesar.TextOperations.Text;

import java.util.ArrayList;
import java.util.Collections;

public class BruteCrack implements CodeCracking {
    Helper characters;
    Language english;
    CesarCode cesarCode;

    public BruteCrack(Helper characters, Language english, CesarCode cesarCode) {
        this.characters = characters;
        this.english = english;
        this.cesarCode = cesarCode;
    }

    @Override
    public String codeCracking(String text) {
        String result;
        int correctShift;
        ArrayList<Integer> realityScoreList = new ArrayList<>();

        for (int i = 1; i < characters.characters.size(); i++) {
            cesarCode.shift = i;
            result = cesarCode.deCrypt(text);
            realityScoreList.add(Text.checkIfTextIsReal(result, english));
        }

        int maxScore = Collections.max(realityScoreList);
        correctShift = realityScoreList.indexOf(maxScore);
        cesarCode.shift = correctShift + 1;
        result = cesarCode.deCrypt(text);

        return result;
    }
}
