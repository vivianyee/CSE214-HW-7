import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * The <code>WebGraph</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class WebGraph {
	public static final int MAX_PAGES = 40;
	private static ArrayList<WebPage> pages = new ArrayList<WebPage>();
	private static int[][] edges = new int[MAX_PAGES][MAX_PAGES];
	
	private static ArrayList<String> url = new ArrayList<String>();
	
	public WebGraph(ArrayList<WebPage> pages) {
		this.pages = pages;
	}
	
	public static ArrayList buildFromFiles(String pagesFile, String linksFile) throws IllegalArgumentException, IOException{
		// page reader
		FileInputStream fis = new FileInputStream(pagesFile);
	    InputStreamReader inStream = new InputStreamReader(fis);
	    BufferedReader reader = new BufferedReader(inStream);
	    // link reader
	    FileInputStream fis1 = new FileInputStream(linksFile);
	    InputStreamReader inStream1 = new InputStreamReader(fis1);
	    BufferedReader reader1 = new BufferedReader(inStream1);
		String data = "";
		String data1 = "";
		ArrayList<ArrayList<String>> keyword = new ArrayList<ArrayList<String>>();
		// pages scan
		while((data = reader.readLine()) != null) {
			ArrayList<String> as = new ArrayList<String>();
			data = data.trim();
			String[] x = data.split(" ");
			url.add(x[0]);
			System.out.println(x[0]+x[1]);
			System.out.println(x.length);
			String keywords = "";
			boolean first = true;
			for(int i = 1; i < x.length; i++) {
				if(first) {
					keywords+=x[i];
					first = false;
				}else {
					keywords+=", "+x[i];
				}
			}
			as.add(keywords);
			keyword.add(as);
		}
		// link scan		
		while((data1 = reader1.readLine()) != null) {
			data1 = data1.trim();
			String[] huh = data1.split(" ");
			for(int i = 0; i < url.size(); i++) {
				if(url.get(i).equals(huh[0])) {
					for(int j = 0; j < url.size(); j++) {
						if(url.get(j).equals(huh[1])) {
							edges[i][j] = 1;
						}
					}
				}
			}
		}
		for(int i = 0; i < url.size(); i++) {
			for(int j = 0; j < url.size(); j++) {
				if(edges[i][j] != 1) {
					edges[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < url.size(); i++) {
			int count = 0;
			for(int j = 0; j < edges[i].length; j++) {
				if(edges[i][j]==1) {
					count++;
				}
			}
			WebPage x = new WebPage(url.get(i),i,count,keyword.get(i));
			pages.add(x);
		}
		return pages;
	}
	
	public void addPage(String url, ArrayList<String> keywords) throws IllegalArgumentException{
		if() {
			throw new IllegalArgumentException("Error: " + url + " already exists in the WebGraph. Could not add new WepPage.");
		}
		System.out.println(url + " successuflly added to the WebGraph!");
	}
	
	public void addLink(String source, String destination) throws IllegalArgumentException{
		if() {
			throw new IllegalArgumentException("Error: " + source + " could not be found in the WebGraph.");
		}
		System.out.println("Link successfully added from " + source + "to " + destination + "!");
	}
	
	public void removePage(String url) {
		System.out.println(url + " has been removed from the graph!");
	}
	
	public void removeLink(String source, String destination) {
		System.out.println("Link removed from " + source + " to " + destination + "!");
	}
	
	public void updatePageRanks() {
		
	}
	
	public void printTable() {
		System.out.println("Index     URL               PageRank  Links               Keywords\r\n" + 
				"------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < url.size(); i++) {
			WebPage x = pages.get(i);
			System.out.printf("%-10s %-10s %-10s %10s %10s %10s %10s %n",x.getIndex(),"|",x.getUrl(),"|",x.getRank(),"|",2,"|",x.toString());
		}
	}
}

			System.out.println(pages.get(i).toString());
		}
	}
}
