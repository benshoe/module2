import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// AssignmentApplication class.
// Used as driver class, in accordance with instructions.
public class AssignmentApplication {

    public static void main(String[] args) {

        ZooEditor z = new ZooEditor();

    }

} // end class AssignmentApplication

/*
 *   Zoo management GUI
 */

class ZooEditor {
    // main window and its size
    private JFrame f;
    private final int editorWindowWidth = 600;
    private final int editorWindowHeight = 400;
    // Editor data storage
    //private ArrayList<Animal> inhabitants;
    private int selectedAnimal; // should point to item in list
    // instead of ArrayList<Animal> inhabitants:
    DefaultListModel<Animal> inhabitants;

    public ZooEditor () {
        // set up data structures
        // inhabitants = new ArrayList<Animal>();
        // add some initial inhabitants to the Zoo
        // inhabitants.add(new Mammal("Human","Ben"));
        // inhabitants.add(new Mammal("Human","Chris"));
        // alternative way ...
        // Mammal jan = new Mammal();
        // jan.setName("Jan");
        // jan.setType("Human");
        // inhabitants.add(jan);
        //inhabitants.add(new Bird("Foo","Bar"));

        /// better Alternative? Eases listing using JList -> animalChooserPanel()
        inhabitants = new DefaultListModel<>();
        inhabitants.addElement( new Mammal("Human","Ben") );
        inhabitants.addElement( new Mammal("Human","Chris") );
        inhabitants.addElement( new Mammal("Human","Jan") );

        // set up main window
        setupMainWindow();
    }

    private void setupMainWindow() {
        f = new JFrame("Zoo Editor (v2016.0.1)");
        f.setLayout(new GridLayout(3,1)); // 3 rows, 1 cols
        f.setPreferredSize(new Dimension(editorWindowWidth,editorWindowHeight));

        // first row (head / title)
        f.add( new JLabel("Zoo", JLabel.CENTER) );

        // second row (split into two columns: animal chooser and editor)
        JPanel windowCenterRow = new JPanel(new GridLayout(1,2));
        windowCenterRow.add( animalChooserPanel() );
        windowCenterRow.add( animalEditorPanel() );
        f.add(windowCenterRow);

        // third row, buttons
        JPanel buttons = new JPanel(new GridLayout(1,2));
        buttons.add( buttonNew() );
        buttons.add( buttonSave() );
        f.add(buttons);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private JButton buttonNew() {
        // add new item to ArrayList<Animals>, show editor
        JButton button = new JButton("Add new...");
        button.addActionListener(new NewAnimalButtonListener(inhabitants));
        return button;
    }

    private JButton buttonSave() {
        // add ev listener to actually save when pressed...
        JButton button = new JButton("Save");
        button.addActionListener(new UpdateAnimalButtonListener());
        return button;
    }

    public JPanel animalChooserPanel() {
        JPanel p = new JPanel(new GridLayout(2,1));
        p.add( new JLabel("Select animal...", JLabel.CENTER) );
        // USE THIS??? :
        // https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
        JList<Animal> l = new JList<>(inhabitants);
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(l);
        p.add(listScroller);
        return p;
    }

    public JPanel animalEditorPanel( /* optional existing Record */ ) {
        // should receive events animalSelected/Added and re-fire?
        JPanel p = new JPanel(new GridLayout(3,2));
        p.add( new JLabel("Editor, base data plus specifics", JLabel.CENTER) );
        // I think this panel should be half static, half dynamic:
        // static: "type" input field and "species" dropdown
        // dynamic: species-specific panel-contents, a la
        // p.add( existingRecord.showSpeciesSpecificPanel()? )
        return p;
    }

    public JPanel speciesChooserPanel(int speciesId) {
        // lists available species, .onChange: show species-specific edit form below
        // speciesId is pre-selected
        JPanel p = new JPanel(new GridLayout(3,2));
        p.add( new JLabel("DROPDOWN", JLabel.CENTER) );
        return p;
    }

}

class NewAnimalButtonListener implements ActionListener {
    private DefaultListModel<Animal> list;
    public NewAnimalButtonListener(DefaultListModel l) {
        list = l;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("ADD NEW pressed...");
        // should add new item to inhabitants
        // FIXME:
        // how to add yet-type-undefined Animal if it's abstract? :-(
        list.addElement( new Mammal("UNDEFINED","UGLY") );
    }
}

class UpdateAnimalButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("UPDATE pressed...");
    }
}

/*
 *   Animal: abstract super class
 */

abstract class Animal {
    // does each animal have it's own JFrame "display logic"?
    //protected String clade; // https://en.wikipedia.org/wiki/Clade ??
    private String[] species = {"undefined","Mamal","Bird","Reptile"};
    public enum Species {
        UNDEFINED ("Please select species"),
        MAMMAL    ("Mammal"),
        BIRD      ("Bird"),
        REPTILE   ("Reptile"),
        INSECT    ("Insect");

        private /* ???? */ String speciesName;

        String getSpeciesName() {
            return speciesName;
        }

        Species(String name) {
            speciesName = name;
        }
    }
    private Species animalSpecies;
    private String type;  // Animal type -- tiger, ostrich etc
    private String name;  // Animal name -- john, jack, jim ... ?

    public Animal (Species s) {
        System.out.println("Animal constructor called, species: "+ s.speciesName);
        animalSpecies = s;
    }

    public void setType(String t) {
        System.out.println("Setting type to "+t);
        type = t;
    }

    public String getType() {
        return type;
    }

    public void setName(String n) {
        System.out.println("Setting name to "+n);
        name = n;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        // this will be used in animal list view!
        return animalSpecies+": "+name + " " + animalSpecies.getSpeciesName();
    }

}

/*
 *   Species: Inheriting common Animal properties
 */

class Mammal extends Animal {
    public Mammal() {
        super(Animal.Species.MAMMAL);
        System.out.println("New Mammal created of undefined type, unnamed yet.");
    }
    public Mammal(String artName, String givenName) {
        super(Animal.Species.MAMMAL);
        setType(artName);
        setName(givenName);
        System.out.println("New Mammal created of type "+artName+", given name: "+givenName);
    }

    // interface should enforce us to provide something like:
    // public JFrame speciesSpecificEditorPanel ???
}

class Bird extends Animal {
    private double wingSpan;
    public Bird() {
        super(Animal.Species.BIRD);
    }
}

class Reptile extends Animal {
    private int footCount;
    public Reptile() {
        super(Animal.Species.REPTILE);
    }

    public void move() {
        System.out.println("I'm a reptile");
    }
}


