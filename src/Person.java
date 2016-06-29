/**
 * Created by doetken on 29.06.2016.
 */
public class Person implements Comparable<Person> {
    private final String vorname;
    private final String nachname;
    private final int groesse;
    private final PersonenSpeicher speicher = new PersonenSpeicher();


    public Person(String vorname, String nachname, int groesse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.groesse = groesse;
        this.speicher.personHinzufuegen(this);
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getGroesse() {
        return groesse;
    }

    @Override
    public int compareTo(Person o) {
        return this.getNachname().compareTo(o.getNachname());
    }

    @Override
    public String toString() {
        return personInZeile();
    }

    public String personInZeile() {

        String zeile;

        StringBuilder sb = new StringBuilder("Person");
        sb.append("::");
        sb.append(this.getNachname());
        sb.append("::");
        sb.append(this.getVorname());
        sb.append("::");
        sb.append(this.getGroesse());
        sb.append("\n");
        zeile = sb.toString();

        return zeile;

    }
}
