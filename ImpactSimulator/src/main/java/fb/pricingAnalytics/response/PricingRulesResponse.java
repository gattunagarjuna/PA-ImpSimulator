package fb.pricingAnalytics.response;

import java.util.List;

import fb.pricingAnalytics.model.vo.PricingRuleVo;
import fb.pricingAnalytics.utils.FBRestResponse;

public class PricingRulesResponse extends FBRestResponse{
	
	private int pricingRules_Count;
	private List<PricingRuleVo> pricingRuleVo;
	
	public int getPricingRules_Count() {
		return pricingRules_Count;
	}
	public void setPricingRules_Count(int pricingRules_Count) {
		this.pricingRules_Count = pricingRules_Count;
	}
	public List<PricingRuleVo> getPricingRuleVo() {
		return pricingRuleVo;
	}
	public void setPricingRuleVo(List<PricingRuleVo> pricingRuleVo) {
		this.pricingRuleVo = pricingRuleVo;
	}
		
}
