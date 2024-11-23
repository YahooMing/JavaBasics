public class Pair {
    Object key;
    Object value;

    public Pair(Object k, Object v)
    {
        key = k;
        value = v;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public String toString() {
        return getKey() + " " + getValue() + " zł";
    }
}
