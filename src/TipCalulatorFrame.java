import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 8
*Date: April 7th, 2019
*/
/**
 * This class creates the GUI for the tip calculator, Calculates and outputs the
 * results.
 *
 * 
 * @author Ayub Mohamed
 * @version 1.0
 * @since 1.8
 */
public class TipCalulatorFrame {

	/**
	 * This initializes the JFrame
	 */
	JFrame frame;
	private JLabel amountLabel;
	private JLabel tipPercentageLabel;
	private JLabel tipLabel;
	private JLabel totalLabel;

	private JTextField amountTextField;
	private JTextField tipTextField;
	private JTextField totalTextField;
	private JSlider tipPercentageSlider;
	private JButton calculateButton;

	private double tipPercentage = 30;// current tip percentage
	private static final DecimalFormat DF = new DecimalFormat("$0.00");

	public TipCalulatorFrame() {

		// code to initialize the frame
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.setBounds(100, 100, 331, 247);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// code to initialize the amount label
		amountLabel = new JLabel("Amount");
		amountLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		amountLabel.setBounds(15, 16, 69, 20);
		frame.getContentPane().add(amountLabel);

		// code to initialize the tip Percentage label
		tipPercentageLabel = new JLabel("30%");
		tipPercentageLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		tipPercentageLabel.setBounds(28, 54, 42, 20);
		frame.getContentPane().add(tipPercentageLabel);

		// code to initialize the tip label
		tipLabel = new JLabel("Tip");
		tipLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		tipLabel.setBounds(38, 90, 26, 20);
		frame.getContentPane().add(tipLabel);

		// code to initialize the total label
		totalLabel = new JLabel("Total ");
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		totalLabel.setBounds(25, 126, 48, 20);
		frame.getContentPane().add(totalLabel);

		// code to initialize the amount text field
		amountTextField = new JTextField();
		amountTextField.setBounds(99, 14, 200, 26);
		frame.getContentPane().add(amountTextField);
		amountTextField.setColumns(10);

		// code to initialize the tip text field
		tipTextField = new JTextField();
		tipTextField.setColumns(10);
		tipTextField.setBounds(99, 88, 200, 26);
		frame.getContentPane().add(tipTextField);

		// code to initialize the total text field
		totalTextField = new JTextField();
		totalTextField.setColumns(10);
		totalTextField.setBounds(99, 124, 200, 26);
		frame.getContentPane().add(totalTextField);

		// code to initialize the slider, and to change the value of slider when moved
		tipPercentageSlider = new JSlider();
		tipPercentageSlider.setMaximum(30);
		tipPercentageSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				setTipPercentage(tipPercentageSlider.getValue());
				tipPercentage = tipPercentageSlider.getValue();
			}
		});
		tipPercentageSlider.setBounds(99, 54, 200, 26);
		frame.getContentPane().add(tipPercentageSlider);

		// code to initialize the button, and to calculates results when clicked
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(amountTextField.getText());
				calculateResults(amount);
			}
		});
		calculateButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		calculateButton.setBounds(99, 153, 200, 29);
		frame.getContentPane().add(calculateButton);

	}

	/**
	 * Sets the tip percentage Label to equal the value of the slider
	 * 
	 * @param int,
	 *            the value of the slider
	 */
	public void setTipPercentage(int value) {
		// code to update value
		tipPercentageLabel.setText(value + "%");

	}

	/**
	 * Sets the tip percentage Label to equal the value of the slider
	 * 
	 * @param int,
	 *            the amount entered by user
	 */
	public void calculateResults(double amount) {
		// calculates tip
		double tip = amount * (tipPercentage / 100);

		// output tips to the tip text field
		String tipAmount = DF.format(tip);
		tipTextField.setText(tipAmount);

		// calculates and output tips to the total text field
		String totalAmount = DF.format(amount + tip);
		totalTextField.setText(totalAmount);

	}

}
