package com.concretepage.entity;



import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user")
/*@SQLDelete(sql="UPDATE user as u set u.enable='1' where u.user_Id=? ",check =ResultCheckStyle.COUNT)
@Where(clause="enable<>'0'")
@NamedQuery(name="User.FindByName",query="Select u from User u where u.username like :username")*/
public class User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Logger log =Logger.getLogger(this.getClass().getName());
	
	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false, updatable = false)
	private long userId;
	
	

	/*@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")*/
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enable")
	@Enumerated(EnumType.STRING)
	 private UserState enable;
	 
	/*@Column 
	@Enumerated(EnumType.STRING)
	private UserState enabled;*/	
	/*@Column(name="Email_Id")
	private String emailId;
	@Column(name="Created_Date")
	private Date createdDate;
	@Column(name="Social_Id")
	private String socialId;
	@Column(name="Status_Id")
	private String statusId;
	
	@Column(name="Confirmation_Token")
	private String confirmationToken;
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL ) 
	@JoinTable(name = "user_role", joinColumns=@JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;*/

	

	public long getUserId() {
		return userId;
	}

	public UserState getEnable(UserState true1) {
		return enable;
	}

	public void setEnable(UserState enable) {
		this.enable = enable;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


		
	
}
