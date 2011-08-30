//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.13 at 10:12:26 PM MESZ 
//


package slash.navigation.kml.binding22gx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import slash.navigation.kml.binding22.AbstractObjectType;


/**
 * <p>Java class for PlaylistType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaylistType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.google.com/kml/ext/2.2}AbstractTourPrimitiveGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaylistType", propOrder = {
    "abstractTourPrimitiveGroup"
})
public class PlaylistType
    extends AbstractObjectType
{

    @XmlElementRef(name = "AbstractTourPrimitiveGroup", namespace = "http://www.google.com/kml/ext/2.2", type = JAXBElement.class)
    protected List<JAXBElement<? extends AbstractTourPrimitiveType>> abstractTourPrimitiveGroup;

    /**
     * Gets the value of the abstractTourPrimitiveGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractTourPrimitiveGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractTourPrimitiveGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TourControlType }{@code >}
     * {@link JAXBElement }{@code <}{@link WaitType }{@code >}
     * {@link JAXBElement }{@code <}{@link AnimatedUpdateType }{@code >}
     * {@link JAXBElement }{@code <}{@link FlyToType }{@code >}
     * {@link JAXBElement }{@code <}{@link SoundCueType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTourPrimitiveType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractTourPrimitiveType>> getAbstractTourPrimitiveGroup() {
        if (abstractTourPrimitiveGroup == null) {
            abstractTourPrimitiveGroup = new ArrayList<JAXBElement<? extends AbstractTourPrimitiveType>>();
        }
        return this.abstractTourPrimitiveGroup;
    }

}