package io.wangler.cartesian

import io.wangler.cartesian.internal.SetsImpl
import spock.lang.Specification

/** @author Silvio Wangler     */
class CartesianProductSpec extends Specification {

    void "Calculate a simple cartesian product using two small sets"() {

        given:
        Sets sets = new SetsImpl()

        sets.add(["A", "B"] as Set)
        sets.add(1, 2)

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 4

        and:
        ["A", 1] == product.row(0)
        ["A", 2] == product.row(1)
        ["B", 1] == product.row(2)
        ["B", 2] == product.row(3)
    }

    void "Calculate a simple cartesian product using three small sets"() {

        given:
        Sets sets = new SetsImpl()

        sets.add(["A", "B"] as Set)
        sets.add(1, 2)
        sets.add(new Comparator<Locale>() {
            @Override
            int compare(Locale o1, Locale o2) {
                return o1.toString().compareTo(o2.toString())
            }
        }, Locale.GERMAN, Locale.FRENCH, Locale.ITALIAN, Locale.ENGLISH)

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 16

        and:
        ["A", 1, Locale.GERMAN] == product.row(0)
        ["A", 1, Locale.ENGLISH] == product.row(1)
        ["A", 1, Locale.FRENCH] == product.row(2)
        ["A", 1, Locale.ITALIAN] == product.row(3)
        ["A", 2, Locale.GERMAN] == product.row(4)
        ["A", 2, Locale.ENGLISH] == product.row(5)
        ["A", 2, Locale.FRENCH] == product.row(6)
        ["A", 2, Locale.ITALIAN] == product.row(7)
        ["B", 1, Locale.GERMAN] == product.row(8)
        ["B", 1, Locale.ENGLISH] == product.row(9)
        ["B", 1, Locale.FRENCH] == product.row(10)
        ["B", 1, Locale.ITALIAN] == product.row(11)
        ["B", 2, Locale.GERMAN] == product.row(12)
        ["B", 2, Locale.ENGLISH] == product.row(13)
        ["B", 2, Locale.FRENCH] == product.row(14)
        ["B", 2, Locale.ITALIAN] == product.row(15)
    }

    void "Calculate a simple cartesian product using one small set"() {

        given:
        Sets sets = new SetsImpl()

        sets.add(["A", "B", "C", "A", "D", "B", "Z"] as Set)

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 5

        and:
        ["A"] == product.row(0)
        ["B"] == product.row(1)
        ["C"] == product.row(2)
        ["D"] == product.row(3)
        ["Z"] == product.row(4)
    }

    void "Row access with invalid index causes an exception"() {

        when:
        given:
        Sets sets = new SetsImpl()

        sets.add(["A"] as Set)

        and:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        when:
        product.row(index)

        then:
        thrown(IndexOutOfBoundsException)

        where:
        index << [-2, -1, 1, 2, 3]
    }
}
