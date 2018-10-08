package io.wangler.cartesian

import io.wangler.cartesian.internal.SetsImpl
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Silvio Wangler
 */
class SetsSpec extends Specification {

    @Unroll
    void "Calculate combinations and expect a size of #expectedSize"() {

        given:
        Sets.Builder builder = Sets.Builder.create()

        setInputs.each { builder.withSet (it as Set) }

        Sets sets = builder.build()

        expect:
        sets.class == SetsImpl

        and:
        sets.combinationProduct == expectedSize

        where:
        setInputs                               || expectedSize
        []                                      || 0
        [['A']]                                 || 1
        [['A', 'B']]                            || 2
        [['A', 'B'], [1]]                       || 2
        [['A', 'B'], [1, 2]]                    || 4
        [['A', 'B', 'C'], [1, 2]]               || 6
        [['A', 'B', 'C'], [1, 2], ['vv', 'bb']] || 12
    }
}
