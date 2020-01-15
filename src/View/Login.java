package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connexion.Connection_DB;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
 static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 779, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(292, 0, 471, 381);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(35, 186, 407, 32);
		panel.add(textField);
		
		Label label = new Label("Username");
		label.setBounds(35, 148, 92, 32);
		panel.add(label);
		
		Label label_1 = new Label("Password");
		label_1.setBounds(35, 224, 92, 32);
		panel.add(label_1);
		
		Button button_1 = new Button("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connection_DB.connectionWithDatabase();
					Statement st =con.createStatement();
					String sql=" select * from login where UserName='"+textField.getText()+"' && Password='"+textField_1.getText()+"'";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next()) {
						Gestion_Commande h = new Gestion_Commande();
						h.setVisible(true);
						Login.this.setVisible(false);
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
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setBackground(new Color(244, 164, 96));
		button_1.setBounds(35, 320, 407, 32);
		panel.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 262, 407, 32);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Pictures/001-boss.png")));
		lblNewLabel.setBounds(210, 55, 69, 73);
		panel.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/Pictures/jiji.PNG")));
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(0, 0, 295, 381);
		contentPane.add(label_3);
	}

}
