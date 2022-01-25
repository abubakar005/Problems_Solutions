import java.util.Objects;

public class abc implements Comparable {

    int key;
    int counter;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        abc abc = (abc) o;
        return key == abc.key &&
                counter == abc.counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, counter);
    }

    @Override
    public String toString() {
        return "abc{" +
                "key=" + key +
                ", counter=" + counter +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
