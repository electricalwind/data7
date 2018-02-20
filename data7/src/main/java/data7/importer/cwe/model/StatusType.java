package data7.importer.cwe.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Status_Type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Status_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Deprecated"/>
 *     &lt;enumeration value="Incomplete"/>
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Usable"/>
 *     &lt;enumeration value="Stable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Status_Type")
@XmlEnum
public enum StatusType {

    @XmlEnumValue("Deprecated")
    DEPRECATED("Deprecated"),
    @XmlEnumValue("Incomplete")
    INCOMPLETE("Incomplete"),
    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Usable")
    USABLE("Usable"),
    @XmlEnumValue("Stable")
    STABLE("Stable");
    private final String value;

    StatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusType fromValue(String v) {
        for (StatusType c: StatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
