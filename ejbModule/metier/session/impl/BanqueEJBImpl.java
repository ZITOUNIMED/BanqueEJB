package metier.session.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;
import metier.session.IBanqueLocal;
import metier.session.IBanqueRemote;

@Stateless(name="BK")
public class BanqueEJBImpl implements IBanqueRemote, IBanqueLocal{

	@PersistenceContext(unitName="BanqueEJB")
	private EntityManager em;
	
	@Override
	public Compte addCompte(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public Compte getCompte(Long code) {
		Compte cp = em.find(Compte.class, code);
		if(cp == null) {
			throw new RuntimeException("Compte introuvable for code= "+code);
		}
		return cp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> listComptes() {
		
		Query req = em.createQuery("SELECT c FROM COMPTE c");
		return req.getResultList();
	}

	@Override
	public void verser(Long code, double mt) {
		Compte cp = getCompte(code);
		cp.setSolde(cp.getSolde() + mt);
	}

	@Override
	public void retirer(Long code, double mt) {
		Compte cp = getCompte(code);
		if(cp.getSolde()<mt) {
			throw new RuntimeException("Solde insuffisant");
		}
		cp.setSolde(cp.getSolde() - mt);
	}

	@Override
	public void virement(Long cp1, Long cp2, double mt) {
		retirer(cp1, mt);
		verser(cp2, mt);
	}

}
