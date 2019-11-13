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
import fb.pricingAnalytics.response.MenuPricingResponse;
import fb.pricingAnalytics.response.StoreTierResponse;
import fb.pricingAnalytics.utils.FBRestResponse;


@Repository
public class MenuPricingDAOImpl implements MenuPricingDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	
	/*@Override 
	public List<MenuPricingVo> getMenuPricing( RequestPricePlanner requestPricePlanner)  throws SQLException,Exception{
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[MenuitemSelectProc]");
		query.execute();
		int count = query.getResultList().size();
		if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
			if(requestPricePlanner.getPaging().getPageNo()>0&&requestPricePlanner.getPaging().getPageSize()>0){
				query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
				query.setParameter(0, (requestPricePlanner.getPaging().getPageNo()-1)* requestPricePlanner.getPaging().getPageSize());
				query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
				query.setParameter(1, requestPricePlanner.getPaging().getPageSize());
				// etc.
			}
	
			
			
		}
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<MenuPricingVo> result = new ArrayList<MenuPricingVo>(rows.size());
		for (Object[] row : rows) {
		    result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5],(String)row[6],
		    		(String)row[7],(String)row[8],(Double)row[9],(Double)row[10],(Double)row[11],(BigDecimal)row[12],(Double)row[13],(Double)row[14],
		    		(Double)row[15],(Double)row[16],(BigInteger)row[17]));
		}
		return result;
	}
*/

	
	@Override 
	public MenuPricingResponse getMenuPricing( RequestPricePlanner requestPricePlanner)  throws SQLException,Exception{
		
		MenuPricingResponse response = new MenuPricingResponse();
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[MenuitemSelectProc]");
		query.execute();
		int count = query.getResultList().size();
		response.setCount(count);

		if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
			if(requestPricePlanner.getPaging().getPageNo()>0&&requestPricePlanner.getPaging().getPageSize()>0){
				StoredProcedureQuery pagingQuery = entityManager
						.createStoredProcedureQuery("[Simulator].[dbo].[MenuitemSelectProc]");
				pagingQuery.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
				pagingQuery.setParameter(0, (requestPricePlanner.getPaging().getPageNo()-1)* requestPricePlanner.getPaging().getPageSize());
				pagingQuery.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
				pagingQuery.setParameter(1, requestPricePlanner.getPaging().getPageSize());
				pagingQuery.execute();
				List<Object[]> pagingRows = pagingQuery.getResultList();
				List<MenuPricingVo> result = new ArrayList<MenuPricingVo>(pagingRows.size());
				for (Object[] row : pagingRows) {
				    result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5],(String)row[6],
				    		(String)row[7],(String)row[8],(Double)row[9],(Double)row[10],(Double)row[11],(BigDecimal)row[12],(Double)row[13],(Double)row[14],
				    		(Double)row[15],(Double)row[16],(BigInteger)row[17]));
				}
				response.setMenuPrice(result);
				return response;
			}
		}

		List<Object[]> rows = query.getResultList();
		List<MenuPricingVo> result = new ArrayList<MenuPricingVo>(rows.size());
		for (Object[] row : rows) {
		    result.add(new MenuPricingVo((String)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5],(String)row[6],
		    		(String)row[7],(String)row[8],(Double)row[9],(Double)row[10],(Double)row[11],(BigDecimal)row[12],(Double)row[13],(Double)row[14],
		    		(Double)row[15],(Double)row[16],(BigInteger)row[17]));
		}
		response.setMenuPrice(result);
		return response;
	}

	
	
	@Override
	public int updateMenuTierPrice(RequestMenuTierPriceUpdate requestMenuTier, String userName) throws SQLException, Exception {
		StringBuilder sb =  new StringBuilder ("UPDATE ISTProductTierInfo as IST SET IST.price =:price, IST.updatedOn =:lastUpdated_date, IST.updatedBy =:lastUpdated_by WHERE IST.productId =:product_id AND IST.tier =:tier");
		
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("price",requestMenuTier.getPrice());	
		query.setParameter("product_id",requestMenuTier.getProductId());
		query.setParameter("tier",requestMenuTier.getTier());	
		query.setParameter("lastUpdated_date",Date.from(Instant.now()));
		query.setParameter("lastUpdated_by",userName);	

		int resultObjects = query.executeUpdate();
		return resultObjects;
	}


	/*@Override
	public List<StoreTierVo> getStoreTierView(RequestPricePlanner requestPricePlanner) throws SQLException, Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[StoreTierViewProc]");
		if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
			if(requestPricePlanner.getPaging().getPageNo()>-1){
				query.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
				query.setParameter(0, requestPricePlanner.getPaging().getPageNo());
				// etc.
			}
	
			if(requestPricePlanner.getPaging().getPageSize()>0){
				query.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
				query.setParameter(1, requestPricePlanner.getPaging().getPageSize());
			}
			
		}
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<StoreTierVo> result = new ArrayList<StoreTierVo>(rows.size());
		for (Object[] row : rows) {
		    result.add(new StoreTierVo((String)row[0],(String)row[1], (String)row[2],(String)row[3],(String)row[4],(String)row[5],(Integer)row[6],(String)row[7],
		    		(Double)row[8],(Double)row[9],(Double)row[10],(BigDecimal)row[11],(BigInteger)row[12]));
		}
		return result;
	}*/
	
	
	@Override
	public StoreTierResponse getStoreTierView(RequestPricePlanner requestPricePlanner) throws SQLException, Exception {
		
		StoreTierResponse response = new StoreTierResponse();
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[StoreTierViewProc]");
		query.execute();
		int count = query.getResultList().size();
		response.setCount(count);
		if(requestPricePlanner!=null&&requestPricePlanner.getPaging()!=null){
			if(requestPricePlanner.getPaging().getPageNo()>-1 && requestPricePlanner.getPaging().getPageSize()>0){
				StoredProcedureQuery pagingQuery = entityManager
						.createStoredProcedureQuery("[Simulator].[dbo].[StoreTierViewProc]");
				pagingQuery.registerStoredProcedureParameter(0, Integer.class , ParameterMode.IN);
				pagingQuery.setParameter(0, requestPricePlanner.getPaging().getPageNo());
				pagingQuery.registerStoredProcedureParameter(1, Integer.class , ParameterMode.IN);
				pagingQuery.setParameter(1, requestPricePlanner.getPaging().getPageSize());
				pagingQuery.execute();
				List<Object[]> pagingRows = pagingQuery.getResultList();
				
				List<StoreTierVo> result = new ArrayList<StoreTierVo>(pagingRows.size());
				for (Object[] row : pagingRows) {
				    result.add(new StoreTierVo((String)row[0],(String)row[1], (String)row[2],(String)row[3],(String)row[4],(String)row[5],(Integer)row[6],(String)row[7],
				    		(Double)row[8],(Double)row[9],(Double)row[10],(BigDecimal)row[11],(BigInteger)row[12]));
				}
				response.setStoreTier(result);
				return response;
			}
				
		}
		
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<StoreTierVo> result = new ArrayList<StoreTierVo>(rows.size());
		for (Object[] row : rows) {
		    result.add(new StoreTierVo((String)row[0],(String)row[1], (String)row[2],(String)row[3],(String)row[4],(String)row[5],(Integer)row[6],(String)row[7],
		    		(Double)row[8],(Double)row[9],(Double)row[10],(BigDecimal)row[11],(BigInteger)row[12]));
		}
		return response;
	}
	
	


	@Override
	public FBRestResponse updateStoreTier(String proposedTier, Integer storeCode,String userName)throws SQLException, Exception {
		
		StringBuilder sb =  new StringBuilder ("update IST_Store_Info set  Proposed_Tier=:proposedTier,isChanged=:isChanged,"
				+ "CreatedOn=createdOn,UpdatedOn=:updatedOn,UpdatedBy=:updatedBy where Store_Code =:storeCode");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		query.setParameter("proposedTier",proposedTier);	
		query.setParameter("storeCode",storeCode);
		query.setParameter("isChanged", true);
		query.setParameter("updatedOn", Date.from(Instant.now()));
		query.setParameter("updatedBy", userName);
		int resultObjects = query.executeUpdate();
		if(resultObjects >= 1){
			return new FBRestResponse(true, "Store Tier Updated Successfully");
		}
		return new FBRestResponse(false, "There are no records to be updated for the provided store code : "+storeCode+" and proposed tier :"+proposedTier);
	}


	@Override
	public List<StoreTierVo> getOtherStoreView(RequestPricePlanner requestPricePlanner) throws SQLException,Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[OtherStoreViewProc]");

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
	public OverAllImpactsVo getOverAllImpacts() throws SQLException,Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[GetOverallImpacts]");
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<OverAllImpactsVo> result = new ArrayList<OverAllImpactsVo>(rows.size());
		for (Object[] row : rows) {
		    //result.add(new OverAllImpactsVo((Double)row[0],(Double)row[1],(Double)row[2],(Double)row[3]));
		    
		    result.add(new OverAllImpactsVo(((long)((Double)row[0] * 1e4)) / 1e4,((long)((Double)row[1] * 1e4)) / 1e4,
		    		((long)((Double)row[2] * 1e4)) / 1e4,((long)((Double)row[3] * 1e4)) / 1e4));
		}
		return (OverAllImpactsVo) result.get(0);
	}


	@Override
	public List<StoreDistributionVo> getStoreDistribution()	throws SQLException, Exception {
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[GetStoreDistribution]");
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
	public List<MenuItemDistributionVo> getMenuItemDistribution()throws SQLException, Exception {
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("[Simulator].[dbo].[GetMenuItemDistribution]");
		query.execute();
		List<Object[]> rows = query.getResultList();
		
		List<MenuItemDistributionVo> result = new ArrayList<MenuItemDistributionVo>(rows.size());
		for (Object[] row : rows) {
		    //result.add(new OverAllImpactsVo((Double)row[0],(Double)row[1],(Double)row[2],(Double)row[3]));
		    
		    result.add(new MenuItemDistributionVo ((String)row[0],(BigInteger)row[1]));
		}
		return result;
	}
	
	
	@Override
	public FilterData getFilterData() throws SQLException,Exception {
		FilterData filterData = new FilterData();
		getCat1Data(filterData);
		getCat2Data(filterData);
		getCat3Data(filterData);
		getCurrentTier(filterData);
		getPricingPower(filterData);
		getProductPriceSentivity(filterData);
		getStoreSentivity(filterData);
		getTierChange(filterData);
		return filterData;
		
		
		
		
	}


	private void getTierChange(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("SELECT distinct "
					+ "(CASE WHEN (spi.Current_Tier = si.proposedTier) THEN 'N' ELSE 'Y' END) AS Tier_Change FROM vw_store_product_info_temp_ist spi LEFT JOIN IST_Store_Info si ON (spi.Store_Code = si.storeCode)");
			
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] tierChangeList = rows.stream().toArray(String[]::new);
		filterData.setTier_Change(tierChangeList);
	}


	private void getStoreSentivity(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct (CASE WHEN (Store_Sensitivity >= 0) THEN 'Low' WHEN (Store_Sensitivity <= -1) THEN 'High' ELSE 'Mod' END) AS Store_Sensitivity from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] storeSentivityList = rows.stream().toArray(String[]::new);
		filterData.setStore_Sensitivity(storeSentivityList);
	}


	private void getProductPriceSentivity(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Product_Price_Sensitivity from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] prodcutPriceSensitivityList = rows.stream().toArray(String[]::new);
		filterData.setProduct_Price_Sensitivity(prodcutPriceSensitivityList);
		
	}


	private void getPricingPower(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Pricing_Power from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] pricingPowerList = rows.stream().toArray(String[]::new);
		filterData.setPricing_Power(pricingPowerList);
		
	}


	private void getCurrentTier(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Current_Tier from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] currentTiers = rows.stream().toArray(String[]::new);
		filterData.setCurrent_Tier(currentTiers);
		
	}


	private void getCat3Data(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Cat3 from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] cat3 = rows.stream().toArray(String[]::new);
		filterData.setCat3(cat3);
		
	}


	private void getCat2Data(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Cat2 from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
		List<Object> rows = query.list();
		String[] cat2 = rows.stream().toArray(String[]::new);
		filterData.setCat2(cat2);
		
	}


	private void getCat1Data(FilterData filterData) {

		StringBuilder sb =  new StringBuilder("select distinct Cat1 from vw_store_product_info_temp_ist");
		Query query = entityManager.unwrap(Session.class).createQuery(sb.toString());
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
