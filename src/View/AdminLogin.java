package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import connexion.Connection_DB;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frmLogin;
	private JTextField textField_1;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminLogin() {
		initialize();
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.getContentPane().setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(546, 216, 1, 2);
		frmLogin.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(471, 194, 369, -1);
		frmLogin.getContentPane().add(separator_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(0, 0, 404, 524);
		frmLogin.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/Pictures/two.jpg")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(406, 0, 471, 524);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(35, 359, 407, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		Label label_1 = new Label("Username");
		label_1.setBounds(35, 249, 92, 32);
		panel.add(label_1);
		
		Label label = new Label("Password");
		label.setBounds(35, 332, 92, 32);
		panel.add(label);
		
		Button button_1 = new Button("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setBounds(298, 418, 144, 32);
		panel.add(button_1);
		button_1.setBackground(new Color(255, 102, 153));
		
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con=Connection_DB.connectionWithDatabase();
				Statement st =con.createStatement();
				String sql=" select * from login where UserName='"+textField.getText()+"' && Password='"+textField_1.getText()+"'";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next()) {
					Gestion_Commande h = new Gestion_Commande();
					h.setVisible(true);
				}
				else {
					textField.setText("");
					textField_1.setText("");
					JOptionPane.showMessageDialog(null,"information incorrecte ! ressayer :)");
				}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		button.setBounds(35, 418, 257, 32);
		panel.add(button);
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(154, 205, 50));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(35, 275, 407, 32);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AdminLogin.class.getResource("/Pictures/001-boss.png")));
		lblNewLabel_1.setBounds(221, 120, 69, 83);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 312, 407, 2);
		panel.add(separator);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(35, 396, 407, 2);
		panel.add(separator_3);
		frmLogin.setBounds(500, 300, 893, 563);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
