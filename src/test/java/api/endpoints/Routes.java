package api.endpoints;

public class Routes {
	
	
	public static String base_url= "http://3.25.233.114:3001/api/v1/" ;
	
	
	//User folder
	public static String post_login_url= base_url + "auth/login" ;
	public static String get_url= base_url + "user";
	public static String put_url= base_url + "user/address";
	public static String put_url_setLang= base_url + "user/set-lang";
	public static String getFollowers_url= base_url + "user/get-followers?pageNo=1&userID={userID}";
	public static String getFollowing_url= base_url + "user/get-following?pageNo=1&userID={userID}";
	public static String unfollow_user_url= base_url + "user/unfollow";
	public static String follow_user_url= base_url + "user/follow";
	public static String BankID_verified_url= base_url + "user/bank-verified?pageNo=1&userID={userID}";
	
	//Categories folder
	public static String getCategories_url= base_url + "categories";
	
	//Product folder
	public static String addProduct_url= base_url + "product/add";

	
	

}
