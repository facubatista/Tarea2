
package webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSCargarDatosService", targetNamespace = "http://WebServices/", wsdlLocation = "http://localhost:8088/webSDatos?wsdl")
public class WSCargarDatosService
    extends Service
{

    private final static URL WSCARGARDATOSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSCARGARDATOSSERVICE_EXCEPTION;
    private final static QName WSCARGARDATOSSERVICE_QNAME = new QName("http://WebServices/", "WSCargarDatosService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8088/webSDatos?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCARGARDATOSSERVICE_WSDL_LOCATION = url;
        WSCARGARDATOSSERVICE_EXCEPTION = e;
    }

    public WSCargarDatosService() {
        super(__getWsdlLocation(), WSCARGARDATOSSERVICE_QNAME);
    }

    public WSCargarDatosService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCARGARDATOSSERVICE_QNAME, features);
    }

    public WSCargarDatosService(URL wsdlLocation) {
        super(wsdlLocation, WSCARGARDATOSSERVICE_QNAME);
    }

    public WSCargarDatosService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCARGARDATOSSERVICE_QNAME, features);
    }

    public WSCargarDatosService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCargarDatosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSCargarDatos
     */
    @WebEndpoint(name = "WSCargarDatosPort")
    public WSCargarDatos getWSCargarDatosPort() {
        return super.getPort(new QName("http://WebServices/", "WSCargarDatosPort"), WSCargarDatos.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSCargarDatos
     */
    @WebEndpoint(name = "WSCargarDatosPort")
    public WSCargarDatos getWSCargarDatosPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServices/", "WSCargarDatosPort"), WSCargarDatos.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCARGARDATOSSERVICE_EXCEPTION!= null) {
            throw WSCARGARDATOSSERVICE_EXCEPTION;
        }
        return WSCARGARDATOSSERVICE_WSDL_LOCATION;
    }

}
