import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WebSpider {

    private final Set<URL> links;
    private final long startTime;
    private int start = 2;
    static PrintWriter writer;
    final int max = 200;



    WebSpider(final URL startURL) throws FileNotFoundException, UnsupportedEncodingException {
        this.links = new HashSet<>();
        this.startTime = System.currentTimeMillis();

        writer = new PrintWriter("youtubesubs.txt", "UTF-8");
        crawl(initURLS(startURL));


    }

    private void crawl(final Set<URL> urls) {
        urls.removeAll(this.links);
        if(!urls.isEmpty()){
            final Set<URL> newURLS = new HashSet<>();
            try{
                this.links.addAll(urls);
                for(final URL url : urls){
                    System.out.println("time = " + (System.currentTimeMillis() - this.startTime) + " connected to " + url);
                    final Document document = Jsoup.connect(url.toString()).get();
                    final Elements linksOnPage = document.select("a[href]");
                    final Elements namesofthings = document.select("span");
                    for(final Element element : linksOnPage){
                        final String urlText = element.attr("abs:href");
                        if(urlText.contains("the-most-subscribed-youtube-users/page/" + start+ "/")) {
                            final URL discoveredURL = new URL(urlText);
                            newURLS.add(discoveredURL);
                        }
                    }
                    for(final Element element : namesofthings){
                        final String urlText = element.attr("style");
                        if(urlText.contains("margin-left:10px")) {
                            //System.out.println(element.text());
                            writer.println(element.text());
                        }
                    }

                }
            }catch(final Exception | Error ignored){

            }
            start += 1;

            if(start > max){
                return;
            }

            crawl(newURLS);
        }

    }

    //WRITE RESULTS

    private Set<URL> initURLS(final URL startURL) {
        return Collections.singleton(startURL);
    }

    public static void main(String[] args) throws IOException{

        final WebSpider spider = new WebSpider(new URL("https://www.trackalytics.com/the-most-subscribed-youtube-users/page/1/"));

        System.out.print("done");
        System.out.print("done");
        System.out.print("done");

        writer.close();

    }

}



