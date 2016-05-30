package web.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole implements Serializable  {
    
	public UserRole() {}
	
    public UserRole(User user, String role) {
		super();
		this.userid = user.getUserid();
		this.role = role;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2617299971732014940L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="user_role_id")
    private Long userroleid;
    
    @Column(name="userid")
    private Long userid;
    
    @Column(name="role")
    private String role;    

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserroleid() {
        return this.userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }   
    
}
