package template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TemplateGeneratorTest {

    @Test
    @Ignore
    public void whenProduce() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        String produce = templateGenerator.produce(template, args);
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(expected, is(produce));
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenInvalidArgs() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String template = "I am a ${surname}, Who are ${object}? ";
        String produce = templateGenerator.produce(template, args);
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void whenArgsMoreThenExpressive() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("object", "me");
        String template = "I am a ${surname}, Who are ${object}? ";
        String produce = templateGenerator.produce(template, args);
    }
}