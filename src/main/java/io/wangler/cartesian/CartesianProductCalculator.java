package io.wangler.cartesian;

import java.util.ArrayList;

/**
 * @author Silvio Wangler
 */
public class CartesianProductCalculator {

    private CartesianProductCalculator() {

    }

    public static CartesianProduct calculate(Sets sets) {

        int size = sets.getSets().stream().map(s -> s.size()).reduce(1, (a,b) -> a * b);

        return new CartesianProduct(new ArrayList(size));
    }
}
