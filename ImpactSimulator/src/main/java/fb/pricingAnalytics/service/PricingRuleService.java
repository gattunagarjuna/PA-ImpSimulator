package fb.pricingAnalytics.service;

import java.math.BigInteger;
import java.sql.SQLException;

import fb.pricingAnalytics.request.PricingRuleRequest;
import fb.pricingAnalytics.response.PricingRulesResponse;

public interface PricingRuleService {
	
	public BigInteger createPricingRule(PricingRuleRequest pricingRuleRequest,int brandId, String userName) throws SQLException,Exception;

	public PricingRulesResponse getPricingRules(BigInteger projectId, int brandId)throws SQLException,Exception;
	

}
