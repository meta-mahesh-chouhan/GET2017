package DAO;

import Enums.DBType;
import Enums.EntityName;

/**
 * Factory Class which returns instances of DAOs.
 * 
 * @author Mahesh Chouhan
 *
 */
public class DAOFactory {

	/**
	 * Returns instance of DAO based on entityName and dbType.
	 * 
	 * @param entityName
	 * @param dbType
	 * @return Instance of DAO
	 */
	public static BaseDAO<?> getDAOForEntity(EntityName entityName,
			DBType dbType) {

		if (entityName == EntityName.User) {

			if (dbType == DBType.InMemory) {
				return InMemoryUserDAO.getInstance();
			}

		} else if (entityName == EntityName.Product) {

			if (dbType == DBType.InMemory) {
				return InMemoryProductDAO.getInstance();
			}

		}

		return null;

	}

}
