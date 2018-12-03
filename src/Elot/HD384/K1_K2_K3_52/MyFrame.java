package Elot.HD384.K1_K2_K3_52;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyFrame extends JFrame {

    private int cableIndex;
    private String conductor;
    private String insulation;
    private int chargedConductorsNum;
    private double crossSection;
    private String multicore;
    private String pipe;
    private String contact;
    private String triangleSetUp;
    private String horizontalSetUp;
    private ArrayList<Cable> cableTypes;
    private String[] crossSectionArray;
    private JPanel panel;

    private JComboBox<String> CableSelector;
    private JComboBox<String> ConductorMaterialSelector;
    private JComboBox<String> InsulationSelector;
    private JComboBox<String> ChargedConductorSelector;
    private JLabel ChargedConductorLabel;
    private JLabel InsulationLabel;
    private JLabel ConductorMaterialLabel;
    private JLabel CableTypeLabel;
    private JLabel CrossSectionLabel;
    private JComboBox<String> CrossSectionSelector;
    private JLabel MultiCoreLabel;
    private JComboBox<String> MultiCoreSelector;
    private JLabel PipeLabel;
    private JComboBox<String> PipeSelector;
    private JLabel ContactLabel;
    private JComboBox<String> ContactSelector;
    private JLabel TriangleSetUpLabel;
    private JComboBox<String> TriangleSetUpSelector;
    private JLabel HorizontalSetUpLabel;
    private JComboBox<String> HorizontalSetUpSelector;
    private JLabel CurrentCalculatorLabel;
    private JButton CurrentCalculatorButton;
    BuildInCable binc;
    WallMountedCable wmc;
    AerialCable ac;
    OnGroundCable ogc;

    public MyFrame() {

        panel = new JPanel();
        this.setContentPane(panel);





        //Create JLabel for CableTypeLabel
        CableTypeLabel = new JLabel("Είδη ηλεκτρικών γραμμών.", JLabel.CENTER);
        CableTypeLabel.setVerticalAlignment(JLabel.TOP);
        CableTypeLabel.setLabelFor(CableSelector);
        panel.add(CableTypeLabel);
        //Create ComboBox for CableSelector
        String[] CableSelectorItems = {"Εντοιχισμένο", "Επιτοίχιο", "Στον αέρα", "Στο έδαφος"};
        CableSelector = new JComboBox<>(CableSelectorItems);
        CableSelectorListener ctl = new CableSelectorListener();
        CableSelector.addActionListener(ctl);
        CableSelector.setSelectedIndex(-1);
        CableSelector.setEditable(false);
        panel.add(CableSelector);

        //Create JLabel for ConductorMaterialLabel
        ConductorMaterialLabel = new JLabel("Υλικό αγωγού.", JLabel.CENTER);
        ConductorMaterialLabel.setVerticalAlignment(JLabel.TOP);
        ConductorMaterialLabel.setLabelFor(ConductorMaterialSelector);
        panel.add(ConductorMaterialLabel);
        //Create ComboBox for ConductorMaterialSelector
        String[] conductorMaterialItems = {"Χαλκός", "Αλουμίνιο"};
        ConductorMaterialSelector = new JComboBox<>(conductorMaterialItems);
        ConductorMaterialListener cml = new ConductorMaterialListener();
        ConductorMaterialSelector.addActionListener(cml);
        ConductorMaterialSelector.setSelectedIndex(-1);
        ConductorMaterialSelector.setEditable(false);
        panel.add(ConductorMaterialSelector);

        //Create JLabel for InsulationLabel
        InsulationLabel = new JLabel("Υλικό Μόνωσης.", JLabel.CENTER);
        InsulationLabel.setVerticalAlignment(JLabel.TOP);
        InsulationLabel.setLabelFor(InsulationSelector);
        panel.add(InsulationLabel);
        //Create ComboBox for InsulationSelector
        String[] insulationItems = {"PVC", "EPR ή XLPE"};
        InsulationSelector = new JComboBox<>(insulationItems);
        InsulationListener insl = new InsulationListener();
        InsulationSelector.addActionListener(insl);
        InsulationSelector.setSelectedIndex(-1);
        InsulationSelector.setEditable(false);
        panel.add(InsulationSelector);

        //Create JLabel for ChargedConductorLabel
        ChargedConductorLabel = new JLabel("Πλήθος φορτιζόμενων αγωγών.", JLabel.CENTER);
        ChargedConductorLabel.setVerticalAlignment(JLabel.TOP);
        ChargedConductorLabel.setLabelFor(ChargedConductorSelector);
        panel.add(ChargedConductorLabel);
        //Create ComboBox for ChargedConductorSelector
        String[] chargedConductorItems = {"2", "3"};
        ChargedConductorSelector = new JComboBox<>(chargedConductorItems);
        ChargedConductorListener ccl = new ChargedConductorListener();
        ChargedConductorSelector.addActionListener(ccl);
        ChargedConductorSelector.setSelectedIndex(-1);
        ChargedConductorSelector.setEditable(false);
        panel.add(ChargedConductorSelector);

        //Create JLabel for MultiCoreLabel
        MultiCoreLabel = new JLabel("Είδος καλωδίου.", JLabel.CENTER);
        MultiCoreLabel.setVerticalAlignment(JLabel.TOP);
        MultiCoreLabel.setLabelFor(MultiCoreSelector);
        MultiCoreLabel.setVisible(false);
        panel.add(MultiCoreLabel);
        //Create ComboBox for MultiCoreSelector
        MultiCoreSelector = new JComboBox<>();
        MultiCoreListener mcl = new MultiCoreListener();
        MultiCoreSelector.addActionListener(mcl);
        MultiCoreSelector.setSelectedIndex(-1);
        MultiCoreSelector.setEditable(false);
        MultiCoreSelector.setVisible(false);
        MultiCoreSelector.setEnabled(false);
        panel.add(MultiCoreSelector);

        //Create JLabel for PipeLabel
        PipeLabel = new JLabel("Υπαρξη σωλήνα.", JLabel.CENTER);
        PipeLabel.setVerticalAlignment(JLabel.TOP);
        PipeLabel.setLabelFor(PipeSelector);
        PipeLabel.setVisible(false);
        panel.add(PipeLabel);
        //Create ComboBox for PipeSelector
        String[] PipeItems = {"Γυμνό", "Σε σωλήνα"};
        PipeSelector = new JComboBox<>(PipeItems);
        PipeListener pipel = new PipeListener();
        PipeSelector.addActionListener(pipel);
        PipeSelector.setSelectedIndex(-1);
        PipeSelector.setEditable(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        panel.add(PipeSelector);

        //Create JLabel for ContactLabel
        ContactLabel = new JLabel("Γειτνίαση.", JLabel.CENTER);
        ContactLabel.setVerticalAlignment(JLabel.TOP);
        ContactLabel.setLabelFor(ContactSelector);
        ContactLabel.setVisible(false);
        panel.add(ContactLabel);
        //Create ComboBox for ContactSelector
        String[] ContactItems = {"Σε επαφή μεταξύ τους", "Σε απόσταση μεταξύ τους"};
        ContactSelector = new JComboBox<>(ContactItems);
        ContactListener cncl = new ContactListener();
        ContactSelector.addActionListener(cncl);
        ContactSelector.setSelectedIndex(-1);
        ContactSelector.setEditable(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        panel.add(ContactSelector);

        //Create JLabel for TriangleSetUpLabel
        TriangleSetUpLabel = new JLabel("Διάταξη.", JLabel.CENTER);
        TriangleSetUpLabel.setVerticalAlignment(JLabel.TOP);
        TriangleSetUpLabel.setLabelFor(TriangleSetUpSelector);
        TriangleSetUpLabel.setVisible(false);
        panel.add(TriangleSetUpLabel);
        //Create ComboBox for TriangleSetUpSelector
        String[] triangleSetUpItems = {"∆ιάταξη επίπεδη οριζόντια ή κατακόρυφη", "∆ιάταξη τριγωνική"};
        TriangleSetUpSelector = new JComboBox<>(triangleSetUpItems);
        TriangleSetUpListener tsul = new TriangleSetUpListener();
        TriangleSetUpSelector.addActionListener(tsul);
        TriangleSetUpSelector.setSelectedIndex(-1);
        TriangleSetUpSelector.setEditable(false);
        TriangleSetUpSelector.setVisible(false);
        TriangleSetUpSelector.setEnabled(false);
        panel.add(TriangleSetUpSelector);

        //Create JLabel for HorizontalSetUpLabel
        HorizontalSetUpLabel = new JLabel("Διάταξη.", JLabel.CENTER);
        HorizontalSetUpLabel.setVerticalAlignment(JLabel.TOP);
        HorizontalSetUpLabel.setLabelFor(HorizontalSetUpSelector);
        HorizontalSetUpLabel.setVisible(false);
        panel.add(HorizontalSetUpLabel);
        //Create ComboBox for TriangleSetUpSelector
        String[] horizontalSetUpItems = {"∆ιάταξη επίπεδη οριζόντια", "∆ιάταξη επίπεδη κατακόρυφη"};
        HorizontalSetUpSelector = new JComboBox<>(horizontalSetUpItems);
        HorizontalSetUpListener hsul = new HorizontalSetUpListener();
        HorizontalSetUpSelector.addActionListener(hsul);
        HorizontalSetUpSelector.setSelectedIndex(-1);
        HorizontalSetUpSelector.setEditable(false);
        HorizontalSetUpSelector.setVisible(false);
        HorizontalSetUpSelector.setEnabled(false);
        panel.add(HorizontalSetUpSelector);

        //Create JLabel for CrossSection
        CrossSectionLabel = new JLabel("Διατομή αγωγών mm2.", JLabel.CENTER);
        CrossSectionLabel.setVerticalAlignment(JLabel.TOP);
        CrossSectionLabel.setLabelFor(CrossSectionSelector);
        panel.add(CrossSectionLabel);
        //Create ComboBox for CrossSection Selector (Box is created elsewhere.
        crossSectionArray = new String[]{"1.5", "2.5", "4", "6", "10", "16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300", "400", "500", "630"};
        CrossSectionSelector = new JComboBox<>(crossSectionArray);
        CrossSectionListener cslll = new CrossSectionListener();
        CrossSectionSelector.addActionListener(cslll);
        CrossSectionSelector.setEditable(false);
        panel.add(CrossSectionSelector);

        //Create JLabel for HorizontalSetUpLabel
        CurrentCalculatorLabel = new JLabel("Υπολογισμός μέγιστης φόρτησης καλωδίου.", JLabel.CENTER);
        CurrentCalculatorLabel.setVerticalAlignment(JLabel.TOP);
        CurrentCalculatorLabel.setLabelFor(HorizontalSetUpSelector);
        panel.add(CurrentCalculatorLabel);
        //Create ComboBox for TriangleSetUpSelector

        CurrentCalculatorButton = new JButton("Click Here");
        CurrentCalculatorButtonListener ccbl = new CurrentCalculatorButtonListener();
        CurrentCalculatorButton.addActionListener(ccbl);
        panel.add(CurrentCalculatorButton);








        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setTitle("Μέγιστα επιτρεπόμενα ρεύματα (σε A).");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    //Listener for Cable selector ComboBox
    class CableSelectorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = CableSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Εντοιχισμένο"
                case 0:
                    resetAll();
                    cableIndex = 0;
                    setMultiCore();
                    MultiCoreSelector.removeAllItems();
                    MultiCoreSelector.addItem("Μονωμένοι αγωγοί σε σωλήνα");
                    MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                    MultiCoreSelector.setSelectedIndex(-1);

                    break;
                //case 1 is "Επιτοίχιο"
                case 1:
                    resetAll();
                    cableIndex = 1;
                    setMultiCore();
                    MultiCoreSelector.removeAllItems();
                    MultiCoreSelector.addItem("Μονωμένοι αγωγοί σε σωλήνα");
                    MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                    MultiCoreSelector.setSelectedIndex(-1);

                    break;
                //case 2 is "Στον αέρα"
                case 2:
                    resetAll();
                    cableIndex = 2;
                    setMultiCore();
                    MultiCoreSelector.removeAllItems();
                    MultiCoreSelector.addItem("Μονοπολικά καλώδια");
                    MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                    MultiCoreSelector.setSelectedIndex(-1);
                    break;
                //case 3 is "Στο έδαφος"
                case 3:
                    resetAll();
                    cableIndex = 3;
                    break;
            }
        }
    }

    //Listener for Insulation selector ComboBox
    class InsulationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = InsulationSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "PVC"
                case 0:
                    insulation = "PVC";
                    break;
                //case 1 is "EPR or XLPE"
                case 1:
                    insulation = "EPR or XLPE";
                    break;

            }
        }
    }

    //Listener for Conductor Material selector ComboBox
    class ConductorMaterialListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = ConductorMaterialSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Χαλκός"
                case 0:
                    conductor = "Copper";
                    break;
                //case 1 is "Αλουμίνιο"
                case 1:
                    conductor = "Aluminum";
                    break;

            }
        }
    }

    //Listener for ChargedConductorSelector ComboBox
    class ChargedConductorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = ChargedConductorSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "2"
                case 0:
                    chargedConductorsNum = 2;
                    break;
                //case 1 is "3"
                case 1:
                    chargedConductorsNum = 3;
                    break;
            }
        }
    }

    //Listener for ChargedConductorSelector ComboBox
    class MultiCoreListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = MultiCoreSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Μονοπολικά καλώδια" or "Μονωμένοι αγωγοί σε σωλήνα"
                case 0:
                    if ("Μονοπολικά καλώδια".equals(MultiCoreSelector.getSelectedItem()) && cableIndex == 2) {
                        multicore = "Single Core";
                        resetPipe();
                        setContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();

                    } else if ("Μονωμένοι αγωγοί σε σωλήνα".equals(MultiCoreSelector.getSelectedItem()) && (cableIndex == 0||cableIndex == 1)) {
                        multicore = "No cores";
                        resetPipe();
                        pipe = "no pipe";
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();

                    }

                    break;
                //case 1 is "Πολυπολικά καλώδια"
                case 1:
                    if ("Πολυπολικά καλώδια".equals(MultiCoreSelector.getSelectedItem()) && cableIndex == 2) {
                        multicore = "Multi Core";
                        resetPipe();
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();

                    } else if ("Πολυπολικά καλώδια".equals(MultiCoreSelector.getSelectedItem()) && (cableIndex == 0||cableIndex == 1)) {
                        multicore = "Multi Core";
                        resetPipe();
                        setPipe();
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();

                    }
                    break;
            }
        }
    }

    //Listener for PipeSelector ComboBox
    class PipeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = PipeSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Γυμνό"
                case 0:
                    pipe = "Naked cable";
                    break;
                //case 1 is "Σε σωλήνα"
                case 1:
                    pipe = "Cable in pipe";
                    break;
            }
        }
    }

    //Listener for PipeSelector ComboBox
    class ContactListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = ContactSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Σε επαφή μεταξύ τους"
                case 0:
                    contact = "Cables in contact";
                    resetTriangleSetUp();
                    setTriangleSetUp();
                    resetHorizontalSetUp();
                    break;
                //case 1 is "Σε απόσταση μεταξύ τους"
                case 1:
                    contact = "Cables not in contact";
                    resetTriangleSetUp();
                    setHorizontalSetUp();
                    break;
            }
        }
    }

    //Listener for TriangleSetUpSelector ComboBox
    class TriangleSetUpListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = TriangleSetUpSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "∆ιάταξη τριγωνική"
                case 0:
                    triangleSetUp = "Cables in triangle setup";
                    break;
                //case 1 is "∆ιάταξη επίπεδη οριζόντια ή κατακόρυφη"
                case 1:
                    triangleSetUp = "Cables in horizontal or vertical setup";
                    break;
            }
        }
    }


    //Listener for TriangleSetUpSelector ComboBox
    class HorizontalSetUpListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = HorizontalSetUpSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "∆ιάταξη επίπεδη οριζόντια"
                case 0:
                    horizontalSetUp = "Cables in horizontal setup";
                    break;
                //case 1 is "∆ιάταξη επίπεδη  κατακόρυφη"
                case 1:
                    horizontalSetUp = "Cables in vertical setup";
                    break;
            }
        }
    }


    //Listener for CrossSectionSelector ComboBox
    class CrossSectionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = CrossSectionSelector.getSelectedIndex();
            crossSection = Double.parseDouble(CrossSectionSelector.getItemAt(i));
            System.out.println(crossSection);
            }
        }

    class CurrentCalculatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (cableIndex){
                case 0:
                if (!buildInOrWallMountedCablesErrorCheck())
                    binc = new BuildInCable(conductor, insulation, chargedConductorsNum, multicore, pipe, crossSection);
                else
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                if (!buildInOrWallMountedCablesErrorCheck())
                    wmc = new WallMountedCable(conductor, insulation, chargedConductorsNum, multicore, pipe, crossSection);
                else
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                if (!aerialCableErrorCheck())
                    ac = new AerialCable(conductor, insulation, chargedConductorsNum, multicore, contact, triangleSetUp, horizontalSetUp, crossSection);
                else
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                if (!onGroundCableErrorCheck())
                    ogc = new OnGroundCable(conductor, insulation, chargedConductorsNum,crossSection);
                else
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        }
    }

    /*Setting visibility of JComboboxes and JLabels
     *reset means not visible
     * set means visible
     */

    private void resetMultiCore() {
        MultiCoreLabel.setVisible(false);
        MultiCoreSelector.setVisible(false);
        MultiCoreSelector.setEnabled(false);
        MultiCoreSelector.setSelectedIndex(-1);
        chargedConductorsNum = 0;
    }

    private void setMultiCore() {
        MultiCoreLabel.setVisible(true);
        MultiCoreSelector.setVisible(true);
        MultiCoreSelector.setEnabled(true);
        MultiCoreSelector.setSelectedIndex(-1);
    }

    private void resetPipe() {
        PipeLabel.setVisible(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        PipeSelector.setSelectedIndex(-1);
        pipe = null;
    }

    private void setPipe() {
        PipeLabel.setVisible(true);
        PipeSelector.setVisible(true);
        PipeSelector.setEnabled(true);
        PipeSelector.setSelectedIndex(-1);
    }

    private void resetContact() {
        ContactLabel.setVisible(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        ContactSelector.setSelectedIndex(-1);
        contact = null;
    }

    private void setContact() {
        ContactLabel.setVisible(true);
        ContactSelector.setVisible(true);
        ContactSelector.setEnabled(true);
        ContactSelector.setSelectedIndex(-1);

    }

    private void resetTriangleSetUp() {
        TriangleSetUpLabel.setVisible(false);
        TriangleSetUpSelector.setVisible(false);
        TriangleSetUpSelector.setEnabled(false);
        TriangleSetUpSelector.setSelectedIndex(-1);
        triangleSetUp=null;
    }

    private void setTriangleSetUp() {
        TriangleSetUpLabel.setVisible(true);
        TriangleSetUpSelector.setVisible(true);
        TriangleSetUpSelector.setEnabled(true);
        TriangleSetUpSelector.setSelectedIndex(-1);

    }

    private void resetHorizontalSetUp() {
        HorizontalSetUpLabel.setVisible(false);
        HorizontalSetUpSelector.setVisible(false);
        HorizontalSetUpSelector.setEnabled(false);
        HorizontalSetUpSelector.setSelectedIndex(-1);
        horizontalSetUp = null;
    }

    private void setHorizontalSetUp() {
        HorizontalSetUpLabel.setVisible(true);
        HorizontalSetUpSelector.setVisible(true);
        HorizontalSetUpSelector.setEnabled(true);
        HorizontalSetUpSelector.setSelectedIndex(-1);

    }

    private void resetAll() {
        resetContact();
        resetHorizontalSetUp();
        resetMultiCore();
        resetPipe();
        resetTriangleSetUp();
        ConductorMaterialSelector.setSelectedIndex(-1);
        InsulationSelector.setSelectedIndex(-1);
        ChargedConductorSelector.setSelectedIndex(-1);
        chargedConductorsNum=0;
        conductor=null;
        insulation=null;
        horizontalSetUp = null;
        pipe = null;
        contact = null;
        triangleSetUp=null;

    }

    private boolean onGroundCableErrorCheck(){

        return (conductor==null||insulation==null||chargedConductorsNum==0);

    }
    private boolean buildInOrWallMountedCablesErrorCheck() {
        return (conductor==null || insulation==null || chargedConductorsNum == 0 || multicore==null||pipe==null);
    }
    private boolean aerialCableErrorCheck() {
        return (conductor==null || insulation==null || chargedConductorsNum == 0 || multicore==null || contact==null || triangleSetUp==null || horizontalSetUp==null);
    }


}



