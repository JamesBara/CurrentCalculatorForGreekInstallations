package Elot.HD384.K1_K2_K3_52;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyFrame extends JFrame {

    private String conductor;
    private String insulation;
    private int chargedConductorsNum;
    private double crossSection;
    private boolean isMulticore;
    private boolean hasPipe;
    private boolean inContact;
    private boolean isTriangleSetUp;
    private boolean isHorizontalSetUp;
    private ArrayList<Cable> cableTypes;

    private JPanel panel;

    private JPanel bigPanel;
    private JComboBox CableSelector;
    private JComboBox ConductorMaterialSelector;
    private JComboBox InsulationSelector;
    private JComboBox ChargedConductorSelector;
    private JLabel ChargedConductorLabel;
    private JLabel InsulationLabel;
    private JLabel ConductorMaterialLabel;
    private JLabel CableTypeLabel;
    private JLabel CrossSectionLabel;
    private JComboBox CrossSectionSelector;
    private JLabel MultiCoreLabel;
    private JComboBox MultiCoreSelector;
    private JLabel PipeLabel;
    private JComboBox PipeSelector;
    private JLabel ContactLabel;
    private JComboBox ContactSelector;
    private JLabel TriangleSetUpLabel;
    private JComboBox TriangleSetUpSelector;
    private JLabel isHorizontalSetUpLabel;
    private JComboBox isHorizontalSetUpSelector;


    public MyFrame() {

        panel = new JPanel();
        this.setContentPane(panel);

        //Create JLabel for CableSelector
        CableTypeLabel = new JLabel("Είδη ηλεκτρικών γραμμών.",JLabel.CENTER);
        CableTypeLabel.setVerticalAlignment(JLabel.TOP);
        CableTypeLabel.setLabelFor(CableSelector);
        panel.add(CableTypeLabel);
        //Create ComboBox for CableSelector
        String[] CableSelectorItems = {"Εντοιχισμένο","Επιτοίχιο","Στον αέρα","Στο έδαφος"};
        CableSelector = new JComboBox(CableSelectorItems);
        CableSelectorListener csl = new CableSelectorListener();
        CableSelector.addActionListener(csl);
        CableSelector.setSelectedIndex(-1);
        CableSelector.setEditable(false);
        panel.add(CableSelector);
        //Create JLabel for ConductorMaterial
        ConductorMaterialLabel = new JLabel("Υλικό αγωγού.",JLabel.CENTER);
        ConductorMaterialLabel.setVerticalAlignment(JLabel.TOP);
        ConductorMaterialLabel.setLabelFor(ConductorMaterialSelector);
        panel.add(ConductorMaterialLabel);
        //Create ComboBox for ConductorMaterialSelector
        String[] conductorMaterialItems = {"Χαλκός","Αλουμίνιο"};
        ConductorMaterialSelector = new JComboBox(conductorMaterialItems);
        ConductorMaterialListener cml = new ConductorMaterialListener();
        ConductorMaterialSelector.addActionListener(cml);
        ConductorMaterialSelector.setSelectedIndex(-1);
        ConductorMaterialSelector.setEditable(false);
        panel.add(ConductorMaterialSelector);
        //Create JLabel for InsulationSelector ComboBox
        InsulationLabel = new JLabel("Υλικό Μόνωσης.",JLabel.CENTER);
        InsulationLabel.setVerticalAlignment(JLabel.TOP);
        InsulationLabel.setLabelFor(InsulationSelector);
        panel.add(InsulationLabel);
        //Create ComboBox for InsulationSelector
        String[] insulationItems = {"PVC","EPR ή XLPE"};
        InsulationSelector = new JComboBox(insulationItems);
        InsulationListener insl = new InsulationListener();
        InsulationSelector.addActionListener(insl);
        InsulationSelector.setSelectedIndex(-1);
        InsulationSelector.setEditable(false);
        panel.add(InsulationSelector);
        //Create JLabel for ChargedConductorSelector ComboBox
        ChargedConductorLabel = new JLabel("Πλήθος φορτιζόμενων αγωγών.",JLabel.CENTER);
        ChargedConductorLabel.setVerticalAlignment(JLabel.TOP);
        ChargedConductorLabel.setLabelFor(ChargedConductorSelector);
        panel.add(ChargedConductorLabel);
        //Create ComboBox for ChargedConductorSelector
        String[] chargedConductorItems = {"2","3"};
        ChargedConductorSelector = new JComboBox(chargedConductorItems);
        ChargedConductorListener ccl = new ChargedConductorListener();
        ChargedConductorSelector.addActionListener(ccl);
        ChargedConductorSelector.setSelectedIndex(-1);
        ChargedConductorSelector.setEditable(false);
        panel.add(ChargedConductorSelector);
        //Create JLabel for MultiCoreSelector
        MultiCoreLabel = new JLabel("Είδος καλωδίου.",JLabel.CENTER);
        MultiCoreLabel.setVerticalAlignment(JLabel.TOP);
        MultiCoreLabel.setLabelFor(MultiCoreSelector);
        MultiCoreLabel.setVisible(false);
        panel.add(MultiCoreLabel);
        //Create ComboBox for MultiCoreSelector
        MultiCoreSelector = new JComboBox();
        MultiCoreListener mcl = new MultiCoreListener();
        MultiCoreSelector.addActionListener(mcl);
        MultiCoreSelector.setSelectedIndex(-1);
        MultiCoreSelector.setEditable(false);
        MultiCoreSelector.setVisible(false);
        MultiCoreSelector.setEnabled(false);
        panel.add(MultiCoreSelector);
        //Create JLabel for PipeSelector
        PipeLabel = new JLabel("Υπαρξη σωλήνα.",JLabel.CENTER);
        PipeLabel.setVerticalAlignment(JLabel.TOP);
        PipeLabel.setLabelFor(PipeSelector);
        PipeLabel.setVisible(false);
        panel.add(PipeLabel);
        //Create ComboBox for PipeSelector
        String[] PipeItems = {"Γυμνό","Σε σωλήνα"};
        PipeSelector = new JComboBox(PipeItems);
        PipeListener pipel = new PipeListener();
        PipeSelector.addActionListener(pipel);
        PipeSelector.setSelectedIndex(-1);
        PipeSelector.setEditable(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        panel.add(PipeSelector);
        //Create JLabel for ContactSelector
        ContactLabel = new JLabel("Γειτνίαση.",JLabel.CENTER);
        ContactLabel.setVerticalAlignment(JLabel.TOP);
        ContactLabel.setLabelFor(ContactSelector);
        ContactLabel.setVisible(false);
        panel.add(ContactLabel);
        //Create ComboBox for ContactSelector
        String[] ContactItems = {"Σε επαφή μεταξύ τους","Σε απόσταση μεταξύ τους"};
        ContactSelector = new JComboBox(ContactItems);
        ContactListener cncl = new ContactListener();
        ContactSelector.addActionListener(cncl);
        ContactSelector.setSelectedIndex(-1);
        ContactSelector.setEditable(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        panel.add(ContactSelector);















        /*//Create JLabel for CrossSection Selector ComboBox
        CrossSectionLabel = new JLabel("Πλήθος φορτιζόμενων αγωγών.",JLabel.CENTER);
        CrossSectionLabel.setVerticalAlignment(JLabel.TOP);
        CrossSectionLabel.setLabelFor(CrossSectionSelector);
        panel.add(CrossSectionLabel);
        //Create ComboBox for ChargedConductor Selector
        CrossSectionSelector = new JComboBox();
        ChargedConductorListener ccl = new ChargedConductorListener();
        CrossSectionSelector.addActionListener(ccl);
        CrossSectionSelector.setSelectedIndex(-1);
        CrossSectionSelector.setEditable(false);
        panel.add(CrossSectionSelector);
*/



        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setTitle("Μέγιστα επιτρεπόμενα ρεύματα (σε A).");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }





    //Listener for Cable selector ComboBox
    class CableSelectorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i=CableSelector.getSelectedIndex();
            switch (i){
                //case 0 is "Εντοιχισμένο"
               case 0:
                   MultiCoreLabel.setVisible(true);
                   MultiCoreSelector.setVisible(true);
                   MultiCoreSelector.setEnabled(true);
                   MultiCoreSelector.removeAllItems();
                   MultiCoreSelector.addItem("Μονωμένοι αγωγοί σε σωλήνα");
                   MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                   MultiCoreSelector.setSelectedIndex(-1);

                   break;
                //case 1 is "Επιτοίχιο"
                case 1:
                    MultiCoreLabel.setVisible(true);
                    MultiCoreSelector.setVisible(true);
                    MultiCoreSelector.setEnabled(true);
                    MultiCoreSelector.removeAllItems();
                    MultiCoreSelector.addItem("Μονωμένοι αγωγοί σε σωλήνα");
                    MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                    MultiCoreSelector.setSelectedIndex(-1);

                    break;
                //case 2 is "Στον αέρα"
                case 2:
                    MultiCoreLabel.setVisible(true);
                    MultiCoreSelector.setVisible(true);
                    MultiCoreSelector.setEnabled(true);
                    MultiCoreSelector.removeAllItems();
                    MultiCoreSelector.addItem("Μονοπολικά καλώδια");
                    MultiCoreSelector.addItem("Πολυπολικά καλώδια");
                    MultiCoreSelector.setSelectedIndex(-1);
                    break;
                //case 3 is "Στο έδαφος"
                case 3:
                    MultiCoreLabel.setVisible(false);
                    MultiCoreSelector.setVisible(false);
                    MultiCoreSelector.setEnabled(false);

                    break;
            }
        }
    }

    //Listener for Insulation selector ComboBox
    class InsulationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i=InsulationSelector.getSelectedIndex();
            switch (i){
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
            int i=ConductorMaterialSelector.getSelectedIndex();
            switch (i){
                //case 0 is "Χαλκός"
                case 0:
                    //Need to make more comboboxes visible.
                    conductor = "Copper";
                    break;
                //case 1 is "Αλουμίνιο"
                case 1:
                    //Need to make more comboboxes visible.
                    conductor = "Aluminum";
                    break;

            }
        }
    }
    //Listener for ChargedConductorSelector ComboBox
    class ChargedConductorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i=ChargedConductorSelector.getSelectedIndex();
            switch (i){
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
            int i=MultiCoreSelector.getSelectedIndex();
            switch (i){
                //case 0 is "Μονοπολικά καλώδια" or "Μονωμένοι αγωγοί σε σωλήνα"
                case 0:
                    if (!"Μονοπολικά καλώδια".equals(MultiCoreSelector.getItemAt(0))){
                        isMulticore = true;
                        PipeLabel.setVisible(false);
                        PipeSelector.setVisible(false);
                        PipeSelector.setEnabled(false);
                        ContactLabel.setVisible(false);
                        ContactSelector.setVisible(false);
                        ContactSelector.setEnabled(false);

                    }
                    else {
                        isMulticore = false;
                        hasPipe = true;
                        PipeLabel.setVisible(false);
                        PipeSelector.setVisible(false);
                        PipeSelector.setEnabled(false);
                        ContactLabel.setVisible(true);
                        ContactSelector.setVisible(true);
                        ContactSelector.setEnabled(true);
                    }
                    break;
                //case 1 is "Πολυπολικά καλώδια"
                case 1:
                    if(CableSelector.getSelectedIndex()!=2) {
                        isMulticore = true;
                        PipeLabel.setVisible(true);
                        PipeSelector.setVisible(true);
                        PipeSelector.setEnabled(true);
                        ContactLabel.setVisible(false);
                        ContactSelector.setVisible(false);
                        ContactSelector.setEnabled(false);
                    }
                    else{
                        PipeLabel.setVisible(false);
                        PipeSelector.setVisible(false);
                        PipeSelector.setEnabled(false);
                        ContactLabel.setVisible(false);
                        ContactSelector.setVisible(false);
                        ContactSelector.setEnabled(false);
                    }
                    break;
            }
        }
    }

    //Listener for PipeSelector ComboBox
    class PipeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i=PipeSelector.getSelectedIndex();
            switch (i){
                //case 0 is "Γυμνό"
                case 0:
                    hasPipe = false;
                    break;
                //case 1 is "Σε σωλήνα"
                case 1:
                    hasPipe = true;
                    break;
            }
        }
    }

    //Listener for PipeSelector ComboBox
    class ContactListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i=ContactSelector.getSelectedIndex();
            switch (i){
                //case 0 is "Σε επαφή μεταξύ τους"
                case 0:

                    inContact = true;
                    break;
                //case 1 is "Σε απόσταση μεταξύ τους"
                case 1:
                    inContact = false;
                    break;
            }
        }
    }


}




