
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CargarDatosDePrueba_QNAME = new QName("http://WebServices/", "cargarDatosDePrueba");
    private final static QName _CargarDatosDePruebaResponse_QNAME = new QName("http://WebServices/", "cargarDatosDePruebaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CargarDatosDePrueba }
     * 
     */
    public CargarDatosDePrueba createCargarDatosDePrueba() {
        return new CargarDatosDePrueba();
    }

    /**
     * Create an instance of {@link CargarDatosDePruebaResponse }
     * 
     */
    public CargarDatosDePruebaResponse createCargarDatosDePruebaResponse() {
        return new CargarDatosDePruebaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarDatosDePrueba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "cargarDatosDePrueba")
    public JAXBElement<CargarDatosDePrueba> createCargarDatosDePrueba(CargarDatosDePrueba value) {
        return new JAXBElement<CargarDatosDePrueba>(_CargarDatosDePrueba_QNAME, CargarDatosDePrueba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarDatosDePruebaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "cargarDatosDePruebaResponse")
    public JAXBElement<CargarDatosDePruebaResponse> createCargarDatosDePruebaResponse(CargarDatosDePruebaResponse value) {
        return new JAXBElement<CargarDatosDePruebaResponse>(_CargarDatosDePruebaResponse_QNAME, CargarDatosDePruebaResponse.class, null, value);
    }

}
