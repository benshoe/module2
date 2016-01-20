import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/20/16.
 */
public class InterestCalculatorFrame extends JFrame {

	public InterestCalculatorFrame() {
		super("Interest Calculator");
		Container container = getContentPane();
		container.setLayout(new SpringLayout());
		JPanel panel = new JPanel();

		panel.add(new JLabel("Period", JLabel.TRAILING));
		JComboBox<String> periods = new JComboBox<>(new String[]{"Year", "Month"});
		panel.add(periods);

		panel.add(new JLabel("Start amount"));
		JTextField startAmount = new JTextField();
		panel.add(startAmount);

		pack();
	}
}
