package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class Home extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/Pictures/icon.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1418, 866);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSeConnecter = new JButton("se connecter");
		btnSeConnecter.setBorderPainted(false);
		btnSeConnecter.setBackground(Color.BLACK);
		btnSeConnecter.setForeground(Color.WHITE);
		btnSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeConnecter.setBounds(1193, 11, 199, 36);
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = new Login();
				a.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnSeConnecter);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Pictures/fffff.PNG")));
		lblNewLabel.setBounds(0, 0, 1404, 828);
		contentPane.add(lblNewLabel);
	}
}
