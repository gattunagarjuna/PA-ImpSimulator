package fb.pricingAnalytics.model.vo;

import java.math.BigInteger;

import fb.pricingAnalytics.request.PricingRuleRequest;

public class PricingRuleVo {
	
	BigInteger pricingRuleId;
	BigInteger scenarioId;
	boolean isApplied;
	boolean isDeleted;
	PricingRuleRequest ruleData;
	
	public PricingRuleVo(BigInteger pricingRuleId, BigInteger scenarioId,
			boolean isApplied, boolean isDeleted, PricingRuleRequest ruleData) {
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

	public PricingRuleRequest getRuleData() {
		return ruleData;
	}

	public void setRuleData(PricingRuleRequest ruleData) {
		this.ruleData = ruleData;
	}	
			
}
