package DefaultNamespace;

public class WsServerProxy implements DefaultNamespace.WsServer {
  private String _endpoint = null;
  private DefaultNamespace.WsServer wsServer = null;
  
  public WsServerProxy() {
    _initWsServerProxy();
  }
  
  public WsServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsServerProxy();
  }
  
  private void _initWsServerProxy() {
    try {
      wsServer = (new DefaultNamespace.WsServerServiceLocator()).getWsServer();
      if (wsServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsServer != null)
      ((javax.xml.rpc.Stub)wsServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.WsServer getWsServer() {
    if (wsServer == null)
      _initWsServerProxy();
    return wsServer;
  }
  
  public double convertFahrenheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (wsServer == null)
      _initWsServerProxy();
    return wsServer.convertFahrenheitToCelsius(temperature);
  }
  
  
}