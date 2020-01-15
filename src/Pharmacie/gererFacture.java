/**
 * 
 */
package Pharmacie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import IDAO.IFacture;
import connexion.Connection_DB;

public class gererFacture implements IFacture {
	List<LigneFacture>FactureList=new ArrayList<LigneFacture>();
	public gererFacture(){};
	public void AjouterLigneFacture(LigneFacture e) {
		try {
			
				Connection con=Connection_DB.connectionWithDatabase();
				Statement stat=con.createStatement();
				String sql="insert into Medicament values('"+e.getNum_Med() +"','"+e.getNum_Med() +"','"+e.getNum_Fac()+"','"+String.valueOf(e.getQte())+"','"+String.valueOf(e.getPrix())+"')";
				int rs=stat.executeUpdate(sql);	
				FactureList.add(e);
				JOptionPane.showMessageDialog(null, "Medicament bien Ajouté... ");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
	}
	public void RemplirFacture(String numFacture) {
		try {
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			Date aujourd=new Date();
			String query="insert into facture values('"+numFacture +"','"+sf.format(aujourd)+"',0,0.0)";
			int result=stat.executeUpdate(query);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public void recupererDonnee(LigneFacture LF) {
		try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="insert into lignefacture values('"+LF.getNum_Med() +"','"+LF.getNum_Fac() +"','"+LF.getQte()+"','"+LF.getPrix() +"')";
			int rs=stat.executeUpdate(sql);	
			FactureList.add(LF);
			System.out.println("creation de facture");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public void UpdateQte(int Qte,LigneFacture lf) {
		try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="update medicament set QteEnStock=QteEnStock-'"+Qte+"' where Num_Medicament='"+lf.getNum_Med()+"'";
			int rs=stat.executeUpdate(sql);	
			
			System.out.println("creation de facture");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public void UpdateFacture(String Num_Fac,double Remise,double totale) {
		
		try {
			
			Connection con=Connection_DB.connectionWithDatabase();
			Statement stat=con.createStatement();
			String sql="update facture set Remise='"+Remise+"',Prix_Totale='"+totale+"' where Num_Facture='"+Num_Fac+"'";
			int rs=stat.executeUpdate(sql);
			System.out.println("creation de facture");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	

}
