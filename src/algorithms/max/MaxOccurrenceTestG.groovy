package algorithms.max

import spock.lang.Specification
import spock.lang.Unroll

class MaxOccurrenceTestG extends Specification {

    @Unroll("#description:")
    def "test max occurrence - Happy Path"() {

        def out;
        when:
        out = MaxOccurence.getMaxOccurances(input);
        then:
        output == out
        where:
        description                                  | input       | output
        "Single Character"                           | "a"         | 'a'
        "Only One Possible Maximum Char - variant 1" | "aaabcdef"  | 'a'
        "Only One Possible Maximum Char - variant 2" | "aaabbcdef" | 'a'

    }

    @Unroll("#description")
    def "test max occurrence - Failures"() {
        when:
        MaxOccurence.getMaxOccurances(input);
        then:
        RuntimeException ex = thrown()
        ex.message == output;
        where:
        description                              | input      | output
        "Empty String"                           | null       | 'Input string is empty'
        "More than one char with max occurrence" | "aabbcdef" | 'More than one char with max occurrence'

    }


}