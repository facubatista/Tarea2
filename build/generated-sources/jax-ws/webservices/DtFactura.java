
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtFactura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nroReserva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserva" type="{http://WebServices/}dataReserva" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtFactura", propOrder = {
    "id",
    "nroReserva",
    "reserva"
})
public class DtFactura {

    protected int id;
    protected int nroReserva;
    protected DataReserva reserva;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nroReserva.
     * 
     */
    public int getNroReserva() {
        return nroReserva;
    }

    /**
     * Define el valor de la propiedad nroReserva.
     * 
     */
    public void setNroReserva(int value) {
        this.nroReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad reserva.
     * 
     * @return
     *     possible object is
     *     {@link DataReserva }
     *     
     */
    public DataReserva getReserva() {
        return reserva;
    }

    /**
     * Define el valor de la propiedad reserva.
     * 
     * @param value
     *     allowed object is
     *     {@link DataReserva }
     *     
     */
    public void setReserva(DataReserva value) {
        this.reserva = value;
    }

}
