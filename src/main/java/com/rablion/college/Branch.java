package com.rablion.college;

public class Branch {
	private String code;
	private String name;
	private String approvedintake;
	private String yearofstartingofcourse;
	private String nbaaccredited;
	private String accreditionvalidupto;
	
	public Branch(String code, String name) {
		this.code = code.trim();
		this.name = name.trim();
	}
	
	public Branch(String code, String name, String approvedintake, String yearofstartingofcourse, String nbaaccredited, String accreditionvalidupto) {
		this.code = code.trim();
		this.name = name.trim();
		this.approvedintake = approvedintake.trim();
		this.yearofstartingofcourse = yearofstartingofcourse.trim();
		this.nbaaccredited = nbaaccredited.trim();
		this.accreditionvalidupto = accreditionvalidupto.trim();
	}
	
	public String getApprovedintake() {
		return approvedintake;
	}

	public void setApprovedintake(String approvedintake) {
		this.approvedintake = approvedintake;
	}

	public String getYearofstartingofcourse() {
		return yearofstartingofcourse;
	}

	public void setYearofstartingofcourse(String yearofstartingofcourse) {
		this.yearofstartingofcourse = yearofstartingofcourse;
	}

	public String getNbaaccredited() {
		return nbaaccredited;
	}

	public void setNbaaccredited(String nbaaccredited) {
		this.nbaaccredited = nbaaccredited;
	}

	public String getAccreditionvalidupto() {
		return accreditionvalidupto;
	}

	public void setAccreditionvalidupto(String accreditionvalidupto) {
		this.accreditionvalidupto = accreditionvalidupto;
	}

	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return code + ":" + name ;
	}
}


