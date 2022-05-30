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

public class ShoppingCart implements IMenu{

	private JFrame frame;
//	private JTextField textField;
//	private JTextField textField_2;
//	private JTextField textField_1;
	private JTable table;
//	private JTextField textField_4;
	String server = "jdbc:mysql://140.119.19.73:3315/";
	String database = "mongroup5"; // change to your own database
	String url = server + database + "?useSSL=false";
	String username = "mongroup5"; // change to your own user name
	String password = "gsq2167"; // change to your own password
	private JTextField textField_3;
	String url1  = server + database + "?characterEncoding=utf8";
	//url: jdbc:mysql://host:port/dbname?characterEncoding=utf8
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShoppingCart window = new ShoppingCart();
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
	public ShoppingCart() {
		initialize();
		tableupdate();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 970, 864);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(147, 93, 662, 465);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dl = (DefaultTableModel)table.getModel();
				int index = table.getSelectedRow();
//				textField.setText(dl.getValueAt(index,1).toString());
//				textField_1.setText(dl.getValueAt(index,2).toString());
//				textField_2.setText(dl.getValueAt(index,3 ).toString());
//				textField_4.setText(dl.getValueAt(index,4 ).toString());
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
		
//		textField_3 = new JTextField();
//		textField_3.setBounds(1199, 748, 96, 30);
//		frame.getContentPane().add(textField_3);
//		textField_3.setColumns(10);
		
		
		JButton btnNewButton_5_1 = new JButton("\u5F9E\u8CFC\u7269\u8ECA\u79FB\u9664");
		
		
		
		class buttonlistner implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
						insert = con1.prepareStatement("DELETE FROM `Cart` WHERE ID = ?" );
						
						insert.setInt(1, id);
						insert.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_5_1, "刪除成功");
						tableupdate();
						
					}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		btnNewButton_5_1.addActionListener(new buttonlistner());

		btnNewButton_5_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton_5_1.setBounds(386, 613, 192, 56);
		frame.getContentPane().add(btnNewButton_5_1);
		
		JLabel lblNewLabel = new JLabel("\u6211\u7684\u8CFC\u7269\u8ECA");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 40));
		lblNewLabel.setBounds(367, 10, 238, 51);
		frame.getContentPane().add(lblNewLabel);
		
		
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
			tableupdate = con1.prepareStatement("SELECT * FROM `Cart`" );
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
}	
	
