package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pharmacie.Fournisseur;
import Pharmacie.Fournisseur_List;
import Pharmacie.Medicament;
import Pharmacie.Medicament_List;
import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Gerer_Fournisseur extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerer_Fournisseur frame = new Gerer_Fournisseur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Close() {
		WindowEvent windowClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
	}
	public Gerer_Fournisseur() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gerer_Fournisseur.class.getResource("/Pictures/icon.PNG")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 1270, 758);
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
		
		Label label = new Label("G\u00E9rer fournisseur");
		label.setForeground(new Color(255, 99, 71));
		label.setFont(new Font("DokChampa", Font.BOLD, 18));
		label.setBounds(395, 10, 208, 22);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 38, 821, 9);
		panel.add(separator);
		
		Label label_2 = new Label("num\u00E9ro ");
		label_2.setBounds(395, 93, 62, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("nom ");
		label_3.setBounds(889, 93, 62, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("num\u00E9ro de t\u00E9l\u00E9phone");
		label_4.setBounds(593, 194, 129, 22);
		panel.add(label_4);
		
		Button button = new Button("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!="" && textField_3.getText()!="" && textField_4.getText()!="" )
				{
					Fournisseur_List f=new Fournisseur_List();
					Fournisseur fournisseur=new Fournisseur(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
					f.AjouterFournisseur(fournisseur);
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(154, 205, 50));
		button.setBounds(738, 45, 120, 32);
		panel.add(button);
		
		Button button_1 = new Button("Vider");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		button_1.setBackground(new Color(244, 164, 96));
		button_1.setBounds(1116, 45, 100, 32);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(463, 83, 259, 32);
		panel.add(textField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(395, 245, 821, 9);
		panel.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(957, 83, 259, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(463, 129, 259, 32);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(957, 141, 259, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBounds(725, 184, 259, 32);
		panel.add(textField_4);
		
		Label label_13 = new Label("email");
		label_13.setBounds(889, 151, 62, 22);
		panel.add(label_13);
		
		Label label_14 = new Label("adresse");
		label_14.setBounds(395, 141, 62, 22);
		panel.add(label_14);
		
		Button button_2 = new Button("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!="" && textField_3.getText()!="" && textField_4.getText()!="" )
				{
					Fournisseur_List f=new Fournisseur_List();
					Fournisseur fournisseur=new Fournisseur(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
					f.ModifierFournisseur(fournisseur);
				}
			}
		});
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(new Color(154, 205, 50));
		button_2.setBounds(864, 45, 120, 32);
		panel.add(button_2);
		
		Button button_3 = new Button("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!="" && textField_3.getText()!="" && textField_4.getText()!="" )
				{
					Fournisseur_List f=new Fournisseur_List();
					Fournisseur fournisseur=new Fournisseur(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
					f.SupprimerFournisseur(fournisseur);
					
				}
			}
		});
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setBackground(new Color(154, 205, 50));
		button_3.setBounds(990, 45, 120, 32);
		panel.add(button_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 374, 720);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(Gerer_Fournisseur.class.getResource("/Pictures/pharmacie.PNG")));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		Button button_4 = new Button("Actualiser");
		button_4.setBackground(new Color(244, 164, 96));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=Connection_DB.connectionWithDatabase();
				String sql="select * from fournisseur";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException et) {

					et.printStackTrace();
				}
			}
		});
		
		button_4.setBounds(1116, 262, 100, 32);
		panel.add(button_4);
		
		Button button_5 = new Button("Rechercher");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=Connection_DB.connectionWithDatabase();
				String nom = textField_1.getText();
					String sql_1="select * from fournisseur where Nom_Fournisseur like '%"+nom+"%'";
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
		button_5.setBackground(new Color(154, 205, 50));
		button_5.setBounds(1078, 207, 138, 32);
		panel.add(button_5);
		
		Label label_5 = new Label("Liste des fournisseurs");
		label_5.setForeground(new Color(255, 99, 71));
		label_5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_5.setBounds(395, 262, 181, 22);
		panel.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(447, 310, 722, 212);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mod=(DefaultTableModel)table.getModel();
				int ligne =table.getSelectedRow();
				String num=(String)table.getModel().getValueAt(ligne, 0).toString();
				String nom=(String)table.getModel().getValueAt(ligne, 1).toString();
				String adresse=(String)table.getModel().getValueAt(ligne, 2).toString();
				String email=(String)table.getModel().getValueAt(ligne, 3).toString();
				String tel=(String)table.getModel().getValueAt(ligne, 4).toString();
				textField.setText(num);
				textField_1.setText(nom);
				textField_2.setText(adresse);
				textField_3.setText(email);
				textField_4.setText(tel);
			}
		});
		scrollPane.setViewportView(table);
		
		Button button_6 = new Button("M\u00E9dicaments fournis");
		button_6.setBackground(new Color(244, 164, 96));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=Connection_DB.connectionWithDatabase();
				String sql="select *  from medicament m,medicament_fournit mf,fournisseur f where m.Num_Medicament=mf.Num_Medicament and mf.Num_fournisseur='"+textField.getText()+"'";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException et) {

					et.printStackTrace();
				}
			}
			
		});
		
		button_6.setBounds(1078, 541, 138, 32);
		panel.add(button_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(443, 579, 726, 130);
		panel.add(scrollPane_1);
		
		JPanel panel_3 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_3);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
