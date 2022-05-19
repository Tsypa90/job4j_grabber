package grabber;

import grabber.utils.HarbCareerDateTimeParser;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cn;

    public PsqlStore(Properties config) {
        try {
            Class.forName(config.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            cn = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into post(name, text, link, created) values(?, ?, ?, ?)")) {
                statement.setString(1, post.getTitle());
                statement.setString(2, post.getDescription());
                statement.setString(3, post.getLink());
                statement.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
                statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Post newPost(ResultSet resultSet) throws SQLException {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("link"),
                resultSet.getString("text"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(newPost(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement statement = cn.prepareStatement(String.format("select * from post where id =%s", id))) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    post = newPost(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    public static void main(String[] args) {
        try (InputStream in = PsqlStore.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            PsqlStore psqlStore = new PsqlStore(config);
            var posts = new HabrCareerParse(new HarbCareerDateTimeParser())
                        .list("https://career.habr.com/vacancies/java_developer?page=");
            posts.stream().forEach(post -> psqlStore.save(post));
            var sqlValues = psqlStore.getAll();
            sqlValues.stream().forEach(System.out::println);
            System.out.println(psqlStore.findById(48));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
