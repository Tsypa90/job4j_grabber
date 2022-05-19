package grabber;

import grabber.utils.DateTimeParser;
import grabber.utils.HarbCareerDateTimeParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";

    private static final String PAGE_LINK = String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);

    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private static String retrieveDescription(String link) throws IOException {
        return Jsoup.connect(link).get().selectFirst(".job_show_description__vacancy_description").text();
    }

    public Post postParse(Element element) throws IOException {
        Element titleElement = element.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        Element dateElement = element.select(".vacancy-card__date").first().child(0);
        String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        return new Post(titleElement.text(),
                vacancyLink,
                retrieveDescription(vacancyLink),
                dateTimeParser.parse(dateElement.attr("datetime")));
    }

    @Override
    public List<Post> list(String link) {
        List<Post> list = new ArrayList<>();
         Connection connection = Jsoup.connect(link);
        try {
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                try {
                    list.add(postParse(row));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        for (int page = 1; page <= 5; page++) {
            posts.addAll(new HabrCareerParse(new HarbCareerDateTimeParser())
                    .list(String.format("%s%s", PAGE_LINK, page)));
        }
        System.out.println(posts.size());
    }
}
