package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Toolkit;

public class med_expire extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					med_expire frame = new med_expire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public med_expire() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(med_expire.class.getResource("/Pictures/icon.PNG")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 910, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 51, 699, 274);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 250));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(med_expire.class.getResource("/Pictures/pharmacie.PNG")));
		lblNewLabel.setBounds(0, 0, 175, 336);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("m\u00E9dicaments expir\u00E9s");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remplir_JTable();
				
			}
		});
		button.setBackground(new Color(244, 164, 96));
		button.setBounds(738, 10, 146, 35);
		contentPane.add(button);
	}
	private void Remplir_JTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacien","root","");
			String sql="select * from Medicament where TO_DAYS(Date_Expedition)< TO_DAYS(NOW()) ";
			PreparedStatement prepared=con.prepareStatement(sql);
			ResultSet rs=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}

