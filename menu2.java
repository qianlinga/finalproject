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

public class menu2 implements IMenu  {

	private JFrame frame;
	private JTable table;
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
	public menu2() {
		initialize();
		tableupdate();
		frame.setVisible(true);
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		
		
		
		
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
		lblNewLabel_1.setBounds(314, 22, 558, 70);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("查看購物車");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingCart();
//				java.sql.Connection con1;
//				java.sql.PreparedStatement insert;
//				
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					con1 = DriverManager.getConnection(url, username, password);
//					String sql = "SELECT * FROM `Cart`";
//					insert = con1.prepareStatement(sql);
//			
//					boolean hasResultSet4 = insert.execute(sql);
//					if(hasResultSet4) {
//						ResultSet result = insert.getResultSet();
//						textArea.setText(showResultSet(result));
//						result.close();
//					}
//				
//					
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
				
			}
		});
		btnNewButton_4.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton_4.setBounds(789, 620, 289, 109);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("加入購物車");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dl = (DefaultTableModel)table.getModel();
				int index = table.getSelectedRow();
				
				java.sql.Connection con1;
				java.sql.PreparedStatement insert;
				
				
				try {
					int id = Integer.parseInt(dl.getValueAt(index, 0).toString());//int id = Integer.parseInt(dl.getValueAt(index, 0).toString());
					String name = dl.getValueAt(index, 1).toString();
					int price = Integer.parseInt(dl.getValueAt(index, 2).toString());
					String type = dl.getValueAt(index, 3).toString();
					String genre = dl.getValueAt(index, 4).toString();
					Class.forName("com.mysql.jdbc.Driver");
					//String ID = textField_3.getText();
					
					con1 = DriverManager.getConnection(url, username, password);
					insert = con1.prepareStatement("INSERT INTO `Cart`( `Name`, `Type`, `Price`, `Genre`) VALUES (?,?,?,?)");
					
					insert.setString(1,name);
					insert.setString(2, type);
					insert.setInt(3,price);
					insert.setString(4,genre);
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(btnNewButton_5, "成功加入");
					
//					Class.forName("com.mysql.jdbc.Driver");
//					con1 = DriverManager.getConnection(url, username, password);
					String sql = "SELECT * FROM Cart";
					insert = con1.prepareStatement(sql);
			
					boolean hasResultSet4 = insert.execute(sql);
					if(hasResultSet4) {
						ResultSet result = insert.getResultSet();
						//textArea.setText(showResultSet(result));
						result.close();
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


		
		btnNewButton_5.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton_5.setBounds(347, 620, 277, 109);
		frame.getContentPane().add(btnNewButton_5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(64, 150, 1291, 414);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		table.setRowHeight(30);
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				DefaultTableModel dl = (DefaultTableModel)table.getModel();
//				int index = table.getSelectedRow();
//				textField.setText(dl.getValueAt(index,1).toString());
//				textField_1.setText(dl.getValueAt(index,2).toString());
//				textField_2.setText(dl.getValueAt(index,3 ).toString());
//				textField_4.setText(dl.getValueAt(index,4 ).toString());
//			}
//		});
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
		
		JLabel lblNewLabel_7 = new JLabel("買書頁面");
		lblNewLabel_7.setFont(new Font("华文宋体", Font.PLAIN, 40));
		lblNewLabel_7.setBounds(1213, 22, 192, 55);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		
		
		//JLabel lblNewLabel_6 = new JLabel(new ImageIcon("C:\\eclipse_workspace\\finalproject__new\\src\\finalproject__new\\book_stack.png"));
	
		
		
		tableupdate();
		
		
	}
	
	
	
	
	public void tableupdate() {
		
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
