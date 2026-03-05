import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterator {
    public static void main(String[] args) {
        
    List<string> list = new ArrayList<>();
    list.add("hello");
    Iterator<string> it = list.iterator();

while(it.hasNext()) {
    System.out.println(it.next());
}
}
}
