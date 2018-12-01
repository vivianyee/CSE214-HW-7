import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * The <code>WebPage</code> class 
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 * 		CSE 214 - R06
 */
public class WebPage {
	private static String url;
	private int index;
	private int rank;
	private ArrayList<String> keywords;
	
	public WebPage(String url, int index, int rank, ArrayList<String> keywords) {
		this.url = url;
		this.index = index;
		this.rank = rank;
		this.keywords = keywords;
	}
	
	public String toString() {
		String y = "";
		boolean first = true;
		for(int i = 0; i < keywords.size(); i++) {
			if(first) {
				y+= keywords.get(i);
				first = false;
			}else {
				y+= ", " + keywords.get(i);
			}
		}
		//String x = index + "|" + url + "|" + rank +" |***| " + y;
		return y;
	}

	public static String getUrl() {
		return url;
	}

	public int getIndex() {
		return index;
	}

	public int getRank() {
		return rank;
	}
}
