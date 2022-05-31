package kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxMIn(value, comparator.reversed());
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxMIn(value, comparator);
    }

    public <T> T maxMIn(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T t : value) {
            if (comparator.compare(result, t) >= 0) {
                result = t;
            }
        }
        return result;
    }
}
