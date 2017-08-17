package DefaultNamespace;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * Client class to use service provided by Server.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Converter {

	/**
	 * Calls the method of Service provided by Server.
	 * 
	 * @param Temperture in Fahrenheit
	 * @return Temperature in Celsius
	 */
	public Double convert(double temperture) {
		Double ans = null;
		WsServerServiceLocator wsServerServiceLocator = new WsServerServiceLocator();
		wsServerServiceLocator.setWsServerEndpointAddress("http://localhost:8080/SoapService/services/WsServer");

		WsServer obj;
		try {
			obj = wsServerServiceLocator.getWsServer();
			ans = obj.convertFahrenheitToCelsius(temperture);

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return ans;
	}

}
