
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

    private final static QName _TraerCategoriasResponse_QNAME = new QName("http://WebServices/", "traerCategoriasResponse");
    private final static QName _TraerCategorias_QNAME = new QName("http://WebServices/", "traerCategorias");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TraerCategoriasResponse }
     * 
     */
    public TraerCategoriasResponse createTraerCategoriasResponse() {
        return new TraerCategoriasResponse();
    }

    /**
     * Create an instance of {@link TraerCategorias }
     * 
     */
    public TraerCategorias createTraerCategorias() {
        return new TraerCategorias();
    }

    /**
     * Create an instance of {@link DataCategorias }
     * 
     */
    public DataCategorias createDataCategorias() {
        return new DataCategorias();
    }

    /**
     * Create an instance of {@link DtCategoria }
     * 
     */
    public DtCategoria createDtCategoria() {
        return new DtCategoria();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerCategoriasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "traerCategoriasResponse")
    public JAXBElement<TraerCategoriasResponse> createTraerCategoriasResponse(TraerCategoriasResponse value) {
        return new JAXBElement<TraerCategoriasResponse>(_TraerCategoriasResponse_QNAME, TraerCategoriasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerCategorias }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "traerCategorias")
    public JAXBElement<TraerCategorias> createTraerCategorias(TraerCategorias value) {
        return new JAXBElement<TraerCategorias>(_TraerCategorias_QNAME, TraerCategorias.class, null, value);
    }

}
