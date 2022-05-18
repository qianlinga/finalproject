package finalproject__new;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class menu  {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_4;
	String server = "jdbc:mysql://140.119.19.73:3315/";
	String database = "mongroup5"; // change to your own database
	String url = server + database + "?useSSL=false";
	String username = "mongroup5"; // change to your own user name
	String password = "gsq2167"; // change to your own password
	String url1  = server + database + "?characterEncoding=utf8";
	//url: jdbc:mysql://host:port/dbname?characterEncoding=utf8
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					menu window = new menu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		
//	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
		tableupdate();
		frame.setVisible(true);
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1444, 864);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u653F\u5927\u66F8\u57CE");
		lblNewLabel.setFont(new Font("华文仿宋", Font.BOLD, 61));
		lblNewLabel.setBounds(46, 36, 357, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u66F8,\u4E8C\u624B\u66F8\u4EA4\u6613\u5E73\u53F0");
		lblNewLabel_1.setFont(new Font("標楷體", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(318, 51, 558, 70);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(33, 150, 619, 465);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u66F8\u540D");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(56, 62, 91, 45);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u985E\u5225");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 32));
		lblNewLabel_3.setBounds(56, 127, 68, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u50F9\u9322");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 32));
		lblNewLabel_4.setBounds(56, 188, 91, 43);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u65B0/\u4E8C\u624B\u66F8");
		lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 32));
		lblNewLabel_5.setBounds(56, 244, 158, 59);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(177, 77, 231, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 140, 231, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 202, 231, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		 
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = textField.getText();
				int price = Integer.parseInt(textField_1.getText());
				String type = textField_2.getText();
				String genre = textField_4.getText();
				
				java.sql.Connection con1;
				java.sql.PreparedStatement insert;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					con1 = DriverManager.getConnection(url, username, password);
					con1 = DriverManager.getConnection(url1, username, password);
					
					insert = con1.prepareStatement("INSERT INTO `Booklist1`(`Name`, `Price`, `Type`, `Genre`) VALUES (?,?,?,?)");
					insert.setString(1,name);
					insert.setInt(2, price);
					insert.setString(3,type);
					insert.setString(4,genre);
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(btnNewButton, "增加成功");
					tableupdate();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_4.setText("");
					textField.requestFocus();
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnNewButton.setBounds(39, 352, 108, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u522A\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dl = (DefaultTableModel)table.getModel();
				int index = table.getSelectedRow();
				
				java.sql.Connection con1;
				java.sql.PreparedStatement insert;
				
				
				try {
					int id = Integer.parseInt(dl.getValueAt(index, 0).toString());
					
					int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION) {
						Class.forName("com.mysql.jdbc.Driver");
						
						con1 = DriverManager.getConnection(url, username, password);
						insert = con1.prepareStatement("DELETE FROM `Booklist1` WHERE ID = ?" );
						
						insert.setInt(1, id);
						insert.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1, "刪除成功");
						tableupdate();
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_4.setText("");
						textField.requestFocus();
					}
					
					
					
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnNewButton_1.setBounds(177, 352, 108, 41);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u66F4\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dl = (DefaultTableModel)table.getModel();
				int index = table.getSelectedRow();
				
				java.sql.Connection con1;
				java.sql.PreparedStatement insert;
				
				
				try {
					int id = Integer.parseInt(dl.getValueAt(index, 0).toString());
					String name = textField.getText();
					int price = Integer.parseInt(textField_1.getText());
					String type = textField_2.getText();
					String genre = textField_4.getText();
					
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con1 = DriverManager.getConnection(url, username, password);
					insert = con1.prepareStatement("UPDATE `Booklist1` SET `Name`=?,`Type`=?,`Price`=?,`Genre`=? WHERE ID = ?" );
					insert.setString(1,name);
					insert.setString(2, type);
					insert.setInt(3,price);
					insert.setString(4,genre);
					insert.setInt(5, id);
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(btnNewButton_2, "更新成功");
					tableupdate();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_4.setText("");
					textField.requestFocus();
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 25));
		btnNewButton_2.setBounds(320, 352, 108, 41);
		panel.add(btnNewButton_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(228, 262, 178, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(693, 150, 662, 465);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dl = (DefaultTableModel)table.getModel();
				int index = table.getSelectedRow();
				textField.setText(dl.getValueAt(index,1).toString());
				textField_1.setText(dl.getValueAt(index,2).toString());
				textField_2.setText(dl.getValueAt(index,3 ).toString());
				textField_4.setText(dl.getValueAt(index,4 ).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "\u66F8\u540D", "\u50F9\u683C", "\u985E\u5225", "\u65B0/\u4E8C\u624B"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("賣書頁面");
		lblNewLabel_6.setFont(new Font("华文中宋", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(693, 82, 47, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("賣書頁面");
		lblNewLabel_7.setFont(new Font("华文中宋", Font.PLAIN, 40));
		lblNewLabel_7.setBounds(1240, 10, 180, 62);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		
		
		//JLabel lblNewLabel_6 = new JLabel(new ImageIcon("C:\\eclipse_workspace\\finalproject__new\\src\\finalproject__new\\book_stack.png"));
	
		
		
		tableupdate();
		
		
	}
	
	
	
	
	private void tableupdate() {
		
		int c;  
		java.sql.Connection con1;
		java.sql.PreparedStatement tableupdate;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection(url, username, password);
			tableupdate = con1.prepareStatement("SELECT * FROM `Booklist1`" );
			ResultSet rs = tableupdate.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData();
			c = Rss.getColumnCount();
			
			DefaultTableModel dl = (DefaultTableModel)table.getModel();
			dl.setRowCount(0);
			
			while(rs.next()) {
				
				Vector v1 = new Vector();
				
				for(int a=1;a<=c;a++) {
					v1.add(rs.getString("id"));
					v1.add(rs.getString("Name"));
					v1.add(rs.getString("Price"));
					v1.add(rs.getString("Type"));
					v1.add(rs.getString("Genre"));
				}
				
				dl.addRow(v1);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static String showResultSet(ResultSet result) throws SQLException {
		
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		String output = "";
		
		for (int i = 1; i <= columnCount; i++) {			
			output += String.format("%15s", metaData.getColumnLabel(i));
		}
		output += "\n";
		
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				output += String.format("%15s", result.getString(i));
			}
			output += "\n";
		}
		return output;
	}
}
