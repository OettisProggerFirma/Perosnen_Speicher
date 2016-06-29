import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by doetken on 29.06.2016.
 */
public class FrameHolder {

    private final JFrame frame;
    private final PersonenSpeicher speicher = new PersonenSpeicher();
    private final JList<Person> personenJList;

    public FrameHolder() {
        this.frame = new JFrame();
        this.personenJList = new JList<>();

        Person oetken = new Person("Oetken", "Denis", 188);
        this.speicher.personHinzufuegen(oetken);
        Person mustermann = new Person("Mustermann", "Max", 176);
        this.speicher.personHinzufuegen(mustermann);
        Person musterfrau = new Person("Musterfrau", "Anna", 198);
        this.speicher.personHinzufuegen(musterfrau);

        this.frame.add(this.panelErtellen());
        this.personenJList.setListData(this.speicher.toArray());

        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                speicher.dateiAblage();
            }
        });

        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private JPanel panelErtellen() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JTextField("Name"), BorderLayout.SOUTH);
        panel.add(this.personenJList, BorderLayout.CENTER);

        return panel;
    }
}
