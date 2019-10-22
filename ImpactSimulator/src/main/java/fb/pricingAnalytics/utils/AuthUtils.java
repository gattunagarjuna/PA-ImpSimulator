package fb.pricingAnalytics.utils;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;

import fb.pricingAnalytics.model.auth.UserAuth;

public class AuthUtils {
	private static Logger logger = LoggerFactory.getLogger(AuthUtils.class);
	
	
	
	
	public static HttpServletResponse deleteCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookieList = request.getCookies();
		String domain = request.getServerName();
		String aSPXFORMSAUTH= getaSPXFORMSAUTHString(domain);;
		if(cookieList != null) {
			for(Cookie cookie : cookieList) {
				if(cookie.getName().equals("PA_SessionId") || cookie.getName().equals("BrandID")||aSPXFORMSAUTH.equalsIgnoreCase(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setDomain(AuthUtils.getDomain(request.getServerName()));
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
		
		return response;
		
	}
	
	public static HttpServletResponse getJsonFromObjectWithResponse(HttpServletResponse response, Object object,
			int responsecode) throws IOException {
		response.setContentType("application/json");
		response.setStatus(responsecode);
		response.getWriter().write(getJsonFromObject(object));
		return response;
	}
	public static String getJsonFromObject(Object object) {
		String json = null;
		Gson gson = new Gson();
		try {
			if (object != null) {
				json = gson.toJson(object);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
		}
		return json;
	}
	public static String getParentAppUrl(String domain ) {
		if(domain != null ){
			if(domain.contains("qa")){
				
				return "loginqa.fishbowl.com";
			}else if(domain.contains("staging")){
				return "loginstaging.fishbowl.com";
			}else{
				return "login.fishbowl.com";
			}
		}
		return null;
	}
	
	public static boolean isFishbowlCookiesPresent(Cookie[] cookieList,String domain ) {
		boolean isaSPXFORMSAUTHCookiesPresent=false;
		boolean isfishFrameSessionEnvCookiesPresent=false;
		if(domain != null &&cookieList!=null){
			String fishFrameSessionEnv = getFishFrameSessionEnv(domain);
			String aSPXFORMSAUTH= getaSPXFORMSAUTHString(domain);;
			logger.info("domain "+domain);
			logger.info("aSPXFORMSAUTH "+aSPXFORMSAUTH);
			logger.info("fishFrameSessionEnv"+fishFrameSessionEnv);
			for (Cookie ck : cookieList) {
				  logger.info("Cookie Name : "+ck.getName());
				  logger.info("Cookie Domain : "+ck.getDomain());
			    if (aSPXFORMSAUTH.equalsIgnoreCase(ck.getName())) {
			    	logger.info("AspxCookie is Present and hence proceeding");
			    	isaSPXFORMSAUTHCookiesPresent=true;
			    }
			    if(fishFrameSessionEnv.equalsIgnoreCase(ck.getName())){
			    	logger.info("fishFrameSessionId : "+ck.getValue());
			    	isfishFrameSessionEnvCookiesPresent=true;
			    }
			  }
		}
		if(isfishFrameSessionEnvCookiesPresent&&isaSPXFORMSAUTHCookiesPresent)
		return true;
		else
		return false;
	}
	
	public static boolean isBrandIDCookiesPresent(Cookie[] cookieList,String domain ) {
		logger.info("isBrandIDCookiesPresent method start");
		
		if(domain != null&&cookieList!=null ){
			
			
			for (Cookie ck : cookieList) {
				 
			    if ("BrandID".equalsIgnoreCase(ck.getName())) {
			    	logger.info("BrandID is Present and hence proceeding");
			    	return true;
			    }
			    
			  }
		}
		
		return false;
	}
	
	public static boolean isPACookiesPresent(Cookie[] cookieList,String domain ) {
		logger.info("isBrandIDCookiesPresent method start");
		boolean isBrandIDCookiesPresent=false;
		boolean isPA_SessionIdCookiesPresent=false;
		if(domain != null&&cookieList!=null ){
			
			
			for (Cookie ck : cookieList) {
				 
			   
			    if("PA_SessionId".equalsIgnoreCase(ck.getName())){
			    	logger.info("PA_SessionId is Present and hence proceeding");
			    	isPA_SessionIdCookiesPresent=true;
			    	
			    }
			    
			  }
		}
		if(isPA_SessionIdCookiesPresent){
			return true;
		}
		
		return false;
	}
	
	public static boolean validateProtectedPaths(String requestPath, List<String> exceptionList) {
		for (String path : exceptionList) {
			if (requestPath.equalsIgnoreCase(path)) {
				return true;
			}
		}
		return false;
	}
	
	public static String encrypted(String t) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
        byte[] dataToSend = t.getBytes();
        byte[] key = new byte[16];
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key, "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedData = c.doFinal(dataToSend);
        return new String(Base64.encodeBase64(encryptedData)); 
    }
	
	public static String decrypted(byte[] kr) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
        byte[] key = new byte[16];
        SecretKeySpec k = new SecretKeySpec(key, "AES");
        byte[] encryptedData = Base64.decodeBase64(kr);
        Cipher c2 = Cipher.getInstance("AES");
        c2.init(Cipher.DECRYPT_MODE, k);
        byte[] data = c2.doFinal(encryptedData);
        return new String(data);
    }
	
	public static UserAuth getUserDetails(UserAuth userAuth,String userDetailsStr){
		
		 logger.info("userDetailsStr : "+userDetailsStr);
		String[] userDetails = userDetailsStr.split("\\|");
		logger.info("userDetails[0] : "+userDetails[0]);
		logger.info("userDetails[1] : "+userDetails[1]);
		logger.info("userDetails[2] : "+userDetails[2]);
		logger.info("userDetails[3] : "+userDetails[3]);
		logger.info("userDetails[4] : "+userDetails[4]);
		logger.info("userDetails[5] : "+userDetails[5]);
		logger.info("userDetails[5][0] : "+userDetails[5].split(",")[0]);
		logger.info("userDetails[5][1] : "+userDetails[5].split(",")[1]);
		userAuth.setUserName(userDetails[1]);
		userAuth.setAccessTokenIssued(userDetails[2]);
		userAuth.setAccessTokenExpires(userDetails[3]);
		userAuth.setPersistant(Boolean.valueOf(userDetails[4]));
		userAuth.setUserId(userDetails[5].split(",")[0]);
		userAuth.setClientId(userDetails[5].split(",")[1]);
		return userAuth;
	}
	public static UserAuth updateBrandId(UserAuth userAuth,String brandID){
		  logger.info(" updateBrandId BrandID Value : "+brandID);
		userAuth.setBrandId(brandID);
		return userAuth;
		
	}
	
	public static UserAuth getUserAuthData(HttpServletRequest request) {
		UserAuth userAuth = new UserAuth();
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			  for (Cookie cookie : cookies) {
				  logger.info("Cookie Name : "+cookie.getName());
				  logger.info("Cookie Domain : "+cookie.getDomain());
			    if (cookie.getName().contains("PA_SessionId")) {
					String decryptedKey=null;
					try {
						decryptedKey = AuthUtils.decrypted(cookie.getValue().getBytes());
						userAuth= getUserDetails(userAuth,decryptedKey);
						logger.info("------decryptedKey--------"+decryptedKey);
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					logger.info("------decryptedKey--------         NULL");
					
				}
			    if(cookie.getName().contains("BrandID")){
			    	logger.info("Cookie Name : "+cookie.getName());
					  logger.info("Cookie Domain : "+cookie.getDomain());
					  logger.info("Cookie Value : "+cookie.getValue());
					  
					  userAuth=updateBrandId(userAuth, cookie.getValue());
					  
					  logger.info("BrandID Value : "+userAuth.getBrandId());
			    	
			    }
			    
			  }
		}
		logger.info("BrandID Value : "+userAuth.getBrandId());
		return userAuth;
		
	}
	
	public static String getDomain(String domain) {
		 String paDomain = null;
		  
		  if(domain != null ){
				if(domain.contains("qa")){
					
					//setting to run on local system..we will delete after sometime
					///---------------------------------------------UNDO----------------------------------
//					paDomain = "fishbowl.com";
//					-----------------------------------------------------------------------------------------
					paDomain = "pa2qa.fishbowl.com";
				}else if(domain.contains("staging")){
					paDomain = "pastaging.fishbowl.com";
				}else{
					paDomain = "pa.fishbowl.com";
				}
			}
		  return paDomain;
		
	}
	
	public static String getFishFrameSessionEnv(String domain) {
		 String fishFrameSessionEnv = null;
		  
		  if(domain != null ){
				if(domain.contains("qa")){
					fishFrameSessionEnv = "FishbowlQA";
				}else if(domain.contains("staging")){
					fishFrameSessionEnv = "FishbowlStaging";
				}else{
					fishFrameSessionEnv = "Fishbowl";
				}
			}
		  return fishFrameSessionEnv;
		
	}
	
	public static String getRedirectServerName(String domain) {
		 String redirectServerName = null;
		  
		  if(domain != null ){
				if(domain.contains("qa")){
					redirectServerName = "pa2qa.fishbowl.com";
				}else if(domain.contains("staging")){
					redirectServerName = "pa2staging.fishbowl.com";
				}else{
					redirectServerName = "pa.fishbowl.com";
				}
			}
		  return redirectServerName;
		
	}
	public static String getSoapUrl(String domain) {
		 String soapUrl = null;
		  
		  if(domain != null ){
				if(domain.contains("qa")){
					soapUrl = "loginqa.fishbowl.com";
				}else if(domain.contains("staging")){
					soapUrl =  "loginstaging.fishbowl.com";
				}else{
					soapUrl =  "login.fishbowl.com";
				}
			}
		  return soapUrl;
		
	}
	
	public static String getaSPXFORMSAUTHString(String domain) {
		if(domain.contains("qa")){
			return "QA.ASPXFORMSAUTH";
		
		}else if(domain.contains("staging")){
			return"STAGING.ASPXFORMSAUTH";
			
		}else{
			return".ASPXFORMSAUTH";
			
		}
		
	}
	
	public static Cookie getBrandIdCookies(String brandId , String serverName) {
		  Cookie brandCookie = new Cookie("BrandID",brandId);
		  brandCookie.setDomain(AuthUtils.getDomain(serverName));
		  brandCookie.setPath("/");
		  return brandCookie;
		
	}
	
	
	
	

}
