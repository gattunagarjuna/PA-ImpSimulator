package fb.pricingAnalytics.response;

import java.util.List;

import fb.pricingAnalytics.model.vo.ProjectPricingRuleVo;
import fb.pricingAnalytics.utils.FBRestResponse;

public class ProjectPricingRulesResponse extends FBRestResponse{
	
	int pricingRules_Count;
	List<ProjectPricingRuleVo> pricingRules;
	
	public int getPricingRules_Count() {
		return pricingRules_Count;
	}
	public void setPricingRules_Count(int pricingRules_Count) {
		this.pricingRules_Count = pricingRules_Count;
	}
	public List<ProjectPricingRuleVo> getPricingRules() {
		return pricingRules;
	}
	public void setPricingRules(List<ProjectPricingRuleVo> pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	
	

}
