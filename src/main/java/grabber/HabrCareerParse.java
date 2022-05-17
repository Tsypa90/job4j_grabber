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

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> list = new ArrayList<>();
        Connection connection = Jsoup.connect(link);
        Document document = connection.get();
        Elements rows = document.select(".vacancy-card__inner");
        rows.forEach(row -> {
            Element titleElement = row.select(".vacancy-card__title").first();
            Element linkElement = titleElement.child(0);
            Element dateElement = row.select(".vacancy-card__date").first().child(0);
            String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
            String date = dateElement.attr("datetime");
            try {
                list.add(new Post(
                        titleElement.text(),
                        vacancyLink,
                        retrieveDescription(vacancyLink),
                        new HabrCareerParse(new HarbCareerDateTimeParser()).dateTimeParser.parse(date)
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<Post> posts = new ArrayList<>();
        for (int page = 1; page <= 1; page++) {
            posts = new HabrCareerParse(new HarbCareerDateTimeParser())
                    .list(String.format("%s%s", PAGE_LINK, page));
        }
        for (Post post : posts) {
            System.out.println(post.toString());
        }
    }
}
