package com.bankservices.ejb.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bankservices.ejb.dao.BranchOfficeDAOLocal;
import com.bankservices.entity.BranchOffice;

/**
 * Session Bean implementation class BranchOfficeService
 */
@Stateless
@LocalBean
public class BranchOfficeService implements BranchOfficeServiceLocal {

    public BranchOfficeService() {}
    
    @EJB
    private BranchOfficeDAOLocal officeDAO;

	@Override
	public void save(BranchOffice office) {
		officeDAO.save(office);
	}

	@Override
	public List<BranchOffice> getAll() {
		return officeDAO.getAll();
	}

	@Override
	public BranchOffice getById(int id) {
		return officeDAO.getById(id);
	}

	@Override
	public void update(BranchOffice office) {
		officeDAO.update(office);
	}

	@Override
	public void delete(int id) {
		officeDAO.delete(id);
	}

}
