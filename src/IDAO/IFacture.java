package IDAO;

import Pharmacie.LigneFacture;

public interface IFacture {
	void AjouterLigneFacture(LigneFacture e);
	void RemplirFacture(String numFacture);
	void recupererDonnee(LigneFacture LF);
	void UpdateQte(int Qte,LigneFacture lf);
	void UpdateFacture(String Num_Fac,double Remise,double totale);
}
