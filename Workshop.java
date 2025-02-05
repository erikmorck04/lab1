import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class Workshop<T> {
    private List<Class<?>> allowedTypes;
    private int max_cars;
    public Workshop(List<Class<?>> allowedTypes, int max_cars) {
        this.allowedTypes = allowedTypes;
        this.max_cars = max_cars;
    }




}

