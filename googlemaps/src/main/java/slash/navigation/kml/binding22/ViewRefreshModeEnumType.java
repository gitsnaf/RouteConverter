//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-646 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.13 at 10:12:26 PM MESZ 
//


package slash.navigation.kml.binding22;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for viewRefreshModeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="viewRefreshModeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="never"/>
 *     &lt;enumeration value="onRequest"/>
 *     &lt;enumeration value="onStop"/>
 *     &lt;enumeration value="onRegion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "viewRefreshModeEnumType")
@XmlEnum
public enum ViewRefreshModeEnumType {

    @XmlEnumValue("never")
    NEVER("never"),
    @XmlEnumValue("onRequest")
    ON_REQUEST("onRequest"),
    @XmlEnumValue("onStop")
    ON_STOP("onStop"),
    @XmlEnumValue("onRegion")
    ON_REGION("onRegion");
    private final String value;

    ViewRefreshModeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewRefreshModeEnumType fromValue(String v) {
        for (ViewRefreshModeEnumType c: ViewRefreshModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
