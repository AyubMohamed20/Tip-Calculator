import java.awt.EventQueue;
/*
*Name: Ayub Mohamed
*Student ID: 040899407
*Course & Section: CST8132 310
*Assignment: Lab 8
*Date: April 7th, 2019
*/
/**
 * This class runs the program
 *
 * @author Ayub Mohamed
 * @version 1.0
 * @since 1.8
 */
public class TipCalculator {
	/**
	 * This methods runs the program
	 * 
	 * @throws Exception
	 *             e, catches all errors
	 * @param args
	 *            array of string arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipCalulatorFrame window = new TipCalulatorFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
