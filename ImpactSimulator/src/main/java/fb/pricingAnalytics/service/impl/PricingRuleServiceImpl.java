package fb.pricingAnalytics.service.impl;

import java.math.BigInteger;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fb.pricingAnalytics.dao.PricingRuleDao;
import fb.pricingAnalytics.request.PricingRuleRequest;
import fb.pricingAnalytics.response.PricingRulesResponse;
import fb.pricingAnalytics.service.PricingRuleService;


@Service
public class PricingRuleServiceImpl implements PricingRuleService{
	
	
	@Autowired
	PricingRuleDao pricingRuleDao;

	@Transactional
	@Override
	public BigInteger createPricingRule(PricingRuleRequest pricingRuleRequest,int brandId, String userName) throws SQLException, Exception {
		return pricingRuleDao.createPricingRule( pricingRuleRequest, brandId,  userName);
	}

	
	
	
	@Transactional
	@Override
	public PricingRulesResponse getPricingRules(BigInteger projectId,int brandId) throws SQLException, Exception {
		return pricingRuleDao.getPricingRules(projectId,brandId);
	}

}
