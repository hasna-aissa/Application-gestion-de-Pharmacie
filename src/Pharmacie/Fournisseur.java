package Pharmacie;

public class Fournisseur {

	private String Num_Four;
	private String Nom_Four;
	private String Adresse_Four;
	private String Email_Four;
	private String Tel_Four;
	public Fournisseur() {}
	public Fournisseur(String Num_Four, String Nom_Four,String Adresse_Four,String Email_Four,String Tel_Four) {
		this.setNum_Four(Num_Four);
		this.setNom_Four(Nom_Four);
		this.setAdresse_Four(Adresse_Four);
		this.setEmail_Four(Email_Four);
		this.setTel_Four(Tel_Four);
	}
	public Fournisseur(Fournisseur F) {
		setNum_Four(F.getNum_Four());
		setNom_Four(F.getNom_Four());
		setAdresse_Four(F.getAdresse_Four());
		setEmail_Four(F.getEmail_Four());
		setTel_Four(F.getTel_Four());
	}
	public String getNum_Four() {
		return Num_Four;
	}
	public void setNum_Four(String num_Four) {
		Num_Four = num_Four;
	}
	public String getNom_Four() {
		return Nom_Four;
	}
	public void setNom_Four(String nom_Four) {
		Nom_Four = nom_Four;
	}
	public String getAdresse_Four() {
		return Adresse_Four;
	}
	public void setAdresse_Four(String adresse_Four) {
		Adresse_Four = adresse_Four;
	}
	public String getEmail_Four() {
		return Email_Four;
	}
	public void setEmail_Four(String email_Four) {
		Email_Four = email_Four;
	}
	public String getTel_Four() {
		return Tel_Four;
	}
	public void setTel_Four(String tel_Four) {
		Tel_Four = tel_Four;
	}
	
	
}
