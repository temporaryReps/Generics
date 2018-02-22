package compare;

import java.util.Comparator;

public class LengthComparator<T extends String> implements Comparator<T> {

    @Override
    public int compare(T s1, T s2) {
        return s1.length() - s2.length();
    }
}
