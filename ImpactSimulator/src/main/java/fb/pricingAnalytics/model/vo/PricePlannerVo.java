package fb.pricingAnalytics.model.vo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PricePlannerVo {
	
	
	private BigInteger id;
	private Integer brandId;
	private String name;
	private Integer status;
	private Boolean deleted;
	private Date createdOn;
	private String createdBy;
	private Date updatedOn;
	private String updatedBy;
	private BigInteger dataEntryId;
	
	@JsonIgnore
	private BigInteger scenarioId;
	@JsonIgnore
	private String scenarioName;
	@JsonIgnore
	private Date scenarioCreatedOn;
	@JsonIgnore
	private String scenarioCreatedBy;
	@JsonIgnore
	private Date scenarioUpdatedOn;
	@JsonIgnore
	private String scenarioUpdatedBy;
	@JsonIgnore
	private Boolean scenarioDeleted;
	

	private List<ScenarioVo> scenarioList;
	
	public PricePlannerVo() {
		super();
	}


	public PricePlannerVo(BigInteger id, Integer brandId, String name, Integer status, boolean deleted, Date createdOn, String createdBy,
			Date updatedOn, String updatedBy,BigInteger dataEntryId) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
		this.dataEntryId = dataEntryId;
	}


	public PricePlannerVo(BigInteger id, Integer brandId, String name, Integer status, boolean deleted, Date createdOn, String createdBy,
			Date updatedOn, String updatedBy, BigInteger scenarioId, String scenarioName, Date scenarioCreatedOn, String scenarioCreatedBy,
			Date scenarioUpdatedOn, String scenarioUpdatedBy) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
		this.scenarioId = scenarioId;
		this.scenarioName = scenarioName;
		if(scenarioCreatedOn!=null) {
		this.scenarioCreatedOn = scenarioCreatedOn;
		}
		this.scenarioCreatedBy = scenarioCreatedBy;
		if(scenarioUpdatedOn!=null) {
		this.scenarioUpdatedOn = scenarioUpdatedOn;
		}
		this.scenarioUpdatedBy = scenarioUpdatedBy;
	}
	
	public PricePlannerVo(BigInteger id, Integer brandId, String name, Integer status, boolean deleted, Date createdOn, String createdBy,
			Date updatedOn, String updatedBy, BigInteger dataEntryId,BigInteger scenarioId, String scenarioName, Date scenarioCreatedOn, String scenarioCreatedBy,
			Date scenarioUpdatedOn, String scenarioUpdatedBy,Boolean scenarioDeleted) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.name = name;
		this.status = status;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
		if(scenarioId!=null){
			this.scenarioId = scenarioId;
		}
		if(scenarioName != null){
			this.scenarioName = scenarioName;
		}
		if(scenarioCreatedOn!=null) {
			this.scenarioCreatedOn = scenarioCreatedOn;
		}
		if(scenarioCreatedBy != null){
			this.scenarioCreatedBy = scenarioCreatedBy;
		}
		if(scenarioUpdatedOn!=null) {
			this.scenarioUpdatedOn = scenarioUpdatedOn;
		}
		if(scenarioUpdatedBy != null){
			this.scenarioUpdatedBy = scenarioUpdatedBy;
		}
		if(scenarioDeleted != null){
			this.scenarioDeleted = scenarioDeleted;
		}
		
		this.dataEntryId = dataEntryId;
	}
	


	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}	

	public Boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public BigInteger getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(BigInteger scenarioId) {
		this.scenarioId = scenarioId;
	}

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public Date getScenarioCreatedOn() {
		return scenarioCreatedOn;
	}

	public void setScenarioCreatedOn(Date scenarioCreatedOn) {
		this.scenarioCreatedOn = scenarioCreatedOn;
	}

	public String getScenarioCreatedBy() {
		return scenarioCreatedBy;
	}

	public void setScenarioCreatedBy(String scenarioCreatedBy) {
		this.scenarioCreatedBy = scenarioCreatedBy;
	}

	public Date getScenarioUpdatedOn() {
		return scenarioUpdatedOn;
	}

	public void setScenarioUpdatedOn(Date scenarioUpdatedOn) {
		this.scenarioUpdatedOn = scenarioUpdatedOn;
	}

	public String getScenarioUpdatedBy() {
		return scenarioUpdatedBy;
	}

	public void setScenarioUpdatedBy(String scenarioUpdatedBy) {
		this.scenarioUpdatedBy = scenarioUpdatedBy;
	}

	public List<ScenarioVo> getScenarioList() {
		return scenarioList;
	}

	public void setScenarioList(List<ScenarioVo> scenarioList) {
		this.scenarioList = scenarioList;
	}


	public Boolean getScenarioDeleted() {
		return scenarioDeleted;
	}


	public void setScenarioDeleted(Boolean scenarioDeleted) {
		this.scenarioDeleted = scenarioDeleted;
	}
	
	public BigInteger getDataEntryId() {
		return dataEntryId;
	}


	public void setDataEntryId(BigInteger dataEntryId) {
		this.dataEntryId = dataEntryId;
	}


}
