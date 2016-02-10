import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ben on 10-02-16.
 */
public class ZooFrame extends JFrame {

    public ZooFrame() {
        super("Zoo Application");
        setLayout(new BorderLayout());
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();

        add(new JLabel("Zoo", JLabel.CENTER), BorderLayout.NORTH );
        add(new JLabel("Editor", JLabel.CENTER), BorderLayout.CENTER );

        List<Animal> animals = loadAnimals();
        DefaultListModel<Animal> defaultListModel = new DefaultListModel<>();
        animals.forEach(defaultListModel::addElement);

        JPanel animalListPanel = getAnimalListPanel(defaultListModel);
        add(animalListPanel);
        setVisible(true);
    }

    private JPanel getAnimalListPanel(DefaultListModel<Animal> defaultListModel) {
        JPanel p = new JPanel(new GridLayout(2,1));
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.add("knop", new JButton());
        renderer.setVisible(true);
        p.setLayout(new GridLayout(3, 1));
        p.add( new JLabel("Select animal...", JLabel.CENTER) );
        TableModel tableModel = new AnimalTableModel(loadAnimals());
        JTable table = new JTable(tableModel);
        p.add(new JScrollPane(table));
        JList<Animal> l = new JList<>(defaultListModel);
        l.setCellRenderer(new MyCellRenderer());
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(l);
        p.add(listScroller);
        p.setVisible(true);
        return p;
    }

    class MyCellRenderer extends JLabel implements ListCellRenderer<Animal> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Animal> list, Animal value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getName() + ": " + value.getType());
            return this;
        }
    }

    private List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mammal("Tiger", "Baboo"));
        animals.add(new Bird());
        animals.add(new Reptile());
        animals.add(new Mammal("Elephant", "Dumbo"));
        return animals;
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Couln not load look and feel " + e);
        }
    }

    private class AnimalTableModel implements TableModel {
        private List<Animal> m_animals;
        public AnimalTableModel(List<Animal> animals) {
            m_animals = animals;
        }

        @Override
        public int getRowCount() {
            return m_animals.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Species";
                case 1:
                    return "Name";
                case 2:
                    return "Total";
                case 3:
                    return "Enclosure";
                default:
                    throw new IllegalArgumentException("We don't have columnIndex of " + columnIndex);
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex > 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Animal animal = m_animals.get(rowIndex);
            switch(columnIndex) {
                case 0:
                    return animal.getType();
                case 1:
                    return animal.getName();
                case 2:
                    return animal.toString();
                case 3:
                    return animal.getType() + ": " + animal.getName();
                default:
                    throw new IllegalArgumentException("We don't support columns > 3");
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Animal animal = m_animals.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    animal.setType((String) aValue);
                    break;
                case 1:
                    animal.setName((String) aValue);
                    break;
                case 2:
                case 3:
                    break;
                default:
                    throw new IllegalArgumentException("We don't support columns > 3");
            }
        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }
    }
}
