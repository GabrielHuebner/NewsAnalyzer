package newsanalyzer.ctrl;

import newsapi.NewsApi;
import newsapi.NewsApiBuilder;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;
import newsapi.enums.Category;
import newsapi.enums.Country;
import newsapi.enums.Endpoint;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Controller {

	public static final String APIKEY = "b72436d7a6cb4ca6bce7e99d10a5ec24";

	public void process(Country country, Category category) throws IOException, NewsResponseException {
		System.out.println("Start process");
		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)
				.setQ("corona")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setSourceCountry(country)
				.setSourceCategory(category)
				.createNewsApi();

		NewsReponse newsResponse = newsApi.getNews();
		if(newsResponse != null){
			List<Article> articles = newsResponse.getArticles();
			printArticles(articles);

			articleSize(articles);
			providerMostArticles(articles);
			authorShortestName(articles);
			longestTitleAlphabet(articles);
		}



		//TODO implement Error handling

		//TODO load the news based on the parameters

		//TODO implement methods for analysis

		System.out.println("End process");
	}

	public void printArticles(List<Article> articles) {
		if(articles != null){
			articles.stream().forEach(article -> System.out.println(article.toString()));
		}
	}

	public void articleSize(List<Article> articles){

		System.out.println("Number of Articles ##########################################################");
		//printArticles(articles);
	}

	public void providerMostArticles(List<Article> articles){
		System.out.println("Here some sorted Data ##########################################################");
		//printArticles(articles);
	}

	public void authorShortestName(List<Article> articles){

		System.out.println("Author with shortest name ##########################################################");
		//printArticles(articles);
	}

	public void longestTitleAlphabet(List<Article> articles){
		System.out.println("Here some sorted Data ##########################################################");
		//printArticles(articles);
	}

	public Object getData() {
		
		return null;
	}
}
