
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

    private final static QName _ListarPromocionesBuscadasResponse_QNAME = new QName("http://WebServices/", "listarPromocionesBuscadasResponse");
    private final static QName _ListarServiciosBuscados_QNAME = new QName("http://WebServices/", "listarServiciosBuscados");
    private final static QName _SeleccionarPromocionAListar_QNAME = new QName("http://WebServices/", "seleccionarPromocionAListar");
    private final static QName _ListarPromocionesBuscadas_QNAME = new QName("http://WebServices/", "listarPromocionesBuscadas");
    private final static QName _ListarServiciosBuscadosResponse_QNAME = new QName("http://WebServices/", "listarServiciosBuscadosResponse");
    private final static QName _SeleccionarServicioAListarResponse_QNAME = new QName("http://WebServices/", "seleccionarServicioAListarResponse");
    private final static QName _SeleccionarPromocionAListarResponse_QNAME = new QName("http://WebServices/", "seleccionarPromocionAListarResponse");
    private final static QName _SeleccionarServicioAListar_QNAME = new QName("http://WebServices/", "seleccionarServicioAListar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarPromocionesBuscadasResponse }
     * 
     */
    public ListarPromocionesBuscadasResponse createListarPromocionesBuscadasResponse() {
        return new ListarPromocionesBuscadasResponse();
    }

    /**
     * Create an instance of {@link SeleccionarPromocionAListar }
     * 
     */
    public SeleccionarPromocionAListar createSeleccionarPromocionAListar() {
        return new SeleccionarPromocionAListar();
    }

    /**
     * Create an instance of {@link ListarServiciosBuscados }
     * 
     */
    public ListarServiciosBuscados createListarServiciosBuscados() {
        return new ListarServiciosBuscados();
    }

    /**
     * Create an instance of {@link ListarPromocionesBuscadas }
     * 
     */
    public ListarPromocionesBuscadas createListarPromocionesBuscadas() {
        return new ListarPromocionesBuscadas();
    }

    /**
     * Create an instance of {@link ListarServiciosBuscadosResponse }
     * 
     */
    public ListarServiciosBuscadosResponse createListarServiciosBuscadosResponse() {
        return new ListarServiciosBuscadosResponse();
    }

    /**
     * Create an instance of {@link SeleccionarPromocionAListarResponse }
     * 
     */
    public SeleccionarPromocionAListarResponse createSeleccionarPromocionAListarResponse() {
        return new SeleccionarPromocionAListarResponse();
    }

    /**
     * Create an instance of {@link SeleccionarServicioAListarResponse }
     * 
     */
    public SeleccionarServicioAListarResponse createSeleccionarServicioAListarResponse() {
        return new SeleccionarServicioAListarResponse();
    }

    /**
     * Create an instance of {@link SeleccionarServicioAListar }
     * 
     */
    public SeleccionarServicioAListar createSeleccionarServicioAListar() {
        return new SeleccionarServicioAListar();
    }

    /**
     * Create an instance of {@link DataPromocion }
     * 
     */
    public DataPromocion createDataPromocion() {
        return new DataPromocion();
    }

    /**
     * Create an instance of {@link DataServicio }
     * 
     */
    public DataServicio createDataServicio() {
        return new DataServicio();
    }

    /**
     * Create an instance of {@link DataServicios }
     * 
     */
    public DataServicios createDataServicios() {
        return new DataServicios();
    }

    /**
     * Create an instance of {@link DataPromociones }
     * 
     */
    public DataPromociones createDataPromociones() {
        return new DataPromociones();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPromocionesBuscadasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarPromocionesBuscadasResponse")
    public JAXBElement<ListarPromocionesBuscadasResponse> createListarPromocionesBuscadasResponse(ListarPromocionesBuscadasResponse value) {
        return new JAXBElement<ListarPromocionesBuscadasResponse>(_ListarPromocionesBuscadasResponse_QNAME, ListarPromocionesBuscadasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarServiciosBuscados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarServiciosBuscados")
    public JAXBElement<ListarServiciosBuscados> createListarServiciosBuscados(ListarServiciosBuscados value) {
        return new JAXBElement<ListarServiciosBuscados>(_ListarServiciosBuscados_QNAME, ListarServiciosBuscados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarPromocionAListar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarPromocionAListar")
    public JAXBElement<SeleccionarPromocionAListar> createSeleccionarPromocionAListar(SeleccionarPromocionAListar value) {
        return new JAXBElement<SeleccionarPromocionAListar>(_SeleccionarPromocionAListar_QNAME, SeleccionarPromocionAListar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPromocionesBuscadas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarPromocionesBuscadas")
    public JAXBElement<ListarPromocionesBuscadas> createListarPromocionesBuscadas(ListarPromocionesBuscadas value) {
        return new JAXBElement<ListarPromocionesBuscadas>(_ListarPromocionesBuscadas_QNAME, ListarPromocionesBuscadas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarServiciosBuscadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarServiciosBuscadosResponse")
    public JAXBElement<ListarServiciosBuscadosResponse> createListarServiciosBuscadosResponse(ListarServiciosBuscadosResponse value) {
        return new JAXBElement<ListarServiciosBuscadosResponse>(_ListarServiciosBuscadosResponse_QNAME, ListarServiciosBuscadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarServicioAListarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarServicioAListarResponse")
    public JAXBElement<SeleccionarServicioAListarResponse> createSeleccionarServicioAListarResponse(SeleccionarServicioAListarResponse value) {
        return new JAXBElement<SeleccionarServicioAListarResponse>(_SeleccionarServicioAListarResponse_QNAME, SeleccionarServicioAListarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarPromocionAListarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarPromocionAListarResponse")
    public JAXBElement<SeleccionarPromocionAListarResponse> createSeleccionarPromocionAListarResponse(SeleccionarPromocionAListarResponse value) {
        return new JAXBElement<SeleccionarPromocionAListarResponse>(_SeleccionarPromocionAListarResponse_QNAME, SeleccionarPromocionAListarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarServicioAListar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarServicioAListar")
    public JAXBElement<SeleccionarServicioAListar> createSeleccionarServicioAListar(SeleccionarServicioAListar value) {
        return new JAXBElement<SeleccionarServicioAListar>(_SeleccionarServicioAListar_QNAME, SeleccionarServicioAListar.class, null, value);
    }

}
