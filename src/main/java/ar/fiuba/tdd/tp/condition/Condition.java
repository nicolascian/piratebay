package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public interface Condition<T> {

    /**
     * Check if {@code t} is satisfied by the condition.
     *
     * @param elementT Object to test.
     * @return {@code true} if {@code t} satisfies the condition.
     */
    boolean isSatisfiedBy(T elementT);

    /**
     * Create a new condition that is the AND operation of {@code this} condition and another condition.
     *
     * @param condition Condition to AND.
     * @return A new condition.
     */
    Condition<T> and(Condition<T> condition);

    /**
     * Create a new condition that is the OR operation of {@code this} condition and another condition.
     *
     * @param condition Condition to OR.
     * @return A new condition.
     */
    Condition<T> or(Condition<T> condition);

    /**
     * Create a new condition that is the NOT operation of {@code this} condition.
     *
     * @param condition Condition to NOT.
     * @return A new condition.
     */
    Condition<T> not(Condition<T> condition);
}