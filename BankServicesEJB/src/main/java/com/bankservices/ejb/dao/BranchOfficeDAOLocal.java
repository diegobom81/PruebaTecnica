package com.bankservices.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import com.bankservices.entity.BranchOffice;

@Local
public interface BranchOfficeDAOLocal {

	public void save(BranchOffice office);
	public List<BranchOffice> getAll();
	public BranchOffice getById(int id);
	public void update(BranchOffice office);
	public void delete(int id);
}
