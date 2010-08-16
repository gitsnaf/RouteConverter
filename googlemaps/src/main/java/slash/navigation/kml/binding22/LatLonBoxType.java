//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.13 at 10:12:26 PM MESZ 
//


package slash.navigation.kml.binding22;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LatLonBoxType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LatLonBoxType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractLatLonBoxType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}rotation" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonBoxSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonBoxObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatLonBoxType", propOrder = {
    "rotation",
    "latLonBoxSimpleExtensionGroup",
    "latLonBoxObjectExtensionGroup"
})
public class LatLonBoxType
    extends AbstractLatLonBoxType
{

    @XmlElement(defaultValue = "0.0")
    protected Double rotation;
    @XmlElement(name = "LatLonBoxSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> latLonBoxSimpleExtensionGroup;
    @XmlElement(name = "LatLonBoxObjectExtensionGroup")
    protected List<AbstractObjectType> latLonBoxObjectExtensionGroup;

    /**
     * Gets the value of the rotation property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRotation(Double value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the latLonBoxSimpleExtensionGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonBoxSimpleExtensionGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonBoxSimpleExtensionGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getLatLonBoxSimpleExtensionGroup() {
        if (latLonBoxSimpleExtensionGroup == null) {
            latLonBoxSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.latLonBoxSimpleExtensionGroup;
    }

    /**
     * Gets the value of the latLonBoxObjectExtensionGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonBoxObjectExtensionGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonBoxObjectExtensionGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     * 
     * 
     */
    public List<AbstractObjectType> getLatLonBoxObjectExtensionGroup() {
        if (latLonBoxObjectExtensionGroup == null) {
            latLonBoxObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.latLonBoxObjectExtensionGroup;
    }

}
