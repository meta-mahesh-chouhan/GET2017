package Entity;

import Enums.EntityName;
/**
 * Factory class which returns instances of Entity.
 * 
 * @author Mahesh Chouhan
 *
 */
public class EntityFactory {
	
	/**
	 *  Returns instance of entity based on entityName
	 * @param entityName
	 * @return
	 */
	public static BaseEntity getEntityFromFactory(EntityName entityName){
		
		if (entityName == EntityName.Product){
			return new Product();
		}
		else if (entityName == EntityName.User){
			return new User();
		}
		else if (entityName == EntityName.Cart){
			return Cart.getInstance();
		}
		
		return null;
	}

}
