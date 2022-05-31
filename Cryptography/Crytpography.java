package Cesar.Cryptography;

public interface Crytpography {

    String enCrypt(String text);

    String deCrypt(String text);

    /*
            statisticCrack method is using e frequency of letters in English alphabet,
            */
    String statisticCrackWithSampleText(String text, String sampleText);
}
