package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;
import javax.swing.JSeparator;

public class Commande1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande1 frame = new Commande1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Commande1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Commande1.class.getResource("/Pictures/icon.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 1270, 758);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnAfficherCommande = new JButton("Afficher Commandes");
		btnAfficherCommande.setBackground(new Color(154, 205, 50));
		btnAfficherCommande.setBorderPainted(false);
		btnAfficherCommande.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfficherCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remplir_JTable();
			}
		});
		btnAfficherCommande.setBounds(1024, 79, 191, 33);
		contentPane.add(btnAfficherCommande);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 123, 803, 497);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBorderPainted(false);
		btnImprimer.setBackground(new Color(154, 205, 50));
		btnImprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Les commandes");
				MessageFormat footer = new MessageFormat("");
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception ex) {
					System.err.format("erreur d'impression", e);
				}
			}
		});
		btnImprimer.setBounds(1090, 641, 125, 33);
		contentPane.add(btnImprimer);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Commande1.class.getResource("/Pictures/pharmacie.PNG")));
		label.setBounds(0, 0, 372, 723);
		contentPane.add(label);
		
		JLabel lblConsulterCommandes = new JLabel("Consulter Commandes");
		lblConsulterCommandes.setForeground(new Color(255, 165, 0));
		lblConsulterCommandes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsulterCommandes.setBounds(412, 11, 284, 39);
		contentPane.add(lblConsulterCommandes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(408, 47, 836, 11);
		contentPane.add(separator);
	}
	private void Remplir_JTable() {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			String sql="select * from facture";
			PreparedStatement prepared=con.prepareStatement(sql);
			ResultSet rs=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
