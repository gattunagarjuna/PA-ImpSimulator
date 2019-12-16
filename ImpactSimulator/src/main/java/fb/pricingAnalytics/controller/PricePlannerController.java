package fb.pricingAnalytics.controller;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fb.pricingAnalytics.model.auth.UserAuth;
import fb.pricingAnalytics.model.vo.PricePlannerVo;
import fb.pricingAnalytics.model.vo.ProjectVo;
import fb.pricingAnalytics.request.PricePlannerProjectRequest;
import fb.pricingAnalytics.request.PricePlannerScenarioRequest;
import fb.pricingAnalytics.response.PricePlannerResponse;
import fb.pricingAnalytics.response.ProjectListResponse;
import fb.pricingAnalytics.service.PricePlannerService;
import fb.pricingAnalytics.utils.AuthUtils;
import fb.pricingAnalytics.utils.FBConstants;
import fb.pricingAnalytics.utils.FBRestResponse;

@RestController
@RequestMapping("/pp/priceplanner")
public class PricePlannerController {

	private static Logger logger = LoggerFactory.getLogger(PricePlannerController.class);
	
	@Autowired
	PricePlannerService pricePlannerService;
	
	@RequestMapping(value="/createProject", method = RequestMethod.POST)
	public ResponseEntity<?> createProject(HttpServletRequest request,@RequestBody PricePlannerProjectRequest projectRequest) {

		logger.debug("PricePlannerController createProject function starts :::");
		
		if(null == projectRequest){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Request Object is null"),
				    HttpStatus.BAD_REQUEST);
		}
		
		logger.info("Project Name  ::: "+projectRequest.getProjectName() +" "+
				"Status Id ::: "+projectRequest.getStatusId() +" "+
				"Deleted ::: "+projectRequest.isDeleted());
		
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String brandId = userAuth.getBrandId();
		String userName = userAuth.getUserName();

		PricePlannerResponse response = new PricePlannerResponse();
		
		logger.info("Brand Id ::: "+ brandId);
			
		try {
				BigInteger projectId = pricePlannerService.createProject(projectRequest, brandId, userName);
				if(null != projectId && projectId.intValue()<=0) {
					return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Error during inserting value into the table"),
						    HttpStatus.INTERNAL_SERVER_ERROR);
				}
				pricePlannerService.copyProjectData(projectId,brandId,userName);
				response.setResult(projectId.intValue());
			}
		catch(SQLException e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "SQL exception occured"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PricePlannerResponse>(response,HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/updateProject", method = RequestMethod.POST)
	public ResponseEntity<?> updateProject(HttpServletRequest request,@RequestBody PricePlannerProjectRequest projectRequest) {
		logger.debug("PricePlannerController updateScenario function starts :::");
		int updatedRows = -1;
		if(null == projectRequest|| projectRequest.getProjectId() == null){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Either the Request object or the Project Id is null"),
				    HttpStatus.BAD_REQUEST);
		}
		
		logger.info("Project Id  ::: "+projectRequest.getProjectId() +" "+
				 "Project Name  ::: "+projectRequest.getProjectName() +" "+
				"Status Id ::: "+projectRequest.getStatusId() +" "+
				"Deleted ::: "+projectRequest.isDeleted());
		
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String userName = userAuth.getUserName();
		String brandId = userAuth.getBrandId();
		
		logger.info("Brand Id ::: "+ brandId);
		
		try {
			updatedRows = pricePlannerService.updateProject(projectRequest, brandId, userName);
		}catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.BAD_REQUEST);
		}
		if(updatedRows<=0) {
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "No rows updated. Table does not contain the provided project id"),
				    HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "Project updated Successfully"),
			    HttpStatus.OK);
	}
	
	@RequestMapping(value="/createScenario", method = RequestMethod.POST)
	public ResponseEntity<?> createScenario(HttpServletRequest request,@RequestBody PricePlannerScenarioRequest scenarioRequest) {

		logger.debug("PricePlannerController createProject function starts :::");
		
		if(null == scenarioRequest){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Request Object is null"),
				    HttpStatus.BAD_REQUEST);
		}
		
		logger.info("Project Id  ::: "+scenarioRequest.getProjectId() +" "+
				"Scenario Name ::: "+scenarioRequest.getScenarioName() );
		
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String brandId = userAuth.getBrandId();
		String userName = userAuth.getUserName();

		PricePlannerResponse response = new PricePlannerResponse();
		
		logger.info("Brand Id ::: "+ brandId);
			
		try {
			BigInteger scenarioId = pricePlannerService.createScenario(scenarioRequest, brandId, userName);
				if(null == scenarioId && scenarioId.intValue() <= 0) {
					return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Error during inserting value into the table"),
						    HttpStatus.INTERNAL_SERVER_ERROR);
				}
				pricePlannerService.copyScenarioData(scenarioRequest.getProjectId(),scenarioId,brandId,userName);
				response.setResult(scenarioId.intValue());
			}
		catch(SQLException e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "SQL exception occured"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PricePlannerResponse>(response,HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/updateScenario", method = RequestMethod.POST)
	public ResponseEntity<?> updateScenario(HttpServletRequest request,@RequestBody PricePlannerScenarioRequest scenarioRequest) {
		logger.debug("PricePlannerController updateScenario function starts :::");
		int updatedRows = -1;
		if(null == scenarioRequest|| scenarioRequest.getScenarioId() == null){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Either the Request object or the Project Id is null"),
				    HttpStatus.BAD_REQUEST);
		}
		
		logger.info("Scenario Id  ::: "+scenarioRequest.getScenarioId() +" "+
				 "Scenario Name  ::: "+scenarioRequest.getScenarioName() +" "+
				"Project Id ::: "+scenarioRequest.getProjectId() );
		
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String userName = userAuth.getUserName();
		String brandId = userAuth.getBrandId();
		
		logger.info("Brand Id ::: "+ brandId);
		
		try {
			updatedRows = pricePlannerService.updateScenario(scenarioRequest, brandId, userName);
		}catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.BAD_REQUEST);
		}
		if(updatedRows<=0) {
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "No rows updated. Table does not contain the provided project id"),
				    HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "Project updated Successfully"),
			    HttpStatus.OK);
	}
	
	@RequestMapping(value="/getProject", method = RequestMethod.GET)
	public ResponseEntity<?> getProject(HttpServletRequest request,@RequestParam("projectId") BigInteger projectId) {
		logger.debug("PricePlannerController getProject function starts :::");
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String brandId = userAuth.getBrandId();
		PricePlannerResponse response = new PricePlannerResponse();
		PricePlannerVo pricePlannerVo = new PricePlannerVo();
		logger.info("Project Id ::: " +projectId);
		try {
			if(projectId.intValue()>0 && brandId!=null) {
				pricePlannerVo = pricePlannerService.getProject(brandId, projectId);
			}else {
				logger.error("The project Id is less than or equal to 0 or brandId is not set");
				return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "The project Id is less than or equal to 0 or brandId is not set"),
					    HttpStatus.BAD_REQUEST);
			}
		}
		catch(SQLException e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "SQL exception occured"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(null == pricePlannerVo){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "There is no Report with the provided Id"),
				    HttpStatus.BAD_REQUEST);
		}
		response.setResponse(true, FBConstants.SUCCESS);
		response.setResultObject(pricePlannerVo);
		return new ResponseEntity<PricePlannerResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getProjectList", method = RequestMethod.GET)
	public ResponseEntity<?> getProjectList(HttpServletRequest request) {
		logger.debug("PricePlannerController getProjectList function starts :::");
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		String brandId = userAuth.getBrandId();
		ProjectListResponse response = new ProjectListResponse();
		List<ProjectVo> projectVo = new ArrayList<ProjectVo>();
		
		try {
			
			projectVo = pricePlannerService.getProjectList(brandId);
			
		}
		catch(SQLException e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "SQL exception occured"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(null == projectVo || projectVo.size() == 0){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "There are no projects with the associated brandid"),
				    HttpStatus.OK);
		}
		response.setResponse(true, FBConstants.SUCCESS);
		response.setProjectVo(projectVo);
		response.setCount(projectVo.size());
		return new ResponseEntity<ProjectListResponse>(response,HttpStatus.OK);
	}
}
