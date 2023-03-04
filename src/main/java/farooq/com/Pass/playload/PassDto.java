package farooq.com.Pass.playload;

public class PassDto {
private long id;
private String name;
private String title;
private String location;
private String mobile;
private String email;


public PassDto() {
	super();
}
public PassDto(String name, String title, String location, String mobile, String email) {
	super();
	this.name = name;
	this.title = title;
	this.location = location;
	this.mobile = mobile;
	this.email = email;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
