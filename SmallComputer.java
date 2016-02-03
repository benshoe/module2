import java.util.Scanner;

/**
 * This is the class to run and test the SmallComputer
 *
 * The startComputer method displays the information and then starts in a loop the askUserForInput method.
 * This method handles the input and output with the user.
 *
 * SmallComputer creates a SmallProcessor to perform all the instructions.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 3 February 2016
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
        boolean keepRunning = true;
        /* I could have coded while(askUserForInput()) but that looks awkward, therefore the boolean */
        while(keepRunning) {
            keepRunning = askUserForInput();
        }
        stopComputer();
    }

    private void stopComputer() {
        System.out.println("\nThank you for using this small computer! I hope you enjoyed it.\n" +
                "Until next time!\n\n" +
                "Best regards,\n\nBen Schoen");

    }

    private void displayInformation() {
        System.out.println("Welcome to this small computer.\n\nBy entering three digit values you are\n" +
                "able to set and manipulate 10 registers. After each instruction I will display\n" +
                "the value of each register.\n\n" +
                "You can enter one instruction at a time or more on one line if you like. I will handle\n" +
                "each instruction separately and show the result after each instruction.\n\n" +
                "Instructions that are invalid will not affect the registers (e.g. dividing by 0).\n" +
                "Instructions in the range 000-099 are not accepted and will result in an error.\n" +
                "If you would like to quit the program, enter a 3-digit number in the range 100-199.");
    }

    private boolean askUserForInput() {
        switch(m_processor.getResult()) { // Initially the result is SUCCESS
            case SUCCESS:
                String instruction = scanner.next(); // get the next instruction from the user
                if (m_processor.verifyInput(instruction)) { // verify that the instruction is correct
                    m_processor.processInput(instruction); // if it is successful process the instruction
                    printRegisters(instruction); // and print the instruction
                }
                return true; // we would like to continue
            case ERROR:
                System.out.println(m_processor.getMessage()); // in case of an error we print the message
                System.out.println("Please, try again with a new instruction:");
                m_processor.resetResult(); // the result must be reset; this is done via this method. We don't know how to reset it.
                return true; // when an error occurred ask the user again for input
            case STOPPED:
                return false; // now we return false from the method, because the user entered an instruction to stop
            default:
                /* A default added, so when a new enum value is added and used this will throw an exception and we are forced to implement it */
                throw new IllegalStateException("We don't know the following result type from the processor: " + m_processor.getResult().name());
        }
    }

    private void printRegisters(String instruction) {
        System.out.println("Processing: " + instruction); // we print the instruction being processed
        for (int i = 0; i < m_processor.getRegisters().length; i++) { // we loop through the registers
            System.out.print(i + ": ");
            System.out.printf("%03d\t", m_processor.getRegisters()[i]); //we format the register value to 3 digits with leading zeroes
        }
        System.out.println(); // for readability two line breaks
        System.out.println();
    }

}
