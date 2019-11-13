package fb.pricingAnalytics.service;

import java.sql.SQLException;
import java.util.List;

import fb.pricingAnalytics.model.vo.FilterData;
import fb.pricingAnalytics.model.vo.MenuItemDistributionVo;
import fb.pricingAnalytics.model.vo.OverAllImpactsVo;
import fb.pricingAnalytics.model.vo.StoreDistributionVo;
import fb.pricingAnalytics.model.vo.StoreTierVo;
import fb.pricingAnalytics.request.RequestMenuTierPriceUpdate;
import fb.pricingAnalytics.request.RequestPricePlanner;
import fb.pricingAnalytics.response.MenuPricingResponse;
import fb.pricingAnalytics.response.StoreTierResponse;
import fb.pricingAnalytics.utils.FBRestResponse;

public interface MenuPricingService {
	
	//public List<MenuPricingVo> getMenuPricing(RequestPricePlanner requestPricePlanner) throws SQLException,Exception;
	public MenuPricingResponse getMenuPricing(RequestPricePlanner requestPricePlanner) throws SQLException,Exception;
	public int updateMenuTierPrice(RequestMenuTierPriceUpdate requestMenuTier, String userName) throws SQLException,Exception;
	//public List<StoreTierVo> getStoreTierView(RequestPricePlanner requestPricePlanner) throws SQLException,Exception;
	public StoreTierResponse getStoreTierView(RequestPricePlanner requestPricePlanner) throws SQLException,Exception;
	public FBRestResponse updateStoreTier(String storeCode, Integer proposedTier, String userName)throws SQLException, Exception;
	List<StoreTierVo> getOtherStoreView(RequestPricePlanner requestPricePlanner) throws SQLException, Exception;
	public OverAllImpactsVo getOverAllImpacts()throws SQLException, Exception;
	public List<StoreDistributionVo> getStoreDistribution()throws SQLException, Exception;
	public List<MenuItemDistributionVo> getMenuItemDistribution()throws SQLException, Exception;
	public FilterData getFilterData()throws SQLException, Exception;
	public List<Object> getFilterData(String filterParam)throws SQLException, Exception;
}
