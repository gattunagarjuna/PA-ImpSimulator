package fb.pricingAnalytics.service.impl;

import java.math.BigInteger;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fb.pricingAnalytics.dao.PricingRuleDao;
import fb.pricingAnalytics.request.PricingRule;
import fb.pricingAnalytics.response.ProjectPricingRulesResponse;
import fb.pricingAnalytics.response.ScenarioPricingRulesResponse;
import fb.pricingAnalytics.service.PricingRuleService;


@Service
public class PricingRuleServiceImpl implements PricingRuleService{
	
	
	@Autowired
	PricingRuleDao pricingRuleDao;

	@Transactional
	@Override
	public BigInteger createPricingRule(PricingRule pricingRuleRequest,int brandId, String userName) throws SQLException, Exception {
		return pricingRuleDao.createPricingRule( pricingRuleRequest, brandId,  userName);
	}

	@Transactional
	@Override
	public ScenarioPricingRulesResponse getPricingRulesForScenario(BigInteger projectId,BigInteger scenarioId,int brandId) throws SQLException, Exception {
		return pricingRuleDao.getPricingRulesForScenario(projectId,scenarioId,brandId);
	}

	@Override
	public ProjectPricingRulesResponse getPricingRulesForProject(BigInteger projectId,int brandId) throws SQLException, Exception {
		return pricingRuleDao.getPricingRulesForProject(projectId,brandId);
	}

}
