package com.rablion.college;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.io.FileUtils;

public class College {
	
	private String code;
	private String name;
	private String city;
	List<Branch> branches = new ArrayList<Branch>();
	
	String headerDetails;
	String collegeDetails;
	String hostelDetails;
	String branchDetails;
	
	
	public String getHeaderDetails() {
		return headerDetails;
	}

	public void setHeaderDetails(String headerDetails) {
		this.headerDetails = headerDetails;
	}

	public String getCollegeDetails() {
		return collegeDetails;
	}

	public void setCollegeDetails(String collegeDetails) {
		this.collegeDetails = collegeDetails;
	}

	public String getHostelDetails() {
		return hostelDetails;
	}

	public void setHostelDetails(String hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

	public String getBranchDetails() {
		return branchDetails;
	}

	public void setBranchDetails(String branchDetails) {
		this.branchDetails = branchDetails;
		System.out.println("------------------------------------");
		System.out.println(getBranchDetails());
		//Convert the raw data into values inside branches list
		String START_WITH_NUMBER = "^[0-9].*";
		String[] arr = getBranchDetails().split("\n");
		List<Branch> branches = getBranches();
		
		for(int i=0;i<arr.length;i++){
			if(arr[i].trim().matches(START_WITH_NUMBER)){
				//System.out.println(arr[i]);
				String[] finalarr = arr[i].split(" ");
				for(short j =0;j<finalarr.length;j++) {
					System.out.print(finalarr[j] + " ");
				}
					final String temp_code = finalarr[1];  
					int idx = ListUtils.indexOf(branches, new Predicate<Branch>() {
						public boolean evaluate(Branch arg0) {
							return arg0.getCode().equals(temp_code.trim());
						};
					});
				//}
					System.out.println(idx + ":");
					System.out.println(branches);
					System.out.println(branches.size());
					if(idx != -1){
					System.out.println(idx + ":" + branches.get(idx));
					System.out.println(idx + ":" + branches);
					
						branches.get(idx).setApprovedintake(finalarr[2]);
						branches.get(idx).setYearofstartingofcourse(finalarr[3]);
						branches.get(idx).setNbaaccredited(finalarr[4]);
						branches.get(idx).setAccreditionvalidupto(finalarr[5]);
					}
					else{
						System.out.println("ERROR : " + "unable to set branch details for college code " + code);
					}
			}
		}
		System.out.println("Branches : " + getBranches());
		
		
	}
	
	public void findBranch(){
		//getBranches()
		
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public College(String code, String name) {
		this.code = code.trim();
		
		String[] ar = name.split(",");
		if(ar.length>1) {
			this.name = ar[0];
			this.city = ar[1];
		}
		else { 
			this.name = name.trim();
		}
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
		return code + ":" + name + ":" + city + ":" + branches;
	}
	
	public void addBranch(String code, String name){
		branches.add(new Branch(code, name));
	}
	
	public List<Branch> getBranches(){
		return branches;
	}
	
	public static void main(String a[]) throws Exception{
		//FileUtils.writeStringToFile(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/branchDetails.txt"), branchDetails)
		String START_WITH_NUMBER = "^[0-9].*";
		String lines = FileUtils.readFileToString(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/branchDetails.txt"));
		String[] arr = lines.split("\n");
		for(int i=0;i<arr.length;i++){
			if(arr[i].trim().matches(START_WITH_NUMBER)){
				System.out.println(arr[i]);
				//B	
			}
		}
		List<Branch> b = new ArrayList<Branch>();
		b.add(new Branch("0001","AI"));
		b.add(new Branch("0002","CE"));
		b.add(new Branch("0003","ZR"));
		System.out.println(b);
		final String name = "ZR";
		System.out.println(ListUtils.indexOf(b, new Predicate<Branch>() {
			public boolean evaluate(Branch arg0) {
				return arg0.getName().equals(name);
			};
		}));
	}
	
}

