package com.rablion.college;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class CollegeDetails {
	
	PDFTextStripperByArea singlePageStripper;
	PDFTextStripperByArea doublePageStripper;
	
	public CollegeDetails() {
		
		try{
			setupStrippers();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		
		CollegeDetails cd = new CollegeDetails();
		cd.extractCollegeDetails();
		//System.out.println(cd.isSinglePage(41));
		//System.out.println(cd.isSinglePage(44));
		//System.out.println(Integer.MAX_VALUE);

	}
	
	public boolean isSinglePage(int pageNo) {
		int[] singlePageColleges = {44,45,46,47,48,76,140,141,162,163,166,167,168,197,201,202,203,209,210,211,235,314};
		//System.out.println(Arrays.binarySearch(singlePageColleges, pageNo));
		return (Arrays.binarySearch(singlePageColleges, pageNo) >= 0) ? true : false;
	}
	
	public void extractCollegeDetails() throws Exception {
		String sourceFilePath = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/college_details2017.pdf";
		
		PDDocument pdDoc = PDDocument.load(new File(sourceFilePath));
		
		for(short i=44;i<45;i++){
			System.out.println("Processing page " + i + " : isSinglePage-" + isSinglePage(i));
			if(isSinglePage(i)){
				singlePageStripper.extractRegions(pdDoc.getPage(i));
				
				String headerDetails = singlePageStripper.getTextForRegion( "headerDetails_1" );
				String collegeDetails = singlePageStripper.getTextForRegion( "collegeDetails_1" );
				String branchDetails = singlePageStripper.getTextForRegion( "branchDetails_1" );
				String hostelDetails = singlePageStripper.getTextForRegion( "hostelDetails_1" );
				
				
				System.out.println("--------------------headerDetails------------------------------------------------");
				System.out.println(headerDetails);
				//FileUtils.writeStringToFile(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/headerDetails.txt"), headerDetails);
				System.out.println("--------------------collegeDetails------------------------------------------------");
				System.out.println(collegeDetails);
				//FileUtils.writeStringToFile(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/collegeDetails.txt"), collegeDetails);
				System.out.println("---------------------branchDetails-----------------------------------------------");
				System.out.println(branchDetails);
				//FileUtils.writeStringToFile(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/branchDetails.txt"), branchDetails);
				System.out.println("---------------------hostelDetails-----------------------------------------------");
				System.out.println(hostelDetails);
				//FileUtils.writeStringToFile(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/hostelDetails.txt"), hostelDetails);
			}
			else{
				doublePageStripper.extractRegions(pdDoc.getPage(i));
				
				String collegeDetails = doublePageStripper.getTextForRegion( "collegeDetails_1" );
				String branchDetails = doublePageStripper.getTextForRegion( "branchDetails_1" );
				String hostelDetails = doublePageStripper.getTextForRegion( "hostelDetails_1" );
				String headerDetails = doublePageStripper.getTextForRegion( "headerDetails_1" );
				
				String collegeDetails_2 = doublePageStripper.getTextForRegion( "collegeDetails_2" );
				String branchDetails_2 = doublePageStripper.getTextForRegion( "branchDetails_2" );
				String hostelDetails_2 = doublePageStripper.getTextForRegion( "hostelDetails_2" );
				String headerDetails_2 = doublePageStripper.getTextForRegion( "headerDetails_2" );
				
				System.out.println("--------------------headerDetails------------------------------------------------");
				System.out.println(headerDetails);
				System.out.println("--------------------collegeDetails------------------------------------------------");
				System.out.println(collegeDetails);
				System.out.println("---------------------branchDetails-----------------------------------------------");
				System.out.println(branchDetails);
				System.out.println("---------------------hostelDetails-----------------------------------------------");
				System.out.println(hostelDetails);
				
				System.out.println("--------------------headerDetails_2------------------------------------------------");
				System.out.println(headerDetails_2);
				System.out.println("--------------------collegeDetails_2------------------------------------------------");
				System.out.println(collegeDetails_2);
				System.out.println("---------------------branchDetails_2-----------------------------------------------");
				System.out.println(branchDetails_2);
				System.out.println("---------------------hostelDetails_2-----------------------------------------------");
				System.out.println(hostelDetails_2);		
			}
		}
		
		/**/ 
		
		/**/
	}
	
	
	public void setupStrippers() throws Exception {
		singlePageStripper = new PDFTextStripperByArea();
		singlePageStripper.setSortByPosition( true );
		
		List<TablePositions> singlePageTablePositions = new ArrayList<TablePositions>();
			singlePageTablePositions.add(new TablePositions("headerDetails_1", 37,37,507,26));
			singlePageTablePositions.add(new TablePositions("collegeDetails_1", 36,73,508,165));
			singlePageTablePositions.add(new TablePositions("branchDetails_1", 36,250,233,311));
			singlePageTablePositions.add(new TablePositions("hostelDetails_1", 275,252,269,285));
			
		for(int i=0;i<singlePageTablePositions.size();i++) {
			singlePageStripper.addRegion( singlePageTablePositions.get(i).getName(), singlePageTablePositions.get(i).getRect());
		}
		
		doublePageStripper = new PDFTextStripperByArea();
		
		doublePageStripper.setSortByPosition( true );
		
		List<TablePositions> doublePageTablePositions = new ArrayList<TablePositions>();
			doublePageTablePositions.add(new TablePositions("headerDetails_1", 34,37,511,22));
			doublePageTablePositions.add(new TablePositions("collegeDetails_1", 36,60,510,111));
			doublePageTablePositions.add(new TablePositions("branchDetails_1", 35,174,235,203));
			doublePageTablePositions.add(new TablePositions("hostelDetails_1", 276,172,268,205));
			
			doublePageTablePositions.add(new TablePositions("headerDetails_2", 29,388,516,19));	
			doublePageTablePositions.add(new TablePositions("collegeDetails_2", 36,408,510,109));
			doublePageTablePositions.add(new TablePositions("branchDetails_2", 36,521,234,202));
			doublePageTablePositions.add(new TablePositions("hostelDetails_2", 276,521,269,203));
			
		for(int i=0;i<doublePageTablePositions.size();i++) {
			doublePageStripper.addRegion( doublePageTablePositions.get(i).getName(), doublePageTablePositions.get(i).getRect());
		}	
	}
}
