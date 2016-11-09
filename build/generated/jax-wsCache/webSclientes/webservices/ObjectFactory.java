
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

    private final static QName _GetDataCliente_QNAME = new QName("http://WebServices/", "getDataCliente");
    private final static QName _CrearReserva_QNAME = new QName("http://WebServices/", "crearReserva");
    private final static QName _TraerRsRpResponse_QNAME = new QName("http://WebServices/", "traerRsRpResponse");
    private final static QName _ListarResDeCli_QNAME = new QName("http://WebServices/", "listarResDeCli");
    private final static QName _CambiarEstado_QNAME = new QName("http://WebServices/", "cambiarEstado");
    private final static QName _MostrarReservaResponse_QNAME = new QName("http://WebServices/", "mostrarReservaResponse");
    private final static QName _CrearUserWeb_QNAME = new QName("http://WebServices/", "crearUserWeb");
    private final static QName _UserPassValido_QNAME = new QName("http://WebServices/", "userPassValido");
    private final static QName _GetDataClienteResponse_QNAME = new QName("http://WebServices/", "getDataClienteResponse");
    private final static QName _MostrarReserva_QNAME = new QName("http://WebServices/", "mostrarReserva");
    private final static QName _AgregarPromoAreservaResponse_QNAME = new QName("http://WebServices/", "agregarPromoAreservaResponse");
    private final static QName _LimpiarResponse_QNAME = new QName("http://WebServices/", "limpiarResponse");
    private final static QName _AgregarPromoAreserva_QNAME = new QName("http://WebServices/", "agregarPromoAreserva");
    private final static QName _ListarResDeCliResponse_QNAME = new QName("http://WebServices/", "listarResDeCliResponse");
    private final static QName _VerificarUsuario_QNAME = new QName("http://WebServices/", "verificarUsuario");
    private final static QName _CrearUserWebResponse_QNAME = new QName("http://WebServices/", "crearUserWebResponse");
    private final static QName _Limpiar_QNAME = new QName("http://WebServices/", "limpiar");
    private final static QName _ParseException_QNAME = new QName("http://WebServices/", "ParseException");
    private final static QName _AgregarServicioAreservaResponse_QNAME = new QName("http://WebServices/", "agregarServicioAreservaResponse");
    private final static QName _GetFactura_QNAME = new QName("http://WebServices/", "getFactura");
    private final static QName _SeleccionarProveedorResponse_QNAME = new QName("http://WebServices/", "seleccionarProveedorResponse");
    private final static QName _SeleccionarReservaResponse_QNAME = new QName("http://WebServices/", "seleccionarReservaResponse");
    private final static QName _TraerRsRp_QNAME = new QName("http://WebServices/", "traerRsRp");
    private final static QName _VerificarUsuarioResponse_QNAME = new QName("http://WebServices/", "verificarUsuarioResponse");
    private final static QName _CrearReservaResponse_QNAME = new QName("http://WebServices/", "crearReservaResponse");
    private final static QName _CambiarEstadoResponse_QNAME = new QName("http://WebServices/", "cambiarEstadoResponse");
    private final static QName _SeleccionarReserva_QNAME = new QName("http://WebServices/", "seleccionarReserva");
    private final static QName _GetFacturaResponse_QNAME = new QName("http://WebServices/", "getFacturaResponse");
    private final static QName _AgregarServicioAreserva_QNAME = new QName("http://WebServices/", "agregarServicioAreserva");
    private final static QName _UserPassValidoResponse_QNAME = new QName("http://WebServices/", "userPassValidoResponse");
    private final static QName _SeleccionarProveedor_QNAME = new QName("http://WebServices/", "seleccionarProveedor");
    private final static QName _CrearUserWebArg6_QNAME = new QName("", "arg6");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TraerRsRp }
     * 
     */
    public TraerRsRp createTraerRsRp() {
        return new TraerRsRp();
    }

    /**
     * Create an instance of {@link VerificarUsuarioResponse }
     * 
     */
    public VerificarUsuarioResponse createVerificarUsuarioResponse() {
        return new VerificarUsuarioResponse();
    }

    /**
     * Create an instance of {@link CrearReservaResponse }
     * 
     */
    public CrearReservaResponse createCrearReservaResponse() {
        return new CrearReservaResponse();
    }

    /**
     * Create an instance of {@link CambiarEstadoResponse }
     * 
     */
    public CambiarEstadoResponse createCambiarEstadoResponse() {
        return new CambiarEstadoResponse();
    }

    /**
     * Create an instance of {@link SeleccionarReserva }
     * 
     */
    public SeleccionarReserva createSeleccionarReserva() {
        return new SeleccionarReserva();
    }

    /**
     * Create an instance of {@link GetFacturaResponse }
     * 
     */
    public GetFacturaResponse createGetFacturaResponse() {
        return new GetFacturaResponse();
    }

    /**
     * Create an instance of {@link AgregarServicioAreserva }
     * 
     */
    public AgregarServicioAreserva createAgregarServicioAreserva() {
        return new AgregarServicioAreserva();
    }

    /**
     * Create an instance of {@link UserPassValidoResponse }
     * 
     */
    public UserPassValidoResponse createUserPassValidoResponse() {
        return new UserPassValidoResponse();
    }

    /**
     * Create an instance of {@link SeleccionarProveedor }
     * 
     */
    public SeleccionarProveedor createSeleccionarProveedor() {
        return new SeleccionarProveedor();
    }

    /**
     * Create an instance of {@link GetDataCliente }
     * 
     */
    public GetDataCliente createGetDataCliente() {
        return new GetDataCliente();
    }

    /**
     * Create an instance of {@link ListarResDeCli }
     * 
     */
    public ListarResDeCli createListarResDeCli() {
        return new ListarResDeCli();
    }

    /**
     * Create an instance of {@link CrearReserva }
     * 
     */
    public CrearReserva createCrearReserva() {
        return new CrearReserva();
    }

    /**
     * Create an instance of {@link TraerRsRpResponse }
     * 
     */
    public TraerRsRpResponse createTraerRsRpResponse() {
        return new TraerRsRpResponse();
    }

    /**
     * Create an instance of {@link CambiarEstado }
     * 
     */
    public CambiarEstado createCambiarEstado() {
        return new CambiarEstado();
    }

    /**
     * Create an instance of {@link MostrarReservaResponse }
     * 
     */
    public MostrarReservaResponse createMostrarReservaResponse() {
        return new MostrarReservaResponse();
    }

    /**
     * Create an instance of {@link CrearUserWeb }
     * 
     */
    public CrearUserWeb createCrearUserWeb() {
        return new CrearUserWeb();
    }

    /**
     * Create an instance of {@link UserPassValido }
     * 
     */
    public UserPassValido createUserPassValido() {
        return new UserPassValido();
    }

    /**
     * Create an instance of {@link GetDataClienteResponse }
     * 
     */
    public GetDataClienteResponse createGetDataClienteResponse() {
        return new GetDataClienteResponse();
    }

    /**
     * Create an instance of {@link MostrarReserva }
     * 
     */
    public MostrarReserva createMostrarReserva() {
        return new MostrarReserva();
    }

    /**
     * Create an instance of {@link AgregarPromoAreserva }
     * 
     */
    public AgregarPromoAreserva createAgregarPromoAreserva() {
        return new AgregarPromoAreserva();
    }

    /**
     * Create an instance of {@link ListarResDeCliResponse }
     * 
     */
    public ListarResDeCliResponse createListarResDeCliResponse() {
        return new ListarResDeCliResponse();
    }

    /**
     * Create an instance of {@link AgregarPromoAreservaResponse }
     * 
     */
    public AgregarPromoAreservaResponse createAgregarPromoAreservaResponse() {
        return new AgregarPromoAreservaResponse();
    }

    /**
     * Create an instance of {@link LimpiarResponse }
     * 
     */
    public LimpiarResponse createLimpiarResponse() {
        return new LimpiarResponse();
    }

    /**
     * Create an instance of {@link VerificarUsuario }
     * 
     */
    public VerificarUsuario createVerificarUsuario() {
        return new VerificarUsuario();
    }

    /**
     * Create an instance of {@link CrearUserWebResponse }
     * 
     */
    public CrearUserWebResponse createCrearUserWebResponse() {
        return new CrearUserWebResponse();
    }

    /**
     * Create an instance of {@link Limpiar }
     * 
     */
    public Limpiar createLimpiar() {
        return new Limpiar();
    }

    /**
     * Create an instance of {@link GetFactura }
     * 
     */
    public GetFactura createGetFactura() {
        return new GetFactura();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link AgregarServicioAreservaResponse }
     * 
     */
    public AgregarServicioAreservaResponse createAgregarServicioAreservaResponse() {
        return new AgregarServicioAreservaResponse();
    }

    /**
     * Create an instance of {@link SeleccionarProveedorResponse }
     * 
     */
    public SeleccionarProveedorResponse createSeleccionarProveedorResponse() {
        return new SeleccionarProveedorResponse();
    }

    /**
     * Create an instance of {@link SeleccionarReservaResponse }
     * 
     */
    public SeleccionarReservaResponse createSeleccionarReservaResponse() {
        return new SeleccionarReservaResponse();
    }

    /**
     * Create an instance of {@link DtPromocion }
     * 
     */
    public DtPromocion createDtPromocion() {
        return new DtPromocion();
    }

    /**
     * Create an instance of {@link DtServicio }
     * 
     */
    public DtServicio createDtServicio() {
        return new DtServicio();
    }

    /**
     * Create an instance of {@link DataRsRp }
     * 
     */
    public DataRsRp createDataRsRp() {
        return new DataRsRp();
    }

    /**
     * Create an instance of {@link DtRP }
     * 
     */
    public DtRP createDtRP() {
        return new DtRP();
    }

    /**
     * Create an instance of {@link DtFactura }
     * 
     */
    public DtFactura createDtFactura() {
        return new DtFactura();
    }

    /**
     * Create an instance of {@link DataServicio }
     * 
     */
    public DataServicio createDataServicio() {
        return new DataServicio();
    }

    /**
     * Create an instance of {@link DataCliente }
     * 
     */
    public DataCliente createDataCliente() {
        return new DataCliente();
    }

    /**
     * Create an instance of {@link DataReserva }
     * 
     */
    public DataReserva createDataReserva() {
        return new DataReserva();
    }

    /**
     * Create an instance of {@link DataReservas }
     * 
     */
    public DataReservas createDataReservas() {
        return new DataReservas();
    }

    /**
     * Create an instance of {@link DtRS }
     * 
     */
    public DtRS createDtRS() {
        return new DtRS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "getDataCliente")
    public JAXBElement<GetDataCliente> createGetDataCliente(GetDataCliente value) {
        return new JAXBElement<GetDataCliente>(_GetDataCliente_QNAME, GetDataCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "crearReserva")
    public JAXBElement<CrearReserva> createCrearReserva(CrearReserva value) {
        return new JAXBElement<CrearReserva>(_CrearReserva_QNAME, CrearReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerRsRpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "traerRsRpResponse")
    public JAXBElement<TraerRsRpResponse> createTraerRsRpResponse(TraerRsRpResponse value) {
        return new JAXBElement<TraerRsRpResponse>(_TraerRsRpResponse_QNAME, TraerRsRpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResDeCli }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarResDeCli")
    public JAXBElement<ListarResDeCli> createListarResDeCli(ListarResDeCli value) {
        return new JAXBElement<ListarResDeCli>(_ListarResDeCli_QNAME, ListarResDeCli.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiarEstado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "cambiarEstado")
    public JAXBElement<CambiarEstado> createCambiarEstado(CambiarEstado value) {
        return new JAXBElement<CambiarEstado>(_CambiarEstado_QNAME, CambiarEstado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "mostrarReservaResponse")
    public JAXBElement<MostrarReservaResponse> createMostrarReservaResponse(MostrarReservaResponse value) {
        return new JAXBElement<MostrarReservaResponse>(_MostrarReservaResponse_QNAME, MostrarReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearUserWeb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "crearUserWeb")
    public JAXBElement<CrearUserWeb> createCrearUserWeb(CrearUserWeb value) {
        return new JAXBElement<CrearUserWeb>(_CrearUserWeb_QNAME, CrearUserWeb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserPassValido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "userPassValido")
    public JAXBElement<UserPassValido> createUserPassValido(UserPassValido value) {
        return new JAXBElement<UserPassValido>(_UserPassValido_QNAME, UserPassValido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "getDataClienteResponse")
    public JAXBElement<GetDataClienteResponse> createGetDataClienteResponse(GetDataClienteResponse value) {
        return new JAXBElement<GetDataClienteResponse>(_GetDataClienteResponse_QNAME, GetDataClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "mostrarReserva")
    public JAXBElement<MostrarReserva> createMostrarReserva(MostrarReserva value) {
        return new JAXBElement<MostrarReserva>(_MostrarReserva_QNAME, MostrarReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarPromoAreservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "agregarPromoAreservaResponse")
    public JAXBElement<AgregarPromoAreservaResponse> createAgregarPromoAreservaResponse(AgregarPromoAreservaResponse value) {
        return new JAXBElement<AgregarPromoAreservaResponse>(_AgregarPromoAreservaResponse_QNAME, AgregarPromoAreservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LimpiarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "limpiarResponse")
    public JAXBElement<LimpiarResponse> createLimpiarResponse(LimpiarResponse value) {
        return new JAXBElement<LimpiarResponse>(_LimpiarResponse_QNAME, LimpiarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarPromoAreserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "agregarPromoAreserva")
    public JAXBElement<AgregarPromoAreserva> createAgregarPromoAreserva(AgregarPromoAreserva value) {
        return new JAXBElement<AgregarPromoAreserva>(_AgregarPromoAreserva_QNAME, AgregarPromoAreserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResDeCliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "listarResDeCliResponse")
    public JAXBElement<ListarResDeCliResponse> createListarResDeCliResponse(ListarResDeCliResponse value) {
        return new JAXBElement<ListarResDeCliResponse>(_ListarResDeCliResponse_QNAME, ListarResDeCliResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerificarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "verificarUsuario")
    public JAXBElement<VerificarUsuario> createVerificarUsuario(VerificarUsuario value) {
        return new JAXBElement<VerificarUsuario>(_VerificarUsuario_QNAME, VerificarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearUserWebResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "crearUserWebResponse")
    public JAXBElement<CrearUserWebResponse> createCrearUserWebResponse(CrearUserWebResponse value) {
        return new JAXBElement<CrearUserWebResponse>(_CrearUserWebResponse_QNAME, CrearUserWebResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Limpiar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "limpiar")
    public JAXBElement<Limpiar> createLimpiar(Limpiar value) {
        return new JAXBElement<Limpiar>(_Limpiar_QNAME, Limpiar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarServicioAreservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "agregarServicioAreservaResponse")
    public JAXBElement<AgregarServicioAreservaResponse> createAgregarServicioAreservaResponse(AgregarServicioAreservaResponse value) {
        return new JAXBElement<AgregarServicioAreservaResponse>(_AgregarServicioAreservaResponse_QNAME, AgregarServicioAreservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "getFactura")
    public JAXBElement<GetFactura> createGetFactura(GetFactura value) {
        return new JAXBElement<GetFactura>(_GetFactura_QNAME, GetFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarProveedorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarProveedorResponse")
    public JAXBElement<SeleccionarProveedorResponse> createSeleccionarProveedorResponse(SeleccionarProveedorResponse value) {
        return new JAXBElement<SeleccionarProveedorResponse>(_SeleccionarProveedorResponse_QNAME, SeleccionarProveedorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarReservaResponse")
    public JAXBElement<SeleccionarReservaResponse> createSeleccionarReservaResponse(SeleccionarReservaResponse value) {
        return new JAXBElement<SeleccionarReservaResponse>(_SeleccionarReservaResponse_QNAME, SeleccionarReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerRsRp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "traerRsRp")
    public JAXBElement<TraerRsRp> createTraerRsRp(TraerRsRp value) {
        return new JAXBElement<TraerRsRp>(_TraerRsRp_QNAME, TraerRsRp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerificarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "verificarUsuarioResponse")
    public JAXBElement<VerificarUsuarioResponse> createVerificarUsuarioResponse(VerificarUsuarioResponse value) {
        return new JAXBElement<VerificarUsuarioResponse>(_VerificarUsuarioResponse_QNAME, VerificarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "crearReservaResponse")
    public JAXBElement<CrearReservaResponse> createCrearReservaResponse(CrearReservaResponse value) {
        return new JAXBElement<CrearReservaResponse>(_CrearReservaResponse_QNAME, CrearReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiarEstadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "cambiarEstadoResponse")
    public JAXBElement<CambiarEstadoResponse> createCambiarEstadoResponse(CambiarEstadoResponse value) {
        return new JAXBElement<CambiarEstadoResponse>(_CambiarEstadoResponse_QNAME, CambiarEstadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarReserva")
    public JAXBElement<SeleccionarReserva> createSeleccionarReserva(SeleccionarReserva value) {
        return new JAXBElement<SeleccionarReserva>(_SeleccionarReserva_QNAME, SeleccionarReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "getFacturaResponse")
    public JAXBElement<GetFacturaResponse> createGetFacturaResponse(GetFacturaResponse value) {
        return new JAXBElement<GetFacturaResponse>(_GetFacturaResponse_QNAME, GetFacturaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarServicioAreserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "agregarServicioAreserva")
    public JAXBElement<AgregarServicioAreserva> createAgregarServicioAreserva(AgregarServicioAreserva value) {
        return new JAXBElement<AgregarServicioAreserva>(_AgregarServicioAreserva_QNAME, AgregarServicioAreserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserPassValidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "userPassValidoResponse")
    public JAXBElement<UserPassValidoResponse> createUserPassValidoResponse(UserPassValidoResponse value) {
        return new JAXBElement<UserPassValidoResponse>(_UserPassValidoResponse_QNAME, UserPassValidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeleccionarProveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "seleccionarProveedor")
    public JAXBElement<SeleccionarProveedor> createSeleccionarProveedor(SeleccionarProveedor value) {
        return new JAXBElement<SeleccionarProveedor>(_SeleccionarProveedor_QNAME, SeleccionarProveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg6", scope = CrearUserWeb.class)
    public JAXBElement<byte[]> createCrearUserWebArg6(byte[] value) {
        return new JAXBElement<byte[]>(_CrearUserWebArg6_QNAME, byte[].class, CrearUserWeb.class, ((byte[]) value));
    }

}
