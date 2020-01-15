/**
 * 
 */
package IDAO;

import Pharmacie.Medicament;

public interface IMedicament {
	void AjouterMedicament(Medicament e);
	void ModifierMedicament(Medicament m);
	void SupprimerMedicament(Medicament m);
	void ChercherMedicament(String Nom);
	
}
