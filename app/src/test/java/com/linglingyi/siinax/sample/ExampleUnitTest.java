package com.linglingyi.siinax.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testJsoup() {

        try {
            Document document = Jsoup.connect("https://www.jianshu.com/").get();

            Elements elements = document.select("li.have-img");
//            Elements elements = document.select("div.content");
            for (Element element : elements) {

                Elements a = element.getElementsByTag("a");
                Element img = element.getElementsByTag("img").first();
                String src = img.attr("src");

                Element content = element.select("div.content").first();
                Elements a1 = content.getElementsByTag("a");
//                a1

                String title = (String) a1.text();
                String text = content.getElementsByTag("p").text();

                Element meta = content.select("div.meta").first();
                String nickname = meta.getElementsByTag("a").first().text();

               /* Elements p = element.getElementsByTag("p");
                String text = a.text();
                String textp = p.text();
                System.out.println("title = " + text);
                System.out.println("text = " + textp);*/
                System.out.println("title = " + title);
                System.out.println("src = " + src);
                System.out.println("text = " + text);
                System.out.println("nickname = " + nickname);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
