package fb.pricingAnalytics.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ScenarioPricingRule",schema="ImpactSimulator.dbo")
public class ScenarioPricingRule {
		
	@Id
	@GeneratedValue
	@Column(name="Id")
	private BigInteger id;
	
	@Column(name="RuleId")
	private BigInteger ruleId;
	
	@Column(name="BrandId")
	private int brandId;
	
	@Column(name="ScenarioId")
	private BigInteger scenarioId;
	
	@Column(name="IsApplied")
	private boolean isApplied;
	
	@Column(name="IsDeleted")
	private boolean isDeleted;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@Column(name="CreatedBy")
	private String createdBy;

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getRuleId() {
		return ruleId;
	}

	public void setRuleId(BigInteger ruleId) {
		this.ruleId = ruleId;
	}

	public BigInteger getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(BigInteger scenarioId) {
		this.scenarioId = scenarioId;
	}

	public boolean isApplied() {
		return isApplied;
	}

	public void setApplied(boolean isApplied) {
		this.isApplied = isApplied;
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
