package io.wangler.cartesian

import spock.lang.PendingFeature
import spock.lang.Specification

/** @author Silvio Wangler  */
class CartesianProductSpec extends Specification {

    @PendingFeature
    void "Calculate a simple cartesian product using two small sets"() {

        given:
        Sets sets = new Sets()

        sets.add(Set.of("A", "B"))
        sets.add(Set.of(1, 2))

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 4

        and:
        List.of("A", 1) == product.rows(0)
        List.of("B", 1) == product.rows(1)
        List.of("A", 2) == product.rows(2)
        List.of("B", 2) == product.rows(3)
    }
}
