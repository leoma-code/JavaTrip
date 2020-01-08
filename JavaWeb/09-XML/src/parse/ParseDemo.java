package parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/8.
 * Description :
 */
public class ParseDemo {

    @Test
    public void testParse() throws IOException {

        String path = ParseDemo.class.getClassLoader().getResource("student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements= document.getElementsByTag("name");

        System.out.println(elements.size());

        Element element = elements.get(0);

        System.out.println(element.text());

    }




}
