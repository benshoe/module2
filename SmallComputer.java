import javax.swing.*;
import java.util.Scanner;

/**
 * Created by ben on 03-02-16.
 */
public class SmallComputer {

    private SmallProcessor m_processor = new SmallProcessor();

    public static void main(String[] args) {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.startComputer();
    }

    private void startComputer() {
        displayInformation();
        askUserForInput();
        stopComputer();
    }

    private void stopComputer() {
        System.out.println("\n\nThank you for using this small computer! I hope you enjoyed it.\n" +
                "Until next time!\n\n" +
                "Best regards,\n\nBen Schoen");

    }

    private void displayInformation() {
        System.out.println("Welcome to this small computer. By entering three digit values you are\n" +
                "able to set and manipulate 10 registers. After each instruction I will display\n" +
                "the value of each register.\n\n" +
                "Instructions that are invalid will not affect the registers (e.g. dividing by 0).\n" +
                "An instruction starting with a 0 will result in an error.\n" +
                "If you would like to quit eht program, enter a 3-digit number starting with a '1'.");
    }

    private void askUserForInput() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("\nEnter instruction: ");
            if(m_processor.getResult() == SmallProcessor.Result.SUCCESS) {
                String instruction = input.next();
                if (m_processor.verifyInput(instruction)) {
                    m_processor.processInput(instruction);
                    printRegisters();
                }
            } else if(m_processor.getResult() == SmallProcessor.Result.ERROR) {
                System.out.println("Error: " + m_processor.getMessage());
                m_processor.setResult(SmallProcessor.Result.SUCCESS);
            } else if(m_processor.getResult() == SmallProcessor.Result.STOPPED) {
                break;
            }
        }
    }

    private void printRegisters() {
        for(int i = 0; i < m_processor.getRegisters().length; i ++) {
            System.out.print( i + ": ");
            System.out.printf("%03d\t", m_processor.getRegisters()[i]);
        }
        System.out.println();
    }

}
