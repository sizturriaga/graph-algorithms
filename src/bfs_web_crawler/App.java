package bfs_web_crawler;

public class App {

	public static void main(String[] args) {
		WebCrawler webCrawler = new WebCrawler();
		String rootUrl = "https://www.bbc.com/";
		webCrawler.discoverWeb(rootUrl);
	}

}
