package Tests;

import Core.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest extends BaseTest {
    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs(){
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        hrefs.forEach(x->links.add(x.getAttribute("href")));
        List <Integer> linksLenght = hrefs.stream().map(x->x.getAttribute("href").length()).collect(Collectors.toList());
    }
}
