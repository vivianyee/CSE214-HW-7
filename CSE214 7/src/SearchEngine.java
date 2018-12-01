import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The <code>SearchEngine</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class SearchEngine {
	public static final String PAGES_FILE = "pages.txt";
	public static final String LINKS_FILE = "links.txt";
	private static WebGraph web;
	
	public static void main(String[] args) throws IOException {
		try {
			WebGraph web = new WebGraph(WebGraph.buildFromFiles(PAGES_FILE, LINKS_FILE));
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		while(true) {
			menu();
		}
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("(AP) - Add a new page to the graph.\r\n" + 
				"(RP) - Remove a page from the graph.\r\n" + 
				"(AL) - Add a link between pages in the graph.\r\n" + 
				"(RL) - Remove a link between pages in the graph.\r\n" + 
				"(P) - Print the graph.\r\n" + 
				"   - (I) Sort based on index (ASC)\r\n" + 
				"   - (U) Sort based on URL (ASC)\r\n" + 
				"   - (R) Sort based on rank (DSC)\r\n" +
				"(S) - Search for pages with a keyword.\r\n" + 
				"(Q) - Quit.\r\n\n"+
				"Please select an option: ");
		String x = scan.nextLine();
		if(x.equalsIgnoreCase("ap")) {
			addPage();
		}else if(x.equalsIgnoreCase("rp")) {
			removePage();
		}else if(x.equalsIgnoreCase("al")) {
			addLink();
		}else if(x.equalsIgnoreCase("rl")) {
			removeLink();
		}else if(x.equalsIgnoreCase("p")) {
			printGraph();
		}else if(x.equalsIgnoreCase("s")) {
			searchPage();
		}else if(x.equalsIgnoreCase("q")) {
			System.out.println("\nGoodbye.");
			System.exit(0);
		}
	}
	
	public static void addPage() { // AP
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a URL: ");
		String x = scan.nextLine();
		System.out.println("Enter keywords (space-separated): ");
		String y = scan.nextLine();
		String[] keywords = y.split(" ");
		ArrayList<String> key = new ArrayList<String>();
		for(int i = 0; i < keywords.length; i++) {
			key.add(keywords[i]);
		}
		try {
			web.addPage(x,key);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	public static void removePage() { // RP
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a URL: ");
		String x = scan.nextLine();
		web.removePage(x);
	}
	
	public static void addLink() { // AL
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a source URL: ");
		String x = scan.nextLine();
		System.out.println("Enter a destination URL: ");
		String y = scan.nextLine();
		try {
			web.addLink(x,y);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	public static void removeLink() { // RL
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a source URL: ");
		String x = scan.nextLine();
		System.out.println("Enter a destination URL: ");
		String y = scan.nextLine();
		web.removeLink(x,y);
	}
	
	public static void printGraph() { // P
		Scanner scan = new Scanner(System.in);
		System.out.println("(I) Sort based on index (ASC)\r\n" + 
				"(U) Sort based on URL (ASC)\r\n" + 
				"(R) Sort based on rank (DSC)\r\n\n" +  
				"Please select an option: ");
		String x = scan.nextLine();
		if(x.equalsIgnoreCase("i")) {
			
		}else if(x.equalsIgnoreCase("u")) {
			
		}else if(x.equalsIgnoreCase("r")) {
			
		}
		web.printTable();
	}
	
	public static void searchPage() { // S
		Scanner scan = new Scanner(System.in);
		System.out.println("Search keyword: ");
		String x = scan.nextLine();
		System.out.println("Rank   PageRank    URL\r\n" + 
				"---------------------------------------------");
	}
}
