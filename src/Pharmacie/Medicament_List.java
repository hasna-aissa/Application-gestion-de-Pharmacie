/**
 * 
 */
package Pharmacie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import IDAO.IMedicament;
import connexion.Connection_DB;

public class Medicament_List implements IMedicament {
	List<Medicament>MedicamentList=new ArrayList<Medicament>();
	public Medicament_List(){};
	public void AjouterMedicament(Medicament m) {
		try {
			
				Connection con=Connection_DB.connectionWithDatabase();
				Statement stat=con.createStatement();
				String sql="insert into medicament values('"+m.getNum_Med() +"','"+m.getNom_Med() +"','"+m.getNom_Cat()+"','"+m.getQteStock()+"','"+String.valueOf(m.getDate_p())+"','"+String.valueOf(m.getDate_E())+"','"+m.getPrix()+"')";
				int rs=stat.executeUpdate(sql);	
				MedicamentList.add(m);
				JOptionPane.showMessageDialog(null, "Medicament bien Ajouté... ");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
	}
	public void ModifierMedicament(Medicament m) {
		try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="update medicament set Num_Medicament='"+m.getNum_Med()+"',Nom_Medicament='"+m.getNom_Med()+"',Nom_Categorie='"+m.getNom_Cat()+"',QteEnStock='"+m.getQteStock()+"',Date_Production='"+m.getDate_p()+"',Date_Expedition='"+m.getDate_E()+"',Prix='"+m.getPrix()+"' where Num_Medicament='"+m.getNum_Med()+"'";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "Medicament bien Modifié... ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public void SupprimerMedicament(Medicament m) {
			try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			Statement stat1=con.createStatement();
			Statement stat2=con.createStatement();
			String sql1="delete from lignefacture where Num_Medicament='"+m.getNum_Med()+"'";
			int rs1=stat1.executeUpdate(sql1);
			String sql2="delete from medicament_fournit where Num_Medicament='"+m.getNum_Med()+"'";
			int rs2=stat2.executeUpdate(sql1);
			String sql="delete from Medicament where Num_Medicament='"+m.getNum_Med()+"' and Nom_Medicament='"+m.getNom_Med()+"'and Nom_Categorie='"+m.getNom_Cat()+"' and QteEnStock='"+m.getQteStock()+"'and Date_Production='"+m.getDate_p()+"'and Date_Expedition='"+m.getDate_E()+"'and Prix='"+m.getPrix()+"'";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "Medicament bien supprimé... ");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void ChercherMedicament(String Nom) {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="select * from Medicament where Nom_Medicament like '"+Nom+"'+'%'";
			ResultSet rs=stat.executeQuery(sql);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void Affichertous() {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="select * from Medicament";
			ResultSet rs=stat.executeQuery(sql);
			ResultSetMetaData meta=rs.getMetaData();
			Object[] column=new Object[meta.getColumnCount()];
			for(int i=1;i<=meta.getColumnCount();i++) {
				column[i-1]=meta.getColumnName(i);
			}
		}
		catch(Exception ex) {
			
		}
	}
	
	public ArrayList<Medicament> getMedicamentList() {
		ArrayList<Medicament> f_list = new ArrayList<Medicament>();
			Connection con=Connection_DB.connectionWithDatabase();
			String sql="select * from medicament";
			try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			Medicament medicament;
			while(rs.next()) {
				medicament = new Medicament(rs.getString(1),rs.getString(2),rs.getString(3),Integer.parseInt(rs.getString(4)),
						 rs.getString(5),rs.getString(6),Double.parseDouble(rs.getString(7)));
				f_list.add(medicament);
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			return f_list;
	}
	
	public void remplir_table(JTable table) {
	ArrayList<Medicament> f_list = getMedicamentList();
	DefaultTableModel model = (DefaultTableModel)table.getModel();
	Object[] row = new Object[5];
	for(int i=0 ; i<f_list.size() ; i++) {
		row[0] = f_list.get(i).getNum_Med();
		row[1] = f_list.get(i).getNom_Med();
		row[2] = f_list.get(i).getNom_Cat();
		row[3] = f_list.get(i).getQteStock();
		row[4] = f_list.get(i).getDate_p();
		row[4] = f_list.get(i).getDate_E();
		row[4] = f_list.get(i).getPrix();
		model.addRow(row);
	}
	}
	
	
	
}
