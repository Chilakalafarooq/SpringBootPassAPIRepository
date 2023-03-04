package farooq.com.Pass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passes")
public class Pass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",length = 225)
	private String name;
	@Column(name = "title",length = 225)
	private String title;
	@Column(name = "email",length = 225,unique = true)
	private String email;
	@Column(name = "mobile")
	private String mobile;
	
	public Pass() {
		super();
	}
	public Pass(String name, String title, String email, String mobile) {
		super();
		this.name = name;
		this.title = title;
		this.email = email;
		this.mobile = mobile;
		
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




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
