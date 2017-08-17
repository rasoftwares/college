package com.rablion.college.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Cuttoff extends Base{
	String colleges_url = "http://cutoff.tnea.ac.in/getdata.php";
	String branches_url = "http://cutoff.tnea.ac.in/getbranch.php";
	String cutoff_url = "http://cutoff.tnea.ac.in/cutoff.php";
	
	
	Map<String, JsonElement> college = new HashMap<String, JsonElement>();
	
	private final static Logger LOGGER = Logger.getLogger(Cuttoff.class.getName());
	
	public Cuttoff(){
		init();
	}
	
	JsonElement e;
	Map<String, JsonElement> detailsMap = new HashMap<String, JsonElement>();
	public void init() {
		try{
			String allcolleges = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/data/allColleges_1.json";
			String data = FileUtils.readFileToString(new File(allcolleges));
			JsonParser parser = new JsonParser();
			e = parser.parse(data);
			int size = e.getAsJsonArray().size();
			for(int i=0;i<size;i++){
				JsonElement element = e.getAsJsonArray().get(i);
				detailsMap.put(element.getAsJsonObject().get("code").getAsString(), element);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Cuttoff u = new Cuttoff();
		//u.getCutoff("", "", "");
	//}
	//public static void main_1(String[] args) throws Exception {
		Cuttoff u = new Cuttoff();
		//1. Fetch Colleges based on districts . Total Districts = 32
		int  distCode = 32;
		
		JsonArray root = new JsonArray();
		for (int dist = 1; dist <= distCode; dist++) {
			JsonArray colleges = u.getColleges(""+ dist);
			//System.out.println("#####"+ colleges);
			for(int i=0;i</*1*/colleges.size();i++) {
				LOGGER.log(Level.INFO, "Processing District " + dist + " and colleges "  + i + " / "  + colleges.size() );
				
				JsonObject college = (JsonObject)colleges.get(i);
				String collegeCode = college.getAsJsonObject().get("code").getAsString();
				LOGGER.log(Level.INFO, "CollegeCode : "+ collegeCode);

				JsonArray branches = u.getBranches(""+dist, collegeCode);
				
				for (int j = 0; j < branches.size(); j++) {
					JsonElement branch = branches.get(j);
					String branchCode = branch.getAsJsonObject().get("code").getAsString(); // branchcode
					//System.out.println("\tBranchCode :"+ branchCode);
					JsonArray cutoff = u.getCutoff(""+dist, collegeCode, branchCode);
					System.out.println("\t\t "+ distCode + ":" + collegeCode + ":" +  branchCode + "-->" + cutoff);
					branch.getAsJsonObject().add("cutoff", cutoff);
				}
				
				LOGGER.log(Level.INFO, "Adding further college details from PDF extracted data for college code : " + collegeCode);
				
				
				JsonElement tempElement = u.detailsMap.get(StringUtils.leftPad(collegeCode, 4, "0"));
				if(tempElement != null) {
					JsonElement tempBranches = tempElement.getAsJsonObject().get("branches");
									
					int s = branches.getAsJsonArray().size();
					LOGGER.log(Level.INFO, "Total Branches :" + branches.getAsJsonArray().size() + "<====>" + tempBranches.getAsJsonArray().size());
					
					for(int k =0;k<s;k++) {
						JsonElement toBranches = branches.getAsJsonArray().get(k);
						
						Iterator<JsonElement> fromBranchesIterator =  tempBranches.getAsJsonArray().iterator();
						JsonElement fromBranches = null;
						while(fromBranchesIterator.hasNext()){
							fromBranches = fromBranchesIterator.next();
							if(toBranches.getAsJsonObject().get("code").equals(fromBranches.getAsJsonObject().get("code"))){
								toBranches.getAsJsonObject().add("approvedintake", fromBranches.getAsJsonObject().get("approvedintake"));
								toBranches.getAsJsonObject().add("yearofstartingofcourse", fromBranches.getAsJsonObject().get("yearofstartingofcourse"));
								toBranches.getAsJsonObject().add("nbaaccredited", fromBranches.getAsJsonObject().get("nbaaccredited"));
								toBranches.getAsJsonObject().add("accreditionvalidupto", fromBranches.getAsJsonObject().get("accreditionvalidupto"));							
								break;
							}
						}
						//System.out.println("\t" + toBranches.getAsJsonObject().get("code") + "<--->" + fromBranches.getAsJsonObject().get("code") );
					}
				}
				else{
					LOGGER.log(Level.SEVERE, "Unable to fetch college code from master data :" + collegeCode);
				}
				//branches.addAll(tempBranches.getAsJsonArray());
				college.add("branches", branches);
			}
			root.addAll(colleges);
			LOGGER.log(Level.INFO, "Data:" + dist + ":" + colleges.size());
		
			LOGGER.log(Level.INFO, "------------------------------------------------------------");
		
		String destination = "/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/result.txt";
		FileUtils.writeStringToFile(new File(destination), root.toString());
		LOGGER.log(Level.INFO, "Data:" + dist + ":" + colleges);
		LOGGER.log(Level.INFO, "------------------------------------------------------------");
		}
		System.out.println("Final Data:" + root);
	}
	
	public JsonArray getCutoff(String distCode, String collegeCode, String branchCode) throws Exception {
		Map<String,String> params = new HashMap<String, String>();
		params.put("DIST_CODE", distCode);
		params.put("COLL_CODE", collegeCode);
		params.put("BRANCH_CODE", branchCode);
		params.put("COMM_NAME", "-Select Community -");

		//String out = FileUtils.readFileToString(new File("/Users/robinbennedictluba/Data/3_personal/RASoft/projects/ra-git/college/cutoff-sample.txt"));
		String out = getURLContent(cutoff_url, params);
		
		Document doc = Jsoup.parse(out);
        Elements header = doc.getElementsByClass("tdheader");
        Elements values = doc.getElementsByTag("div");
        Iterator<Element> it = header.listIterator();
        JsonArray jarray = new JsonArray();
        for(int i=1;i<header.size();i++) {
        	//System.out.println(header.get(i).text() + ":" + values.get(i).text() );
        	JsonObject jo = new JsonObject();
        	jo.addProperty("cname",header.get(i).text());
        	jo.addProperty("mark", values.get(i).text());
        	jarray.add(jo);
        }
        //System.out.println(jarray);
        
		return jarray;
	}
	
	
	public JsonArray getBranches(String distCode, String collegeCode) throws Exception {
		Map<String,String> params = new HashMap<String, String>();
		params.put("DIST_CODE", distCode);
		params.put("COLL_CODE", collegeCode);
		//System.out.println("Fetching details :" + branches_url + ":" + params);
		String out = getURLContent(branches_url,params);
        
		//System.out.println(out);
		//System.out.println(parseHtmlToJson(out));
		JsonArray branches = parseHtmlTAGToJsonArray(out,"option");
        return branches;
	}
	
	
	
	public JsonArray getColleges(String distCode) throws Exception {
		Map<String,String> params = new HashMap<String, String>();
		params.put("DIST_CODE", distCode);
		
		//Check the requested resource available in file cache, If not available, then download from url.
		
		String out = getURLContent(colleges_url, params);
		
		
		JsonArray colleges = parseHtmlTAGToJsonArray(out, "option");

        return colleges;
	}

}
