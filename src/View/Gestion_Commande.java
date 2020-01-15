package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Pharmacie.LigneFacture;
import Pharmacie.gererFacture;
import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;
import java.awt.Button;

public class Gestion_Commande extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Commande frame = new Gestion_Commande();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion_Commande() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gestion_Commande.class.getResource("/Pictures/icon.PNG")));
		gererFacture gr=new gererFacture();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1427, 854);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setMaximumSize(new Dimension(32823, 32877));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 224));
		scrollPane.setBounds(502, 398, 799, 178);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		scrollPane.setColumnHeaderView(panel);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(632, 243, 214, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom_Medicament :");
		lblNewLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(478, 202, 147, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNummedicament = new JLabel("Num_Medicament :");
		lblNummedicament.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblNummedicament.setBounds(478, 246, 147, 14);
		contentPane.add(lblNummedicament);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String Nom_Med=comboBox.getSelectedItem().toString(); 
					Connection cnx=Connection_DB.connectionWithDatabase();
					Statement stat=cnx.createStatement();
					ResultSet rs=stat.executeQuery("select * from Medicament where Nom_Medicament='"+Nom_Med+"'");
					while(rs.next()) {
						textField.setText(rs.getString("Num_Medicament"));
						textField_1.setText(rs.getString("QteEnStock"));
						textField_2.setText(rs.getString("Prix"));
					}
				}
				catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		comboBox.setBounds(632, 198, 214, 29);
		contentPane.add(comboBox);
		

		try {
			Connection cnx=Connection_DB.connectionWithDatabase();
			Statement stat=cnx.createStatement();
			ResultSet rs=stat.executeQuery("select * from Medicament");
			while(rs.next()) {
				comboBox.addItem(rs.getString("Nom_Medicament"));
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblPrix.setBounds(817, 307, 67, 14);
		contentPane.add(lblPrix);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1158, 243, 214, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("QteDisponible :");
		lblNewLabel_1.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(990, 248, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(894, 302, 214, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("QteCommande :");
		lblNewLabel_2.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(990, 203, 147, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char car=e.getKeyChar();
				
				if(car>='1' && car<='9') {
				try {
					Connection cnx=Connection_DB.connectionWithDatabase();
					String Nom_Med=comboBox.getSelectedItem().toString(); 
					String Num_Med=textField.getText();
					int Qte=Integer.parseInt(textField_3.getText());
					Statement stat=cnx.createStatement();
					ResultSet rs=stat.executeQuery("select * from Medicament where Num_Medicament='"+Num_Med+"'");
					while(rs.next()) {
						double QteD=Double.parseDouble(rs.getString("QteEnStock"));
						if(Qte<QteD) {
							double prix=Qte*Double.parseDouble(rs.getString("Prix"));
							textField_2.setText(String.valueOf(prix));
						}
						else {
							JOptionPane.showMessageDialog(null, "Stock insuffisant ,veuillez amiliorez le stock!!!!!");
						}
						
					}
				}
				catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, ex);
				}
				}
			}
		});
		textField_3.setBounds(1158, 196, 214, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEnregister = new JButton("Ajouter");
		btnEnregister.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnEnregister.setBorderPainted(false);
		btnEnregister.setBackground(new Color(255, 165, 0));
		btnEnregister.setFont(new Font("Century", Font.BOLD, 14));
		btnEnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Num_Med=textField.getText();
				String Num_Fac=textField_4.getText();
				int Qte=Integer.parseInt(textField_3.getText());
				double prix=Double.parseDouble(textField_2.getText());
				LigneFacture LF=new LigneFacture(Num_Med,Num_Fac,Qte,prix);
				gr.recupererDonnee(LF);
				gr.UpdateQte(Qte, LF);
				Remplir_JTable();
				double totale1=Double.parseDouble(textField_5.getText());
				double totale2=Double.parseDouble(textField_2.getText());
				textField_5.setText(String.valueOf(totale1+totale2));
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			}
		});
		btnEnregister.setBounds(1266, 346, 106, 29);
		contentPane.add(btnEnregister);
		
		textField_4 = new JTextField();
		textField_4.setBounds(931, 137, 96, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNumfacture = new JLabel("Facture N\u00B0: ");
		lblNumfacture.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblNumfacture.setBounds(826, 138, 106, 14);
		contentPane.add(lblNumfacture);
		
		textField_5 = new JTextField("0");
		textField_5.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		textField_5.setBounds(645, 645, 127, 29);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTotale = new JLabel("Totale :");
		lblTotale.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblTotale.setBounds(491, 652, 83, 14);
		contentPane.add(lblTotale);
		
		JButton btnTotale = new JButton("Enregistrer");
		btnTotale.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnTotale.setBorderPainted(false);
		btnTotale.setBackground(new Color(154, 205, 50));
		btnTotale.setFont(new Font("Century", Font.BOLD, 14));
		btnTotale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gr.UpdateFacture(textField_4.getText(),Double.parseDouble(textField_6.getText()),Double.parseDouble(textField_7.getText()));
				JOptionPane.showMessageDialog(null, "facture enregistré");
			}
		});
		btnTotale.setBounds(645, 766, 117, 40);
		contentPane.add(btnTotale);
		
		JLabel lblRemise = new JLabel("Remise :");
		lblRemise.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblRemise.setBounds(491, 688, 83, 14);
		contentPane.add(lblRemise);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char car=e.getKeyChar();
				
				if(car>='0' && car<='9') {
					double remise=Double.parseDouble(textField_6.getText())/100;
					double totale=Double.parseDouble(textField_5.getText());
					textField_7.setText(String.valueOf(totale-(remise*totale)));
				}
			}
		});
		textField_6.setBounds(645, 685, 127, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTotaleapres = new JLabel("A pay\u00E9 :");
		lblTotaleapres.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 14));
		lblTotaleapres.setBounds(491, 726, 111, 14);
		contentPane.add(lblTotaleapres);
		
		textField_7 = new JTextField();
		textField_7.setBounds(645, 726, 127, 29);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gr.RemplirFacture(textField_4.getText());
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setBounds(1026, 137, 25, 29);
		contentPane.add(btnNewButton);
		
		JButton btnImprimer = new JButton("IMPRIMER");
		btnImprimer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnImprimer.setBorderPainted(false);
		btnImprimer.setBackground(new Color(154, 205, 50));
		btnImprimer.setFont(new Font("Century", Font.BOLD, 14));
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("la facture N°: '"+textField_4.getText()+"' Totale='"+textField_5.getText()+"' Remise:'"+textField_6.getText()+"' TotalePayé :'"+textField_7.getText()+"'");
				MessageFormat footer = new MessageFormat("la facture");
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception ex) {
					System.err.format("erreur d'impression", e);
				}
			}
		});
		btnImprimer.setBounds(502, 766, 117, 40);
		contentPane.add(btnImprimer);
		
		JButton btnConsulterCommande = new JButton("Consulter Commande");
		btnConsulterCommande.setBackground(new Color(154, 205, 50));
		btnConsulterCommande.setBorderPainted(false);
		btnConsulterCommande.setFont(new Font("Century", Font.BOLD, 14));
		btnConsulterCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commande1 cmd=new Commande1();
				cmd.setVisible(true);
			}
		});
		btnConsulterCommande.setBounds(1078, 21, 189, 47);
		contentPane.add(btnConsulterCommande);
		label.setIcon(new ImageIcon(Gestion_Commande.class.getResource("/Pictures/picture.PNG")));
		label.setOpaque(true);
		label.setBackground(Color.GREEN);
		label.setBounds(0, 0, 372, 815);
		contentPane.add(label);
		
		JLabel lblPasserCommande = new JLabel("Passer commande");
		lblPasserCommande.setForeground(new Color(255, 165, 0));
		lblPasserCommande.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPasserCommande.setBounds(438, 105, 186, 14);
		contentPane.add(lblPasserCommande);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(382, 103, 862, -46);
		contentPane.add(separator);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMontant.setForeground(new Color(255, 165, 0));
		lblMontant.setBounds(438, 627, 117, 14);
		contentPane.add(lblMontant);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBorderPainted(false);
		btnStock.setBackground(new Color(154, 205, 50));
		btnStock.setFont(new Font("Century", Font.BOLD, 14));
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock1 stock=new Stock1();
				stock.setVisible(true);
			}
		});
		btnStock.setBounds(958, 24, 89, 41);
		contentPane.add(btnStock);
		
		JButton btnGextionMedicament = new JButton("Gestion Medicament");
		btnGextionMedicament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gerer_medicament g=new Gerer_medicament();
				g.setVisible(true);
			}
		});
		btnGextionMedicament.setBorderPainted(false);
		btnGextionMedicament.setBackground(new Color(154, 205, 50));
		btnGextionMedicament.setFont(new Font("Century", Font.BOLD, 14));
		btnGextionMedicament.setBounds(510, 24, 186, 41);
		contentPane.add(btnGextionMedicament);
		
		JButton btnGestionFournisseur = new JButton("Gestion Fournisseur");
		btnGestionFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gerer_Fournisseur gf=new Gerer_Fournisseur();
				gf.setVisible(true);
			}
			
		});
		btnGestionFournisseur.setBorderPainted(false);
		btnGestionFournisseur.setBackground(new Color(154, 205, 50));
		btnGestionFournisseur.setFont(new Font("Century", Font.BOLD, 14));
		btnGestionFournisseur.setBounds(731, 24, 191, 41);
		contentPane.add(btnGestionFournisseur);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(426, 79, 946, 11);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(426, 605, 946, 11);
		contentPane.add(separator_2);
		
		Button button = new Button("se d\u00E9connecter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
			}
		});
		button.setBounds(1305, 10, 96, 29);
		contentPane.add(button);
		
	}
	private void Remplir_JTable() {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			String sql="select * from lignefacture where Num_Facture='"+textField_4.getText()+"'";
			PreparedStatement prepared=con.prepareStatement(sql);
			ResultSet rs=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
