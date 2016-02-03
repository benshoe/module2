import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ben on 03-02-16.
 */
public class SmallComputerTerminal extends JFrame {

    JLabel instructionLabel;
    JTextField instructionField;
    String instruction;

    public SmallComputerTerminal() {
        super("Small computer");
        setLayout(new FlowLayout());
        instructionLabel = new JLabel("Enter instruction: ");
        add(instructionLabel);
        instructionField = new JTextField(10);
        add(instructionField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInstruction();
            }
        });
        add(okButton);
    }

    private void setInstruction() {
        instruction = instructionField.getText();
    }
}
