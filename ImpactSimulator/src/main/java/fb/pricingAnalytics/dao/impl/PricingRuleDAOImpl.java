package fb.pricingAnalytics.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import fb.pricingAnalytics.dao.MenuPricingDAO;
import fb.pricingAnalytics.dao.PricingRuleDAO;
import fb.pricingAnalytics.model.ScenarioPricingRule;
import fb.pricingAnalytics.model.vo.MenuPricingVo;
import fb.pricingAnalytics.model.vo.PricingRuleData;
import fb.pricingAnalytics.model.vo.PricingRuleVo;
import fb.pricingAnalytics.model.vo.StoreTierVo;
import fb.pricingAnalytics.request.ApplyRuleRequest;
import fb.pricingAnalytics.request.MenuItem;
import fb.pricingAnalytics.request.PricingRuleRequest;
import fb.pricingAnalytics.request.RequestMenuTierPriceUpdate;
import fb.pricingAnalytics.request.StoreTier;
import fb.pricingAnalytics.request.UpdateStoreInfoRequest;
import fb.pricingAnalytics.response.ApplyRulesStatusResponse;
import fb.pricingAnalytics.response.MenuPricingResponse;
import fb.pricingAnalytics.response.PricingRulesListResponse;
import fb.pricingAnalytics.response.StoreTierResponse;
import fb.pricingAnalytics.utils.FBRestResponse;


@Repository
public class PricingRuleDAOImpl implements PricingRuleDAO{
	
	private final static Logger logger = LoggerFactory.getLogger(PricingRuleDAOImpl.class);
	
	@Autowired
	MenuPricingDAO  menuPricingDAO;
	
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public BigInteger createPricingRule(PricingRuleRequest pricingRuleRequest,int brandId, String userName) throws SQLException, Exception {
		
		BigInteger ruleId = new BigInteger("0");
	
		try{
			ScenarioPricingRule pricingRule = new ScenarioPricingRule();
			
			Session session =  entityManager.unwrap(Session.class);
			
			pricingRule.setScenarioId(pricingRuleRequest.getScenarioId());
			pricingRule.setBrandId(brandId);
			pricingRule.setApplied(false);
			pricingRule.setDeleted(false);
			pricingRule.setCreatedOn(Date.from(Instant.now()));
			pricingRule.setCreatedBy(userName);
			pricingRule.setRuleType(pricingRuleRequest.getType());
			pricingRule.setTierUpdate(pricingRuleRequest.getTierUpdate());
			pricingRule.setPriceChange(null);
			pricingRule.setRuleName(pricingRuleRequest.getRuleName());
			pricingRule.setPriceChangeByPercentage(pricingRuleRequest.getPriceChangeByPercentage());
			if(null != pricingRuleRequest.getPriceChange()){
				pricingRule.setPriceChange(pricingRuleRequest.getPriceChange().floatValue());
			}
			pricingRule.setRuleData(new ObjectMapper().writeValueAsString(pricingRuleRequest));
			
			ruleId = (BigInteger) session.save(pricingRule);
			
		}catch(Exception ex){
			logger.info("Exception occured while saving Rule data into DB");
			return ruleId;
		}
		return ruleId;
	}

	@Override
	public PricingRulesListResponse getPricingRulesForScenario(	BigInteger scenarioId, int brandId) throws SQLException, Exception {
		
		PricingRulesListResponse response = new PricingRulesListResponse();
		try{
			StringBuilder sb =  new StringBuilder("from ScenarioPricingRule where brandId=:brand_Id and scenarioId=:scenario_Id and isDeleted=:deleted");
			Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
			query.setParameter("brand_Id", brandId);
			query.setParameter("scenario_Id", scenarioId);
			query.setParameter("deleted", false);
			List<Object[]> rows = query.list();
		
			
			List<PricingRuleVo> result = new ArrayList<PricingRuleVo>(rows.size());
			for (Object row : rows) {
				ScenarioPricingRule pricingRule = (ScenarioPricingRule)row;
				PricingRuleData ruleData = new ObjectMapper().readValue(pricingRule.getRuleData(),PricingRuleData.class);
				result.add(new PricingRuleVo(pricingRule.getRuleId(),pricingRule.getRuleName(),pricingRule.getScenarioId(),pricingRule.getBrandId(),
						pricingRule.isApplied(),pricingRule.isDeleted(),pricingRule.getCreatedOn(),pricingRule.getCreatedBy(),
						pricingRule.getRuleType(),pricingRule.getTierUpdate(),pricingRule.getPriceChange(),ruleData,pricingRule.isPriceChangeByPercentage()));
			}
			response.setCount_PricingRules(rows.size());
			response.setPricingRules(result);
			response.setSuccessFlag(true);
		}catch(Exception ex){
			logger.debug("Exception occured inside while fetching Pricing Rules from DB");
			return (PricingRulesListResponse) new FBRestResponse(false,"Exception Occured while fetching data from DB");
		}
		return response;

	}

	@Override
	public FBRestResponse applyPricingRules(int brandId,List<ApplyRuleRequest> applyRules) throws SQLException, Exception {
		
		
		
		
		
		
		
		
		
		for(ApplyRuleRequest applyRuleRequest : applyRules){
			
			try{
				StringBuilder sb =  new StringBuilder("UPDATE ScenarioPricingRule SET IsApplied=:is_Applied where BrandId=:brand_Id and RuleId=:rule_Id and ScenarioId=:scenario_Id");
				Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
				query.setParameter("brand_Id", brandId);
				query.setParameter("scenario_Id", applyRuleRequest.getScenarioId());
				query.setParameter("is_Applied", applyRuleRequest.isApplied());
				query.setParameter("rule_Id", applyRuleRequest.getRuleId());
				query.executeUpdate();
			}catch(Exception ex){
				logger.info("Updation failed");
				return new FBRestResponse(false, "Updation Failed");
			}
			
		}
		return new FBRestResponse(true, "success");
	}

	

	private ScenarioPricingRule fetchPricingRule(int brandId,BigInteger ruleId) {
		
		StringBuilder sb =  new StringBuilder("from ScenarioPricingRule where brandId=:brand_Id and ruleId=:rule_Id ");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", brandId);
		query.setParameter("rule_Id", ruleId);
		List<Object> rows = query.list();
		ScenarioPricingRule pricingRule = (ScenarioPricingRule)rows.get(0);
		return pricingRule;
	}
	
	@Override
	public List<ApplyRulesStatusResponse> revertRules(int brandId,List<ApplyRuleRequest> rulesNotApplicable,String userName) throws SQLException,Exception {
		
		List<ApplyRulesStatusResponse> revertRulesResponseList = new ArrayList<ApplyRulesStatusResponse>();
		
		for(ApplyRuleRequest revertRule : rulesNotApplicable){
			ScenarioPricingRule pricingRule = fetchPricingRule(brandId,revertRule.getRuleId());
			ApplyRulesStatusResponse response = applyOrRevertRule(revertRule,pricingRule,brandId,userName);
			revertRulesResponseList.add(response);
		}
		
		return revertRulesResponseList;
	}

	@Override
	public List<ApplyRulesStatusResponse> applyRules(int brandId,List<ApplyRuleRequest> rulesApplicable,String userName) throws SQLException,Exception {
		
		List<ApplyRulesStatusResponse> applyRulesResponseList = new ArrayList<ApplyRulesStatusResponse>();
		
		for(ApplyRuleRequest ruleRequest : rulesApplicable){
			ScenarioPricingRule pricingRule = fetchPricingRule(brandId,ruleRequest.getRuleId());
			ApplyRulesStatusResponse response = applyOrRevertRule(ruleRequest,pricingRule,brandId,userName);
			applyRulesResponseList.add(response);
		}
		
		return applyRulesResponseList;
	}

	private ApplyRulesStatusResponse applyOrRevertRule(ApplyRuleRequest ruleRequest,ScenarioPricingRule pricingRule, int brandId, String userName) {
		
		ApplyRulesStatusResponse response = null;
		try{
			String ruleType = pricingRule.getRuleType();
			if(ruleType.equalsIgnoreCase("menuitem")){
				PricingRuleData ruleData = new ObjectMapper().readValue(pricingRule.getRuleData(),PricingRuleData.class);
				MenuPricingResponse responseList = getMenuItemRecordsForRule(ruleData.getMenuItem(),ruleRequest,brandId);
				if(responseList.getCount() == 0){
					response = new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),false,"There are no records present for the associated rule criteria");
				}else{
					response = updateMenuTierPrice(ruleRequest,brandId,responseList,pricingRule,userName);
					logger.info("update rulescenariopricing table");
					if(response.isRuleApplied()){
						updateScenarioPricing(ruleRequest,brandId);
					}
				}
			}else{
				PricingRuleData ruleData = new ObjectMapper().readValue(pricingRule.getRuleData(),PricingRuleData.class);
				StoreTierResponse responseList = getStoreTierRecordsForRule(ruleData.getStoreTier(),ruleRequest,brandId);

				if(responseList.getCount() == 0){
					response= new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),false,"There are no records present for the associated rule type criteria");
				}else{
					response = updateStoreTier(ruleRequest,brandId,responseList,pricingRule,userName);
					logger.info("update rulescenariopricing table");
					if(response.isRuleApplied()){
						updateScenarioPricing(ruleRequest,brandId);
					}
				}
			}
		}catch(Exception ex){
			response = new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),false,"Exception occured while processing the Rule");
		}
		return response;
	}

	



	private ApplyRulesStatusResponse updateStoreTier(ApplyRuleRequest ruleRequest, int brandId,StoreTierResponse responseList, ScenarioPricingRule pricingRule,
			String userName) {
	
		try{
			for(StoreTierVo storeTierVo : responseList.getStoreTier()){
				UpdateStoreInfoRequest updateStoreInfoRequest = new UpdateStoreInfoRequest();
				updateStoreInfoRequest.setBrandId(brandId); 
				updateStoreInfoRequest.setProject_Id(ruleRequest.getProjectId());
				updateStoreInfoRequest.setScenario_Id(ruleRequest.getScenarioId());
				updateStoreInfoRequest.setProposedTier(pricingRule.getTierUpdate());
				if(pricingRule.getTierUpdate().equalsIgnoreCase(storeTierVo.getCurrent_Tier())){
					continue;
				}
				if(!ruleRequest.isApplied() || ruleRequest.isDeleted()){
					if(!pricingRule.getTierUpdate().equalsIgnoreCase(storeTierVo.getProposed_Tier())){
						continue;
					}
					updateStoreInfoRequest.setProposedTier(storeTierVo.getCurrent_Tier());
				}
				updateStoreInfoRequest.setStoreCode(storeTierVo.getStore_Code());
				menuPricingDAO.updateStoreTier(updateStoreInfoRequest, userName);
			}
			
		}catch(Exception ex){
			logger.info("Excption occured while updating Menu Tier Price");
			return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),false,"Exception occured while applying rule to data");
		}
		if(!ruleRequest.isApplied()){
			return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),true,"Rule reverted successfully ");
		}
		return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),true,"Rule applied successfully to data");
	}

	private ApplyRulesStatusResponse updateMenuTierPrice(ApplyRuleRequest ruleRequest, int brandId, MenuPricingResponse responseList,ScenarioPricingRule pricingRule,
			String userName) {
		
		try{
			for(MenuPricingVo menuPricingVo : responseList.getMenuPrice()){
				RequestMenuTierPriceUpdate menuTierPriceUpdateReq = new RequestMenuTierPriceUpdate();
				menuTierPriceUpdateReq.setBrandId(brandId);
				menuTierPriceUpdateReq.setScenario_Id(ruleRequest.getScenarioId());
				menuTierPriceUpdateReq.setProject_Id(ruleRequest.getProjectId());
				menuTierPriceUpdateReq.setProductId(menuPricingVo.getProduct_ID());
				//menuTierPriceUpdateReq.setPrice(Double.valueOf(pricingRule.getPriceChange().toString()));
				
				if(!ruleRequest.isApplied() || ruleRequest.isDeleted()){
					if(pricingRule.isPriceChangeByPercentage()){
						Double priceChange = ((menuPricingVo.getCurrent_Price()*pricingRule.getPriceChange())/100);
						Double newPrice = menuPricingVo.getCurrent_Price() + priceChange;
						if(newPrice != menuPricingVo.getNew_Price()){
							continue;
						}
					}else{
						if(menuPricingVo.getNew_Price()!=menuPricingVo.getCurrent_Price()+pricingRule.getPriceChange()){
							continue;
						}
					}
					menuTierPriceUpdateReq.setPrice(Double.valueOf(menuPricingVo.getCurrent_Price()));
				}
				if(menuPricingVo.getCurrent_Price()!= menuPricingVo.getNew_Price() && ruleRequest.isApplied() && !ruleRequest.isDeleted()){
					if(pricingRule.isPriceChangeByPercentage()){
						Double priceChange = ((menuPricingVo.getCurrent_Price()*pricingRule.getPriceChange())/100);
						Double newPrice = menuPricingVo.getCurrent_Price() + priceChange;
						menuTierPriceUpdateReq.setPrice(newPrice);
					}else{
						menuTierPriceUpdateReq.setPrice(menuPricingVo.getCurrent_Price()+Double.valueOf(pricingRule.getPriceChange().toString()));
					}
				}
				//menuTierPriceUpdateReq.setPrice(menuPricingVo.getCurrent_Price()+Double.valueOf(pricingRule.getPriceChange().toString()));
				
				menuTierPriceUpdateReq.setTier(menuPricingVo.getProposed_Tier());
				menuPricingDAO.updateMenuTierPrice(menuTierPriceUpdateReq, userName);
			}
		}catch(Exception ex){
			logger.info("Excption occured while updating Menu Tier Price");
			return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),false,"Exception occured while applying rule to data");
		}
		if(!ruleRequest.isApplied()){
			return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),true,"Rule reverted successfully ");
		}
		return new ApplyRulesStatusResponse(ruleRequest.getRuleId(),pricingRule.getRuleName(),true,"Rule applied successfully to data");
		
	}

	private MenuPricingResponse getMenuItemRecordsForRule(MenuItem menuItem,ApplyRuleRequest ruleRequest, int brandId) {
		
		MenuPricingResponse response = new MenuPricingResponse();
		response.setCount(0);
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[MenuitemSelectProcForSearch]");
		
		query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
		query.setParameter(0, 0);
		query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
		query.setParameter(1, 100000);
		
		if(menuItem!=null && menuItem.getCat1()!=null && !(menuItem.getCat1().isEmpty())){
			query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
			query.setParameter(2, menuItem.getCat1());
		}else{
			query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
			query.setParameter(2, null);
		}
		if(menuItem!=null && menuItem.getCat2()!=null && !(menuItem.getCat2().isEmpty())){
			query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
			query.setParameter(3, menuItem.getCat2());
		}else{
			query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
			query.setParameter(3, null);
		}
		if(menuItem!=null && menuItem.getCat3()!=null && !(menuItem.getCat3().isEmpty())){
			query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
			query.setParameter(4, menuItem.getCat1());
		}else{
			query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
			query.setParameter(4, null);
		}
		if(menuItem!=null && menuItem.getTier()!=null && !(menuItem.getTier().isEmpty())){
			query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
			query.setParameter(5, menuItem.getTier());
		}else{
			query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
			query.setParameter(5, null);
		}
		if(menuItem!=null && menuItem.getPriceSensitivity()!=null && !(menuItem.getPriceSensitivity().isEmpty())){
			query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
			query.setParameter(6, menuItem.getPriceSensitivity());
		}else{
			query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
			query.setParameter(6, null);
		}
		query.registerStoredProcedureParameter(7, String.class , ParameterMode.IN);
		query.setParameter(7, "Product_ID");
		
		query.registerStoredProcedureParameter(8, String.class , ParameterMode.IN);
		query.setParameter(8, "ASC");
		
		query.registerStoredProcedureParameter(9, BigInteger.class , ParameterMode.IN);
		query.setParameter(9, ruleRequest.getScenarioId());

		query.registerStoredProcedureParameter(10, BigInteger.class , ParameterMode.IN);
		query.setParameter(10, ruleRequest.getProjectId());

		query.registerStoredProcedureParameter(11, Integer.class , ParameterMode.IN);
		query.setParameter(11, brandId);
		
		query.execute();
		
		List<Object[]> rows = query.getResultList();
		
		if(rows!=null&&rows.size()>0){
			List<MenuPricingVo> result = new ArrayList<MenuPricingVo>(rows.size());
			for (Object[] row : rows) {
				result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4], (Double)row[5],(String)row[6]));
			}
			Integer count = (Integer)(rows.get(0))[7];
			response.setCount(count);
			response.setMenuPrice(result);
		}
		return response;
		
	}
	
	private StoreTierResponse getStoreTierRecordsForRule(StoreTier storeTier,ApplyRuleRequest ruleRequest, int brandId) {
		
		StoreTierResponse response = new StoreTierResponse();
		response.setCount(0);
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[StoreTierViewProcForSearch]");
		
		query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
		query.setParameter(0, 0);
		query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
		query.setParameter(1, 100000);
		if(storeTier!=null && storeTier.getCurrentTier()!=null && !(storeTier.getCurrentTier().isEmpty())){
			query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
			query.setParameter(2, storeTier.getCurrentTier());
		}else{
			query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
			query.setParameter(2, null);
		}
		if(storeTier!=null && storeTier.getStoreSensitivity()!=null && !(storeTier.getStoreSensitivity().isEmpty())){
			query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
			query.setParameter(3, storeTier.getStoreSensitivity());
		}else{
			query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
			query.setParameter(3, null);
		}
		if(storeTier!=null && storeTier.getPricingPower()!=null && !(storeTier.getPricingPower().isEmpty())){
			query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
			query.setParameter(4, storeTier.getPricingPower());
		}else{
			query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
			query.setParameter(4, null);
		}
		query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
		query.setParameter(5, "Store_Code");
		query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
		query.setParameter(6, "ASC");
		query.registerStoredProcedureParameter(7, BigInteger.class , ParameterMode.IN);
		query.setParameter(7, ruleRequest.getScenarioId());
		query.registerStoredProcedureParameter(8, BigInteger.class , ParameterMode.IN);
		query.setParameter(8, ruleRequest.getProjectId());
		query.registerStoredProcedureParameter(9, Integer.class , ParameterMode.IN);
		query.setParameter(9, brandId);
		
		query.execute();
		
		List<Object[]> rows = query.getResultList();
		
		
		if(rows!=null&&rows.size()>0){
			List<StoreTierVo> result = new ArrayList<StoreTierVo>(rows.size());
			for (Object[] row : rows) {
				result.add(new StoreTierVo((Integer)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]));
			}
			Integer count = (Integer)(rows.get(0))[5];
			response.setCount(count);
			response.setStoreTier(result);
		}
		
		return response;
	}

	@Override
	public List<ApplyRulesStatusResponse> deleteRules(int brandId,List<ApplyRuleRequest> deleteRules, String userName) {
		
		List<ApplyRulesStatusResponse> applyRulesResponseList = new ArrayList<ApplyRulesStatusResponse>();
		
		try {
				applyRulesResponseList  = revertRules(brandId, deleteRules, userName);
		} catch (Exception e) {
			logger.info("Excption occured while reverting rule ");
			applyRulesResponseList.add(new ApplyRulesStatusResponse(deleteRules.get(0).getRuleId(),applyRulesResponseList.get(0).getRuleName(),false,"Exception occured while deleting rule "));
			return applyRulesResponseList;
		}
		
			
			ApplyRuleRequest applyRuleRequest = deleteRules.get(0);
				try{
					StringBuilder sb =  new StringBuilder("UPDATE ScenarioPricingRule SET IsDeleted=:is_Deleted where BrandId=:brand_Id and RuleId=:rule_Id and ScenarioId=:scenario_Id");
					Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
					query.setParameter("brand_Id", brandId);
					query.setParameter("scenario_Id", applyRuleRequest.getScenarioId());
					query.setParameter("is_Deleted", applyRuleRequest.isDeleted());
					query.setParameter("rule_Id", applyRuleRequest.getRuleId());
					query.executeUpdate();
				}catch(Exception ex){
					applyRulesResponseList.add(new ApplyRulesStatusResponse(deleteRules.get(0).getRuleId(),applyRulesResponseList.get(0).getRuleName(),false,"Exception occured while deleting rule "));
					return applyRulesResponseList;
				}
	
	
		List<ApplyRulesStatusResponse> applyRulesResponseSuccessList = new ArrayList<ApplyRulesStatusResponse>();
		applyRulesResponseSuccessList.add(new ApplyRulesStatusResponse(deleteRules.get(0).getRuleId(),applyRulesResponseList.get(0).getRuleName(),true,"Rule deleted successfully"));
		return applyRulesResponseSuccessList;
	}
	
	
	private void updateScenarioPricing(ApplyRuleRequest applyRuleRequest, int brandId) {
			
				StringBuilder sb =  new StringBuilder("UPDATE ScenarioPricingRule SET IsApplied=:is_Applied where BrandId=:brand_Id and RuleId=:rule_Id and ScenarioId=:scenario_Id");
				Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
				query.setParameter("brand_Id", brandId);
				query.setParameter("scenario_Id", applyRuleRequest.getScenarioId());
				query.setParameter("is_Applied", applyRuleRequest.isApplied());
				query.setParameter("rule_Id", applyRuleRequest.getRuleId());
				query.executeUpdate();
			
	}
	
}
