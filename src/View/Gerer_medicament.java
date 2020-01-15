package View;

import Pharmacie.Fournisseur_List;
import Pharmacie.Medicament;
import Pharmacie.Medicament_List;
import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerer_medicament extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerer_medicament frame = new Gerer_medicament();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Gerer_medicament() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gerer_medicament.class.getResource("/Pictures/icon.PNG")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1270, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1252, 720);
		contentPane.add(panel);
		
		Label label = new Label("G\u00E9rer m\u00E9dicament");
		label.setForeground(new Color(255, 127, 80));
		label.setFont(new Font("DokChampa", Font.BOLD, 18));
		label.setBounds(395, 10, 208, 22);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 38, 836, 11);
		panel.add(separator);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(497, 162, 259, 32);
		panel.add(comboBox_1);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Gerer_medicament.class.getResource("/Pictures/pharmacie.PNG")));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(0, 0, 374, 720);
		panel.add(label_1);
		
		Label label_2 = new Label("num\u00E9ro");
		label_2.setBounds(395, 129, 62, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("nom");
		label_3.setBounds(864, 129, 87, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("quantit\u00E9");
		label_4.setBounds(864, 172, 76, 22);
		panel.add(label_4);
		
		Label label_5 = new Label("date expiration");
		label_5.setBounds(864, 215, 87, 22);
		panel.add(label_5);
		
		Button button = new Button("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && comboBox_1.getSelectedItem()!="" && textField_3.getText()!="" && textField_4.getText()!="" && textField_5.getText()!="" && textField_6.getText()!="")
				{
					Medicament_List m=new Medicament_List();
					Medicament med=new Medicament(textField.getText(),textField_1.getText(),comboBox_1.getSelectedItem().toString(),Integer.parseInt(textField_3.getText()),textField_4.getText(),textField_5.getText(),Double.parseDouble(textField_6.getText()));
					m.AjouterMedicament(med);
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(154, 205, 50));
		button.setBounds(753, 55, 120, 32);
		panel.add(button);
		
		Button button_1 = new Button("Vider");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				comboBox_1.setSelectedIndex(-1);
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		button_1.setBackground(new Color(244, 164, 96));
		button_1.setBounds(1131, 55, 100, 32);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(497, 119, 259, 32);
		panel.add(textField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(395, 309, 836, 22);
		panel.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(957, 119, 259, 32);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(957, 162, 259, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBounds(497, 205, 259, 32);
		panel.add(textField_4);
		
		Label label_6 = new Label(" prix");
		label_6.setBounds(659, 268, 62, 22);
		panel.add(label_6);
		
		
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBounds(957, 205, 259, 32);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.BLACK);
		textField_6.setColumns(10);
		textField_6.setBounds(722, 258, 258, 32);
		panel.add(textField_6);
		
		Label label_13 = new Label("date production");
		label_13.setBounds(395, 215, 96, 22);
		panel.add(label_13);
		
		Label label_14 = new Label("cat\u00E9gorie");
		label_14.setBounds(395, 172, 62, 22);
		panel.add(label_14);
		
		Button button_2 = new Button("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && comboBox_1.getSelectedItem()!="" && textField_3.getText()!="" && textField_4.getText()!="" && textField_5.getText()!="" && textField_6.getText()!="")
				{
					Medicament_List m=new Medicament_List();
					Medicament med=new Medicament(textField.getText(),textField_1.getText(),comboBox_1.getSelectedItem().toString(),Integer.parseInt(textField_3.getText()),textField_4.getText(),textField_5.getText(),Double.parseDouble(textField_6.getText()));
					m.ModifierMedicament(med);
				}
			}
		});
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(new Color(154, 205, 50));
		button_2.setBounds(879, 55, 120, 32);
		panel.add(button_2);
		
		Button button_3 = new Button("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText()!="" && textField_1.getText()!="" && comboBox_1.getSelectedItem()!="" && textField_3.getText()!="" && textField_4.getText()!="" && textField_5.getText()!="" && textField_6.getText()!="")
				{
					Medicament_List m=new Medicament_List();
					Medicament med=new Medicament(textField.getText(),textField_1.getText(),comboBox_1.getSelectedItem().toString(),Integer.parseInt(textField_3.getText()),textField_4.getText(),textField_5.getText(),Double.parseDouble(textField_6.getText()));m.SupprimerMedicament(med);
					m.SupprimerMedicament(med);
				}
			}
		});
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setBackground(new Color(154, 205, 50));
		button_3.setBounds(1005, 55, 120, 32);
		panel.add(button_3);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(980, 359, 251, 27);
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement st =con.createStatement();
			String sql=" select * from categorie";
			ResultSet rs=st.executeQuery(sql);
			comboBox.addItem("");
			while(rs.next()) {
				comboBox.addItem(rs.getString(2));
				comboBox_1.addItem(rs.getString(2));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		panel.add(comboBox);
		
		Label label_15 = new Label("par cat\u00E9gorie");
		label_15.setBounds(884, 364, 90, 22);
		panel.add(label_15);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(395, 445, 836, 11);
		panel.add(separator_2);
		
		Button button_4 = new Button("Rechercher");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		button_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
					Connection con=Connection_DB.connectionWithDatabase();
					String categorie = comboBox.getSelectedItem().toString();
					String sql="select * from medicament where Nom_Categorie = '"+ categorie+"'";
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (SQLException et) {
						et.printStackTrace();
					}
				
					String nom = textField_2.getText();
						String sql_1="select * from Medicament where Nom_Medicament like '%"+nom+"%'";
					try {
						PreparedStatement ps_1 = con.prepareStatement(sql_1);
						ResultSet rs_1 = ps_1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs_1));
					}
					catch(Exception exx) {
						JOptionPane.showMessageDialog(null, exx);
					}
			}
		});
		
		button_4.setForeground(Color.DARK_GRAY);
		button_4.setBackground(new Color(154, 205, 50));
		button_4.setBounds(1111, 399, 120, 32);
		panel.add(button_4);
		
		Connection con=Connection_DB.connectionWithDatabase();
		String sql="select * from medicament";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException et) {

			et.printStackTrace();
		}
		
		
		Label label_17 = new Label("Recherche avanc\u00E9e");
		label_17.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_17.setForeground(new Color(255, 127, 80));
		label_17.setBounds(395, 324, 181, 32);
		panel.add(label_17);
		
		Button button_5 = new Button("Actualiser");
		button_5.setBackground(new Color(244, 164, 96));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=Connection_DB.connectionWithDatabase();
				String sql="select * from medicament";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException et) {

					et.printStackTrace();
				}
			}
		});
		button_5.setBounds(1111, 462, 120, 32);
		panel.add(button_5);
		
		Label label_18 = new Label("Liste de m\u00E9dicaments");
		label_18.setForeground(new Color(255, 127, 80));
		label_18.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_18.setBounds(395, 462, 181, 22);
		panel.add(label_18);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(408, 514, 808, 155);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mod=(DefaultTableModel)table.getModel();
				int ligne =table.getSelectedRow();
				String num=(String)table.getModel().getValueAt(ligne, 0).toString();
				String nom=(String)table.getModel().getValueAt(ligne, 1).toString();
				String nomC=(String)table.getModel().getValueAt(ligne, 2).toString();
				String qte=(String)table.getModel().getValueAt(ligne, 3).toString();
				String date=(String)table.getModel().getValueAt(ligne, 4).toString();
				String ndateEum=(String)table.getModel().getValueAt(ligne, 5).toString();
				String prix=(String)table.getModel().getValueAt(ligne, 6).toString();
				textField.setText(num);
				textField_1.setText(nom);
				comboBox_1.setSelectedItem(nomC);
				textField_3.setText(qte);
				textField_4.setText(date);
				textField_5.setText(ndateEum);
				textField_6.setText(prix);
				
			}
		});
		scrollPane.setViewportView(table);
		
		Button button_6 = new Button("m\u00E9dicaments expir\u00E9s");
		button_6.setFont(new Font("Dialog", Font.BOLD, 12));
		button_6.setForeground(new Color(0, 0, 0));
		button_6.setBackground(new Color(244, 164, 96));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				med_expire m=new med_expire();
				m.setVisible(true);
			}
		});
		button_6.setBounds(405, 675, 181, 35);
		panel.add(button_6);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(598, 359, 259, 32);
		panel.add(textField_2);
		
		Label label_7 = new Label("par nom");
		label_7.setBounds(524, 369, 62, 22);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(660, 470, 48, 14);
		panel.add(label_8);
		
		
		
	}
}
