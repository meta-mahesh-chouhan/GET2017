/**
 * WsServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface WsServerService extends javax.xml.rpc.Service {
    public java.lang.String getWsServerAddress();

    public DefaultNamespace.WsServer getWsServer() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.WsServer getWsServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
