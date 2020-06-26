import java.util.Arrays;
import java.util.HashSet;

public class removeDuplicateWithOrder {
    public static void main(String[] args) throws Exception {

        String[] list = { "1", "1", "2" };
        String[] lista = new HashSet<String>(Arrays.asList(list)).stream().toArray(String[]::new);
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]);
        }

    }
}