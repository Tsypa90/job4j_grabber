package ocp;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    public List<String> chat = new ArrayList<>();

    public boolean save(String msg) {
        var rsl = false;
        if (!chat.contains(msg)) {
           rsl = chat.add(msg);
        }
        return rsl;
    }

    public boolean delete(String msg) {
        return chat.remove(msg);
    }

    public boolean repeatChat(String msg) {
        var rsl = false;
        if (!chat.contains(msg)) {
            rsl = chat.add(msg + "REPEAT");
        }
        return rsl;
    }
}
