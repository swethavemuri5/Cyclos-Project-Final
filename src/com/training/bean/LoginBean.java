package com.training.bean;

public class LoginBean {
	private String loginName;
	private String fullName;
	private String email;
	private String birthday;
	private String gender;
	private String address;
	private String postalCode;
	private String city;
	private String area;
	private String phone;
	private String mobPhone;
	private String fax;
	private String url;
	private String password;
	private String confirmPassword;
	//private String captcha;

	public LoginBean() {
	}

	public LoginBean(String loginName, String fullName,String email,String birthday,String gender,String address,String postalCode,String city,String area,String phone,String mobPhone,String fax,String url,String password,String confirmPassword) {
		super();
		this.loginName = loginName;
		this.fullName = fullName;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.area = area;
		this.phone = phone;
		this.mobPhone = mobPhone;
		this.fax = fax;
		this.url = url;
		this.password = password;
		this.confirmPassword = confirmPassword;
		//this.captcha=captcha;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName=fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode=postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area=area;
	}

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobPhone() {
		return mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}
	
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/*public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}*/
	

	@Override
	public String toString() {
		return "LoginBean [loginName=" + loginName + ", fullName=" + fullName + ",email="+email+",birthday="+birthday+",gender="+gender+",adress="+address+",postalCode="+postalCode+",city="+city+",area="+area+",phone="+phone+",mobPhone="+mobPhone+",fax="+fax+",url="+url+",password="+password+",confirmPassword="+confirmPassword+"]";
	}

}
