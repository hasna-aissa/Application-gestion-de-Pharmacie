/**
 * 
 */
package Pharmacie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZATeC
 *
 */
public class Medicament {
	private String Num_Med;
	private String Nom_Med;
	private String Nom_Cat;
	private int QteStock;
	private String Date_p;
	private String Date_E;
	private double Prix;
	public Medicament() {}
	public Medicament(String Num_Med, String Nom_Med,String Nom_Cat,int QteStock,String Date_p,String Date_E,double Prix) {
		this.Num_Med=Num_Med;
		this.Nom_Med=Nom_Med;
		this.Nom_Cat=Nom_Cat;
		this.QteStock=QteStock;
		this.Date_p=Date_p;
		this.Date_E=Date_E;
		this.Prix=Prix;
	}
	public Medicament(Medicament M) {
		setNum_Med(M.getNum_Med());
		setNom_Med(M.getNom_Med());
		setNom_Cat(M.getNom_Cat());
		setQteStock(M.getQteStock());
		setDate_p(M.getDate_p());
		setDate_E(M.getDate_E());
		setPrix(M.getPrix());
	}
	/**
	 * @return the num_Med
	 */
	public String getNum_Med() {
		return Num_Med;
	}
	/**
	 * @param num_Med the num_Med to set
	 */
	public void setNum_Med(String num_Med) {
		Num_Med = num_Med;
	}
	/**
	 * @return the nom_Med
	 */
	public String getNom_Med() {
		return Nom_Med;
	}
	/**
	 * @param nom_Med the nom_Med to set
	 */
	public void setNom_Med(String nom_Med) {
		Nom_Med = nom_Med;
	}
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return QteStock;
	}
	/**
	 * @param qteStock the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		QteStock = qteStock;
	}
	/**
	 * @return the num_Cat
	 */
	public String getNom_Cat() {
		return Nom_Cat;
	}
	/**
	 * @param num_Cat the num_Cat to set
	 */
	public void setNom_Cat(String nom_Cat) {
		Nom_Cat = nom_Cat;
	}
	/**
	 * @return the date_p
	 */
	public String getDate_p() {
		return Date_p;
	}
	/**
	 * @param date_p the date_p to set
	 */
	public void setDate_p(String date_p) {
		Date_p = date_p;
	}
	/**
	 * @return the date_E
	 */
	public String getDate_E() {
		return Date_E;
	}
	/**
	 * @param date_E the date_E to set
	 */
	public void setDate_E(String date_E) {
		Date_E = date_E;
	}
	/**
	 * @return the prix
	 */
	public double getPrix() {
		return Prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		Prix = prix;
	}
	public String toString()
	{
		return("Medicament ( Num_Med : "+this.Num_Med+" Nom_Med : "+this.Nom_Med+" Num_Cat : "+this.Nom_Cat+" QteStock : "+this.QteStock+" Date_p : "+this.Date_p+" Date_E : "+this.Date_E+" Prix : "+this.Prix+")");
	}
	public boolean isExpired() throws ParseException
	{
		Date auj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		Date date=sdf.parse(Date_E);
		if(date.before(auj))
		{
			System.out.println("Le Medicament expiré est :"+this.Num_Med+"son nom : "+this.Nom_Med);
			return true;
		}
		else
			return false;
	}
}
