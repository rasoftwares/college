package com.rablion.college;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App
{
	
	String sourceFilePath = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/college_details2017.pdf";
	String branchesFilePath = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/branches.txt";
	
	String START_WITH_NUMBER = "^[0-9].*";
	
	Map<String,College> collegeMap = new TreeMap<String, College>();
	List<Branch> allBranches = new ArrayList<Branch>();
	List<College> allColleges = new ArrayList<College>();
	
	PDFTextStripperByArea singlePageStripper;
	PDFTextStripperByArea doublePageStripper;
	
	public App(){
		try{
			setupStrippers();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 1. Extract list of colleges	(code,college name ) - Pages 3 to 20
	 2. Extract Branches to colleges () - Page 39 to 43
	 3. Extract college information () - Page 45 to 356
	 */
    public static void main2( String[] args ) throws Exception
    {
    	
       
    }
    
    public void extractBranches() throws Exception {
    	System.out.println("Collecting Branch Data from file " + branchesFilePath);
        List<String> branchList = FileUtils.readLines(new File(branchesFilePath));
        Iterator<String> it = branchList.iterator();
        String str = "";
        String[] arr;
        
        while(it.hasNext()) {
        	str = it.next();
        	arr = str.trim().split("#");
        	String[] collegeCode = StringUtils.split(arr[2],",");
        	
        	//System.out.println(arr[0] + ":" + arr[1]);
        	allBranches.add(new Branch(arr[0].trim(), arr[1].trim()));
        	
        	for(int i=0;i<collegeCode.length;i++) {
        		//System.out.println(collegeCode[i]);
        		College college = collegeMap.get(collegeCode[i].trim());
        		if(college != null ) {
        			college.addBranch(arr[0].trim(), arr[1].trim());
        		}
        		else {
        			System.out.println("DATA ERROR : College not present in the master list " + collegeCode[i]);
        		}
        	}
        	//System.out.println(arr[0] + ":" + arr[1] + ":" + arr[2]);
        }
        
        //System.out.println(collegeMap);
        
	}
    
    public void extractColleges(String filePath) throws Exception {
	    
    	System.out.println("Collecting Colleges Data from file " + filePath);

	    PDDocument pdDoc = PDDocument.load(new File(filePath));

        PDFTextStripper pdfStripper = new PDFTextStripper();
        int startIndex = 3;
        int endIndex = 20;
        
        pdfStripper.setStartPage(startIndex);
        pdfStripper.setEndPage(endIndex);
        pdfStripper.setLineSeparator("\n");
        String str = pdfStripper.getText(pdDoc);
        
        StringTokenizer strT = new StringTokenizer(str, "\n");
        String collegeRecord = "";
        String temp[];
        while(strT.hasMoreTokens()) {
               collegeRecord = strT.nextToken();
               if(collegeRecord.trim().matches(START_WITH_NUMBER)){
            	   temp = collegeRecord.split(" ");
                       
                       StringBuffer sb = new StringBuffer();
                       
                       for(int i=3; i<=temp.length-2; i++) {
                    	   sb.append(temp[i] + " ");
                       }
                       
                       collegeMap.put(temp[1].trim(), new College(temp[1].trim(), sb.toString().trim()));
                       allColleges.add(new College(temp[1].trim(), sb.toString().trim()));
               }
       }
       //System.out.println(collegeMap);

        System.out.println("PDF "+ filePath + " Loaded Successfully !!");
        
        //Closing the document
        pdDoc.close();
	}
    
    
    
    public boolean isSinglePage(int pageNo) {
		int[] singlePageColleges = {44, 45,46,47,48,76,140,141,162,163,166,167,168,197,201,202,203,209,210,211,235,314};
		//System.out.println(Arrays.binarySearch(singlePageColleges, pageNo));
		return (Arrays.binarySearch(singlePageColleges, pageNo) >= 0) ? true : false;
	}
    
    //3. Extract college information () - Page 45 to 336
	public void extractCollegeDetails() throws Exception {
		
		PDDocument pdDoc = PDDocument.load(new File(sourceFilePath));
		short fromPage = 44;
		short toPage = 336;
		
		for(short i=fromPage;i<toPage;i++){
			if(isSinglePage(i)){
				singlePageStripper.extractRegions(pdDoc.getPage(i));
				
				String headerDetails = singlePageStripper.getTextForRegion( "headerDetails_1" );
				String collegeDetails = singlePageStripper.getTextForRegion( "collegeDetails_1" );
				String branchDetails = singlePageStripper.getTextForRegion( "branchDetails_1" );
				String hostelDetails = singlePageStripper.getTextForRegion( "hostelDetails_1" );
				
				updateCollegeDetails(headerDetails, branchDetails, collegeDetails, hostelDetails);
				
				
			}
			else{
				doublePageStripper.extractRegions(pdDoc.getPage(i));
				
				String collegeDetails = doublePageStripper.getTextForRegion( "collegeDetails_1" );
				String branchDetails = doublePageStripper.getTextForRegion( "branchDetails_1" );
				String hostelDetails = doublePageStripper.getTextForRegion( "hostelDetails_1" );
				String headerDetails = doublePageStripper.getTextForRegion( "headerDetails_1" );
				
				updateCollegeDetails(headerDetails, branchDetails, collegeDetails, hostelDetails);
				
				
				String collegeDetails_2 = doublePageStripper.getTextForRegion( "collegeDetails_2" );
				String branchDetails_2 = doublePageStripper.getTextForRegion( "branchDetails_2" );
				String hostelDetails_2 = doublePageStripper.getTextForRegion( "hostelDetails_2" );
				String headerDetails_2 = doublePageStripper.getTextForRegion( "headerDetails_2" );
				
				updateCollegeDetails(headerDetails_2, branchDetails_2, collegeDetails_2, hostelDetails_2);
			}
		}
		
		/* System.out.println("--------------------headerDetails------------------------------------------------");
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
		*/
	}
	
	public void updateCollegeDetails(String headerDetails, String branchDetails, String collegeDetails, String hostelDetails){
		if(headerDetails != null){
			College college = collegeMap.get(headerDetails.trim().split(" ")[0]);
			if(college != null){
				college.setHeaderDetails(headerDetails);
				college.setBranchDetails(branchDetails);
				college.setCollegeDetails(collegeDetails);
				college.setHostelDetails(hostelDetails);
			}
		}
		else{
			System.out.println("Unable to set details ");
		}
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
    
    
    public static void main( String[] args ) throws Exception {
    	
    	App a = new App();
    	String path = a.sourceFilePath;
    	
	    //"d:/temp_R/data/college_details2017.pdf";
	    String START_WITH_NUMBER = "^[0-9].*";
	    
	    a.extractColleges(path);
	    a.extractBranches();
	    a.extractCollegeDetails();
	    
	    Map<String, College> collegeMap = a.collegeMap;
	    Iterator<String> it = collegeMap.keySet().iterator();
	    String str = "";
	    while(it.hasNext()) {
	    	str = it.next();
	    	System.out.println(str + ":" + collegeMap.get(str));
	    	//Thread.sleep(1000);
	    }
	    
	    //To generate json files for view layer
	    /**/
	    Gson gs = new Gson();
	    System.out.println(gs.toJson(a.allBranches));
	    
	    Collection colleges = a.collegeMap.values();
	    System.out.println(gs.toJson(a.allColleges));
	    
	    String allBranchesFile = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/allBranches.json";
	    String allCollegesFile = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/allColleges.json";
	    String allColleges_1File = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/allColleges_1.json";
	    FileUtils.writeStringToFile(new File(allBranchesFile), gs.toJson(a.allBranches));
	    FileUtils.writeStringToFile(new File(allCollegesFile), gs.toJson(a.allColleges));
	    FileUtils.writeStringToFile(new File(allColleges_1File), gs.toJson(colleges));
    }
}

