package Cesar.Cryptography;

public interface Crytpography {

    String enCrypt(String text, int shift);

    String deCrypt(String text, int s);

    String bruteCrack(String text);

    /*
            statisticCrack method is using e frequency of letters in English alphabet,
            */
    String statisticCrackWithSampleText(String text, String sampleText);

    //TODO make a statistic crack with languege rules, remember to remove spaces from encrypted text, they are most frequent chracters and are not a part of chracters available in language.
}
