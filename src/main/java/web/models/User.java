package web.models;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	public enum Gender{MALE, FEMALE;}
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="userid")
    private Long userId;

    @Column(name = "username")
    private String userName;   

    @Column(name = "password")
    private String password;   

    @Column(name = "email")
    private String email;
    
    @Column(name = "realName")
    private String realName;
    
    @Column(name = "gender")
    private Gender gender;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    public User() { }
    
    public User(String username, String password, String email) {
            this.userName = username;
            this.email = email; 
            this.password = password;  
    }
    
    public User(User user) {
    	this.userId = user.userId;
        this.userName = user.userName;
        this.email = user.email; 
        this.password = user.password;  
    }
    
    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
  
}