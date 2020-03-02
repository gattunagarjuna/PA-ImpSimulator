package fb.pricingAnalytics.controller;

import java.math.BigInteger;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fb.pricingAnalytics.model.auth.UserAuth;
import fb.pricingAnalytics.request.PricingRuleRequest;
import fb.pricingAnalytics.response.MenuPricingResponse;
import fb.pricingAnalytics.response.PricingRulesResponse;
import fb.pricingAnalytics.service.PricingRuleService;
import fb.pricingAnalytics.utils.AuthUtils;
import fb.pricingAnalytics.utils.FBRestResponse;



@RestController
@RequestMapping("/pp/pricingrule")
public class PricingRuleController {
	
	private static Logger logger = LoggerFactory.getLogger(PricingRuleController.class);
	
	
	@Autowired
	PricingRuleService pricingRuleService;
	
	
	@RequestMapping(value="/createPricingRule", method = RequestMethod.POST)
	public ResponseEntity<?> createPricingRule(HttpServletRequest request,@RequestBody PricingRuleRequest pricingRuleRequest) {

		logger.debug("PricingRuleController createPricingRule function starts :::");
		
		if(null == pricingRuleRequest){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Request Object is null"),
				    HttpStatus.BAD_REQUEST);
		}
		
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		int brandId = Integer.valueOf(userAuth.getBrandId());
		String userName = userAuth.getUserName();

		FBRestResponse response = new FBRestResponse();
		
		logger.info("Brand Id ::: "+ brandId);
		logger.info("UserName  ::: "+ userName);
			
		try {
				BigInteger pricingRuleId = pricingRuleService.createPricingRule(pricingRuleRequest, brandId, userName);
				logger.info("PricingRuleId : "+pricingRuleId);
				if(pricingRuleId.intValue() > 0){
					return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Failed in creating the Rule"),
						    HttpStatus.INTERNAL_SERVER_ERROR);
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
		
		response.setMessage("success");
		response.setSuccessFlag(true);
	
		return new ResponseEntity<FBRestResponse>(response,HttpStatus.OK);
	
	}
	
	
	@RequestMapping(value="/rules/{projectid}",method=RequestMethod.GET)
	public ResponseEntity<?> getPricingRules(HttpServletRequest request,@PathVariable("projectid") BigInteger projectId){
		
		logger.debug("PricingRuleController getPricingRules function starts :::");
		PricingRulesResponse response = new PricingRulesResponse();
		UserAuth userAuth=AuthUtils.getUserAuthData(request);
		int brandId = Integer.valueOf(userAuth.getBrandId());
	
		
		if(null == projectId || projectId.intValue()<=0){
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "ProjectId is required field"),
				    HttpStatus.BAD_REQUEST);
		}
		try{
			response = pricingRuleService.getPricingRules(projectId,brandId);
			if(!response.getSuccessFlag()){
				return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
					    HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(response.getPricingRules_Count() == 0){
				response.setMessage("There are no Rules Created for the associated Project Id");
				return new ResponseEntity<PricingRulesResponse>(response, HttpStatus.OK);
			}
			
		}catch(SQLException e){
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(true, "SQL exception occured"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			e.printStackTrace();
			return new ResponseEntity<FBRestResponse>(new FBRestResponse(false, "Exception Occured, Please check the log files"),
				    HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FBRestResponse>(response,HttpStatus.OK);
		
		
	}

}
