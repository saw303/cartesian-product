package io.wangler.cartesian


import spock.lang.Specification

/** @author Silvio Wangler    */
class CartesianProductSpec extends Specification {

    void "Calculate a simple cartesian product using two small sets"() {

        given:
        Sets sets = new Sets()

        sets.add(["A", "B"] as Set)
        sets.add(1, 2)

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 4

        and:
        ["A", 1] == product.rows(0)
        ["A", 2] == product.rows(1)
        ["B", 1] == product.rows(2)
        ["B", 2] == product.rows(3)
    }

    void "Calculate a simple cartesian product using three small sets"() {

        given:
        Sets sets = new Sets()

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
        ["A", 1, Locale.GERMAN] == product.rows(0)
        ["A", 1, Locale.ENGLISH] == product.rows(1)
        ["A", 1, Locale.FRENCH] == product.rows(2)
        ["A", 1, Locale.ITALIAN] == product.rows(3)
        ["A", 2, Locale.GERMAN] == product.rows(4)
        ["A", 2, Locale.ENGLISH] == product.rows(5)
        ["A", 2, Locale.FRENCH] == product.rows(6)
        ["A", 2, Locale.ITALIAN] == product.rows(7)
        ["B", 1, Locale.GERMAN] == product.rows(8)
        ["B", 1, Locale.ENGLISH] == product.rows(9)
        ["B", 1, Locale.FRENCH] == product.rows(10)
        ["B", 1, Locale.ITALIAN] == product.rows(11)
        ["B", 2, Locale.GERMAN] == product.rows(12)
        ["B", 2, Locale.ENGLISH] == product.rows(13)
        ["B", 2, Locale.FRENCH] == product.rows(14)
        ["B", 2, Locale.ITALIAN] == product.rows(15)
    }

    void "Calculate a simple cartesian product using one small set"() {

        given:
        Sets sets = new Sets()

        sets.add(["A", "B", "C", "A", "D", "B", "Z"] as Set)

        when:
        CartesianProduct product = CartesianProductCalculator.calculate(sets)

        then:
        product.size() == 5

        and:
        ["A"] == product.rows(0)
        ["B"] == product.rows(1)
        ["C"] == product.rows(2)
        ["D"] == product.rows(3)
        ["Z"] == product.rows(4)
    }
}
