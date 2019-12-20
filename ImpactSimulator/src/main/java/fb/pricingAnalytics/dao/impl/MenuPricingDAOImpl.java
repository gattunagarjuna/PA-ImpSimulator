package fb.pricingAnalytics.dao.impl;

import java.math.BigDecimal;
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
import org.springframework.stereotype.Repository;

import fb.pricingAnalytics.dao.MenuPricingDAO;
import fb.pricingAnalytics.model.vo.FilterData;
import fb.pricingAnalytics.model.vo.MenuItemDistributionVo;
import fb.pricingAnalytics.model.vo.MenuPricingVo;
import fb.pricingAnalytics.model.vo.OverAllImpactsVo;
import fb.pricingAnalytics.model.vo.StoreDistributionVo;
import fb.pricingAnalytics.model.vo.StoreTierVo;
import fb.pricingAnalytics.request.RequestMenuTierPriceUpdate;
import fb.pricingAnalytics.request.RequestPricePlanner;
import fb.pricingAnalytics.request.UpdateStoreInfoRequest;
import fb.pricingAnalytics.response.MenuPricingResponse;
import fb.pricingAnalytics.response.StoreTierResponse;
import fb.pricingAnalytics.utils.FBRestResponse;


@Repository
public class MenuPricingDAOImpl implements MenuPricingDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override 
	public MenuPricingResponse getMenuPricing( RequestPricePlanner requestPricePlanner)  throws SQLException,Exception{
		MenuPricingResponse response = new MenuPricingResponse();
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[MenuitemSelectProc]");
		if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
			if(requestPricePlanner.getPaging().getPageNo()>0&&requestPricePlanner.getPaging().getPageSize()>0){
				query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
				query.setParameter(0, (requestPricePlanner.getPaging().getPageNo()-1)* requestPricePlanner.getPaging().getPageSize());
				query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
				query.setParameter(1, requestPricePlanner.getPaging().getPageSize());
				// etc.
			}
		}
		
			if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getCat1()!=null){
				query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
				query.setParameter(2, requestPricePlanner.getSearch().getCat1());
			}else{
				query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
				query.setParameter(2, null);
			}if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getCat2()!=null){
				query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
				query.setParameter(3, requestPricePlanner.getSearch().getCat2());
			}else{
				query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
				query.setParameter(3, null);
			}if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getTier()!=null){
				query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
				query.setParameter(4, requestPricePlanner.getSearch().getTier());
			}else{
				query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
				query.setParameter(4, null);
			}/*if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getTier_Change()!=null){
				query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
				query.setParameter(5, requestPricePlanner.getSearch().getTier_Change());
			}else{
				query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
				query.setParameter(5, null);
			}*//*if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getPrice_Sensitivity()!=null){
				query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
				query.setParameter(6, requestPricePlanner.getSearch().getPrice_Sensitivity());
			}else{
				query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
				query.setParameter(6, null);
			}*/
		
			if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getProduct_Price_Sensitivity()!=null){
				query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
				query.setParameter(5, requestPricePlanner.getSearch().getProduct_Price_Sensitivity());
			}else{
				query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
				query.setParameter(5, null);
			}
			
	
			if(requestPricePlanner.getSort()!=null && requestPricePlanner.getSort().getField()!=null){
					query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
					query.setParameter(6, requestPricePlanner.getSort().getField());
			}else {
				query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
				query.setParameter(6, "Product_Name");
			}
			
			
			if(requestPricePlanner.getSort()!=null && requestPricePlanner.getSort().getDirection()!=null){
				query.registerStoredProcedureParameter(7, String.class , ParameterMode.IN);
				query.setParameter(7, requestPricePlanner.getSort().getDirection());
			}else {
				query.registerStoredProcedureParameter(7, String.class , ParameterMode.IN);
				query.setParameter(7, "ASC");
			}
		
		
			query.registerStoredProcedureParameter(8, BigInteger.class , ParameterMode.IN);
			query.setParameter(8, requestPricePlanner.getScenario_Id());
		
	
			query.registerStoredProcedureParameter(9, BigInteger.class , ParameterMode.IN);
			query.setParameter(9, requestPricePlanner.getProject_Id());
	
	
			query.registerStoredProcedureParameter(10, Integer.class , ParameterMode.IN);
			query.setParameter(10, requestPricePlanner.getBrandId());
	
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		if(rows!=null&&rows.size()>0){
			List<MenuPricingVo> result = new ArrayList<MenuPricingVo>(rows.size());
			for (Object[] row : rows) {
			    /*result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5],(String)row[6],
			    		(String)row[7],(String)row[8],(Double)row[9],(Double)row[10],(Double)row[11],(BigDecimal)row[12],(Double)row[13],(Double)row[14],
			    		(Double)row[15],(Double)row[16],(BigInteger)row[17]));*/
				
				result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5],(String)row[6],
			    		(Double)row[7],(Double)row[8],(Double)row[9],(BigDecimal)row[10],(Double)row[11],(Double)row[12],
			    		(Double)row[13],(Double)row[14],(BigInteger)row[15]));
			  
			}
			Integer count = (Integer)(rows.get(0))[16];
			response.setCount(count);
			response.setMenuPrice(result);
		}
		
		return response;
	}


	@Override
	public int updateMenuTierPrice(RequestMenuTierPriceUpdate requestMenuTier, String userName) throws SQLException, Exception {
		StringBuilder sb =  new StringBuilder ("UPDATE ISTProductTierInfo as IST SET IST.price =:price, IST.updatedOn =:lastUpdated_date, IST.updatedBy =:lastUpdated_by WHERE IST.projectId=:project_Id and IST.scenarioId=:scenario_Id and IST.brandId=:brand_Id and IST.productId =:product_id AND IST.tier =:tier");
		
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("price",requestMenuTier.getPrice());	
		query.setParameter("product_id",requestMenuTier.getProductId());
		query.setParameter("tier",requestMenuTier.getTier());	
		query.setParameter("lastUpdated_date",Date.from(Instant.now()));
		query.setParameter("lastUpdated_by",userName);	
		query.setParameter("project_Id",requestMenuTier.getProject_Id());	
		query.setParameter("scenario_Id", requestMenuTier.getScenario_Id());
		query.setParameter("brand_Id", requestMenuTier.getBrandId());
		int resultObjects = query.executeUpdate();
		return resultObjects;
	}


	@Override
	public StoreTierResponse getStoreTierView(RequestPricePlanner requestPricePlanner) throws SQLException, Exception {
		
		StoreTierResponse response = new StoreTierResponse();
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[StoreTierViewProc]");
		
		
				if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
					if(requestPricePlanner.getPaging().getPageNo()>-1){
						query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
						query.setParameter(0, (requestPricePlanner.getPaging().getPageNo()-1)* requestPricePlanner.getPaging().getPageSize());
						// etc.
					}
			
					if(requestPricePlanner.getPaging().getPageSize()>0){
						query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
						query.setParameter(1, requestPricePlanner.getPaging().getPageSize());
					}
				}

				if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getCurrent_Tier()!=null){
					query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
					query.setParameter(2, requestPricePlanner.getSearch().getCurrent_Tier());
				}else{
					query.registerStoredProcedureParameter(2, String.class , ParameterMode.IN);
					query.setParameter(2, null);
				}
				if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getStore_Sensitivity()!=null){
					query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
					query.setParameter(3, requestPricePlanner.getSearch().getStore_Sensitivity());
				}else{
					query.registerStoredProcedureParameter(3, String.class , ParameterMode.IN);
					query.setParameter(3, null);
				}
				if(requestPricePlanner.getSearch()!=null && requestPricePlanner.getSearch().getPricing_Power()!=null){
					query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
					query.setParameter(4, requestPricePlanner.getSearch().getPricing_Power());
				}else{
					query.registerStoredProcedureParameter(4, String.class , ParameterMode.IN);
					query.setParameter(4, null);
				}
		
				if(requestPricePlanner.getSort()!=null && requestPricePlanner.getSort().getField()!=null){
						query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
						query.setParameter(5, requestPricePlanner.getSort().getField());
				}else{
					query.registerStoredProcedureParameter(5, String.class , ParameterMode.IN);
					query.setParameter(5, "Store_Code");
				}
				
				if(requestPricePlanner.getSort()!=null && requestPricePlanner.getSort().getDirection()!=null){
					query.registerStoredProcedureParameter(6, String.class , ParameterMode.IN);
					query.setParameter(6, requestPricePlanner.getSort().getDirection());
				}else{
					query.registerStoredProcedureParameter(7, String.class , ParameterMode.IN);
					query.setParameter(7, "ASC");
				}
				query.registerStoredProcedureParameter(8, BigInteger.class , ParameterMode.IN);
				query.setParameter(8, requestPricePlanner.getScenario_Id());
			
		
				query.registerStoredProcedureParameter(9, BigInteger.class , ParameterMode.IN);
				query.setParameter(9, requestPricePlanner.getProject_Id());
		
		
				query.registerStoredProcedureParameter(10, Integer.class , ParameterMode.IN);
				query.setParameter(10, requestPricePlanner.getBrandId());
			
		

		query.execute();
		List<Object[]> rows = query.getResultList();
		if(rows!=null&&rows.size()>0){
			List<StoreTierVo> result = new ArrayList<StoreTierVo>(rows.size());
			for (Object[] row : rows) {
			    result.add(new StoreTierVo((String)row[0],(String)row[1], (String)row[2],(String)row[3],(String)row[4],(String)row[5],(Integer)row[6],(String)row[7],
			    		(Double)row[8],(Double)row[9],(Double)row[10],(BigDecimal)row[11],(BigInteger)row[12]));
			}
			Integer count = (Integer)(rows.get(0))[13];
			response.setCount(count);
			response.setStoreTier(result);
		}
		
		return response;
	}


	@Override
	public FBRestResponse updateStoreTier(UpdateStoreInfoRequest updateStoreInfoRequest,String userName)throws SQLException, Exception {
		
		StringBuilder sb =  new StringBuilder ("update IST_Store_Info set  Proposed_Tier=:proposed_Tier,isChanged=:isChanged,"
				+ "CreatedOn=createdOn,UpdatedOn=:updatedOn,UpdatedBy=:updatedBy where BrandId=:brand_Id and Project_Id =:project_Id and Scenario_Id=:scenario_Id and Store_Code =:store_Code");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("proposed_Tier",updateStoreInfoRequest.getProposedTier());	
		query.setParameter("store_Code",updateStoreInfoRequest.getStoreCode());
		query.setParameter("isChanged", true);
		query.setParameter("updatedOn", Date.from(Instant.now()));
		query.setParameter("updatedBy", userName);
		query.setParameter("project_Id",updateStoreInfoRequest.getProject_Id());	
		query.setParameter("scenario_Id", updateStoreInfoRequest.getScenario_Id());
		query.setParameter("brand_Id", updateStoreInfoRequest.getBrandId());
		int resultObjects = query.executeUpdate();
		if(resultObjects >= 1){
			return new FBRestResponse(true, "Store Tier Updated Successfully");
		}
		return new FBRestResponse(false, "There are no records to be updated for the provided store code : "+updateStoreInfoRequest.getStoreCode()+" and proposed tier :"+updateStoreInfoRequest.getProposedTier());
	}


	@Override
	public List<StoreTierVo> getOtherStoreView(RequestPricePlanner requestPricePlanner) throws SQLException,Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[OtherStoreViewProc]");

		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<StoreTierVo> result = new ArrayList<StoreTierVo>(rows.size());
		for (Object[] row : rows) {
		    result.add(new StoreTierVo((String)row[0],(String)row[1], (String)row[2],(String)row[3],(String)row[4],(String)row[5],(Integer)row[6],(String)row[7],
		    		(Double)row[8],(Double)row[9],(Double)row[10],(BigDecimal)row[11],(BigInteger)row[12]));
		}
		return result;
	}


	@Override
	public OverAllImpactsVo getOverAllImpacts(RequestPricePlanner requestPricePlanner) throws SQLException,Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[GetOverallImpacts]");
		
		query.registerStoredProcedureParameter(0, BigInteger.class , ParameterMode.IN);
		query.setParameter(0, requestPricePlanner.getScenario_Id());

		query.registerStoredProcedureParameter(1, BigInteger.class , ParameterMode.IN);
		query.setParameter(1, requestPricePlanner.getProject_Id());

		query.registerStoredProcedureParameter(2, Integer.class , ParameterMode.IN);
		query.setParameter(2, requestPricePlanner.getBrandId());
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		if(rows.size()>0){
			List<OverAllImpactsVo> result = new ArrayList<OverAllImpactsVo>(rows.size());
			for (Object[] row : rows) {
			    //result.add(new OverAllImpactsVo((Double)row[0],(Double)row[1],(Double)row[2],(Double)row[3]));
			    
			    result.add(new OverAllImpactsVo(((long)((Double)row[0] * 1e4)) / 1e4,((long)((Double)row[1] * 1e4)) / 1e4,
			    		((long)((Double)row[2] * 1e4)) / 1e4,((long)((Double)row[3] * 1e4)) / 1e4));
			}
			return (OverAllImpactsVo) result.get(0);
		}else{
			return new OverAllImpactsVo((double)0, (double)0, (double)0, (double)0);
		}
		
	}


	@Override
	public List<StoreDistributionVo> getStoreDistribution(RequestPricePlanner requestPricePlanner)	throws SQLException, Exception {
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[GetStoreDistribution]");

		query.registerStoredProcedureParameter(0, BigInteger.class , ParameterMode.IN);
		query.setParameter(0, requestPricePlanner.getProject_Id());

		query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
		query.setParameter(1, requestPricePlanner.getBrandId());
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<StoreDistributionVo> result = new ArrayList<StoreDistributionVo>(rows.size());
		for (Object[] row : rows) {
		    //result.add(new OverAllImpactsVo((Double)row[0],(Double)row[1],(Double)row[2],(Double)row[3]));
		    
		    result.add(new StoreDistributionVo ((String)row[0],(String)row[1],(BigInteger)row[2]));
		}
		return result;
	
	}


	@Override
	public List<MenuItemDistributionVo> getMenuItemDistribution(RequestPricePlanner requestPricePlanner)throws SQLException, Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[ImpactSimulator].[dbo].[GetMenuItemDistribution]");
		
		query.registerStoredProcedureParameter(0, BigInteger.class , ParameterMode.IN);
		query.setParameter(0, requestPricePlanner.getProject_Id());

		query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
		query.setParameter(1, requestPricePlanner.getBrandId());
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<MenuItemDistributionVo> result = new ArrayList<MenuItemDistributionVo>(rows.size());
		for (Object[] row : rows) {
		    //result.add(new OverAllImpactsVo((Double)row[0],(Double)row[1],(Double)row[2],(Double)row[3]));
		    
		    result.add(new MenuItemDistributionVo ((String)row[0],(BigInteger)row[1],(Integer)row[3],(BigDecimal)row[2]));
		}
		return result;
	}
	
	
	@Override
	public FilterData getFilterData(RequestPricePlanner requestPricePlanner) throws SQLException,Exception {
		FilterData filterData = new FilterData();
		getCat1Data(filterData,requestPricePlanner);
		getCat2Data(filterData,requestPricePlanner);
		getCat3Data(filterData,requestPricePlanner);
		getCurrentTier(filterData,requestPricePlanner);
		getPricingPower(filterData,requestPricePlanner);
		getProductPriceSentivity(filterData,requestPricePlanner);
		getStoreSentivity(filterData,requestPricePlanner);
		//getTierChange(filterData,requestPricePlanner);
		return filterData;
		
		
		
		
	}


	private void getTierChange(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		StringBuilder sb =  new StringBuilder("SELECT distinct "
					+ "(CASE WHEN (spi.Current_Tier = si.proposedTier) THEN 'N' ELSE 'Y' END) AS Tier_Change FROM IST_Store_Product_Info spi LEFT JOIN IST_Store_Info si ON (spi.storeCode = si.storeCode and spi.brandId = si.brandId and spi.projectId = si.projectId)"
					+ "where spi.brandId=:brand_Id and spi.projectId=:project_Id and spi.scenarioId=:scenario_Id");
			
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		query.setParameter("scenario_Id", requestPricePlanner.getScenario_Id());
		List<Object> rows = query.list();
		String[] tierChangeList = rows.stream().toArray(String[]::new);
		filterData.setTier_Change(tierChangeList);
	}


	private void getStoreSentivity(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		//StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (Store_Sensitivity >= 0) THEN 'Low' WHEN (Store_Sensitivity <= -1) THEN 'High' ELSE 'Mod' END) AS Store_Sensitivity from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (Store_Sensitivity >= 0) THEN 'Low' WHEN (Store_Sensitivity <= -1) THEN 'High' ELSE 'Moderate' END) AS Store_Sensitivity from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id =:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] storeSentivityList = rows.stream().toArray(String[]::new);
		filterData.setStore_Sensitivity(storeSentivityList);
	}


	private void getProductPriceSentivity(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		/*StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'ELASTIC') THEN 'High' WHEN (UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'INELASTIC') THEN 'Low' WHEN(UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'MOD') THEN 'Mod' ELSE Product_Price_Sensitivity END) AS Product_Price_Sensitivity "
				+ "from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");*/
		StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'ELASTIC') THEN 'High' WHEN (UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'INELASTIC') THEN 'Low' WHEN (UPPER(LTRIM(RTRIM(Product_Price_Sensitivity))) = 'MOD') THEN 'Moderate' ELSE 'NA' END) AS Product_Price_Sensitivity from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id =:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] prodcutPriceSensitivityList = rows.stream().toArray(String[]::new);
		filterData.setProduct_Price_Sensitivity(prodcutPriceSensitivityList);
		
	}


	private void getPricingPower(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		//StringBuilder sb =  new StringBuilder("select distinct Pricing_Power from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (UPPER(LTRIM(RTRIM(Pricing_Power))) = 'HIGH') THEN 'High' WHEN(UPPER(LTRIM(RTRIM(Pricing_Power))) = 'LOW') THEN 'Low' WHEN(UPPER(LTRIM(RTRIM(Pricing_Power))) = 'MID') THEN 'Moderate' ELSE 'NA' END) as Pricing_Power from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id =:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] pricingPowerList = rows.stream().toArray(String[]::new);
		filterData.setPricing_Power(pricingPowerList);
		
	}


	private void getCurrentTier(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		StringBuilder sb =  new StringBuilder("select distinct Current_Tier from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] currentTiers = rows.stream().toArray(String[]::new);
		filterData.setCurrent_Tier(currentTiers);
		
	}


	private void getCat3Data(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		StringBuilder sb =  new StringBuilder("select distinct Cat3 from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] cat3 = rows.stream().toArray(String[]::new);
		filterData.setCat3(cat3);
		
	}


	private void getCat2Data(FilterData filterData,RequestPricePlanner requestPricePlanner) {

		StringBuilder sb =  new StringBuilder("select distinct Cat2 from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] cat2 = rows.stream().toArray(String[]::new);
		filterData.setCat2(cat2);
		
	}


	private void getCat1Data(FilterData filterData, RequestPricePlanner requestPricePlanner) {

		StringBuilder sb =  new StringBuilder("select distinct Cat1 from IST_Store_Product_Info where BrandId=:brand_Id and Project_Id=:project_Id");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("brand_Id", requestPricePlanner.getBrandId());
		query.setParameter("project_Id", requestPricePlanner.getProject_Id());
		List<Object> rows = query.list();
		String[] cat1 = rows.stream().toArray(String[]::new);
		filterData.setCat1(cat1);
	}
	
	
	@Override
	public List<Object> getFilterData(String filterParam) throws SQLException,Exception {
		
		StringBuilder sb =  new StringBuilder ();
		switch (filterParam){
			
		case ("cat1") :
			sb.append("select distinct Cat1 from vw_store_product_info_temp_ist");
			break;
		case ("cat2") :
			sb.append("select distinct Cat2 from vw_store_product_info_temp_ist");
			break;
		case ("cat3") :
			sb.append("select distinct Cat3 from vw_store_product_info_temp_ist");
			break;
		case ("currenttier") :
			sb.append("select distinct Current_Tier from vw_store_product_info_temp_ist");
			break;
		case ("pricingpower") :
			sb.append("select distinct Pricing_Power from vw_store_product_info_temp_ist");
			break;
		case ("productpricesensitivity") :
			sb.append("select distinct Product_Price_Sensitivity from vw_store_product_info_temp_ist");
			break;
		case ("storesensitivity") :
			sb.append("select distinct (CASE WHEN (Store_Sensitivity >= 0) THEN 'Low' WHEN (Store_Sensitivity <= -1) THEN 'High' ELSE 'Mod' END) AS Store_Sensitivity from vw_store_product_info_temp_ist");
			break;
		case ("tierchange") :
			sb.append("SELECT distinct "
					+ "(CASE WHEN (vspi.Current_Tier = si.proposedTier) THEN 'N' ELSE 'Y' END) AS Tier_Change FROM vw_store_product_info_temp_ist vspi LEFT JOIN IST_Store_Info si ON (vspi.Store_Code = si.storeCode)");
			break;
		default :
				break;
		}
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		return rows;

	}
}
