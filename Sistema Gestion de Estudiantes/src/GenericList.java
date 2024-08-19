import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> items;

    public GenericList() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public T find(int index) {
        if (index < 0 || index >= items.size()) {
            return null; // o lanzar una excepción si es necesario
        }
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}
