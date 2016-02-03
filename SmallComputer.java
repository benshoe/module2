import javax.swing.*;
import java.util.Scanner;

/**
 * Created by ben on 03-02-16.
 */
public class SmallComputer {

    private SmallProcessor m_processor = new SmallProcessor();

    public static void main(String[] args) {
        setLookAndFeel();
        SmallComputer smallComputer = new SmallComputer();
        smallComputer.startComputer();
    }

    /**
     * This method forces the Nimbus Look and Feel to be loaded
     */
    private static void setLookAndFeel() {
        final UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for(int i = installedLookAndFeels.length - 1; i >=0; i--) {
            if(installedLookAndFeels[i].getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(installedLookAndFeels[i].getClassName());
                } catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("Too bad, it is not possible to set the LookAndFeel to Nimbus. We'll use the default then.");
                }
            }
        }
    }

    private void startComputer() {
        displayInformation();
        while(m_processor.getResult() != SmallProcessor.Result.STOPPED) {
            askUserForInput();
        }
        stopComputer();
    }

    private void stopComputer() {
        JOptionPane.showMessageDialog(null, "Thank you for using this small computer! I hope you enjoyed it.\n" +
                "Until next time!\n\n" +
                "Best regards,\n\nBen Schoen", "Small Computer", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayInformation() {
        JOptionPane.showMessageDialog(null, "Welcome to this small computer. By entering three digit values you are\n" +
                "able to set and manipulate 10 registers. After each instruction I will display\n" +
                "the value of each register.\n\n" +
                "Instructions that are invalid will not affect the registers (e.g. dividing by 0).\n" +
                "An instruction starting with a 0 will result in an error.\n" +
                "If you would like to quit the program, enter a 3-digit number starting with a '1'.", "Small computer", JOptionPane.INFORMATION_MESSAGE);
    }

    private void askUserForInput() {
        String instruction = JOptionPane.showInputDialog(null, "Enter an instruction", "Small Computer", JOptionPane.QUESTION_MESSAGE);
        if (m_processor.verifyInput(instruction)) {
            m_processor.processInput(instruction);
            if(m_processor.getResult() == SmallProcessor.Result.SUCCESS) {
//                String instruction = input.next();
                printRegisters();
            }
        } else if(m_processor.getResult() == SmallProcessor.Result.ERROR) {
            JOptionPane.showMessageDialog(null, m_processor.getMessage(), "Error", JOptionPane.OK_OPTION);
            m_processor.setResult(SmallProcessor.Result.SUCCESS);
        }
    }

    private void printRegisters() {
        StringBuilder registers = new StringBuilder();
        for(int i = 0; i < m_processor.getRegisters().length; i ++) {
            registers.append( i + ": ");
            registers.append(String.format(String.valueOf(m_processor.getRegisters()[i]), "%03d\t"));
        }
        JOptionPane.showMessageDialog(null, registers, "Result", JOptionPane.OK_OPTION);

    }

}
