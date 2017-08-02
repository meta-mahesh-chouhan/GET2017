package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Holds the connection map between entities
 * 
 * @author Mahesh Chouhan
 *
 */
public class Connection {
	private List<String> detailsFromFile;
	private List<String> connectionList;
	private HashMap<String, List<String>> connectionMap = new HashMap<String, List<String>>();

	public Connection() {
		initConnectionList();
	}

	/**
	 * initiate the connectionMap
	 */
	private void initConnectionList() {
		detailsFromFile = new FileHandling()
				.read(Constants.CONNECTION_LIST_PATH);
		for (String str : detailsFromFile) {
			connectionList = new ArrayList<String>();
			String[] details = str.split(",");
			if (details.length > 1) {
				String[] connectionIds = details[1].split(";");
				for (int index = 0; index < connectionIds.length; index++) {
					connectionList.add(connectionIds[index]);
				}
				connectionMap.put(details[0], connectionList);
			}
		}
	}

	/**
	 * Removes a particular connection.
	 * 
	 * @param Id
	 *            - enity Id holding connection list
	 * @param connectionId
	 *            - Connection Id present in connection List
	 */
	public void removeConnection(String Id, String connectionId) {
		connectionMap.get(Id).remove(connectionId);
	}

	/**
	 * Adds an entity to connection map.
	 * @param Id
	 *            - enity Id holding connection list
	 * @param connectionId
	 *            - Connection Id present in connection List
	 * @return String message according to the condition
	 */
	public String addConnection(String entityId, String connectionId) {
		if (!connectionMap.containsKey(entityId)) {
			connectionList = new ArrayList<String>();
			connectionList.add(connectionId);
			connectionMap.put(entityId, connectionList);
			return "Successfully Added";
		} else if (connectionMap.get(entityId).contains(connectionId)) {
			return "This is person is already in your connection";
		} else {
			connectionList = getConnectionList(entityId);
			connectionList.add(connectionId);
			connectionMap.put(entityId, connectionList);
			return "Successfully Added";
		}
	}

	/**
	 * Return the connection List.
	 * @param entityId
	 *            - Unique Id of entity
	 * @return connection list of that entityId
	 */
	public List<String> getConnectionList(String entityId) {
		return connectionMap.get(entityId);
	}

	/**
	 * 
	 * @return the whole connection Map
	 */
	public Set<String> getConnectionIdSet() {
		return connectionMap.keySet();
	}
}
