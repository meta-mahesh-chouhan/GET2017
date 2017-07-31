package SocialNetwork;

import java.util.List;

/**
 * Abstract class having common details of Entity
 * 
 * @author Mahesh Chouhan
 *
 */
public abstract class Entity {
	private String entityId;
	private String name;
	private String type;
	private long contact;
	private String password;
	private List<Record> posts;

	public Entity(String entityId, String name, String password, long contact,
			String type) {
		this.entityId = entityId;
		this.name = name;
		this.type = type;
		this.contact = contact;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.entityId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.entityId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	protected void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param record
	 *            - Record class object contains posts
	 */

	public void addPost(Record record) {
		posts.add(record);
	}

	/**
	 * 
	 * @return
	 */
	public long getContact() {
		return contact;
	}

	/**
	 * 
	 * @param contact
	 */
	public void setContact(long contact) {
		this.contact = contact;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the posts
	 */
	public List<Record> getPosts() {
		return posts;
	}

	/**
	 * @param posts
	 *            the posts to set
	 */
	public void setPosts(List<Record> posts) {
		this.posts = posts;
	}

	@Override
	public boolean equals(Object o) { // overriding equals method for entity
										// comparison
		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		// Check if o is an instance of Entity or not
		if (!(o instanceof Entity)) {
			return false;
		}

		// typecast o to Entity so that we can compare data members
		Entity e = (Entity) o;

		// Compare the data members and return accordingly
		return this.entityId.equals(e.entityId);
	}

	/**
	 * Override hashcode function return hashcode of entityId
	 */
	@Override
	public int hashCode() {
		return entityId.hashCode();
	}
}
