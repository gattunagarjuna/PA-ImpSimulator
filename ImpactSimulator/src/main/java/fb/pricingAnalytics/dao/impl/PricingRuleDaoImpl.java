package fb.pricingAnalytics.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

















import com.fasterxml.jackson.databind.ObjectMapper;

import fb.pricingAnalytics.dao.PricingRuleDao;
import fb.pricingAnalytics.model.PricingRule;
import fb.pricingAnalytics.model.ScenarioPricingRule;
import fb.pricingAnalytics.model.vo.PricingRuleVo;
import fb.pricingAnalytics.request.PricingRuleRequest;
import fb.pricingAnalytics.response.PricingRulesResponse;
import fb.pricingAnalytics.utils.FBRestResponse;


@Repository
public class PricingRuleDaoImpl implements PricingRuleDao{
	
	private final static Logger logger = LoggerFactory.getLogger(PricingRuleDaoImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public BigInteger createPricingRule(PricingRuleRequest pricingRuleRequest,int brandId,String userName) throws SQLException, Exception {
		
		
		try{
			PricingRule pricingRule = new PricingRule();
			
			Session session =  entityManager.unwrap(Session.class);
			pricingRule.setProjectId(pricingRuleRequest.getProjectId());
			pricingRule.setBrandId(brandId);
			pricingRule.setType(pricingRuleRequest.getType());
			pricingRule.setTierUpdate(pricingRuleRequest.getTierUpdate());
			pricingRule.setDeleted(false);
			pricingRule.setCreatedBy(userName);
			pricingRule.setCreatedOn(Date.from(Instant.now()));
			pricingRule.setRuleData(new ObjectMapper().writeValueAsString(pricingRuleRequest));
			session.save(pricingRule);
			BigInteger ruleId =  pricingRule.getRuleId();
			
			if(null != ruleId && ruleId.intValue() > 0 ){
				BigInteger[] scenarioIds = fetchScenarios(pricingRuleRequest.getProjectId(),brandId);
				if(null != scenarioIds && scenarioIds.length> 0){
					//insertIntoScenarioPricingRule(ruleId,scenarioIds,brandId,userName);
					Stream.of(scenarioIds).forEach(s->insertIntoScenarioPricingRule(ruleId,s,brandId,userName));
				}
			}
		}catch(Exception ex){
			logger.info("Exception occured while saving Rule data");
			 new BigInteger("0");
		}
		return new BigInteger("1");
	}

	private void insertIntoScenarioPricingRule(BigInteger ruleId,BigInteger scenarioId, int brandId,String userName) {
		
		Session session =  entityManager.unwrap(Session.class);
		ScenarioPricingRule scenarioPricingRule = new ScenarioPricingRule();
		scenarioPricingRule.setRuleId(ruleId);
		scenarioPricingRule.setBrandId(brandId);
		scenarioPricingRule.setScenarioId(scenarioId);
		scenarioPricingRule.setApplied(false);
		scenarioPricingRule.setDeleted(false);
		scenarioPricingRule.setCreatedBy(userName);
		scenarioPricingRule.setCreatedOn(Date.from(Instant.now()));
		session.save(scenarioPricingRule);
		
	}

	private BigInteger[] fetchScenarios(BigInteger projectId, int brandId) {
		StringBuilder sb =  new StringBuilder("select scenarioId from Scenario where brandId=:brand_Id and projectId=:project_Id and deleted=:deleted");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", brandId);
		query.setParameter("project_Id", projectId);
		query.setParameter("deleted",false);
		List<Object> rows = query.list();
		BigInteger[] scenarioIds = rows.stream().toArray(BigInteger[]::new);
		return scenarioIds;
		
	}

	@Override
	public PricingRulesResponse getPricingRules(BigInteger projectId,int brandId) throws SQLException, Exception {
		
		PricingRulesResponse response = new PricingRulesResponse();
		try{
			StringBuilder sb =  new StringBuilder(" select spr.ruleId,spr.scenarioId,spr.isApplied,spr.isDeleted,pr.ruleData from ScenarioPricingRule spr "
					+ "left join PricingRule pr on pr.ruleId = spr.ruleId where "
					+ "pr.projectId = :project_Id and spr.isDeleted = 0 and spr.brandId=:brand_Id");
			Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
			query.setParameter("brand_Id", brandId);
			query.setParameter("project_Id", projectId);
			List<Object[]> rows = query.list();
		
			List<PricingRuleVo> result = new ArrayList<PricingRuleVo>(rows.size());
			for (Object[] row : rows) {
				PricingRuleRequest request = new ObjectMapper().readValue((String)row[4], PricingRuleRequest.class);
				result.add(new PricingRuleVo((BigInteger)row[0],(BigInteger)row[1],(Boolean)row[2],(Boolean)row[3],request));
			}
			response.setPricingRules_Count(rows.size());
			response.setPricingRuleVo(result);
			response.setSuccessFlag(true);
		}catch(Exception ex){
			logger.debug("Exception occured inside while fetching Pricing Rules from DB");
			return (PricingRulesResponse) new FBRestResponse(false,"Exception Occured while fetching data from DB");
		}
		return response;
	}

}
