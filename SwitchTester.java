/**
 * Created by ben on 26-01-16.
 */
public class SwitchTester {

    public static void main(String[] args) {
        int engineCapacity = 1800;
        char raceclass;

        if(engineCapacity >= 3500) {
            raceclass = 'A';
        } else if(engineCapacity <= 3499 && engineCapacity >= 2000) {
            raceclass = 'B';
        } else if(engineCapacity <= 1999 && engineCapacity >= 1600) {
            raceclass = 'C';
        } else if(engineCapacity <= 1599 && engineCapacity >= 1100) {
            raceclass = 'D';
        } else {
            raceclass = 'X';
        }
        System.out.println("raceclass = " + raceclass);

        engineCapacity = 1400;
        if(engineCapacity >= 3500) {
            raceclass = 'A';
        } else if(engineCapacity >= 2000) {
            raceclass = 'B';
        } else if(engineCapacity >= 1600) {
            raceclass = 'C';
        } else if(engineCapacity >= 1100) {
            raceclass = 'D';
        } else {
            raceclass = 'X';
        }
        System.out.println("raceclass = " + raceclass);


        if (raceclass == 'A') {
            System.out.println("Excellent");
            System.out.println("Very High");
            System.out.println("Good");
            System.out.println("Average");
            System.out.println("Failed");
        } else if (raceclass == 'B') {
            System.out.println("Very High");
            System.out.println("Good");
            System.out.println("Average");
            System.out.println("Failed");
        } else if (raceclass == 'C') {
            System.out.println("Good");
            System.out.println("Average");
            System.out.println("Failed");
        } else if (raceclass == 'D') {
            System.out.println("Average");
            System.out.println("Failed");
        } else {
            System.out.println("Failed");
        }

    }




}
