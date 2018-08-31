package io.wangler.cartesian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Silvio Wangler
 */
public class Sets {

    private List<Set> sets = new ArrayList<>();

    public void add(Set set) {
        sets.add(set);
    }

    public List<Set> getSets() {
        return Collections.unmodifiableList(this.sets);
    }
}
