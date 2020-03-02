package fb.pricingAnalytics.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PricingRule",schema="ImpactSimulator.dbo")
public class PricingRule implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="RuleId")
	private BigInteger ruleId;
	
	@Column(name="ProjectId")
	private BigInteger projectId;
	
	@Column(name="BrandId")
	private int brandId;
	
	@Column(name="RuleData")
	private String ruleData;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="PriceChange")
	private float priceChange;
	
	@Column(name="TierUpdate")
	private String tierUpdate;
	
	@Column(name="IsDeleted")
	private boolean isDeleted;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@Column(name="CreatedBy")
	private String createdBy;

	public BigInteger getRuleId() {
		return ruleId;
	}

	public void setRuleId(BigInteger ruleId) {
		this.ruleId = ruleId;
	}

	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	public String getRuleData() {
		return ruleData;
	}

	public void setRuleData(String ruleData) {
		this.ruleData = ruleData;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(float priceChange) {
		this.priceChange = priceChange;
	}

	public String getTierUpdate() {
		return tierUpdate;
	}

	public void setTierUpdate(String tierUpdate) {
		this.tierUpdate = tierUpdate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	

}
