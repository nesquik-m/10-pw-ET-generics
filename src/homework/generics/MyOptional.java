package homework.generics;

public class MyOptional<T> {

    private static final MyOptional<?> EMPTY = new MyOptional<>();

    private T value;

    private MyOptional() {
    }

    public MyOptional(T value) {
        this.value = value;
    }

    public T get() {

        if (value == null) {
            throw new InvalidParameterException("Value cannot be null");
        }

        return value;
    }

    static <T> MyOptional<T> of(T value) {

        if (value == null) {
            throw new InvalidParameterException("Value cannot be null");
        }

        return new MyOptional<>(value);
    }

    static <T> MyOptional<T> ofNullable(T value) {

        if (value == null) {
            return (MyOptional<T>) EMPTY;
        }

        return new MyOptional<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public Object orElse(Object other) {
        return value == null ? other : value;
    }

}
