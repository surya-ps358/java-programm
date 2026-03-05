package CollectionFramwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SafeModificationExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Bob")) {
                // ✅ Safe removal
                iterator.remove();
            }
        }

        System.out.println("After removal: " + names);
    }
}
