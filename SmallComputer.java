import javax.swing.*;
import java.util.Scanner;

/**
 * Created by ben on 03-02-16.
 */
public class SmallComputer {

    private SmallProcessor m_processor = new SmallProcessor();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.startComputer();
    }

    private void startComputer() {
        displayInformation();
        System.out.println("\nEnter instruction: ");
        while (askUserForInput()) ;
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
                "Instructions in the range 000-099 are not accepted and will result in an error.\n" +
                "If you would like to quit the program, enter a 3-digit number in the range 100-199.");
    }

    private boolean askUserForInput() {
        if (m_processor.getResult() == SmallProcessor.Result.SUCCESS) {
            String instruction = scanner.next();
            if (m_processor.verifyInput(instruction)) {
                m_processor.processInput(instruction);
                printRegisters(instruction);
            }
            return true;
        } else if (m_processor.getResult() == SmallProcessor.Result.ERROR) {
            System.out.println(m_processor.getMessage());
            m_processor.setResult(SmallProcessor.Result.SUCCESS);
            return true;
        } else {
            return false;
        }
    }

    private void printRegisters(String instruction) {
        System.out.println("Processing: " + instruction);
        for (int i = 0; i < m_processor.getRegisters().length; i++) {
            System.out.print(i + ": ");
            System.out.printf("%03d\t", m_processor.getRegisters()[i]);
        }
        System.out.println();
    }

}
