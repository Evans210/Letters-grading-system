import java.util.Scanner;

public class LettersGradingConverter {
    public static double charToStat(char stat){
        if ((int)stat >= 65 && (int)stat <= 70){
            return 70 - stat;
        }else if ((int)stat == 43){
            return 0.333;
        }else if ((int)stat == 45){
            return -0.333;
        }else if ((int)stat == 83){
            return 6;
        }else return 0;
    }

    public static String statToLetter(float stat){
//        System.out.println(stat);
        String letterStat = "";
        float signValue = Math.round(stat % 1 * 1000.0f) / 1000.0f;

        int letterValue = 70 - (int)stat;
        if (signValue >=0.166f && signValue <0.5f) {
            letterStat = "+";
        } else if(signValue >=0.5f){
            letterValue--;
            if (signValue < 0.833){
                letterStat = "-";
            }
        }
        if (letterValue == 64){
            letterValue = 83;
        }
        letterStat = (char)letterValue + letterStat;
        return letterStat;
    }

    public static String converter(String stats){
        float averageStat = 0f;
        int statNumber = stats.replaceAll("[+-]", "").length();

        String averageLetter;
        for (int i = 0; i < stats.length(); i++) {
            averageStat += charToStat(stats.charAt(i));
        }
        averageStat = averageStat/statNumber;
        averageLetter = statToLetter(averageStat);
        return averageLetter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter stats: "); // Letter format from A to F
        String testString = in.nextLine();
        do{
            System.out.println(converter(testString));
            System.out.println("Enter stats: ");
            testString = in.nextLine();
        }while (!testString.equalsIgnoreCase("stop"));

        in.close();
    }
}
