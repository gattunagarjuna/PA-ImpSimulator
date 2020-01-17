package fb.pricingAnalytics.utils;

import java.util.Arrays;
import java.util.HashMap;
	
public class FBConstants {
	
	//Pricing Analytic Constants
	

	public static final int PA_USERTYPE_ALL = 0;
	public static final int PA_USERTYPE_ADMIN = 1;
	public static final int PA_USERTYPE_NONADMIN = 2;
	
	final public static String PAGINATION_ERROR = "Pagination attributes are not passed properly";
	final public static String SEARCH_OBJECT_ERROR = "The search object is null or empty";
	
	 
	final public static String X_XSRF_TOKEN = "X-XSRF-TOKEN"; 
	final public static String LOYALITY_ENGINE_URL = "LOYALITY_ENGINE_URL";
	final public static String LOYALTY_POS_URL = "LOYALTY_POS_URL";
	final public static String BAR_TYPE = "BAR";
	final public static String IS_EMAIL_OPTIN = "emailOptin"; 

	final public static String IS_REWARD_RULE = "isRewardRule"; 
	final public static String RULE_ID = "ruleId";
	final public static String QR_TYPE = "QR";
	final public static String LOYALTY_ENGINE_SIGN_UP = "sign-up?tenantId=(%%tenantId%%)";
	final public static String LOYALTY_ENGINE_CLAIM = "claim?tenantId=(%%tenantId%%)";
	final public static String LOYALTY_ENGINE_CHECK_IN = "check-in?tenantId=(%%tenantId%%)";
	final public static String LOYALTY_ENGINE_SUPPORT = "/loyalty-support/v1/";   
	final public static String LOYALTY_ENGINE_POINT_ALLOCATE = "point-allocate?tenantId=(%%tenantId%%)"; 
	final public static String LOYALTY_ENGINE_REWARD_ALLOCATE= "reward-allocate?tenantId=(%%tenantId%%)"; 
	
	final public static String FISHBOWL_AWS_ACCESS_KEY= "FISHBOWL_AWS_ACCESS_KEY"; 
	final public static String FISHBOWL_AWS_ACCESS_KEY_SECRET= "FISHBOWL_AWS_ACCESS_KEY_SECRET"; 
	
	final public static String LOYALTY_ENGINE_POINT_OFFERS = "point-offers/(%%loyaltyNo%%)?tenantId=(%%tenantId%%)";
	final public static String LOYALTY_ENGINE_POS_EVENT = "pos-event?tenantId=(%%tenantId%%)";
	final public static String LOYALTY_ENGINE_RETRO_CREDIT_POINT_REWARD = "retroCreditPointReward?tenantId=(%%tenantId%%)";
	
	final public static String LOYALTY_SIGNUP = "SIGN_UP";
	final public static String PROMO_EXPIRE_NEVER = "NEVER";
	
	//final public static String CFGST_GOOGLE_MAP_API_KEY = "AIzaSyCvrn9MhY51p0pPzEgNxjG5QhLALmiX5vw";
	final public static String CFGST_GOOGLE_MAP_API_KEY = "AIzaSyDvxUYEIyZol0kM1GBJnjxbTvP73z9g2g4";
	
	final public static String MEMBER_INPUT_SOURCE_FISHBOWLCLOUD = "FishbowlCloud";
	final public static String MEMBER_INPUT_SOURCE_FISHBOWLCLOUDSMS = "FishbowlCloudSMS";
	final public static String MEMBER_INPUT_SOURCE_SPENDGO = "Spendgo";

	final public static int COOKIE_MAX_AGE = 300;
	final public static String APPLICATION_TYPE 		= "Application";
	final public static String APPLICATION_TYPE_WEB 	= "web";
	final public static String APPLICATION_TYPE_WEBEUP 	= "webeup";
	final public static String APPLICATION_TYPE_WEBADMIN 	= "webadmin";
	final public static String APPLICATION_TYPE_MOBILE 	= "mobile";
	final public static String APPLICATION_TYPE_IPAD 	= "ipad";
	final public static String APPLICATION_TYPE_SMS 	= "sms";
	public static final String APPLICATION_TYPE_SDK 	= "mobilesdk";
	public static final String APPLICATION_TYPE_KIOSK   = "kiosk";
	final public static String APPLICATION_TYPE_ENTERPRISE  = "enterprise";
	public static final String FUNCTIONTYPE_INSERT 	= "INSERT";
	
	final public static String SUBDOMAIN = "subDomain";
	final public static String EMPTY_SUBDOMAIN = "SubDomain is Empty";
	final public static String COUNT_IS_ZERO = "Count should not be 0";
	final public static String INVALID_APPLICATION 	= "Invalid Application";
	
	final public static long FILE_MAXIMUM_SIZE = 10485760;
	final public static String FILE_SIZE_EXCEEDED = "File size is too large. please Upload File within 10mb";
	final public static int MEMBER_ACTIVE 		= 1;
	final public static int MEMBER_INACTIVE 	= 0;
	final public static String ACTIVE 	= "Y";
	final public static String INACTIVE 	= "N";
	final public static int EMAIL_CHANNEL = 1;
	

	public static final String CONFIG_NAME_SPENDGO_MESSAGING_URL = "SPENDGO_MESSAGING_URL";
	public static final String CONFIG_NAME_SPENDGO_AUTH_KEY = "SPENDGO_AUTH_KEY";
	
	//Media
	final public static long MEDIA_FILE_MAXIMUM_SIZE = 5242880;
	final public static String MEDIA_FILE_SIZE_EXCEEDED = "Media file size is too large. Please Upload file within 5mb";
	final public static String MEDIA_TYPE_IMAGE = "Image";
	final public static String MEDIA_TYPE_VIDEO = "Video";
	final public static String MEDIA_CONFIG_GROUP = "ImageLibraryFormat";
	final public static String MEDIA_LIBRARY_IMAGE_FORMAT = "IMAGE%";
	final public static String MEDIA_LIBRARY_VIDEO_FORMAT = "VIDEO%";
	
	// Menu Constants
	final public static boolean PRODUCT_ACTIVE = true;
	final public static String MENU_STORE_INFO_NOT_FOUND = "Store Info not found";
	final public static String MENU_STORE_ID_IS_EMPTY = "Store Id is Empty";
	final public static String MENU_FAMILY_IS_EMPTY = "Family is Empty";
	final public static String MENU_CATEGORY_IS_EMPTY = "Category is Empty";
	final public static String MENU_SUB_CATEGORY_IS_EMPTY = "SubCategory is Empty";
	final public static String MENU_PRODUCT_ID_IS_EMPTY = "Product id is Empty";
	final public static String MENU_PRODUCT_LIST_IS_EMPTY = "Product List is Empty";
	final public static String MENU_PRODUCT_IS_EMPTY = "Product not found";

	final public static String INVALID_STORE = "Invalid Store";
	final public static String CONFIG_NAME_DEFAULT_STORE = "DefaultStore";
	final public static String STORE_NAME_DEFAULT_STORE = "Default Store";
	final public static String STORE_CODE_DEFAULT_STORE = "~DEFAULT";
	final public static String MENU_INVALID_INPUT = "Invalid Input. Please Check the Input details";
	final public static String STORE_EXIST = "Store exist";
	final public static String STORE_NOT_EXIST = "Store not exist";

	//Header, Side, Footer, Background
	final public static String UPLOAD_IMAGE_TYPE						= "File_type";
	final public static String UPLOAD_IMAGE_TYPE_LOGIN_HEADER			= "LoginHeader";
	final public static String UPLOAD_IMAGE_TYPE_LOGIN_SIDE 			= "LoginSide";
	final public static String UPLOAD_IMAGE_TYPE_LOGIN_RIGHT_TOP 		= "LoginRightTop";
	final public static String UPLOAD_IMAGE_TYPE_LOGIN_FOOTER 			= "LoginFooter";
	final public static String UPLOAD_IMAGE_TYPE_LOGIN_BACKGROUND 		= "LoginBackground";
	final public static String UPLOAD_IMAGE_TYPE_SIGNUP_BACKGROUND 		= "SignupBackground";
	final public static String UPLOAD_IMAGE_TYPE_COMPANY_LOGO 			= "CompanyLogo";
	final public static String UPLOAD_IMAGE_TYPE_INVALID 				= "Invalid File Type";
	final public static String UPLOAD_IMAGE_FILE 						= "file";
	final public static String UPLOAD_IMAGE_TYPE_HEADER_IMAGE_SOURCE	= "HeaderImageSource";
	final public static String UPLOAD_IMAGE_FILE_FOOTER_IMAGE_SOURCE	= "FooterImageSource";
	final public static String UPLOAD_FILE_TYPE_TERMS_AND_CONDITION 	= "TermsAndConditions";
	final public static String UPLOAD_FILE_TYPE_PRIVACY_POLICY			= "PrivacyPolicy";
	final public static String UPLOAD_FILE_TYPE_WELCOME_EMAIL			= "WelcomeEmail";
	final public static String UPLOAD_FILE_TYPE_WELCOME_LOYALTY_EMAIL			= "WelcomeLoyaltyEmail";
	final public static String UPLOAD_FILE_TYPE_VERIFY_EMAIL			= "VerifyEmail";
	final public static String UPLOAD_FILE_TYPE_FORGET_PASSWORD_EMAIL	= "ForgetEmail";
	final public static String UPLOAD_IMAGE_TYPE_FAVORITE_ICON 			= "FavoriteIcon";
	final public static String UPLOAD_IMAGE_TYPE_UNSUBSCRIBE_BACKGROUND	= "UnSubscribeBackground";
	final public static String UPLOAD_FILE_TYPE_FAQ			= "FAQ";
	final public static String UPLOAD_FILE_TYPE_PROGRAMDETAIL		= "ProgramDetail";
	final public static String UPLOAD_FILE_TYPE_SIGN_UP_DISCLAIMER_AND_TEXT_HTML = "SignUpDisclaimerAndTextHtml";
	final public static String UPLOAD_FILE_TYPE_LOYALTY_VERIFY_EMAIL			= "VerifyLoyaltyEmail";
	final public static String UPLOAD_IMAGE_TYPE_AD_IMAGE			= "LoyaltyAdImageUrl";
	final public static String UPLOAD_FILE_TYPE_LOYALTY_VERIFY_REGISTRATION			= "VerifyLoyaltyRegistration";
	
	final public static String UPLOAD_FILE_TYPE_THEME_FONT_IN_OTF_FORMAT= "ThemeFontsInOTFFormat";
	final public static String UPLOAD_FILE_TYPE_THEME_FONT_IN_WOFF_FORMAT= "ThemeFontsInWOFFFormat";
	final public static String UPLOAD_FILE_TYPE_THEME_FONT_IN_WOFF2_FORMAT= "ThemeFontsInWOFF2Format";
	final public static String UPLOAD_FILE_TYPE_THEME_FONT_IN_TTF_FORMAT= "ThemeFontsInTTFFormat";

	final public static String URL_SAME_AS_FILEFORMAT = "URL is not end with given FileFormat. So Please check it.";
	 
	final public static String FILE_FORMAT_TTF		= ".ttf";
 	final public static String FILE_FORMAT_WOFF		= ".woff";
 	final public static String FILE_FORMAT_WOFF2	= ".woff2";
 	final public static String FILE_FORMAT_OTF		= ".otf";
 	
 	final public static String FONT_IS_EMPTY = "Font Name is Empty";
 	
 	final public static String UPLOAD_CONFIG_GROUP_FONT	 = "Theme";
 	final public static String FONT_NAME								="FontName";
 	final public static String FONT_FORMAT								="FontFileFormat";
 
	final public static String FILE_FORMAT_HTML 	= ".html";
	final public static String FILE_FORMAT_HTM		= ".htm";
	final public static String FILE_FORMAT_PNG		= ".png";
	final public static String FILE_FORMAT_JPG		= ".jpg";
	final public static String FILE_FORMAT_JPEG		= ".jpeg";
	final public static String FILE_FORMAT_ICO		= ".ico";
	final public static String FILE_FORMAT_INVALID	= "Invalid File";
	
	// Note: it is Expire Hours
	final public static String TOKEN_EXPIRE_HOURS_IS_EMPTY = "Token Expire Hours is Empty";
	
	final public static String UPLOAD_CONFIG_GROUP						= "config_group";
	final public static String UPLOAD_CONFIG_GROUP_DESKTOP				= "Desktop";
	final public static String UPLOAD_CONFIG_GROUP_MOBILE				= "Mobile";
	final public static String UPLOAD_CONFIG_GROUP_NONE					= "None";
	final public static String UPLOAD_CONFIG_GROUP_INVALID				= "Invalid Config Group";
	final public static String CONF_VALUE_EMAIL_VERIFIY 				= "EmailVerify";
	final public static String FILE_SEPARATOR 							= "/";
	
	final public static String DOB_DATE_FORMAT = "MM/dd/yyyy";
	final public static String DOB_DATE_VALIDATE = "yyyy-MM-dd";

	final public static String IMAGE_DESCRIPTION = "Description";
	final public static String IMAGE_NAME = "ImageName";

	final public static int USERNAME_MINIMUM_LENGTH = 6;
	final public static int USERNAME_MAXIMUM_LENGTH = 15;
	final public static int PASSWORD_MINIMUM_LENGTH = 6;
	final public static int PASSWORD_MAXIMUM_LENGTH = 15;

	public static final String STRINGCONCAT_DELIMITER_WITH_ESCAPE = "\\|";
	public static final int SMS_CHANNEL_TYPE = 3;
	// final public static String EMAIL_REGEX =
	// "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{3,6}$";
	final public static String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	//final public static String PHONE_REGEX = "\\d{3}-\\d{3}-\\d{4}";
	final public static String PHONE_REGEX = "\\d{10,12}";
	final public static String MEMBER_CREATE_SUCCESS = "Member Created Successfully";
	final public static String MEMBER_CREATE_FAILED = "Member Creation Failed";

	final public static String MEMBER_UPDATE_SUCCESS = "Member updated Successfully";
	final public static String MEMBER_UPDATE_FAILED = "Failure to Update Member";

	final public static String MEMBER_PASSWORD_CHANGE_SUCCESS = "Password Changed Successfully";
	final public static String MEMBER_PASSWORD_CHANGE_FAILED = "Password change failed";
	final public static String MEMBER_PASSWORD_LINK_EXPIRED = "Password link expired";
	final public static String MEMBER_PASSWORD_KEY_INVALID = "Password link invalid";

	final public static String MEMBER_LOGIN_SUCCESS = "Member login Successfully";
	final public static String MEMBER_LOGIN_FAILED = "Member login Failed";

	final public static String MEMBER_LOGOUT_SUCCESS = "Member logout Successfully";
	final public static String MEMBER_LOGOUT_FAILED = "Member logout Failed";

	final public static int RESET_LOGIN_ATTEMPT = 0;
	final public static int FIRST_LOGIN_ATTEMPT = 1;
	final public static int MAXIMUM_LOGIN_ATTEMPT = 5;
	final public static String EXCEEDED_MAXIMUM_LOGIN_LIMIT = "You have exceeded the maximum allowed login attempts. Please try again in 30 minutes. You may also reset your password";

	final public static String LOYALTY_UPDATE_SUCCESS = "Loyalty updated Successfully";
	final public static String LOYALTY_UPDATE_FAILED = "Loyalty updation Failed";
	final public static String LOYALTY_UPDATE_NO_CHANGE = "No Change in update";
	final public static String LOYALTY_UPDATE_ORDER_MISMATCH = "Loyalty Update Order Mis-Match";
	final public static String LOYALTY_CONFIG_MISMATCH = "Messaging preference and configuration mismatch.";

	final public static String LOYALTY_CREATE_SUCCESS = "Loyalty created Successfully";
	final public static String LOYALTY_CREATE_FAILED = "Loyalty created Failed";

	final public static String LOYALTY_NOT_FOUND = "Loyalty Details Not Found";
	final public static String TENANT_NOT_FOUND = "Tenant Details Not Found";

	final public static String GENERIC_SERVER_ERROR = "Generic Server Error";
	final public static String CRM_SERVER_ERROR = "CRM Server Error: returning member object as NULL";

	final public static String RESPONSE_FLAG = "responseFlag";
	final public static String RESPONSE_MESSAGE = "errorMessage";
	final public static String GENERATED_IMAGE_ROW_ID = "generatedImageRowID";

	final public static int MAIL_MEMBER_ACTIVATION_FAILED = 0;
	final public static int MAIL_MEMBER_ACTIVATED = 1;
	final public static int MAIL_MEMBER_ALREADY_ACTIVATED = 2;
	final public static int MAIL_MEMBER_NOT_FOUND = 3;
	final public static int MAIL_LINK_EXPIRED = 4;

	final public static int FORGET_LINK_EXPIRED = 0;
	final public static int FORGET_LINK_ACTIVE = 1;
	final public static int FORGET_LINK_INVALID = 2;
	final public static int FORGET_RESET_SUCCESS = 3;
	// linkExpier

	final public static String USERNAME_MIN_LENGTH_VALIDATION_ERROR_MSG = "Username should be more than "
			+ String.valueOf(USERNAME_MINIMUM_LENGTH) + " characters.";
	final public static String USERNAME_MAX_LENGTH_VALIDATION_ERROR_MSG = "Username should be less than "
			+ String.valueOf(USERNAME_MAXIMUM_LENGTH) + " characters.";
	final public static String PHONE_NUMBER_FORMAT_ERROR_MSG = "Phone number Should be in the pattern xxx-xxx-xxxx";

	final public static String AWS_ACCESS_KEY_VAL = "AKIAI4SSXNTFGBIR43FQ";
	final public static String AWS_SECRET_KEY_VAL = "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";
	final public static String FROM_ADDRESS = "contact@clyptech.com";
	
	final public static String EMAIL_VERIFICATION_SUBJECT = "EmailVerificationSubject";
	 
	
	final public static String SUBJECT_MEMBER_FORGET_LINK = "Password Reset";
	final public static String WELCOME_EMAIL_SUBJECT = "WelcomeEmailSubject";
	final public static String LOYALTY_REGISTRATION_SUBJECT = "LoyaltyRegistrationSubject";
	
	 final public static String WELCOME_LOYALTY_OPTED_SUBJECT = "WelcomeLoyaltyOptedSubject";
	 final public static String BE_LOYALTY_VERIFICATIONSUBJECT = "BeLoyaltyVerificationSubject";
	 
	 final public static String WELCOME_EMAIL_OPTED_SUBJECT = "WelcomeEmailOptedSubject";
	 final public static String BE_EMAILOPTED_VERIFICATIONSUBJECT = "BeEmailOptedVerificationSubject";
	 
	 
	 final public static String WELCOME_LOYALTY_SUBJECT = "WelcomeLoyaltySubject";//WELCOME_EMAIL_LOYALTY_SUBJECT
	final public static String HEADER_MEMBER_ID = "memberid";
	final public static String HEADER_TENANT_ID = "tenantid";
	final public static String HEADER_TENANT_NAME = "tenantName";
	final public static String OAUTH_TOKEN = "access_token";
	final public static String XSRF_TOKEN = "XSRF_token";
	final public static String OAUTH_CLIENTID = "client_id";
	final public static String OAUTH_SECRET_KEY = "client_secret";
	final public static String OAUTH_RESPONSE_TYPE = "response_type";
	final public static String OAUTH_CODE = "code";
	final public static String OAUTH_USERNAME = "username";
	final public static String OAUTH_PASSWORD = "password";
	final public static String OAUTH_RESPONSE_TOKEN = "accessToken";
	final public static String OAUTH_RESPONSE_CODE = "authorizationCode";
	final public static String OAUTH_TOKEN_EXPIRED = "Token Expired";
	final public static String OAUTH_GRANT_TYPE = "grant_type";
	final public static String OAUTH_SCOPE_VALUE_READ = "read";
	final public static String OAUTH_SCOPE_VALUE_USER_PROFILE = "user_profile";
	final public static String OAUTH_TOKEN_INVALID = "AccessToken is invalid";
	final public static String DEVELOPER_ENVIRONMENT = "DeveloperEnvironment";
	final public static String EMPTY_GRANT_TYPE = "Grant Type is empty";
	final public static String EMPTY_REDIRECT_URI = "Redirect URI is empty";
	final public static String INVALID_GRANT_TYPE = "Invalid Grant Type";

	final public static String AUTHENTICATION = "authentication";
	final public static String CUSTOM = "custom";
	final public static String CUSTOMER_SUPPORT = "Customer Support";
	final public static String IMPLEMENTATION = "IMPLEMENTATION";
	final public static String SPENDGO = "spendgo";
	final public static String DONATOS = "donatos";
	final public static String DEACTIVE_MEMEBR = "This member is deactivated";
 
	
	
	// This is spendgo Access Token
	final public static String ACCESSTOKEN = "accessToken";
	
	
	final public static String OAUTH_REDIRECT_URI = "redirect_uri";
	final public static String OAUTH_STATE = "state";
	final public static String OAUTH_SCOPE = "scope";
	final public static String OAUTH_EXPIRES = "expires";
	public static final String LICENSE = "license";
	final public static String OAUTH_TOKEN_EXPIRE_STATUS = "expire_status";
	final public static int MINUTE_IN_SECONDS = 60;
	final public static int HOUR_IN_SECONDS = 60 * MINUTE_IN_SECONDS;
	final public static int DAY_IN_SECONDS = 24 * HOUR_IN_SECONDS;
	final public static int MONTH_IN_SECONDS = 30 * DAY_IN_SECONDS;
	final public static int SECONDS_TO_EXPIRE = MONTH_IN_SECONDS;// 300
	final public static int MINUTE_IN_HOUR = 60;
	public static final String NOT_FOUND = "Not Found";

	final public static String YES = "YES";
	final public static String NO = "NO";

	final public static String LOYALTY_NO = "loyaltyNo";
	final public static String MEMBERID = "memberId";
	final public static String DB_PROPERTIES_FILE = "Database.properties";

	final public static String SUCCESS = "Success";
	final public static String NO_MESSAGE = "No Message";
	final public static String FAILED = "Failed";
	final public static String INPUT_VALUE_NULL = "Input value is null";
	final public static String MEMBER_NOT_FOUND = "Member Details Not Found";
	final public static String MEMBER_LOGIN_NOTES = "do member Login";
	// final public static String
	// APPLICATION_CONSUME_TYPE_JSON="application/json";
	// final public static String
	// APPLICATION_CONSUME_TYPE_XML="application/xml";
	final public static String AD_SOURCE_PAGE_NAME_IS_EMPTY = "adSourcePageName is Emtpy";
	final public static String AD_SOURCE_PAGE_IS_EMPTY = "adSourcePage is Emtpy";
	final public static String ID_SHOULD_NOT_BE_ZERO = "Id value should not be zero";

	final public static String CREATE_SUCCESS = "Created Successfully";
	final public static String CREATE_SUCCESS_WITH_ID = "Created Successfully With Id : ";
	final public static String CREATE_FAILED = "Creation Failed";
	final public static String SEGMENT_CREATE_FAILED = "Segment Creation Failed";

	final public static String UPDATE_SUCCESS = "Updated Successfully";
	final public static String UPDATE_SUCCESS_FOR_ID = "Updated Successfully For Id : ";
	final public static String UPDATE_FAILED = "Updation Failed";

	final public static String DELETE_SUCCESS = "Deleted Successfully";
	final public static String DELETE_SUCCESS_FOR_ID = "Deleted Successfully For Id : ";
	final public static String DELETE_FAILED = "Deletion Failed";
	final public static String DELETED_MEMBER = "Member already deleted";
	
	
	final public static int DELETE_SUCCESS_STATUS = 1;
 	final public static int DELETE_FAILED_STATUS = 2;


	final public static String RECORD_EXISTS = "RECORD_ALREADY_EXISTS";
	final public static String RECORD_NOT_EXISTS = "RECORD_NOT_EXISTS";

	public static final String INFO_CAMPAIGN_TYPE = "INFO_CAMPAIGN";
	public static final String ACQUISITION_CAMPAIGN_TYPE = "ACQUISITION_CAMPAIGN";
	public static final String ACQUISITION_LIST_CAMPAIGN_TYPE = "ACQ_LIST_CAMPAIGN";
	public static final String SMS_ACQUISITION_TEXT_TO_WIN ="TEXT_TO_WIN_CAMPAIGN";
	public static final String ACQUISITION_STORE_CAMPAIGN_TYPE = "ACQ_STORE_CAMPAIGN";

	final public static String ISO_DATE_FORMATE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	final public static String ISO_DATE_FORMATE_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss";
	final public static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	final public static String UI_DATE_TIME_PATTERN1 = "MM/dd/yyyy HH:mm:ss";
	final public static String UI_DATE_TIME_PATTERN2 = "MM-dd-yyyy HH:mm:ss";
	final public static String MOB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	final public static String PM_EXPIRY_DATE_FORMATE = "MM/dd/yyyy hh:mm:ss a";
	final public static String PM_EXPIRY_DATE_FORMATE1 = "yyyy-MM-dd'T'HH:mm:ss";
	final public static String UI_DATE_PATTERN1 = "MM/dd/yyyy";
	
	final public static String UI_DATE_PATTERN2 = "MM-dd-yyyy";
	
	final public static String DATE_PATTERN = "yyyy-MM-dd";
	final public static String TIME_PATTERN = "HH:mm:ss";
	final public static String TIME_PATTERN1 = "hh:mm a";
	final public static String TIME_PATTERN2 = "HH:mm";
	final public static String CURRENT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

	public static final String SETTING_WORKFLOW_ENABLED = "WORKFLOW_ENABLED";
	public static final String ACCESS_NOT_PERMITTED = "You are not authorized for this permission, please contact ADMINISTRATOR";

	public static final String OFFER_PASS_PREVIEW_EMAIL_NAME = "emailPreview";
	public static final String OFFER_PASS_PREVIEW_MOBILE_NAME = "mobilePreview";
	public static final String OFFER_PASS_BARCODE_NONE = "NONE";
	public static String DEFAULT_QUEUE_NAME = "dev-jamba-acme";
	public static String SMS_HANDLER_QUEUE_NAME_KEY = "SMS_HANDLER_QUEUE_NAME";
	public static String AWS_KEY_ID_VALUE = "";
	public static String AWS_SECRET_KEY_VALUE = "";

	public static final String CAMPAIGN_ID_INVALID = "Offer ID is not valid";

	final public static int SEND_LOYALTY_OFFER_VIA_EMAIL = 1;
	final public static int SEND_LOYALTY_OFFER_VIA_SMS = 2;

	final public static String INVALID_TENANTID = "Invalid tenant id";
	final public static String INVALID_CLIENTID = "Invalid client id";
	final public static String INVALID_TOKEN = "Invalid access token";
	final public static String INVALID_GENERIC_TOKEN = "Invalid token";
	final public static String UNAUTHORIZED_API = "UnAuthorized Api";
	final public static String INTERNAL_SERVER_ERROR = "Internal Server error. Please Contact Administrator";
	final public static String EMPTY_CLIENTID = "Client id is empty";
	final public static String EMPTY_ACCESSTOKEN = "access token is empty";
	final public static String EMPTY_APPLICATIONTYPE = "Application Type is empty";
	final public static String EMPTY_USERNAME = "UserName is empty";
	final public static String INVALID_USERNAME = "Invalid UserName";
	final public static String INVALID_PASSWORD = "Invalid password";
	final public static String CANNOT_FETCH_CLIENT = "Cannot Fetch Client ID";
	final public static String EMPTY_MEMBERGUID = "Empty MemberGUID";
	final public static String INVALID_MEMBERGUID = "Invalid MemberGUID";

	final public static String EMPTY_PASSWORD = "Password is empty";
	final public static String INVALID_CLIENT_DETAILS = "Invalid Client Details";
	final public static String EMPTY_CLIENT_SECRET_KEY = "Client Secret key is empty";
	final public static String VERIFY_YOUR_EMAIL = "Please Verify your Email.";

	final public static String INVALID_USERNAME_AND_PASSWORD = "Invalid Email/Phone Number or Password";

	final public static String EMPTY_AUTHORIZATION_CODE = "Authorization code is empty";
	final public static String INVALID_REDIRECT_URI = "Invalid Redirect URL";

	// EMAIL CONSTANTS
	final public static String EMAIL_TYPE_REG_VERIFY = "reg-active";
	final public static String EMAIL_TYPE_REG_ACK = "reg-acknowledge";
	final public static String EMAIL_TYPE_LOYALTY_REG_ACK = "loyalty-reg-acknowledge";
	final public static String EMAIL_TYPE_FORGET_PASS = "forget-pass";
	final public static String EMAIL_TYPE_UNSUBSCRIBE_LINK="unsubscribe-link";

	final public static int INVALID_UNAME_AND_PASSWORD = 0;
	final public static int VERIFY_EMAIL_DONE = 1;
	final public static int VERIFY_EMAIL_NOT_DONE = 2;
	final public static int INTERNAL_ERROR = 3;

	final public static int FORGET_INTERNAL_ERROR = 0;
	final public static int FORGET_UPDATE_SUCCESS = 1;
	final public static int FORGET_VERIFY_INPUTS = 2;

	final public static String EMAIL_SEND_SUCCESS = "Email Sent Successfully.";
	final public static String EMAIL_SEND_FAILURE = "Unable to send email.";
	final public static String EMAIL_SEND_UNAUTHORIZED = "User is not authorised to send emails";

	final public static int SUCCESS_STATUS = 1;

	final public static String CONDITION_NOT_SATISFIED = "Where Condition Not Satisfied";

	final public static String VISIBLE = "1";
	final public static String INVISIBLE = "0";
	final public static String CONFIG_GROUP = "ConfigGroup";
	final public static String CONFIG_VALUE = "ConfigValue";
	final public static String CONFIG_NAME = "ConfigName";
	final public static String CONFIG_DISPLAY_LABEL = "ConfigDisplayLabel";
	final public static String CONFIG_DISPLAY_SEQ = "ConfigDisplaySeq";
	final public static String MANDATORY = "Mandatory";
	final public static String FIELD_ACTIVE = "Active";
	final public static String LOYALTY_CUSTOMER_SUPPORT="LoyaltyCustomerSupport";

	final public static String EMPTY_CONFIG_GROUP_NAME = "Config Group Name is Empty";
	final public static String EMPTY_CONFIG_NAME = "Config Name is Empty";
	final public static String EMPTY_CONFIG_VALUE = "Config Value is Empty";

	final public static String TENANT_ID = "Id";
	final public static String SCHEMA_NAME = "SchemaName";

	final public static String FB_BUCKET_NAME = "fbappbucket";
	final public static String FB_FILES_BUCKET_NAME = "fishbowlfiles";
	final public static String FB_S3_INSTANCE_ID = FB_BUCKET_NAME;
	final public static String FB_LOYALTY_FOLDER_NAME = "loyalty";
	final public static String FB_UPLOADED_FILEURL = "fileUrl";

	public static final HashMap<String, String> MimeTypeMap;
	static {
		MimeTypeMap = new HashMap<String, String>();
		MimeTypeMap.put("application/pdf", "pdf");
		MimeTypeMap.put("application/csv", "csv");
	}

	// Forget Password
	final public static String KEY_EMPTY = "key_empty";
	final public static String VERIFY_SUCCESS = "verify_success";
	final public static String MAIL_EXPIRED = "mail_expired";
	final public static String MAIL_INVALID = "mail_invalid";

	// STORES
	final public static int STORES_RETRIEVE_COUNT = 10;
	final public static int STORES_RETRIEVE_ALL = 10000;
	final public static int STORES_RETRIEVE_RADIUS = 20; // per miles
	final public static String COUNT_IS_EMPTY = "Count is Empty";
	final public static String COUNT_SHOULD_NOT_BE_ZERO = "Count Should not be 0";
	final public static String LATITUDE_IS_EMPTY = "Latitude is Empty";
	final public static String LONGITUDE_IS_EMPTY = "Longitude is Empty";
	final public static String RADIUS_IS_EMPTY = "Radius is Empty";
	final public static String STORE_LIST_IS_EMPTY = "Store List is Empty";
	public static final String STORE_NOT_FOUND = "Stores Not Found";
	
	public static final String RULE_NOT_FOUND = "Rule Not Found";


	public static final String STORE_DETAILS_NOT_FOUND = "Store Details Not Found";
	public static final String INVALID_STORE_ID = "Store Id should be greater than 0";
	final public static String AD_LIST_IS_EMPTY = "Ad List is Empty";
	// BLACKOUTDATES CONSTANT
	final public static String BLACKOUT_REQUEST_NOT_CORRECT = "Request data is not correct.Please correct & try again";
	final public static String BLACKOUT_START_DATE_REQUIRED = "Blackout request data is not correct.Please enter start date & try again";
	final public static String BLACKOUT_END_DATE_REQUIRED = "Blackout request data is not correct.Please enter end date & try again";
	final public static String BLACKOUT_END_DATE_GREATER_THAN_START_DATE_REQUIRED = "Blackout request data is not correct.End date must be on or after Begin Date";
	final public static String BLACKOUT_DATES_CONFLICTS_EXIST = "Blackout dates conflicts occurred.Please check dates again.";
	final public static String BLACKOUT_DATES_CONFLICTS_NOT_EXIST = " No blackout dates conflicts found.";

	// GENERIC CONSTANTS
	final public static String ID_CAN_NOT_BE_LESS_THAN_ZERO_OR_ZERO = "Request Data is incorrect. Id can not be negative or zero.";
	final public static String UNSUBSCRIBED_SUCESS = "Thank you. You have been un-subscribed from receiving further promotions from us.";
	final public static String REQUEST_DATA_NOT_CORRECT = "Request data is not correct.Please correct & try again";
	final public static String UPDATED_MORE_THAN_ONE_RECORD = "Something Wrong ! More than one Record got updated.";
	final public static String DELETED_MORE_THAN_ONE_RECORD = "Something Wrong ! More than one Record got deleted.";
	final public static String EXCEPTION_OCCURED_WHILE_PROCESSING_THE_REQUEST = "Something Wrong ! Got an exception while processing your request.";

	// PASSBOOK
	final public static String PASSBOOK_FOLDER_UNABLE_TO_DELETE = " Unable to Delete PassbookFolder. PassbookFolder must be empty to delete it.";

	final public static int RESIZE_IMAGE_WIDTH = 200;
	final public static int RESIZE_IMAGE_HEIGHT = 200;

	public static String FILE_UPLOAD_ERROR = "File Not Uploaded";

	// Targeting
	public static final String OPEN_TINY_URL = "OPEN_TINY_URL";
	public static final String OPTOUT_TINY_URL = "OPTOUT_TINY_URL";
	public static final String AWS_KEY_ID = "AWS_KEY_ID";
	public static final String AWS_SECRET_KEY = "AWS_SECRET_KEY";
	public static final String AWS_END_POINT = "AWS_END_POINT";
	public static final String TWILIO_SID = "TWILIO_SID";
	public static final String TWILIO_PHONE_NO = "TWILIO_PHONE_NO";
	public static final String TWILIO_AUTH_TOKEN = "TWILIO_AUTH_TOKEN";
	public static final String PLIVO_AUTH_ID = "PLIVO_AUTH_ID";
	public static final String PLIVO_AUTH_TOKEN = "PLIVO_AUTH_TOKEN";

	// SMS Handler
	public static final String SMS_DEFAULT_KEYWORD = "SMS_DEFAULT_KEYWORD";
	public static final String SMS_DEFAULT_KEYWORD_MESSAGE = "SMS_DEFAULT_KEYWORD_MESSAGE";
	public static final String SMS_DEFAULT_HELP_MESSAGE = "SMS_DEFAULT_HELP_MESSAGE";
	public static final String SMS_DEFAULT_INVALID_MESSAGE = "SMS_DEFAULT_INVALID_MESSAGE";
	public static final String SMS_DEFAULT_STOP_MESSAGE = "SMS_DEFAULT_STOP_MESSAGE";

	// RESET PASSWORD CONSTANTS
	public static final String PASSWORD_RESET_FAILED = "Password reset failed. Please try again latter.";
	public static final String PASSWORD_RESET_SUCCESS = "Password has been reset successfully.";
	public static final String USER_NOT_EXISTS = "User not exists.";
	public static final String PASSWORD_RESET_TOKEN_WRONG = "Password Token is incorrect.Please correct and try again.";

	public static final String UPLOADFILES = "/srv/files/fishbowl/";
	public static final String EMPTY_PASS_BYTE_ARRAY = "Pass is empty.";

	public static final String MALE = "male";
	public static final String FEMALE = "female";
	public static final String MALE_SINGLE = "m";
	public static final String FEMALE_SINGLE = "f";
	
	public static final String GENDER_WRONG = "Gender is wrong";
 

//	public static final String EMAIL_ALREADY_EXISTS = "Err! Email Already Exists.";
//	public static final String PHONE_ALREADY_EXISTS = "Err! Phone Number Already Exists";
//
//	public static final String JSON_PARSE_EXCEPTION = "Unable to parse the given json. Please correct and try again.";

	public static final String EMAIL_ALREADY_EXISTS="Email address already exists.";
	public static final String PHONE_ALREADY_EXISTS="Phone number already exists";
	public static final String EMAIL_OR_PHONE_EXISTS="Either email address or phone number exists";
	
	public static final String JSON_PARSE_EXCEPTION ="Unable to parse the given json. Please correct and try again.";

	final public static int MAXSEGMENTCOUNT = 500;

	// Admin
	public static final String FILE_FORMAT_ALREADY_EXIST = "This Fileformat Already Exist";
	public static final String FONT_ALREADY_EXIST = "This Font Already Exist";
	public static final String INVALID_FONT_FORMAT = "Invalid File Format";
	public static final String FONT_ID = "fontId";
	public static final String NO_UPDATES_IN_FONTS = "No change in fonts";

	public static final String USER_AUTH_NULL_OR_INVALID = "USER AUTH IS EITHER NULL OR INVALID";

	// Batch

	final public static int BATCH_SUCCESS = 0;
	final public static int BATCH_FAILED = 1;
	final public static int BATCH_NO_RECORDS = 2;
	final public static int BATCH_FAILED_TRUNCATE = 3;

	final public static int BATCH_TRUNCATE_SUCCESS = 0;
	final public static int BATCH_TRUNCATE_FAILED = 1;

	// InAppAd
	public static final String AD_TYPE_LIST_IS_EMPTY = "Ad Type List is Empty";
	public static final String AD_LOCATION_LIST_IS_EMPTY = "Ad Location List is Empty";
	public static final String AD_PAGES_WITH_LOCATION_LIST_IS_EMPTY = "Ad PagesWithLocation List is Empty";
	public static final long AD_TYPE_MESSAGE = 1;
	public static final long AD_TYPE_ID_OFFER = 2;
	public static final String AD_TYPE_OFFER = "OFFER";
	public static final String AD_IS_EMPTY = "Currently  Ad is not Available";
	public static final String ACTIONPAGE_EMPTY_INPUTS = "ClientId/ActionPageID is Empty";
	public static final String LOCATION_BY_PAGE_EMPTY_INPUTS = "ClientId/PageID is Empty";
	public static final long NO_ACTION = 1;
	public static final long APP_PAGE = 2;
	public static final long BROWSER_URL = 3;
	public static final long OFFER_COUPON_FULL_POPUP_ID = 4;
	public static final long OFFER_COUPON_PROVISIONING_ID = 5;
	public static final String OFFER_COUPON_FULL_POPUP = "Offer Coupon Full Popup";
	public static final String OFFER_COUPON_PROVISIONING = "Offer Coupon Provisioning";
	public static final String OFFER_COUPON_PROVISION_IS_EMPTY = "Offer Coupon Provision is Empty";
	
	public static final String AD_TEMPLATE_IMAGE_NAME_IS_EMPTY = "Ad Template Image Name is Empty";
	public static final String AD_TEMPLATE_IMAGE_URL_IS_EMPTY = "Ad Template Image URL is Empty";
	public static final String AD_ID_IS_ZERO = "Id should not be 0";
	public static final String FAILED_TO_DELETE = "Failed to delete. So Please check Ad Id";
	public static final String ADCAROUSEL_EMPTY_INPUTS = "ClientId/AdID is Empty";
	public static final String AD_ACTION_PAGE_IS_EMPTY = "Ad Action Page is Empty";
	
	public static final String AD_ACTION_PAGE_LIST_IS_EMPTY ="Ad Action Page List is Empty";
	public static final String CONFIGURATION_ALREADY_CREATED = "This configuration is already created";
	public static final String AD_ID = "id";
	public static final String AD_PAGE_ID = "AdPageId";
	public static final String AD_LOCATION_ID = "AdLocationId";
	public static final String MEMBER_ID = "MemberId";
	public static final String IN_APP_AD_DATE = "yyyy-MM-dd";
	public static final String STORE_AD_LOCATION_LIST_IS_EMPTY = "Store Ad Location List is Empty";
	public static final String AD_PAGES_LIST_IS_EMPTY = "Ad Page List is Empty";
	public static final String AD_ACTION_LIST_IS_EMPTY = "Ad Action List is Empty";
	public static final String OFFER_DISPLAY_TYPE_LIST_IS_EMPTY = "Offer Display Type List is Empty";
	public static final String FONT_FAMILY_LIST_IS_EMPTY = "Font Family List is Empty";
	public static final String FONT_SIZE_LIST_IS_EMPTY = "Font Size List is Empty";
	public static final String FONT_WEIGHT_LIST_IS_EMPTY = "Font Weight List is Empty";
	public static final String LOCATION_ID_IS_EMPTY = "Location Id is Empty";
	public static final String PAGE_ID_IS_EMPTY = "Page Id is Empty";
	public static final String MEMBER_ID_IS_EMPTY = "MemberId is Empty";
	public static final String INVALID_INPUT = "Invalid Input";
	public static final String AD_CAROUSEL_LIST_IS_EMPTY = "Ad Caurosel List is Empty";
	public static final String AD_FULLPAGE_TEMPLATE_IS_EMPTY = "Ad fullpage list is Empty";
	public static final String DEFAULT_IMAGE_NAME_IS_EMPTY = "Default Image Name is Empty";
	public static final String DEFAULT_IMAGE_IS_EMPTY = "Default Image URL is Empty";
	public static final String INVALID_AD_TYPE = "Invalid Ad Type";
	public static final String AD_TYPE_IS_EMPTY = "Ad Type is empty";
	public static final String AD_LOCATION_ID_IS_EMPTY = "Ad Location Id is 0";
	public static final String AD_ACTION_IS_EMPTY = "Ad Action is Empty";
	public static final String AD_SOURCE_PAGE_ID_IS_EMPTY = "Ad Source Page Id is 0";
	public static final String AD_PAGE_ID_IS_EMPTY = "Ad Source Page Id is 0";
	public static final String INVALID_ID = "Invalid Id";
	public static final String INVALID_MEMBER_ID = "Invalid Member Id";
	public static final String INVALID_COUPON_CODE = "Invalid Coupon Code";

	public static final String START_INDEX = "StartIndex";
	public static final String COUNT = "Count";
	public static final String AD_TITLE_IS_EMPTY = "Ad Title is Empty";
	public static final String VALIDITY_START_DATE_IS_EMPTY = "Validity StartDate is Empty";
	public static final String INVALID_VALIDITY_START_DATE_PATTERN = "Invalid Validity StartDate Pattern";
	public static final String VALIDITY_START_DATE_IS_INVALID = "Validity StartDate is less than current Date";
	public static final String VALIDITY_END_DATE_IS_EMPTY = "Validity EndDate is Empty";
	public static final String INVALID_VALIDITY_END_DATE_PATTERN = "Invalid Validity EndDate Pattern";
	public static final String AD_ACTION_PAGE_ID_IS_EMPTY = "Ad Action Page Id is 0";
	public static final String AD_ACTION_PAGE_URL_IS_EMPTY = "Ad Action Page Url is Empty";
	public static final String INVALID_ACTION= "Invalid Ad Action";
	public static final String TEMPLATE_IMAGE_URL_IS_EMPTY = "Template Image Url is Empty";
	public static final String DISPLAY_ORDER_IS_EMPTY = "Display Order is 0";
	public static final String THUMB_IMAGE_URL_IS_EMPTY = "Thumb Image Url is Empty";
	public static final String AD_CONTENT_IS_EMPTY = "Ad Content is Empty";
	public static final String HEADER_URL_IS_EMPTY = "Header Url is Empty";
	public static final String BACKGROUND_URL_IS_EMPTY = "Background ImageUrl is Empty";
	public static final String AD_TITLE_ID_IS_EMPTY = "Ad Title Id is 0";
	public static final String AD_SUBTITLE_ID_IS_EMPTY = "Ad SubTitle Id is 0";
	public static final String AD_DISCLAIMER_ID_IS_EMPTY = "Ad Disclaimer Id is 0";
	public static final String OFFER_ID_IS_EMPTY = "Offer Id is 0";
	public static final String OFFER_DISPLAY_TYPE_ID_IS_EMPTY = "Offer Display type id is 0";
	public static final String LOGO_URL_IS_EMPTY = "Logo url is Empty";
	public static final String CONTENT_HTML_IS_EMPTY = "Content HTML is Empty";
	public static final String FOOTER_ID_IS_EMPTY = "Footer id is 0";
	public static final String FAILED_TO_CREATE_AD = "Failed to create Ad";
	
	public static final String AD_LOGO_URL_IS_EMPTY = "Ad Logo Url is Empty";
	public static final String AD_ID_IS_EMPTY = "Ad Id is 0";
	public static final String AD_CONTENT_ID_IS_EMPTY = "AdContent Id is 0";
	public static final String START_INDEX_SHOULD_NOT_BE_ZERO = "Start Index should not be 0";
	public static final String INVALID_AD_FULL_PAGE_TEMPLATE_ID = "Ad fullpage template id is 0 or invalid";

	public static final String INAPP_AD_DATE = "yyyy-MM-dd HH:mm:ss";
	
	 //Create AdSourcePage 


	public static final String ADTEMPLATE_OBJECT_IS_EMPTY = "AdTemplate Object is Empty";
	// Create AdPage
	final public static int CREATE_AD_PAGE_SUCCESS = 1;
	final public static int CREATE_AD_PAGE_FAILED = 0;

	final public static String AD_SOURCE_PAGE_CREATE_SUCCESS = "Ad Source Page Created Successfully";
	final public static String AD_SOURCE_PAGE_CREATE_FAILED = "Ad Source Page Creation Failed";

	// Update AdSourcePageName
	final public static String AD_SOURCE_PAGE_UPDATE_SUCCESS = "Ad Source Page Updated Successfully";
	final public static String AD_SOURCE_PAGE_UPDATE_FAILED = "Ad Source Page Updation Failed";

	// Delete AdSourcePage
	final public static String AD_SOURCE_PAGE_DELETE_SUCCESS = "Ad Source Page Deleted Successfully";
	final public static String AD_SOURCE_PAGE_DELETE_FAILED = "Ad Source Page Deletion Failed";

	final public static String AD_IN_DRAFT = "Draft";
	final public static String AD_IN_LIVE = "Live";
	final public static String AD_IN_EXPIRED = "Expired";

	final public static String STORE_AD_SUCCESS = "SUCCESS";
	final public static String STORE_AD_FAILED = "FAIL";

	final public static String STORE_AD_CREATE_SUCCESS = "Ad Created Successfully";
	final public static String STORE_AD_CREATE_FAILED = "Ad Creation Failed";
	final public static String EXPIRE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	final public static String DEVICE_NOT_EXISTS = "No device exists for member";
	
	final public static String DEVICE_ID = "deviceId";
	final public static String DEVICE_ID_EMPTY = "deviceId is empty in header";

	public static final String MEMBER_ALREADY_EXISTS = "Member Already Exists.";
	public static final String EMPTY_REQUEST_URL = "Err! Request url is empty";

	// AdLocation
	public static final String AD_LOCATION_IS_EMPTY = "Ad Location is Empty";
	public static final String AD_LOCATION_NAME_IS_EMPTY = "Ad Location Name is Empty";
	public static final String AD_LOCATION_UPDATE_SUCCESS = "Ad Location Updated Successfully";
	public static final String AD_LOCATION_UPDATE_FAILED = "Ad Location Updated Failed";
	
	public static final String SEGMENT_CAN_NOT_BE_DELETED = "Segment can not be deleted, it is currently used by campaigns";
	final public static String LOYALTY_CARD_CREATION_NOTES = "Loyalty Card Creation";
	final public static String LOYALTY_CARD_UPDATION_NOTES = "Loyalty Card Updation";
	final public static String LOYALTY_CARD_DELETION_NOTES = "Loyalty Card Deletion";
	final public static String LOYALTY_CARD_READ_NOTES = "Loyalty Card Read";
	
	final public static String LOYALTY_CARD_API_NOT_FOUND = "Loyalty Card API Not Found";

	public static final String AD_LOCATION_DELETE_SUCCESS = "Ad Location Deleted Successfully";
	public static final String AD_LOCATION_DELETE_FAILED = "Ad Location Deletion Failed";

	public static final String INVALID_AD_ACTION_ID = "Invalid AdActionId";
	public static final String INVALID_AD_LOCATION_ID = "Invalid AdLocationId";
	public static final String STARTDATE_AFTER_ENDDATE = "StartDate should not be after EndDate";
	public static final String STARTDATE_EQUAL_TO_ENDDATE = "StartDate and EndDate should not be same";

	public static final String AD_CONFIGURATION_IS_EMPTY = "AdConfiguration is Empty";
	public static final String INVALID_ADSOURCEPAGELOCATIONId = "AdSourcePageLocationId is Invalid";

	
	public static final String SETTING_ENTERPRISE_ENABLED = "ENTERPRISE_ENABLED";
 
	public static final String PAGE_NOT_FOUND = "Page Not Found";
	public static final String LOCATION_NOT_FOUND = "Location Not Found";

	public static final String AD_VIEW_HISTORY_CREATE_SUCCESS = "Ad View History is Created";
	public static final String AD_VIEW_HISTORY_CREATE_FAILED = "Ad View History Creation Failed";
	public static final String AD_CLICK_HISTORY_CREATE_SUCCESS = "Ad Click History is Created";
	public static final String AD_CLICK_HISTORY_CREATE_FAILED = "Ad Click History Creation Failed";
	public static final String AD_LOCATION_CREATE_SUCCESS = "Ad Location is created Successfully";
	public static final String AD_LOCATION_CREATE_FAILED = "Ad Location is creation failed";
	public static final String AD_SOURCE_PAGE_LOCATION_NOT_FOUND = "AdSourcePage not found";
	public static final String AD_LOCATION_ID_SHOULD_NOT_BE_ZERO = "Ad Location Id should not be Zero";
	public static final String AD_SOURCE_PAGE_ID_SHOULD_NOT_BE_ZERO = "Ad Source Page Id should not be Zero";
	public static final String AD_SOURCE_PAGE_LOCATION_DELETE_SUCCESS = "Ad Source Page Location Deleted";
	public static final String AD_SOURCE_PAGE_LOCATION_DELETION_FAILED = "Ad Source Page Location Deletion Failed";
	public static final String AD_LOCATION_ID_CREATE_SUCCESS = "Ad Location Id Created";
	public static final String AD_LOCATION_ID_CREATE_FAILED = "Ad Location Id creation Failed";
	public static final String AD_LOCATION_NOT_EXIST = "Ad Location not Exist";
	public static final String AD_SOURCE_PAGE_NOT_EXIST = "Ad Source Page not Exist";
	public static final String AD_CAMPAIGN_LIST_IS_EMPTY = "Ad Campaigns list is Empty";
	
	// AdActionpage

	final public static String AD_ACTION_PAGE_CREATE_SUCCESS = "Ad Action Page Created Successfully";
	final public static String AD_ACTION_PAGE_CREATE_FAILED = "Ad Action Page Creation Failed";

	final public static String AD_ACTION_PAGE_UPDATE_SUCCESS = "Ad Action Page Updated Successfully";
	final public static String AD_ACTION_PAGE_UPDATE_FAILED = "Ad Action Page Update Failed";

	// Delete AdSourcePage
	final public static String AD_ACTION_PAGE_DELETE_SUCCESS = "Ad Action Page Deleted Successfully";
	final public static String AD_ACTION_PAGE_DELETE_FAILED = "Ad Action Page Deletion Failed";

	// Create AdConfiguration
	final public static String DUPLICATE_LOCATION = "You are creating Duplicate Location. So please check your input";
	final public static String CAROUSEL_LIST_IS_EMPTY = "CarouselList is Empty";
	final public static String LOCATION_ALREADY_EXIST = "This location is already created in this page";
	final public static String EMPTY_PAGE_NAME = "PageName is Empty";
	final public static String EMPTY_PAGE_LINK = "PageLink is Empty";
	final public static String EMPTY_LOCATION_LIST = "Location List is Empty";
	final public static String PAGENAME_ALREADY_EXIST = "This page Name Already Exist";
	final public static String PAGELINK_ALREADY_EXIST = "This page link Already Exist";
	final public static String CAROUSEL_DEFAULT_IMAGE_NAME_IS_EMPTY = "Carousel Default Image Name is Empty";
	final public static String CAROUSEL_DEFAULT_IMAGE_URL_IS_EMPTY = "Carousel Default Image URL is Empty";
	final public static String CAROUSEL_PAGE_ID_IS_EMPTY = "Carousel Page Id is Empty";
	public static final String FAILED_TO_DELETE_CONFIGURATION = "Failed to delete. So Please check Id";
	public static final String CONFIGURED_PAGE_IS_EMPTY = "Currently no page is configured";

	
	//Column Name not exists
	public static final String COLUMN_NOT_EXIST = "Column name not exist";
	
	// loyalty Frequency Job scheduler 
	 public static final int ZERO = 0;
	 public static final String INVALID_LOYALTY_PERIOD ="Invalid LoyaltyPeriod";
	 public static final String CURRENTLY_NO_JOB_AVAILABEL = "Currently No Jobs Available";
	 public static final String LOYALTYPERIOD_IS_EMPTY = "LoyaltyPeriod is Empty";
	 public static final String SCHEDULE_START_TIME_IS_EMPTY = "ScheduleStartTime is Empty";
	 public static final String SCHEDULE_START_TIME_IS_INVALID = "ScheduleStartTime is invalid";
	 public static final String SCHEDULE_START_TIME_EXCEEDS_24HRS = "ScheduleStartTime should be within or equal to 24hrs";
	 public static final String FREQUENCY_PERIODICITY_IS_EMPTY = "FrequencyPeriodicity is Empty";
	 public static final String FREQUENCY_PERIODICITY_CONTAINS_INVALID_INPUT = "FrequencyPeriodicity Contains invalid input";;
	 public static final String WEEK_CONTAINS_MORETHAN_SEVANDAYS = "Sevan Days For a week. So please check your input";
	 public static final String MONTH_CONTAINS_MORETHAN_31_DAYS = "Maximum 31 Days For a Month. So please check your input";

	 public static final String CUSTOM_LOGIN_COOKIE ="customLogin";
	 public static final String PA_QUEUE ="paqaqueue-notification-";
	 
	 // AdLocationId 
	 public static final int CAROUSEL = 3;
	 public static final String CAROUSEL_PAGE = "Carousel";

	 // inAppAdOffer
	  
	 public static final String AD_CONTENT_THUMB_IMAGE_URL_IS_EMPTY = "AdContentThumbImageUrl is Empty";
	 public static final String AD_CONTENT_OBJECT_IS_EMPTY = "Ad Content Details is Empty";
	 public static final String AD_OFFER_BACKGROUND_URL_IS_EMPTY = "Background Url is Empty";
	 public static final String AD_OFFER_CONTENT_HTML_IS_EMPTY = "Content Html is Empty";
	 public static final String AD_OFFER_HEADER_URL_IS_EMTPY = "Header Url is Empty";
	 public static final String AD_OFFER_LOGO_URL_IS_EMPTY = "Logo Url is Empty";
	 public static final String AD_OFFER_TITLE_IS_EMPTY = "Ad offer Title is Empty";
	 public static final String AD_OFFER_TITLE_FONT_NAME_IS_EMPTY = "Font Name of Title is Empty";
	 public static final String AD_OFFER_TITLE_FONT_COLOR_IS_EMPTY = "Font Color of Title is Empty";
	 public static final String AD_OFFER_TITLE_FONT_WEIGHT_IS_EMPTY = "Font weight of Title is 0";
	 public static final String AD_OFFER_TITLE_FONT_SIZE_IS_EMPTY = "Font Size of Title is 0";
	 
	 public static final String AD_OFFER_SUBTITLE_IS_EMPTY = "Ad offer Sub-Title is Empty";
	 public static final String AD_OFFER_SUBTITLE_FONT_NAME_IS_EMPTY = "Font Name of Sub-Title is Empty";
	 public static final String AD_OFFER_SUBTITLE_FONT_COLOR_IS_EMPTY = "Font Color of Sub-Title is Empty";
	 public static final String AD_OFFER_SUBTITLE_FONT_WEIGHT_IS_EMPTY = "Font weight of Sub-Title is 0";
	 public static final String AD_OFFER_SUBTITLE_FONT_SIZE_IS_EMPTY = "Font Size of Sub-Title is 0";
	 
	 public static final String AD_OFFER_DISCLAIMER_IS_EMPTY = "Ad offer Disclaimer is Empty";
	 public static final String AD_OFFER_DISCLAIMER_FONT_NAME_IS_EMPTY = "Font Name of Disclaimer is Empty";
	 public static final String AD_OFFER_DISCLAIMER_FONT_COLOR_IS_EMPTY = "Font Color of Disclaimer is Empty";
	 public static final String AD_OFFER_DISCLAIMER_FONT_WEIGHT_IS_EMPTY = "Font weight of Disclaimer is 0";
	 public static final String AD_OFFER_DISCLAIMER_FONT_SIZE_IS_EMPTY = "Font Size of Disclaimer is 0";
	 
	 public static final String AD_OFFER_FOOTER_IS_EMPTY = "Ad offer Footer is Empty";
	 public static final String AD_OFFER_FOOTER_FONT_NAME_IS_EMPTY = "Font Name of Footer is Empty";
	 public static final String AD_OFFER_FOOTER_FONT_COLOR_IS_EMPTY = "Font Color of Footer is Empty";
	 public static final String AD_OFFER_FOOTER_FONT_WEIGHT_IS_EMPTY = "Font weight of Footer is 0";
	 public static final String AD_OFFER_FOOTER_FONT_SIZE_IS_EMPTY = "Font Size of Footer is 0";
	 

	 // GetAll SourcePageLocations 
	 public static final String PAGE_LIST_IS_EMPTY = "Page List is Empty";
	 
	 // Coupon Download
	public static final String IS_NOT_COUPON = "Ad type is not coupon";
	public static final String AD_OFFER_TYPE = "Offer";
	public static final String FILE_DOWNLOADED = "File Downloaded Successfully";
	public static final String COUPON_CANNOT_BE_DOWNLOADED = "Coupon cannot be Downloaded";
	public static final String AD_OFFER_CONTENT_IS_EMPTY = "Ad Offer Content is Empty";

	 // CarouselPage
	 public static final String CAROUSEL_PAGES_ARE_EMPTY = "Carousel Page List is Empty";
	 
	 // GetAdByAdSourcePageLocationId
	 public static final String SOURCE_PAGE_LOCATION_IS_IS_EMPTY = "SourcePageLocation id is Empty";
	 public static final String CURRENTLY_NO_AD_AVAILABLE_FOR_THIS_LOCATION ="Currently No Ad is Available for this Location";
	 public static final String DEFAULT_LOYALTY_POINTS="0";
	 
	 //Create Ad Offer
	public static final String AD_OFFER_HTML_CONTENT_IS_EMPTY = "Ad Offer HTML content is Empty";
	public static final String AD_OFFER_PROMOTION_ID_IS_EMPTY = "Ad Offer Promotion Id is Empty";
	public static final String AD_OFFER_CONTENT_THUMB_IMAGE_URL_IS_EMPTY = "Ad offer content thumb Image Url is Empty";
	public static final long FULL_PAGE_POP_UP = 4;
	
	//Search Ad
	public static final String AD_TYPE_ID_IS_ZERO = "Ad Type Id is zero";
	public static final String AD_ACTION_ID_IS_ZERO = "Ad Action Id is zero";
	public static final String AD_PAGE_ID_IS_ZERO = "Ad Page Id is Zero";
	public static final String INPUT_VALUE_EMPTY = "Input Value is Empty";
	public static final String START_DATE_IS_INVALID = "Start Date is Invalid";
	public static final String END_DATE_IS_INVALID = "End Date is Invalid";
	public static final String STATUS_IS_INVALID = "Status is Invalid";
	public static final int STATUS_COMPLETED = 3;
	public static final int STATUS_SCHEDULED = 2;
	public static final int STATUS_ACTIVE = 1;
	
	public static final String COUPON_EXPIRATION_OPTION_SEND = "SEND";
	public static final String COUPON_EXPIRATION_OPTION_VISIT = "VISIT";
	
	// Store 
	public static final String OPEN = "OP";
	public static final String COMING_SOON = "CS";
	public static final String TEMPORARILY_CLOSED = "TC";

 
	public static final String CLOSE = "CL";
	public static final String ONLY_CA_STORE = "CA";
	public static final int CAMPAIGN_STATUS_COMPLETE=4;
	public static final String COMPLETE = "COMPLETE";
	public static final int CAMPAIGN_STATUS_ACTIVE =2;
	public static final int WINNING_CRITERIA_LOOKUP_KEY_4=4;
	public static final int STORE_OPEN_STATUS = 3;
	public static final String STORE_ZIPCODE_RADIUS_CONFIG="STORE_ZIPCODE_RADIUS_ZIPAPPEND_SMS";
	public static final String DEFAULT_ZIPCODE_RADIUS="50";
	
	//Member Change Password
	public static final int PASSWORD_MISMATCH = 2;
	public static final int PASSWORD_VALIDATION_FAILED =3;
	public static final String VERIFY_OLD_PASSWORD_ENTERED = "Please Verify the Old Password Entered";
	
	//Member Message Type
	public static final int MEMBER_MESSAGE_TYPE_PUSH = 5;
	public static final int MEMBER_MESSAGE_TYPE_SMS = 3;
	public static final int MEMBER_MESSAGE_TYPE_EMAIL = 1;
	public static final String MESSAGE_TYPE_SMS = "SMS";
	public static final String MESSAGE_TYPE_EMAIL = "Email";
	public static final String MESSAGE_TYPE_PUSH = "Push";
	public static final String MESSAGE_TYPE_PULL = "Pull";
	
	public static final String EMAIL_TYPE = "ForgetPasswordMail";
	
	public static final int LOYALTY_MESSAGEID_LENGTH = 15;
	public static final int HYPHEN_NUMBERS = 4;
	
	public static final String LOYALTY_CONTACTUS_REQUEST_TYPE = "LOYALTY_CONTACTUS_REQUEST_TYPE";
	public static final String LOYALTY_CONTACTUS_AREA = "LOYALTY_CONTACTUS_AREA";
	
	public static final String MEMBER_PROFILE_DISPLAY_TAB = "DisplayTab";
	public static final String MEMBER_PROFILE_DISPLAY_ITEM = "DisplayItem";
	public static final String MEMBER_PROFILE_DISPLAY_ITEM_SHOW_LOYALTYCARD = "EnableLoyaltyCard";
	public static final String MEMBER_PROFILE_DISPLAY_ITEM_SHOW_ADS = "EnableAds";
	public static final String MEMBER_PROFILE_DISPLAY_ITEM_SHOW_STORE_LOCATION = "EnableStoreLocation";
	public static final Object CORE_LOYALTY = "Core Loyalty";
	
	public static final String LEVEL_1="level1";
	public static final String LEVEL_2="level2";
	public static final String LEVEL_3="level3";
	
	public static final String NO_RECORDS_FOUND = "No Records Found";
	
	public static final int OFFER_EMAIL_CHANNEL = 1;
	public static final int OFFER_SMS_CHANNEL = 3;
	public static final int OFFER_PUSH_CHANNEL = 5;
	
	public static final int LOYALTY_LICENSE_PRODUCT_ID = 4;
	public static final int LOYALTY_LICENSE_FEATURE_ID = 4;
	
	public static final String FISHBOWL = "fishbowl";
	// Menu configSettins
	public static final String GET_FAMILY_CONFIG_VALUE = "Family";
	public static final String GET_CATEGORY_CONFIG_VALUE = "Category";
	public static final String GET_SUBCATEGORY_CONFIG_VALUE = "SubCategory";
	public static final String GET_PRODUCT_OPTION_CONFIG_VALUE = "ProductOption";
	public static final String GET_PRODUCT_MODIFIER_CONFIG_VALUE = "ProductModifier";
	public static final String GET_PRODUCT_ALLERGENS_CONFIG_VALUE = "ProductAllergens";
	public static final String GET_PRODUCT_INCREDIENTS_CONFIG_VALUE = "ProductIncredients";
	public static final String GET_PRODUCT_NUTRIENT_CONFIG_VALUE = "ProductNutrient";
	public static final String GET_PRODUCT_SIZE_CONFIG_VALUE = "ProductSize";
	
	// setting visibility of response type
	public static final String CONFIG_NAME_SMSOPTIN = "SMSOptIn";
	public static final String CONFIG_NAME_PUSHOPTIN = "pushOptIn";
	public static final String CONFIG_NAME_EMAILOPTIN = "EmailOptIn";
	public static final String PRODUCTID_MARKETING_AUTOMATION = "Marketing Automation";
	public static final String EMAIL_FEATUREID = "MA-Email";
	public static final String SMS_FEATUREID = "MA-SMS";
	public static final String PUSH_FEATUREID = "MA-Mobile";
	
	public static final String FORGET_PASSWORD_FROM_EMAIL_ADDRESS = "FORGET_PASSWORD_FROM_EMAIL_ADDRESS";
	public static final String FORGET_PASSWORD_FROM_EMAIL_NAME = "FORGET_PASSWORD_FROM_EMAIL_NAME";
	public static final String RESET_PASSWORD_SUBJECT = "RESET_PASSWORD_SUBJECT";
	public static final String FORGOT_PASSWORD_SUBJECT = "FORGOT_PASSWORD_SUBJECT";
	public static final String WELCOME_MAIL_FROM_EMAIL_ADDRESS = "WELCOME_MAIL_FROM_EMAIL_ADDRESS";
	public static final String WELCOME_MAIL_FROM_EMAIL_NAME = "WELCOME_MAIL_FROM_EMAIL_NAME";
	public static final String SENDGRID_API_KEY = "SENDGRID_API_KEY";

	
	public static final String RESET_PASSWORD = "RESET_PASSWORD";
	public static final String FORGOT_PASSWORD = "FORGOT_PASSWORD";
	
	public static final String CODED_FORGOT_PASSWORD_SUBJECT ="Your Password information.";
	public static final String CODED_RESET_PASSWORD_SUBJECT ="Your password has been reset.";
	
	public static final String DEFAULT_EMAIL_ADDRESS="do_not_reply@fishbowl.com";
	public static final String DEFAULT_EMAIL_NAME = "FISHBOWL";
	
	public static final String WELCOME_EMAIL_ACTIVE = "ACK_WELCOME_EMAIL";
	
	public static final String SKD_USER="testertesting@gmail.com";
	public static final String SKD_USER_PASSWORD="password";
	public static final String PUBLIC_TOKEN_KEY="PUBLIC_TOKEN_";
	
	public static final String EXTERNAL_CUSTOMER_ID = "ExternalCustomerId";
	public static final String EXTERNAL_ACCESS_TOKEN = "ExternalAccessToken";
	

	public static final String SCHEMA = "SCHEMA_NAME";


	//Theme
	public static final String NOT_DEFAULT_THEME = "It is not a Default Theme";
	public static final String IS_DEFAULT_THEME = "This is a Default Theme. It cannot be Deleted";
	public static final String CONFIG_GROUP_PRIVACY_POLICY = "PrivacyPolicy";
	public static final String CONFIG_TERMS_AND_CONDITION = "TermsConditions";
	public static final String CONFIG_SIGN_UP_MAIL = "SignupMail";
	public static final String CONFIG_NAME_VERIFY_EMAIL = "VerifyEmail";
	public static final String THEME_NAME_EXISTS = "Theme Name Already Exists";
	public static final String DISPLAY_PUBLIC_All = "All";
	public static final String THEME_CONFIG_PAGE_MASTER = "Master";
	public static final String CONFIG_NAME_FORGET_PASSWORD_EMAIL = "ForgetEmail";
	public static final String CONFIG_GROUP_FAQ = "FAQ";
	public static final String CONFIG_NAME_FAQ = "FAQ";
	public static final String CONFIG_GROUP_PROGRAM_DETAIL = "ProgramDetail";
	public static final String CONFIG_NAME_PROGRAM_DETAIL = "ProgramDetail";
	public static final String APPLICATION_TYPE_ALL = "All";
	public static final int THEME_PAGE_GENERAL_ID = 3;
	public static final int THEME_DEVICE_MASTER_ID = 1;
	public static final Object THEME_CONFIG_NAME_SELECTED_FONT = "GeneralSelectedFont";
	public static final Object THEME_CONFIG_NAME_DEFAULT_FONT = "GeneralDefaulltFont";
	public static final Object THEME_CONFIG_NAME_CUSTOM_FONT = "GeneralCustomFont";
	
	//CAMPAIGN ADDITIONAL FIELD TYPE
	public static final String CAMPAIGN_ADDITIONAL_FIELD_TYPE_EMAIL="EMAIL";
	public static final String CAMPAIGN_ADDITIONAL_FIELD_TYPE_DOB="DOB";
	public static final String CAMPAIGN_ADDITIONAL_FIELD_TYPE_FNAME="FNAME"; 
	public static final String THAT_IS_LAST=". That is Last Message"; 

	
	
	public static final String EMAIL_SUBJECT_FOR_MAIL_WITH_PASS_COUPON_URL = "EMAIL_SUBJECT_FOR_MAIL_WITH_PASS_COUPON_URL";
	public static final String EMAIL_BODY_FOR_MAIL_WITH_PASS_COUPON_URL ="EMAIL_BODY_FOR_MAIL_WITH_PASS_COUPON_URL";
	public static final String ENTERPRISE_MOBILEPHONE_KEY ="ENTERPRISE_MOBILEPHONE_KEY";
	
	//Theme
	public static final String THEME_PROFILE_FIELD_DROPDOWN = "dropdown";
	public static final String STORE_AVAILABLE_SELECTION = "STORE_AVAILABLE_SELECTION";
	public static final String STORE_AVAILABLE_CONTACT_US = "STORE_AVAILABLE_CONTACT_US";

	public static final String FIELD_NAME_ALREADY_EXIST = "This FieldName is Already Exist";
	public static final String EXCEEDED_MAXIMUM_CUSTOM_FIELDS = "Sorry! You have already reached Maximum No.Of Fields";

	public static final String DATE_NOT_IN_MM_DD_YYYY="Date is not in correct format. Please resend in MM/DD/YYYY Format";

	public static final String PASS_DATE_PATTERN="MM/dd/yy";
	
	public static final String THEME_NOT_EXIST = "Themes Not Exists";
	
	public static final String INVALID_MASTER_THEME = "Invalid Master Theme";
	
	public static final String CHECK_ID = "Please Check Id";
	public static final String THEME_NOT_FOUND = "Theme not found";
	public static final String PROFILE_FIELD_LIST_EMPTY = "Profile Field List is Empty";
	public static final String INVALID_THEME_DEVICEID_OR_PAGEID = "Theme Device Id or Page Id is Invalid";
	public static final String EMPTY_THEMECONFIGSETTINGS_REGISTRATION = "ThemeConfigSetting for RegistrationPage is Empty";
	public static final String EMPTY_THEMECONFIGSETTINGS_LOGIN = "ThemeConfigSetting for Login is Empty";
	public static final String EMPTY_THEMECONFIGSETTINGS = "ThemeConfigSetting is Empty";
	public static final String DEFAULT_THEME_NOT_FOUND = "Default Theme Not Found";
	public static final String FONT_NAME_ALREADY_EXIST = "Custom Font Name already Exists";
	//
	public static  String PROMOTION_URL_BAR_VALUE ="";
	public static  String PROMOTION_URL_QR_VALUE = "";
	
	public static  String PROMOTION_URL_BAR_DYNAMIC_VALUE = "";
	public static  String PROMOTION_URL_QR_DYNAMIC_VALUE = "";
	public static  String ATTACH_PASS="ATTACH_PASS";
	
	public static String DO_NOT_ADD_CLOUD_OFFERS = "DO_NOT_ADD_CLOUD_OFFERS";
	
	// <<-- INCOMM TOKEN CONSTANTS -->> 
	public static final String INCOMM_TOKEN_GENERATE_SUCCESS = "InComm Token Generated successfully";
	public static final String INCOMM_TOKEN_GENERATE_FAILED = "InComm Token Generation Failed";
	
	public static final int TTL = 1800;// 30 min
	
	public static final int INCOMM_ORDER_STATUS_STARTED = 1;
	public static final int INCOMM_ORDER_STATUS_CANCELLED = 2;
	public static final int INCOMM_ORDER_STATUS_COMPLETED = 3;
	public static final int INCOMM_ORDER_STATUS_FAILED = 4;
	 
	public static final String INCOMM_ORDER_TRANSACTION_SUCCESS = "Update Transaction Successfully";
	public static final String INCOMM_ORDER_TRANSACTION_FAILED = "Update Transaction Failed";
	
	public static final String INCOMM_INVALID_ORDER_STATUS = "Invalid Order status";
	
	public static final String INCOMM_UPDATE_TRANSACTION_SUCCESS = "Update Transaction Successfully";
	public static final String INCOMM_UPDATE_TRANSACTION_FAILED = "Update Transaction Failed";
	// <<-- END INCOMM TOKEN CONSTANTS -->>
		
	public static String STORES_NOT_FOUND = "No stores for channel"; 
	public static String REQUEST_BODY_NOT_FOUND= "Request body not present. Please enter request body.";
	public static String PASSWORD_NOT_FOUND = "Password is empty in request body.Please try with password.";
	public static String CLIENTID_NOT_FOUND = "ClientId is empty.Please try with client Id in Headers.";
	public static String DEVICEID_NOT_FOUND = "DeviceId is empty.Please try with deviceId in Headers.";
	public static String TENANTID_NOT_FOUND = "TenantID is empty.Please try with tenantID in Headers.";
	public static String ACCESS_TOKEN_NOT_FOUND = "Access Token is empty.Please try with access token in Headers.";
	public static String NON_EDITABLE_CAMPAIGN="Campaign is not editable.";
	
	public static final int COUPON_STATUS_ACTIVE = 2;
	public static int UNKNOWN_MEMBER=0;					// email=false password =false emailOpted=false loyaltyOpted=flase
	public static int GUEST_NOT_MEMBER=1;				// email=true password =false emailOpted=false loyaltyOpted=flase
	public static int NOT_EMAIL_OPTED_MEMBER=2;			// email=true password=true emailOpted=false loyaltyOpted=flase
	public static int EMAIL_OPTED_MEMBER=3;				// email=true password=true emailOpted=true loyaltyOpted=flase
	public static int EMAIL_OPTED_WO_PASSWORD=4; 		// email=true password=false emailOpted=true loyaltyOpted=flase
	public static int LOYALTY_MEMBER=5;					// email=true password=true emailOpted=true loyaltyOpted=true

	public static final String VERIFY_LOYALTY_REGISTRATION_WITH_TOKEN = "VerifyLoyaltyRegistrationWithToken";
	public static final String WELCOME_LOYALTY_EMAIL = "WelcomeLoyaltyEmail";

	
	 //1 
	public static String VERIFY_EMAIL = "VerifyEmail";
	//2
	public static  String WELCOME_EMAIL = "WelcomeEmail";    //Creating Member
 
	//3
	public static String VERIFY_EMAIL_OPTIN = "VerifyEmailOpted"; //if email Opted true send mail
	
	//4
	public static String WELCOME_AS_EMAIL_OPTED_MEMBER = "WelcomeAsEmailOptedMember"; //If user confirm as email email opted send mail
	
	//5
	public static String VERIFY_BE_LOYALITY = "VerifyBeLoyality";			//if loyaltyOptin=true sen this mail
	//7
	public static String WELCOME_BE_LOYALITY = "WelcomeBeLoyality";
	
	public static String VERIFY_LOYALTY_REGISTRATION = "VerifyLoyaltyRegistration";//If user confirm as Loyality membersend mail
	
	
	final public static String START_WITH_CHARACTER = "START_WITH_CHARACTER";
	final public static String NOT_START_WITH_CHARACTER = "NOT_START_WITH_CHARACTER";	
	final public static String SPECIAL_CHARACTER = "SPECIAL_CHARACTER";
	final public static String MIN_LENGTH = "MIN_LENGTH";	
	final public static String MAX_LENGTH = "MAX_LENGTH";
	final public static String MIN_NUM_OF_CHAR = "MIN_NUM_OF_CHAR";	
	final public static String MAX_NUM_OF_CHAR = "MAX_NUM_OF_CHAR";
	final public static String MIN_NUM_OF_DIGIT = "MIN_NUM_OF_DIGIT";	
	final public static String MAX_NUM_OF_DIGIT = "MAX_NUM_OF_DIGIT";
	final public static String MIN_NUM_OF_UPPERCASE_CHAR = "MIN_NUM_OF_UPPERCASE_CHAR";	
	final public static String MAX_NUM_OF_UPPERCASE_CHAR = "MAX_NUM_OF_UPPERCASE_CHAR";
	final public static String MIN_NUM_OF_SPECIAL_CHAR = "MIN_NUM_OF_SPECIAL_CHAR";	
	final public static String MAX_NUM_OF_SPECIAL_CHAR = "MAX_NUM_OF_SPECIAL_CHAR";
	final public static String PASSWORD_MIS_MATCH_CONFIG_MESSAGE ="PASSWORD_MIS_MATCH_CONFIG_MESSAGE";
	final public static String PASSWORD_MIS_MATCH_RESPONSE_MESSAGE = "Password didn't match with configuration defined in system";
	final public static String ENDUSER_PORTAL_PASSWORD_CONFIGURATION ="EndUserPortal_Password_Configuration";
	
	final public static int MAX_COUNT =100;
	final public static int MAX_COUNT_1k =1000;
	final public static int ZERO_COUNT =0;

	//PROD-954 FIX
	public static final String SMS_MESSAGE_TYPE_CONFIRM = "CONFIRM";
	public static final String SMS_MESSAGE_TYPE_WELCOME = "WELCOME";
	public static final String SMS_MESSAGE_TYPE_EXISTS = "EXISTS";
	public static final String SMS_MESSAGE_TYPE_INVALID = "INVALID";
	public static final String SMS_MESSAGE_TYPE_EXPIRED = "EXPIRED";
	public static final String SMS_MESSAGE_TYPE_WINNER = "WINNER";
	public static final String SMS_MESSAGE_TYPE_NONWINNER = "NONWINNER";
	public static final String SMS_MESSAGE_TYPE_MEMBER_DOB = "MEMBER_DOB";
	public static final String SMS_MESSAGE_TYPE_MEMBER_FIRSTNAME = "MEMBER_FIRSTNAME";
	public static final String SMS_MESSAGE_TYPE_MEMBER_EMAIL = "MEMBER_EMAIL";
	public static final String SMS_MESSAGE_TYPE_DEFAULT="DEFAULT";
	public static final String SMS_MESSAGE_TYPE_MAXRECEIVED="MAXRECEIVED";
	
	public static final String TOKENGENERATION_FAILED = "Something went wrong during RefreshToken Generation";
	public static final String REFRESHTOKEN = "refreshToken : ";
	public static final String ASYNC_SMS_EMAIL = "ASYNC_SMS_EMAIL : ";
	public static final String ASYNC_ENTERPRISE_UPDATE = "ASYNC_ENTERPRISE_UPDATE : ";

	public static final String DOMAIN_NAME = "domain";

	public static final int LOYALTY_NUMBER_DEFAULT_SIZE = 11;
	public static final String LOYALTY_NUMBER_SIZE = "LOYALTY_NUMBER_SIZE";
	public static final String LOYALTY_NUMBER_TYPE = "LOYALTY_NUMBER_TYPE";
	public static final String NUMERIC_STRING = "NUMERIC";
	
	//PROD-3206
	public static final int DEFAULT_SMS_KEYWORD_ID_FOR_DOUBLE_OPTIN=-1; 
	
	/*
	 * Introduced for VIBES API.
	 */
	public static final String ONE = "ONE";
	public static final String VIBES_SITE_URL = "https://messageapi.vibesapps.com/MessageApi";
	public static final String VIBES_CARRIER_URL = "/mdns/carriercode";
	
	/*
	 * END
	 */


	//MA-3122
	public static final int LOG_SENT_DURATION_CHECK= 2;


	public static final String GA_GETBILLBETAILS_URL = "/GAOlap/bill/getbilldetails";


	final public static String LOYALTY_ENGINE_VISIT_REWARD_ALLOCATE= "visitreward-allocate?tenantId=(%%tenantId%%)";
	
	//MA-3297 constants
	public final static String SMS_SHORT_CODE_DEFULT_HELP = "DefaultHelpMessage";
	public final static String SMS_SHORT_CODE_DEFULT_STOP = "DefaultStopMessage";
	public final static String SMS_SHORT_CODE_DEFULT_INVALID = "DefaultInvalidMessage";
	public final static String SMS_SHORT_CODE_DEFULT = "-1";
	
	public final static String SMS_EVENT_DELAY_IN_MILLISECOND = "SMS_EVENT_DELAY_IN_MILLISECOND";
	public static final String SMS_MESSAGE_SEND_STATUS_DELAYED = "DELAYED";
	public static final String SMS_MESSAGE_SEND_STATUS_SENDING = "SENDING";
	public static final String SMS_MESSAGE_SEND_STATUS_SUCCESS = "SUCCESS";
	public static final String SMS_MESSAGE_SEND_STATUS_ERROR = "ERROR";
	public static final String SMS_DELAYED_RETRY_MESSAGE = "Your request has been received and currently is in progress.";
	
	//MA-3473 constants (please enter the order of leading to trailing character )
    public static final String KEYWORD_TRIMMABLE_LEADING_SPECIAL_CHARS =  String.join("|", Arrays.asList("\"", "“"));
    public static final String KEYWORD_TRIMMABLE_TRAILING_SPECIAL_CHARS = String.join("|", Arrays.asList("\"", "”"));
    
    //MA-3669 Azure Migration
    public static final String AZURE_STORAGE_ACCOUNT_CONNECTION="FISHBOWL_AZURE_STORAGE_ACCOUNT_CONNECTION";

 
    public static final String LOYALTY_STATUS_PENDING = "Pending";
    public static final String LOYALTY_STATUS_ACTIVE = "Active";
    public static final String LOYALTY_STATUS_DEACTIVATED = "Deactivated";
 
    //MA-3493 
    public static final String DECOUPLE_COUPON_GENERATION_IN_SMS = "DECOUPLE_COUPON_GENERATION_IN_SMS";	

    //MA- 3708
    final public static String TWILIO_CALLBACK_URL= "TWILIO_SMSEVENT_CALLBACK_URL";
	public static final String EVENT_REQUEST_CHANNEL_PLATFORM = "platform";
	public static final String EVENT_REQUEST_CHANNEL_SMSEVENTS = "smsevents";
    
    //MA-3110
    public static final String TWILIO_LOOKUP_FLAG = "TWILIO_LOOKUP_FLAG";
    public static final String TWILIO_LOOKUP_DETAILS_NAME = "name";
    public static final String TWILIO_LOOKUP_DETAILS_NETWORK_CODE = "mobile_network_code";
    public static final String TWILIO_LOOKUP_DETAILS_COUNTRY_CODE = "mobile_country_code";
    
    //MA-3807
    public static final int MANUAL_SMS_OPT_OUT_FAILED = 5;
    public static final int CRM_WRAPPER_SMS_OPT_OUT_FAILED = 1;
    
    // PROD-2221 fix
    final public static String INVALID_URL = "Invalid redirect URL";
    
    //Email
    public static final String TEMP_DIR_PATH = "java.io.tmpdir";
	public static final String EMAIL_SMTP_HOST_SERVER = "mail.fishbowl.com";
	public static final String EMAIL_SMTP_HOST_PROP = "mail.smtp.host";
	public static final String EMAIL_ALERTING_FAILED_SMS_FROM_ADDRESS = "platformsupport@fishbowl.com";
	public static final String EMAIL_ALERTING_FAILED_SMS_TO_ADDRESS_PROD = "smsalerts@fishbowl.com";
	public static final String EMAIL_ALERTING_FAILED_SMS_TO_ADDRESS_TEST = "FBCloudNotificationsQA@fishbowl.com";
	public static final String EMAIL_ALERTING_FAILED_SMS_OPT_OUT_SUBJECT = "ERROR: SMS Opt-out unsuccessful";
	public static final String FB_EMAIL_FAILED_TEMPLATE = "FB_EMAIL_FAILED_TEMPLATE";
	public static final String IS_PRODUCTION_ENVIRONMENT = "IS_PRODUCTION_ENVIRONMENT";
	public static final String FB_CNFG_ENVIRONMENT_PROD = "PROD";
	public static final String FB_CNFG_ENVIRONMENT = "ENVIRONMENT";
	public static final String FB_CNFG_ENVIRONMENT_DEV = "DEV";
	public static final String FB_CNFG_ENVIRONMENT_QA = "QA";
	public static final String FB_CNFG_ENVIRONMENT_STAGING = "STG";
	public static final String FB_CNFG_ENVIRONMENT_HOTFIX = "HOTFIX";
	public static final String FILE_LIST_ERROR = "Error in listing files";
	public static final String  FILE_MERGE_ERROR= "Error in merging files";
	public static final String  FILE_SAVE_ERROR= "Error in saving files in database";
	public static final String FB_PRICE_BUCKET_NAME= "fbapppricingbucket";
	
	public static final HashMap<String, String> ENV_DESC;
	static {
		ENV_DESC = new HashMap<String, String>();
		ENV_DESC.put(FB_CNFG_ENVIRONMENT_DEV, "Devlopment");
		ENV_DESC.put(FB_CNFG_ENVIRONMENT_QA, FB_CNFG_ENVIRONMENT_QA);
		ENV_DESC.put(FB_CNFG_ENVIRONMENT_STAGING, "Staging");
		ENV_DESC.put(FB_CNFG_ENVIRONMENT_HOTFIX, FB_CNFG_ENVIRONMENT_HOTFIX);
		ENV_DESC.put(FB_CNFG_ENVIRONMENT_PROD, "Production");
	}
    
}