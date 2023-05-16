package net.nsbm.happymeals.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User
{
    @Id
    @Column(name = "User_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @NotNull
    @Size(min = 4, max = 15)
    @Column(name = "Username")
    private String username;

    @Email
    @NotNull
    @Size(min = 6, max = 30)
    @Column(name = "Email")
    private String email;

    @NotNull
    @Size(min = 4, max = 62)
    @Column(name = "Password")
    private String password;

    @Transient
    @Size(min = 6, max = 30)
    private String cPassword;

    @NotNull
    @Size(min = 6, max = 14)
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @NotNull
    @Column(name = "Gender")
    private String gender;

    @Column(name = "Spent")
    private int spent = 0;

    @Column(name = "Enabled")
    private boolean isEnabled = true;

    @Column(name = "Reg_Date")
    @CreationTimestamp
    private Date regDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User_ID")
    private List<Role> roles;

    public String getRegDateFormatted() {
        String pattern = "E, dd MMM yyyy"; // Sun, 21 Aug 2022 11:34 PM
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern/*, new Locale("Asia/Dhaka")*/);
        return simpleDateFormat.format(regDate);
    }

    public String getcPassword() {
        return cPassword;
    }

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSpent() {
		return spent;
	}

	public void setSpent(int spent) {
		this.spent = spent;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
    
    
}
