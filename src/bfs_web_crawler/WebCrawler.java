
package bfs_web_crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	private Queue<String> queue; 
	private List<String> discoveredWebsitesList;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsitesList = new ArrayList<>();
	}
	
	void discoverWeb(String root) {
		queue.add(root);
		discoveredWebsitesList.add(root);
		
		while (!queue.isEmpty()) {
			String v = queue.remove();
			String rawHtml = readUrl(v);
			
			String regex = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			
			while (matcher.find()) {
				String actualUrl = matcher.group();		
				
				if(!discoveredWebsitesList.contains(actualUrl)){
					discoveredWebsitesList.add(actualUrl);
					queue.add(actualUrl);
					System.out.println("Website has been found with URL: "+actualUrl+ " from: " + v);
				}
			}
		}
	}

	private String readUrl(String v) {
		
		String rawHtml = "";
		
		try {
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			while ((inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}
			
			in.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rawHtml;
	}
	
}
