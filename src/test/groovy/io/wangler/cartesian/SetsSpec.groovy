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

        setInputs.each { builder.withSet(it as Set) }

        Sets sets = builder.build()

        expect:
        sets.class == SetsImpl

        where:
        setInputs                               || _
        []                                      || _
        [['A']]                                 || _
        [['A', 'B']]                            || _
        [['A', 'B'], [1]]                       || _
        [['A', 'B'], [1, 2]]                    || _
        [['A', 'B', 'C'], [1, 2]]               || _
        [['A', 'B', 'C'], [1, 2], ['vv', 'bb']] || _
    }
}
