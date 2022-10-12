import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class fndnj extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fndnj frame = new fndnj();
					frame.setBounds(280,100,700,450);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fndnj() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(0, 122, 329, -7);
		contentPane.add(rdbtnNewRadioButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(200, 100, 700, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("botao");
		btnNewButton.setBounds(0, 0, 200, 25);
		panel.add(btnNewButton);
		for(int i=0 ; i<125 ; i+=25) {
			JButton b = new JButton("a"+(char)(i+2));
			b.setBounds(0,0+i,200,25);
			panel.revalidate();
			panel.repaint();
			panel.add(b);
		}
	}
}
