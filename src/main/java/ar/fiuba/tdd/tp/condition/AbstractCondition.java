package ar.fiuba.tdd.tp.condition;

/**
 * Created by leandro on 10/05/16.
 */
public abstract class AbstractCondition<T> implements Condition<T> {

    public abstract boolean isSatisfiedBy(T elementT);

    public Condition<T> and(final Condition<T> condition) {
        return new BinaryCondition<>(this, condition, (value, value2) -> value && value2);
    }

    public Condition<T> or(final Condition<T> condition) {
        return new BinaryCondition<>(this, condition, (value, value2) -> value || value2);
    }

    public Condition<T> not(final Condition<T> condition) {
        return new UnaryCondition<>(condition, (value) -> !value);
    }
}