
package com.edayspractice.userInfo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
@Entity
@Table(name = "user")
public class CatalogItems {


	public CatalogItems(){}

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			@Column(name="userId")		
			private Integer userId;
			
			@Column(name="firstName")
			private String firstName;

			@Column(name="lastName")
			private String lastName;
			
			@Column(name="deptId")		
			private Integer deptId;
			
			
			public CatalogItems(String firstName, String lastName, Integer deptId) {
				super();
				this.firstName = firstName;
				this.lastName = lastName;
				this.deptId = deptId;
			}
			
			

			public Integer getUserId() {
				return userId;
			}

			public void setUserId(Integer userId) {
				this.userId = userId;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public Integer getDeptId() {
				return deptId;
			}

			public void setDeptId(Integer deptId) {
				this.deptId = deptId;
			}



			@Override
			public String toString() {
				return "CatalogItems [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
						+ ", deptId=" + deptId + "]";
			}

			
			
			
			
}
