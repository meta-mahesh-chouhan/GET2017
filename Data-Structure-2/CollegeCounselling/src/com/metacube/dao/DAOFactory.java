package com.metacube.dao;

import com.metacube.enums.Entity;

public class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	private DAOFactory(){
		
	}
	public static DAOFactory getInstance(){
		if(daoFactory == null){
			synchronized (DAOFactory.class) {
				if(daoFactory == null){
					daoFactory = new DAOFactory();
				}
				
			}
		}
		return daoFactory;
	}
	
	public BaseDAO<?> getDAOfromFactory(Entity entity){
		
		if(entity == Entity.College){
			return InMemoryCollegeDAO.getInstance();
		}
		else if(entity == Entity.Candidate){
			return InMemoryCandidateDAO.getInstance();
		}
		return null;
		
	}

}
