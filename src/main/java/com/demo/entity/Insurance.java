
package com.demo.entity;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Entity
@Table(name = "insurance")
@EntityListeners(AuditingEntityListener.class)
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    private String insuranceCompany;

    private String plan_name;
    
	private String insuranceType;

    
    private String insuranceValid;
    
    private long AnnualPremium;

    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceValid() {
		return insuranceValid;
	}

	public void setInsuranceValid(String insuranceValid) {
		this.insuranceValid = insuranceValid;
	}

	public long getAnnualPremium() {
		return AnnualPremium;
	}

	public void setAnnualPremium(long annualPremium) {
		AnnualPremium = annualPremium;
	}

	public Insurance(long id, String insuranceCompany, String plan_name, String insuranceType, String insuranceValid,
			long annualPremium) {
		super();
		this.id = id;
		this.insuranceCompany = insuranceCompany;
		this.plan_name = plan_name;
		this.insuranceType = insuranceType;
		this.insuranceValid = insuranceValid;
		AnnualPremium = annualPremium;
	}

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", insuranceCompany=" + insuranceCompany + ", plan_name=" + plan_name
				+ ", insuranceType=" + insuranceType + ", insuranceValid=" + insuranceValid + ", AnnualPremium="
				+ AnnualPremium + "]";
	}



	

  
    


}
