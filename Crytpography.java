package Cesar;

public interface Crytpography {

    String enCrypt(String text, int shift);

    String deCrypt(String text, int s);

    String bruteCrack(String text);

    /*
            statisticCrack method is using e frequency of letters in English alphabet,
            */
    String statisticCrack(String text);
}
