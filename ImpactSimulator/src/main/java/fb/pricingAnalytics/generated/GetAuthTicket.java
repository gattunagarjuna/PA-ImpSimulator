
package fb.pricingAnalytics.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appl_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fishFrameSessionID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applId",
    "sessionID",
    "fishFrameSessionID"
})
@XmlRootElement(name = "GetAuthTicket")
public class GetAuthTicket {

    @XmlElement(name = "appl_id")
    protected int applId;
    protected String sessionID;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal fishFrameSessionID;

    /**
     * Gets the value of the applId property.
     * 
     */
    public int getApplId() {
        return applId;
    }

    /**
     * Sets the value of the applId property.
     * 
     */
    public void setApplId(int value) {
        this.applId = value;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

    /**
     * Gets the value of the fishFrameSessionID property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFishFrameSessionID() {
        return fishFrameSessionID;
    }

    /**
     * Sets the value of the fishFrameSessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFishFrameSessionID(BigDecimal value) {
        this.fishFrameSessionID = value;
    }

}
