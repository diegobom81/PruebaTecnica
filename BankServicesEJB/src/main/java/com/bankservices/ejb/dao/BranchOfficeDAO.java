package com.bankservices.ejb.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bankservices.entity.BranchOffice;

/**
 * Session Bean implementation class BranchOfficeDAO
 */
@Stateless
@LocalBean
public class BranchOfficeDAO implements BranchOfficeDAOLocal {

 
    public BranchOfficeDAO() {}
    
    @PersistenceContext(unitName = "BankEntityPU")
    private EntityManager em;

	@Override
	public void save(BranchOffice office) {
		em.persist(office);
	}

	@Override
	public List<BranchOffice> getAll() {
		TypedQuery<BranchOffice> query = em.createNamedQuery("BranchOffice.getAll", BranchOffice.class);
		
		return query.getResultList();
	}

	@Override
	public BranchOffice getById(int id) {
		TypedQuery<BranchOffice> query = em.createNamedQuery("BranchOffice.getById", BranchOffice.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public void update(BranchOffice office) {
		BranchOffice officeToUpdate = getById(office.getId());
		if (officeToUpdate != null) {
			officeToUpdate.setOfficeName(office.getOfficeName());
			
			em.merge(officeToUpdate);
		} else {
			System.out.println("Office not found");
		}
	}

	@Override
	public void delete(int id) {
		em.remove(em.merge(new BranchOffice(id)));
	}

}
