
package fb.pricingAnalytics.generated;

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
 *         &lt;element name="LinkSSOToEnterpriseResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "linkSSOToEnterpriseResult"
})
@XmlRootElement(name = "LinkSSOToEnterpriseResponse")
public class LinkSSOToEnterpriseResponse {

    @XmlElement(name = "LinkSSOToEnterpriseResult")
    protected String linkSSOToEnterpriseResult;

    /**
     * Gets the value of the linkSSOToEnterpriseResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkSSOToEnterpriseResult() {
        return linkSSOToEnterpriseResult;
    }

    /**
     * Sets the value of the linkSSOToEnterpriseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkSSOToEnterpriseResult(String value) {
        this.linkSSOToEnterpriseResult = value;
    }

}
