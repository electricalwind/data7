package cweModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour SDLC_Phase_Type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SDLC_Phase_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="Policy"/>
 *     &lt;enumeration value="Requirements"/>
 *     &lt;enumeration value="Architecture and Design"/>
 *     &lt;enumeration value="Implementation"/>
 *     &lt;enumeration value="Testing"/>
 *     &lt;enumeration value="Bundling"/>
 *     &lt;enumeration value="Distribution"/>
 *     &lt;enumeration value="Installation"/>
 *     &lt;enumeration value="Patch"/>
 *     &lt;enumeration value="Documentation"/>
 *     &lt;enumeration value="Porting"/>
 *     &lt;enumeration value="System Configuration"/>
 *     &lt;enumeration value="Operation"/>
 *     &lt;enumeration value="Build and Compilation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SDLC_Phase_Type")
@XmlEnum
public enum SDLCPhaseType {

    @XmlEnumValue("Policy")
    POLICY("Policy"),
    @XmlEnumValue("Requirements")
    REQUIREMENTS("Requirements"),
    @XmlEnumValue("Architecture and Design")
    ARCHITECTURE_AND_DESIGN("Architecture and Design"),
    @XmlEnumValue("Implementation")
    IMPLEMENTATION("Implementation"),
    @XmlEnumValue("Testing")
    TESTING("Testing"),
    @XmlEnumValue("Bundling")
    BUNDLING("Bundling"),
    @XmlEnumValue("Distribution")
    DISTRIBUTION("Distribution"),
    @XmlEnumValue("Installation")
    INSTALLATION("Installation"),
    @XmlEnumValue("Patch")
    PATCH("Patch"),
    @XmlEnumValue("Documentation")
    DOCUMENTATION("Documentation"),
    @XmlEnumValue("Porting")
    PORTING("Porting"),
    @XmlEnumValue("System Configuration")
    SYSTEM_CONFIGURATION("System Configuration"),
    @XmlEnumValue("Operation")
    OPERATION("Operation"),
    @XmlEnumValue("Build and Compilation")
    BUILD_AND_COMPILATION("Build and Compilation");
    private final String value;

    SDLCPhaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SDLCPhaseType fromValue(String v) {
        for (SDLCPhaseType c: SDLCPhaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
