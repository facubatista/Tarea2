
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataRsRp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataRsRp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servicios" type="{http://WebServices/}dtRS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="promociones" type="{http://WebServices/}dtRP" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataRsRp", propOrder = {
    "servicios",
    "promociones"
})
public class DataRsRp {

    @XmlElement(nillable = true)
    protected List<DtRS> servicios;
    @XmlElement(nillable = true)
    protected List<DtRP> promociones;

    /**
     * Gets the value of the servicios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtRS }
     * 
     * 
     */
    public List<DtRS> getServicios() {
        if (servicios == null) {
            servicios = new ArrayList<DtRS>();
        }
        return this.servicios;
    }

    /**
     * Gets the value of the promociones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promociones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromociones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtRP }
     * 
     * 
     */
    public List<DtRP> getPromociones() {
        if (promociones == null) {
            promociones = new ArrayList<DtRP>();
        }
        return this.promociones;
    }

}
