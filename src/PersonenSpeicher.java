import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by doetken on 29.06.2016.
 */
public class PersonenSpeicher {

    public final Set<Person> personenSet;

    public PersonenSpeicher() {
        this.personenSet = new TreeSet<>();
    }

    public void personHinzufuegen(Person person) {
        this.personenSet.add(person);
    }

    public void dateiAblage() {
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("test.txt"))) {
            for (Person person : personenSet) {
                bwr.write(person.toString());
                bwr.write(System.lineSeparator());
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public Person[] toArray() {
        Person[] array = new Person[this.personenSet.size()];

            for (int i = 0; i < this.personenSet.size(); i++) {
                for (Person person : this.personenSet) {
                array[i] = person;
            }
        }

        return array;
    }

}
