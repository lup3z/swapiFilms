package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageUtils {

    public static List<String> pickRandomCharacter(List<String> lst, int n) {
        List<String> copy = new ArrayList<String>(lst);
        Collections.shuffle(copy);
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }
}
