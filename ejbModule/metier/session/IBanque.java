package metier.session;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Compte;

public interface IBanque {

	public Compte addCompte(Compte compte);
	public Compte getCompte(Long code);
	public List<Compte> listComptes();
	public void verser(Long code, double mt);
	public void retirer(Long code, double mt);
	public void virement(Long cp1, Long cp2, double mt);
}
