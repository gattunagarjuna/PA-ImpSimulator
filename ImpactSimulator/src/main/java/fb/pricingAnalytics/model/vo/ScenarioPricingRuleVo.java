package fb.pricingAnalytics.model.vo;

import java.math.BigInteger;

import fb.pricingAnalytics.request.PricingRule;

public class ScenarioPricingRuleVo {
	
	BigInteger pricingRuleId;
	BigInteger scenarioId;
	boolean isApplied;
	boolean isDeleted;
	PricingRule ruleData;
	
	public ScenarioPricingRuleVo(BigInteger pricingRuleId, BigInteger scenarioId,
			boolean isApplied, boolean isDeleted, PricingRule ruleData) {
		super();
		this.pricingRuleId = pricingRuleId;
		this.scenarioId = scenarioId;
		this.isApplied = isApplied;
		this.isDeleted = isDeleted;
		this.ruleData = ruleData;
	}

	public BigInteger getPricingRuleId() {
		return pricingRuleId;
	}

	public void setPricingRuleId(BigInteger pricingRuleId) {
		this.pricingRuleId = pricingRuleId;
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

	public PricingRule getRuleData() {
		return ruleData;
	}

	public void setRuleData(PricingRule ruleData) {
		this.ruleData = ruleData;
	}	
			
}
