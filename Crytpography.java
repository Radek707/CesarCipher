package Cesar;

public interface Crytpography {

    String enCrypt(String text, int shift);

    String deCrypt(String text, int s);

    String bruteCrack();

    String statisticCrack();
}
