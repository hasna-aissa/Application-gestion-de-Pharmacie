package Pharmacie;
import IDAO.IFournisseur;
import connexion.Connection_DB;
import net.proteanit.sql.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fournisseur_List implements IFournisseur{ 
	List<Fournisseur>FournisseurList=new ArrayList<Fournisseur>();
	public Fournisseur_List(){}
	
	public void AjouterFournisseur(Fournisseur f) {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="insert into fournisseur values('"+f.getNum_Four()+"','"+f.getNom_Four()+"','"+f.getAdresse_Four()+"','"+f.getEmail_Four()+"','"+f.getTel_Four()+"')";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "Fournisseur bien ajouté ! ");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void ModifierFournisseur(Fournisseur f) {
		
try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="update fournisseur set Nom_Fournisseur='"+f.getNom_Four()+"',Adresse_Fournisseur ='"+f.getAdresse_Four()+"',Email_Fournisseur='"+f.getEmail_Four()+"',Tele_Fournisseur='"+f.getTel_Four()+"' where Num_Fournisseur = '"+f.getNum_Four()+"'";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "Fournisseur bien Modifié... ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void SupprimerFournisseur(Fournisseur f) {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			Statement stat_1=con.createStatement();
			String sql="delete from medicament_fournit where Num_Fournisseur='"+f.getNum_Four()+"' ";
			int rs=stat.executeUpdate(sql);	
			String sql_1="delete from fournisseur where Num_Fournisseur='"+f.getNum_Four()+"' and Nom_Fournisseur='"+f.getNom_Four()+"'and Adresse_Fournisseur='"+f.getAdresse_Four()+"' and Email_Fournisseur='"+f.getEmail_Four()+"'and Tele_Fournisseur='"+f.getTel_Four()+"'";
			int rs_1=stat_1.executeUpdate(sql_1);	
			JOptionPane.showMessageDialog(null, "Fournisseur bien supprimé ! ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
		
	}
	
	public ArrayList<Fournisseur> getFournisseurList() {
		ArrayList<Fournisseur> f_list = new ArrayList<Fournisseur>();
			Connection con=Connection_DB.connectionWithDatabase();
			String sql="select * from fournisseur";
			try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			Fournisseur fournisseur;
			while(rs.next()) {
				fournisseur = new Fournisseur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				f_list.add(fournisseur);
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			return f_list;
	}
	
	
	

	public void Vider_liste() {
		ArrayList<Fournisseur> f_list = getFournisseurList();
		for(int i=0 ; i<f_list.size() ; i++) {
			String a = f_list.get(i).getNum_Four();
			String b = f_list.get(i).getNom_Four();
			String c = f_list.get(i).getAdresse_Four();
			String d = f_list.get(i).getEmail_Four();
			String e = f_list.get(i).getTel_Four();
			Fournisseur f = new Fournisseur(a,b,c,d,e);
			//this.SupprimerFournisseur(f);
	}
	}
	
}











