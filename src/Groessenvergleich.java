import java.util.Comparator;

/**
 * Created by doetken on 29.06.2016.
 */
public class Groessenvergleich implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getGroesse() - o1.getGroesse();
    }
}
