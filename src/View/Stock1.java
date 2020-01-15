package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;
import javax.swing.JSeparator;

public class Stock1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock1 frame = new Stock1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Stock1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ZATeC\\Desktop\\java\\GestionDuPharmacie\\src\\pictures\\icon.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 40, 1270, 758);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(960, 78, 252, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumMedicament = new JLabel("Num Medicament");
		lblNumMedicament.setFont(new Font("Century", Font.BOLD, 14));
		lblNumMedicament.setBounds(822, 79, 128, 14);
		contentPane.add(lblNumMedicament);
		
		textField_1 = new JTextField();
		textField_1.setBounds(559, 124, 230, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantit\u00E9");
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 14));
		lblNewLabel.setBounds(416, 125, 74, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(559, 78, 230, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNommedicament = new JLabel("Nom_Medicament");
		lblNommedicament.setFont(new Font("Century", Font.BOLD, 14));
		lblNommedicament.setBounds(415, 79, 141, 14);
		contentPane.add(lblNommedicament);
		
		JButton btnChercer = new JButton("");
		btnChercer.setIcon(new ImageIcon(Stock1.class.getResource("/Pictures/Refresh-icon.png")));
		btnChercer.setBorder(null);
		btnChercer.setBackground(Color.WHITE);
		btnChercer.setFont(new Font("Century", Font.BOLD, 14));
		btnChercer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=textField_2.getText();
				
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacien","root","");
						String sql="select * from Medicament where Nom_Medicament like '%"+nom+"%'";
						PreparedStatement prepared=con.prepareStatement(sql);
						ResultSet rs=prepared.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
					catch(Exception ex) {
						
					}
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnChercer.setBounds(1141, 205, 59, 49);
		contentPane.add(btnChercer);
		
		JButton btnAmiliorer = new JButton("amiliorer");
		btnAmiliorer.setBorder(null);
		btnAmiliorer.setBackground(new Color(154, 205, 50));
		btnAmiliorer.setFont(new Font("Century", Font.BOLD, 14));
		btnAmiliorer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con=Connection_DB.connectionWithDatabase();
					Statement stat=con.createStatement();
					String sql="update Medicament set QteEnStock='"+Double.parseDouble(textField_1.getText())+"' where Num_Medicament='"+textField.getText()+"'";
					int rs=stat.executeUpdate(sql);	
					JOptionPane.showMessageDialog(null, "Le Stock a été augmenté... ");
				}
				catch(Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnAmiliorer.setBounds(1095, 125, 117, 29);
		contentPane.add(btnAmiliorer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 256, 791, 173);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mod=(DefaultTableModel)table.getModel();
				int ligne =table.getSelectedRow();
				String num=(String)table.getModel().getValueAt(ligne, 0).toString();
				String nom=(String)table.getModel().getValueAt(ligne, 1).toString();
				String qte=(String)table.getModel().getValueAt(ligne, 3).toString();
				textField.setText(num);
				textField_2.setText(nom);
				textField_1.setText(qte);
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(413, 546, 791, 162);
		contentPane.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mod=(DefaultTableModel)table_1.getModel();
				int ligne =table_1.getSelectedRow();
				String num=(String)table_1.getModel().getValueAt(ligne, 0).toString();
				String nom=(String)table_1.getModel().getValueAt(ligne, 1).toString();
				String qte=(String)table_1.getModel().getValueAt(ligne, 3).toString();
				textField.setText(num);
				textField_2.setText(nom);
				textField_1.setText(qte);
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton btnMedicamentEpuis = new JButton("Afficher stock Epuis\u00E9");
		btnMedicamentEpuis.setBorder(null);
		btnMedicamentEpuis.setBackground(new Color(154, 205, 50));
		btnMedicamentEpuis.setFont(new Font("Century", Font.BOLD, 14));
		btnMedicamentEpuis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacien","root","");
					String sql="select * from Medicament where QteEnStock=0";
					PreparedStatement prepared=con.prepareStatement(sql);
					ResultSet rs=prepared.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnMedicamentEpuis.setBounds(1033, 506, 180, 29);
		contentPane.add(btnMedicamentEpuis);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Stock1.class.getResource("/Pictures/pharmacie.PNG")));
		label.setBounds(0, 0, 372, 723);
		contentPane.add(label);
		
		JLabel lblLesMedicamentxExpir = new JLabel("Stock epuis\u00E9");
		lblLesMedicamentxExpir.setForeground(new Color(255, 165, 0));
		lblLesMedicamentxExpir.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLesMedicamentxExpir.setBounds(399, 463, 311, 29);
		contentPane.add(lblLesMedicamentxExpir);
		
		JLabel lblAugmenterStock = new JLabel("Augmenter Stock");
		lblAugmenterStock.setForeground(new Color(255, 165, 0));
		lblAugmenterStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAugmenterStock.setBounds(399, 22, 295, 29);
		contentPane.add(lblAugmenterStock);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(399, 58, 821, 9);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(399, 450, 821, 9);
		contentPane.add(separator_1);
	}

}
