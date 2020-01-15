/**
 * 
 */
package Pharmacie;

/**
 * @author ZATeC
 *
 */
public class LigneFacture {
	private String Num_Med;
	private String Num_Fac;
	private int Qte;
	private double prix;
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
	 * @return the num_Fac
	 */
	public String getNum_Fac() {
		return Num_Fac;
	}
	/**
	 * @param num_Fac the num_Fac to set
	 */
	public void setNum_Fac(String num_Fac) {
		Num_Fac = num_Fac;
	}
	/**
	 * @return the qte
	 */
	public int getQte() {
		return Qte;
	}
	/**
	 * @param qte the qte to set
	 */
	public void setQte(int qte) {
		Qte = qte;
	}
	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public LigneFacture(String Num_Med, String Num_Fac,int Qte, double prix) {
		this.Num_Med=Num_Med;
		this.Num_Fac=Num_Fac;
		this.Qte=Qte;
		this.prix=prix;
		
	}

}
