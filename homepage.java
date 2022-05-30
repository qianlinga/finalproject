package finalproject__new;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u653F\u5927\u66F8\u57CE");
		lblNewLabel.setBounds(5, 5, 619, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u5BA2\u4EBA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new menu2();
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(266, 128, 129, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5E97\u54E1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new menu();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(266, 207, 129, 48);
		contentPane.add(btnNewButton_1);
	}
}
