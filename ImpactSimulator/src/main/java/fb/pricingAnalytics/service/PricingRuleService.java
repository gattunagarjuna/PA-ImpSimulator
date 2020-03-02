package fb.pricingAnalytics.service;

import java.math.BigInteger;
import java.sql.SQLException;

import fb.pricingAnalytics.request.PricingRule;
import fb.pricingAnalytics.response.ProjectPricingRulesResponse;
import fb.pricingAnalytics.response.ScenarioPricingRulesResponse;

public interface PricingRuleService {
	
	public BigInteger createPricingRule(PricingRule pricingRuleRequest,int brandId, String userName) throws SQLException,Exception;

	public ScenarioPricingRulesResponse getPricingRulesForScenario(BigInteger projectId,BigInteger scenarioId, int brandId)throws SQLException,Exception;

	public ProjectPricingRulesResponse getPricingRulesForProject(BigInteger projectId,	int brandId)throws SQLException,Exception;
	

}
