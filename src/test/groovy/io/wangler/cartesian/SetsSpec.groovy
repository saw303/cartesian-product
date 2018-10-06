package io.wangler.cartesian

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Silvio Wangler
 */
class SetsSpec extends Specification {

    @Unroll
    void "Calculate combinations and expect a size of #expectedSize"() {

        given:
        Sets sets = new Sets()

        setInputs.each { sets.add(it as Set) }

        expect:
        sets.combinationSize() == expectedSize

        where:
        setInputs                               || expectedSize
        []                                      || 0
        ['A']                                   || 1
        ['A', 'B']                              || 1
        [['A', 'B'], [1]]                       || 2
        [['A', 'B'], [1, 2]]                    || 4
        [['A', 'B', 'C'], [1, 2]]               || 6
        [['A', 'B', 'C'], [1, 2], ['vv', 'bb']] || 12
    }
}
