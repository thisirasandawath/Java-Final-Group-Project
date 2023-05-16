package net.nsbm.happymeals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Helpers")
public class Helper {
	
	@Id
    @Column(name = "Helper_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int helperID;

    @NotNull
    @Size(max = 30)
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Age")
    private Integer age;
    
    @NotNull
    @Column(name = "Gender")
    private String gender;
    
    @NotNull
    @Size(min = 10, max = 14)
    @Column(name = "Phone_Number")
    private String phoneNumber;

	public int getHelperID() {
		return helperID;
	}

	public void setHelperID(int chefID) {
		this.helperID = chefID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
