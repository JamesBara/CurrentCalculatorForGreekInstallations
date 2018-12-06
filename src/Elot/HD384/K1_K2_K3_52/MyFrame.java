package Elot.HD384.K1_K2_K3_52;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* TODO
*
* Adding comments to clarify things.
*Making GUI more presentable.
*
* */




public class MyFrame extends JFrame {

    private int cableIndex;
    private String conductor;
    private String insulation;
    private int chargedConductorsNum;
    private int crossSectionIndex;
    private String multicore;
    private String pipe;
    private String contact;
    private String triangleSetUp;
    private String horizontalSetUp;

    private JPanel panel;

    private JComboBox<String> CableSelector;
    private JComboBox<String> ConductorMaterialSelector;
    private JComboBox<String> InsulationSelector;
    private JComboBox<String> ChargedConductorSelector;
    private JLabel ConductorMaterialLabel;
    private JLabel CableTypeLabel;
    private JLabel CrossSectionLabel;
    private JComboBox<String> CrossSectionType1CopperSelector;
    private JComboBox<String> CrossSectionType1AluminumSelector;
    private JComboBox<String> CrossSectionType2CopperSelector;
    private JComboBox<String> CrossSectionType2AluminumSelector;
    private JLabel MultiCoreLabel;
    private JComboBox<String> MultiCoreSelectorType1;
    private JComboBox<String> MultiCoreSelectorType2;
    private JLabel PipeLabel;
    private JComboBox<String> PipeSelector;
    private JLabel ContactLabel;
    private JComboBox<String> ContactSelector;
    private JLabel TriangleSetUpLabel;
    private JComboBox<String> TriangleSetUpSelector;
    private JLabel HorizontalSetUpLabel;
    private JComboBox<String> HorizontalSetUpSelector;
    private JButton CurrentCalculatorButton;
    private BuildInCable binc;
    private WallMountedCable wmc;
    private AerialCable ac;
    private OnGroundCable ogc;
    private JLabel LabelofResultLabel;
    private JLabel ResultLabel;

    public MyFrame() {

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;

        this.setContentPane(panel);


        //Create JLabel for CableTypeLabel
        CableTypeLabel = new JLabel("Είδη ηλεκτρικών γραμμών:");
        panel.add(CableTypeLabel,gbc);
        gbc.gridx=1;
        //Create ComboBox for CableSelector
        String[] CableSelectorItems = {"Εντοιχισμένο", "Επιτοίχιο", "Στον αέρα", "Στο έδαφος"};
        CableSelector = new JComboBox<>(CableSelectorItems);
        CableSelectorListener ctl = new CableSelectorListener();
        CableSelector.addActionListener(ctl);
        CableSelector.setSelectedIndex(-1);
        CableSelector.setEditable(false);
        panel.add(CableSelector,gbc);
        gbc.gridx=2;

        //Create JLabel for ConductorMaterialLabel
        ConductorMaterialLabel = new JLabel("Υλικό αγωγού:");
        panel.add(ConductorMaterialLabel,gbc);
        gbc.gridx=3;
        //Create ComboBox for ConductorMaterialSelector
        String[] conductorMaterialItems = {"Χαλκός", "Αλουμίνιο"};
        ConductorMaterialSelector = new JComboBox<>(conductorMaterialItems);
        ConductorMaterialListener cml = new ConductorMaterialListener();
        ConductorMaterialSelector.addActionListener(cml);
        ConductorMaterialSelector.setSelectedIndex(-1);
        ConductorMaterialSelector.setEditable(false);
        panel.add(ConductorMaterialSelector,gbc);
        gbc.gridx=4;

        //Create JLabel for InsulationLabel
        JLabel insulationLabel = new JLabel("Υλικό Μόνωσης:");
        panel.add(insulationLabel,gbc);
        gbc.gridx=5;
        //Create ComboBox for InsulationSelector
        String[] insulationItems = {"PVC", "EPR ή XLPE"};
        InsulationSelector = new JComboBox<>(insulationItems);
        InsulationListener insl = new InsulationListener();
        InsulationSelector.addActionListener(insl);
        InsulationSelector.setSelectedIndex(-1);
        InsulationSelector.setEditable(false);
        panel.add(InsulationSelector,gbc);
        gbc.gridx=6;

        //Create JLabel for ChargedConductorLabel
        JLabel chargedConductorLabel = new JLabel("Πλήθος φορτιζόμενων αγωγών:");
        panel.add(chargedConductorLabel,gbc);
        gbc.gridx=7;
        //Create ComboBox for ChargedConductorSelector
        String[] chargedConductorItems = {"2", "3"};
        ChargedConductorSelector = new JComboBox<>(chargedConductorItems);
        ChargedConductorListener ccl = new ChargedConductorListener();
        ChargedConductorSelector.addActionListener(ccl);
        ChargedConductorSelector.setSelectedIndex(-1);
        ChargedConductorSelector.setEditable(false);
        panel.add(ChargedConductorSelector,gbc);
        gbc.gridx=0;
        gbc.gridy=1;

        //Create JLabel for MultiCoreLabel
        MultiCoreLabel = new JLabel("Είδος καλωδίου:");
        MultiCoreLabel.setVisible(false);
        panel.add(MultiCoreLabel,gbc);
        gbc.gridx=1;
        //Create ComboBox for MultiCoreSelector
        String[] MultiCoreItemsType1 = {"Μονωμένοι αγωγοί σε σωλήνα", "Πολυπολικά καλώδια"};
        MultiCoreSelectorType1 = new JComboBox<>(MultiCoreItemsType1);
        MultiCoreType1Listener mcl1 = new MultiCoreType1Listener();
        MultiCoreSelectorType1.addActionListener(mcl1);
        MultiCoreSelectorType1.setSelectedIndex(-1);
        MultiCoreSelectorType1.setEditable(false);
        MultiCoreSelectorType1.setVisible(false);
        MultiCoreSelectorType1.setEnabled(false);
        panel.add(MultiCoreSelectorType1,gbc);

        //Create ComboBox for MultiCoreSelector
        String[] MultiCoreItemsType2 = {"Μονοπολικά καλώδια", "Πολυπολικά καλώδια"};
        MultiCoreSelectorType2 = new JComboBox<>(MultiCoreItemsType2);
        MultiCoreType2Listener mcl2 = new MultiCoreType2Listener();
        MultiCoreSelectorType2.addActionListener(mcl2);
        MultiCoreSelectorType2.setSelectedIndex(-1);
        MultiCoreSelectorType2.setEditable(false);
        MultiCoreSelectorType2.setVisible(false);
        MultiCoreSelectorType2.setEnabled(false);
        panel.add(MultiCoreSelectorType2,gbc);
        gbc.gridx=2;

        //Create JLabel for PipeLabel
        PipeLabel = new JLabel("Υπαρξη σωλήνα:");
        PipeLabel.setVisible(false);
        panel.add(PipeLabel,gbc);
        gbc.gridx=3;
        //Create ComboBox for PipeSelector
        String[] PipeItems = {"Γυμνό", "Σε σωλήνα"};
        PipeSelector = new JComboBox<>(PipeItems);
        PipeListener pipel = new PipeListener();
        PipeSelector.addActionListener(pipel);
        PipeSelector.setSelectedIndex(-1);
        PipeSelector.setEditable(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        panel.add(PipeSelector,gbc);
        gbc.gridx=2;

        //Create JLabel for ContactLabel
        ContactLabel = new JLabel("Γειτνίαση:");
        ContactLabel.setVisible(false);
        panel.add(ContactLabel,gbc);
        gbc.gridx=3;
        //Create ComboBox for ContactSelector
        String[] ContactItems = {"Σε επαφή μεταξύ τους", "Σε απόσταση μεταξύ τους"};
        ContactSelector = new JComboBox<>(ContactItems);
        ContactListener cncl = new ContactListener();
        ContactSelector.addActionListener(cncl);
        ContactSelector.setSelectedIndex(-1);
        ContactSelector.setEditable(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        panel.add(ContactSelector,gbc);
        gbc.gridx=4;

        //Create JLabel for TriangleSetUpLabel
        TriangleSetUpLabel = new JLabel("Διάταξη:");
        TriangleSetUpLabel.setVisible(false);
        panel.add(TriangleSetUpLabel,gbc);
        gbc.gridx=5;
        //Create ComboBox for TriangleSetUpSelector
        String[] triangleSetUpItems = {"∆ιάταξη επίπεδη οριζόντια ή κατακόρυφη", "∆ιάταξη τριγωνική"};
        TriangleSetUpSelector = new JComboBox<>(triangleSetUpItems);
        TriangleSetUpListener tsul = new TriangleSetUpListener();
        TriangleSetUpSelector.addActionListener(tsul);
        TriangleSetUpSelector.setSelectedIndex(-1);
        TriangleSetUpSelector.setEditable(false);
        TriangleSetUpSelector.setVisible(false);
        TriangleSetUpSelector.setEnabled(false);
        panel.add(TriangleSetUpSelector,gbc);
        gbc.gridx=4;

        //Create JLabel for HorizontalSetUpLabel
        HorizontalSetUpLabel = new JLabel("Διάταξη:");
        HorizontalSetUpLabel.setVisible(false);
        panel.add(HorizontalSetUpLabel,gbc);
        gbc.gridx=5;
        //Create ComboBox for TriangleSetUpSelector
        String[] horizontalSetUpItems = {"∆ιάταξη επίπεδη οριζόντια", "∆ιάταξη επίπεδη κατακόρυφη"};
        HorizontalSetUpSelector = new JComboBox<>(horizontalSetUpItems);
        HorizontalSetUpListener hsul = new HorizontalSetUpListener();
        HorizontalSetUpSelector.addActionListener(hsul);
        HorizontalSetUpSelector.setSelectedIndex(-1);
        HorizontalSetUpSelector.setEditable(false);
        HorizontalSetUpSelector.setVisible(false);
        HorizontalSetUpSelector.setEnabled(false);
        panel.add(HorizontalSetUpSelector,gbc);
        gbc.gridx=0;
        gbc.gridy=2;

        //Create JLabel for CrossSection
        CrossSectionLabel = new JLabel("Διατομή αγωγών σε mm"+"\u00b2"+":");
        CrossSectionLabel.setVisible(false);
        panel.add(CrossSectionLabel,gbc);
        gbc.gridx=1;
        //Create ComboBox for CrossSection Selector for 52-K1 and 52-K3 Copper
        String[] crossSectionArrayType1Copper = new String[]{"1.5", "2.5", "4", "6", "10", "16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300"};
        CrossSectionType1CopperSelector = new JComboBox<>(crossSectionArrayType1Copper);
        CrossSectionType1CopperListener cst1cl = new CrossSectionType1CopperListener();
        CrossSectionType1CopperSelector.addActionListener(cst1cl);
        CrossSectionType1CopperSelector.setSelectedIndex(0);
        CrossSectionType1CopperSelector.setEditable(false);
        CrossSectionType1CopperSelector.setVisible(false);
        CrossSectionType1CopperSelector.setEnabled(false);
        panel.add(CrossSectionType1CopperSelector,gbc);

        //Create ComboBox for CrossSection Selector for 52-K1 and 52-K3 Aluminum
        String[] crossSectionArrayType1Aluminum = new String[]{"16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300"};
        CrossSectionType1AluminumSelector = new JComboBox<>(crossSectionArrayType1Aluminum);
        CrossSectionType1AluminumListener cst1al = new CrossSectionType1AluminumListener();
        CrossSectionType1AluminumSelector.addActionListener(cst1al);
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
        CrossSectionType1AluminumSelector.setEditable(false);
        CrossSectionType1AluminumSelector.setVisible(false);
        CrossSectionType1AluminumSelector.setEnabled(false);
        panel.add(CrossSectionType1AluminumSelector,gbc);

        //Create ComboBox for CrossSection Selector for 52-K2 Copper
        String[] crossSectionArrayType2Copper = new String[]{"1.5", "2.5", "4", "6", "10", "16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300", "400", "500", "630"};
        CrossSectionType2CopperSelector = new JComboBox<>(crossSectionArrayType2Copper);
        CrossSectionType2CopperListener cst2cl = new CrossSectionType2CopperListener();
        CrossSectionType2CopperSelector.addActionListener(cst2cl);
        CrossSectionType2CopperSelector.setSelectedIndex(0);
        CrossSectionType2CopperSelector.setEditable(false);
        CrossSectionType2CopperSelector.setVisible(false);
        CrossSectionType2CopperSelector.setEnabled(false);
        panel.add(CrossSectionType2CopperSelector,gbc);

        //Create ComboBox for CrossSection Selector for 52-K2 Aluminum
        String[] crossSectionArrayType2Aluminum = new String[]{"16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300", "400", "500", "630"};
        CrossSectionType2AluminumSelector = new JComboBox<>(crossSectionArrayType2Aluminum);
        CrossSectionType2AluminumListener cst2al = new CrossSectionType2AluminumListener();
        CrossSectionType2AluminumSelector.addActionListener(cst2al);
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
        CrossSectionType2AluminumSelector.setEditable(false);
        CrossSectionType2AluminumSelector.setVisible(false);
        CrossSectionType2AluminumSelector.setEnabled(false);
        panel.add(CrossSectionType2AluminumSelector,gbc);
        gbc.gridx=0;
        gbc.gridy=3;

        //Create ComboBox for CurrentCalculatorButton
        CurrentCalculatorButton = new JButton("Υπολογισμός");
        CurrentCalculatorButtonListener ccbl = new CurrentCalculatorButtonListener();
        CurrentCalculatorButton.addActionListener(ccbl);
        panel.add(CurrentCalculatorButton,gbc);
        gbc.gridx=0;
        gbc.gridy=4;

        //Label of Label
        LabelofResultLabel = new JLabel("Μέγιστο ρεύμα:");
        panel.add(LabelofResultLabel,gbc);
        //Result Printing Label
        gbc.gridx=1;
        ResultLabel = new JLabel();
        panel.add(ResultLabel,gbc);


        this.setResizable(true);
        this.setVisible(true);
        this.setSize(500, 500);
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
                    setMultiCoreType1();
                    break;
                //case 1 is "Επιτοίχιο"
                case 1:
                    resetAll();
                    cableIndex = 1;
                    setMultiCoreType1();
                    break;
                //case 2 is "Στον αέρα"
                case 2:
                    resetAll();
                    cableIndex = 2;
                    setMultiCoreType2();
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
                    if (cableIndex!=2) {
                        resetAllCrossSection();
                        setCrossSectionType1Copper();
                    }
                    else{
                        resetAllCrossSection();
                        setCrossSectionType2Copper();
                    }
                    break;
                //case 1 is "Αλουμίνιο"
                case 1:
                    conductor = "Aluminum";
                    if (cableIndex!=2) {
                        resetAllCrossSection();
                        setCrossSectionType1Aluminum();
                    }
                    else{
                        resetAllCrossSection();
                        setCrossSectionType2Aluminum();
                    }
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
    class MultiCoreType1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = MultiCoreSelectorType1.getSelectedIndex();
            switch (i) {
                //case 0 "Μονωμένοι αγωγοί σε σωλήνα"
                case 0:
                        multicore = "none";
                        resetPipe();
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();
                    break;
                //case 1 is "Πολυπολικά καλώδια"
                case 1:
                        multicore = "Multi Core";
                        resetPipe();
                        setPipe();
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();
                    break;
            }
        }
    }

    //Listener for ChargedConductorSelector ComboBox
    class MultiCoreType2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = MultiCoreSelectorType2.getSelectedIndex();
            switch (i) {
                //case 0 "Μονοπολικά καλώδια"
                case 0:
                    multicore = "Single Core";
                    resetContact();
                    resetPipe();
                    setContact();
                    resetHorizontalSetUp();
                    resetTriangleSetUp();
                    break;
                //case 1 is "Πολυπολικά καλώδια"
                case 1:
                    multicore = "Multi Core";
                    resetPipe();
                    resetContact();
                    resetHorizontalSetUp();
                    resetTriangleSetUp();
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


    //Listener for CrossSection Comboboxes
    class CrossSectionType1CopperListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType1CopperSelector.getSelectedIndex();
        }
    }

    class CrossSectionType1AluminumListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            crossSectionIndex= CrossSectionType1AluminumSelector.getSelectedIndex();
        }
    }
    class CrossSectionType2CopperListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType2CopperSelector.getSelectedIndex();
        }
    }
    class CrossSectionType2AluminumListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType2AluminumSelector.getSelectedIndex();
        }
    }

    //Listener for CurrentCalculatorButton
    class CurrentCalculatorButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            switch (cableIndex){
                case 0:
                if (buildInOrWallMountedCablesErrorCheck())
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else{
                    binc = new BuildInCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    binc.setMulticore(multicore);
                    binc.setPipe(pipe);
                    ResultLabel.setText(binc.getMaxCurrent()+"A");
                }
                    break;
                case 1:
                if (buildInOrWallMountedCablesErrorCheck())
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else {
                    wmc = new WallMountedCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    wmc.setMulticore(multicore);
                    wmc.setPipe(pipe);
                    ResultLabel.setText(wmc.getMaxCurrent()+"A");
                }
                    break;
                case 2:
                if (aerialCableErrorCheck())
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else {
                    ac = new AerialCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    ac.setMulticore(multicore);
                        ac.setContact(contact);
                        ac.setTriangleSetUp(triangleSetUp);
                        ac.setHorizontalSetUp(horizontalSetUp);
                        ResultLabel.setText(ac.getMaxCurrent()+"A");
                }
                    break;
                case 3:
                if (onGroundCableErrorCheck())
                    JOptionPane.showMessageDialog(panel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else
                    ogc = new OnGroundCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    ResultLabel.setText(ogc.getMaxCurrent()+"A");

                    break;
            }

        }
    }

    /*Setting visibility of JComboboxes and JLabels
     *reset means not visible
     * set means visible
     */

    private void resetMultiCoreType1() {
        MultiCoreLabel.setVisible(false);
        MultiCoreSelectorType1.setVisible(false);
        MultiCoreSelectorType1.setEnabled(false);
        MultiCoreSelectorType1.setSelectedIndex(-1);
        chargedConductorsNum = 0;
    }

    private void setMultiCoreType1() {
        MultiCoreLabel.setVisible(true);
        MultiCoreSelectorType1.setVisible(true);
        MultiCoreSelectorType1.setEnabled(true);
        MultiCoreSelectorType1.setSelectedIndex(-1);
    }

    private void resetMultiCoreType2() {
        MultiCoreLabel.setVisible(false);
        MultiCoreSelectorType2.setVisible(false);
        MultiCoreSelectorType2.setEnabled(false);
        MultiCoreSelectorType2.setSelectedIndex(-1);
        chargedConductorsNum = 0;
    }

    private void setMultiCoreType2() {
        MultiCoreLabel.setVisible(true);
        MultiCoreSelectorType2.setVisible(true);
        MultiCoreSelectorType2.setEnabled(true);
        MultiCoreSelectorType2.setSelectedIndex(-1);
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

    private void resetCrossSectionType1Copper() {
        CrossSectionLabel.setVisible(false);
        CrossSectionType1CopperSelector.setVisible(false);
        CrossSectionType1CopperSelector.setEnabled(false);
        CrossSectionType1CopperSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType1Copper() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType1CopperSelector.setVisible(true);
        CrossSectionType1CopperSelector.setEnabled(true);
        CrossSectionType1CopperSelector.setSelectedIndex(0);
    }

    private void resetCrossSectionType1Aluminum() {
        CrossSectionLabel.setVisible(false);
        CrossSectionType1AluminumSelector.setVisible(false);
        CrossSectionType1AluminumSelector.setEnabled(false);
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType1Aluminum() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType1AluminumSelector.setVisible(true);
        CrossSectionType1AluminumSelector.setEnabled(true);
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
    }

    private void resetCrossSectionType2Copper() {
        HorizontalSetUpLabel.setVisible(false);
        CrossSectionType2CopperSelector.setVisible(false);
        CrossSectionType2CopperSelector.setEnabled(false);
        CrossSectionType2CopperSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType2Copper() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType2CopperSelector.setVisible(true);
        CrossSectionType2CopperSelector.setEnabled(true);
        CrossSectionType2CopperSelector.setSelectedIndex(0);
    }

    private void resetCrossSectionType2Aluminum() {
        CrossSectionLabel.setVisible(false);
        CrossSectionType2AluminumSelector.setVisible(false);
        CrossSectionType2AluminumSelector.setEnabled(false);
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType2Aluminum() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType2AluminumSelector.setVisible(true);
        CrossSectionType2AluminumSelector.setEnabled(true);
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
    }

    private void resetAllCrossSection(){
        resetCrossSectionType1Copper();
        resetCrossSectionType1Aluminum();
        resetCrossSectionType2Copper();
        resetCrossSectionType2Aluminum();
    }

    private void resetAll() {
        resetContact();
        resetHorizontalSetUp();
        resetMultiCoreType1();
        resetMultiCoreType2();
        resetPipe();
        resetTriangleSetUp();
        resetAllCrossSection();
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

        if (conductor==null || insulation==null || chargedConductorsNum == 0 || multicore==null)
            return true;
        return ("Multi Core".equals(multicore)&&pipe==null);


    }

    private boolean aerialCableErrorCheck() {

        if (conductor==null || insulation==null || chargedConductorsNum == 0 || multicore==null)
        return true;
        else if ("Single Core".equals(multicore)&&contact==null)
            return true;
        else if ("Cables in contact".equals(contact)&&triangleSetUp==null)
            return true;
        return ("Cables not in contact".equals(contact)&&horizontalSetUp==null);
    }
}



