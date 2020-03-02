package fb.pricingAnalytics.response;

import java.util.List;

import fb.pricingAnalytics.model.vo.ScenarioPricingRuleVo;
import fb.pricingAnalytics.utils.FBRestResponse;

public class ScenarioPricingRulesResponse extends FBRestResponse{
	
	private int pricingRules_Count;
	private List<ScenarioPricingRuleVo> pricingRuleVo;
	
	public int getPricingRules_Count() {
		return pricingRules_Count;
	}
	public void setPricingRules_Count(int pricingRules_Count) {
		this.pricingRules_Count = pricingRules_Count;
	}
	public List<ScenarioPricingRuleVo> getPricingRuleVo() {
		return pricingRuleVo;
	}
	public void setPricingRuleVo(List<ScenarioPricingRuleVo> pricingRuleVo) {
		this.pricingRuleVo = pricingRuleVo;
	}
		
}
