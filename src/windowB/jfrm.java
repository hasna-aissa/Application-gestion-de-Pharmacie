/**
 * 
 */
package windowB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

/**
 * @author ZATeC
 *
 */
public class jfrm {

	private JFrame frame;
	private JTextField txtGgh;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfrm window = new jfrm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jfrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtGgh = new JTextField();
		txtGgh.setBounds(47, 11, 96, 20);
		frame.getContentPane().add(txtGgh);
		txtGgh.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(47, 57, 96, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnSign = new JButton("sign");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaconneion","root","");
					Statement stat=con.createStatement();
					String sql="select pass from connexion where username='"+txtGgh.getText()+"'";
					ResultSet rs=stat.executeQuery(sql);
					
					if(rs.next()) {
							JOptionPane.showMessageDialog(null, "login successfuly... ");
					}
					else {
						JOptionPane.showMessageDialog(null, "login insuccessfuly... ");
					}
					con.close();
				}
				catch(Exception e1) {
					System.out.print(e);
				}
			}
		});
		btnSign.setBounds(232, 43, 89, 23);
		frame.getContentPane().add(btnSign);
		
		table = new JTable();
		table.setBounds(47, 156, 348, 20);
		frame.getContentPane().add(table);
	}
}
