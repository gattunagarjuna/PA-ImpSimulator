package fb.pricingAnalytics.request;

import java.math.BigInteger;

import fb.pricingAnalytics.model.vo.MenuItem;
import fb.pricingAnalytics.model.vo.StoreTier;

public class PricingRuleRequest {
	
	private BigInteger projectId;
	private String type;
	private Double priceChange;
	private String tierUpdate;
	private MenuItem menuItem;
	private StoreTier storeTier;
	
	public BigInteger getProjectId() {
		return projectId;
	}
	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(Double priceChange) {
		this.priceChange = priceChange;
	}
	public String getTierUpdate() {
		return tierUpdate;
	}
	public void setTierUpdate(String tierUpdate) {
		this.tierUpdate = tierUpdate;
	}
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	public StoreTier getStoreTier() {
		return storeTier;
	}
	public void setStoreTier(StoreTier storeTier) {
		this.storeTier = storeTier;
	}
	
	
}
