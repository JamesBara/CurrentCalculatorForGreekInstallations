package Elot.HD384.K1_K2_K3_52;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

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

    private JPanel framePanel;
    private JPanel topPanel;
    private JPanel hiddenComponentsPanel;
    private JPanel bottomPanel;





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

        //Creating the layout managers

        FlowLayout fl = new FlowLayout();
        GridLayout grl = new GridLayout(3,1);



        /*

         I have created  4 different panels, the topPanel includes the components that should appear on the top side
         of the window in the order defined by FlowLayout manager (from left to right).

         The hiddenComponentPanel includes the components that are hidden and should appear in the middle of the window
         in the order defined by FlowLayout manager (from left to right).

         The bottomPanel includes  the components that should appear on the bottom side of the window in the order
         defined by FlowLayout manager (from left to right).

         The framePanel includes all of the above panels  in the order defined by GridLayout manager (from top to bottom).

         */

        //Creating the JPanels  that use FlowLayout.
        topPanel = new JPanel();
        topPanel.setLayout(fl);
        //Create a separator line using the bottom boarder of the layout.
        topPanel.setBorder( new MatteBorder(0, 0, 1, 0, Color.BLACK) );
        hiddenComponentsPanel = new JPanel();
        hiddenComponentsPanel.setLayout(fl);
        //Create a separator line using the bottom boarder of the layout.
        hiddenComponentsPanel.setBorder( new MatteBorder(0, 0, 1, 0, Color.BLACK) );
        bottomPanel = new JPanel();
        bottomPanel.setLayout(fl);

        //Create the JPanel that uses GridLayout and includes the other panels.
        framePanel = new JPanel();
        framePanel.setLayout(grl);
        framePanel.add(topPanel);
        framePanel.add(hiddenComponentsPanel);
        framePanel.add(bottomPanel);

        // In this part I have created all the Jlabels and their respective Comboboxes, as well as Button.

        //This label informs the user that he has to choose a cable in the combobox.
        CableTypeLabel = new JLabel("Είδη ηλεκτρικών γραμμών:");
        //The label is added to the top panel.
        topPanel.add(CableTypeLabel);

        //This combobox includes 4 cables (classes).
        String[] CableSelectorItems = {"Εντοιχισμένο", "Επιτοίχιο", "Στον αέρα", "Στο έδαφος"};
        CableSelector = new JComboBox<>(CableSelectorItems);
        //There is also a listener that performs actions depending on the user's choice.
        CableSelectorListener ctl = new CableSelectorListener();
        CableSelector.addActionListener(ctl);
        //The combobox shouldn't be editable and should start from a blank selection.
        CableSelector.setSelectedIndex(-1);
        CableSelector.setEditable(false);
        //The combobox is added to the top panel.
        topPanel.add(CableSelector);


        //This label informs the user that he has to choose a conductor material in the combobox.
        ConductorMaterialLabel = new JLabel("Υλικό αγωγού:");
        //The label is added to the top panel.
        topPanel.add(ConductorMaterialLabel);

        //This combobox includes 2 conductor materials.
        String[] conductorMaterialItems = {"Χαλκός", "Αλουμίνιο"};
        ConductorMaterialSelector = new JComboBox<>(conductorMaterialItems);
        //There is also a listener that performs actions depending on the user's choice.
        ConductorMaterialListener cml = new ConductorMaterialListener();
        ConductorMaterialSelector.addActionListener(cml);
        //The combobox shouldn't be editable and should start from a blank selection.
        ConductorMaterialSelector.setSelectedIndex(-1);
        ConductorMaterialSelector.setEditable(false);
        //The combobox is added to the top panel.
        topPanel.add(ConductorMaterialSelector);


        //This label informs the user that he has to choose an insulation material in the combobox.
        JLabel insulationLabel = new JLabel("Υλικό Μόνωσης:");
        //The label is added to the top panel.
        topPanel.add(insulationLabel);

        //This combobox includes 2 insulation materials.
        String[] insulationItems = {"PVC", "EPR ή XLPE"};
        InsulationSelector = new JComboBox<>(insulationItems);
        //There is also a listener that performs actions depending on the user's choice.
        InsulationListener insl = new InsulationListener();
        InsulationSelector.addActionListener(insl);
        //The combobox shouldn't be editable and should start from a blank selection.
        InsulationSelector.setSelectedIndex(-1);
        InsulationSelector.setEditable(false);
        //The combobox is added to the top panel.
        topPanel.add(InsulationSelector);


        //This label informs the user that he has to choose the number of charged conductors in the combobox.
        JLabel chargedConductorLabel = new JLabel("Πλήθος φορτιζόμενων αγωγών:");
        //The label is added to the top panel.
        topPanel.add(chargedConductorLabel);

        //This combobox includes either 2 or 3 charged conductors.
        String[] chargedConductorItems = {"2", "3"};
        ChargedConductorSelector = new JComboBox<>(chargedConductorItems);
        //There is also a listener that performs actions depending on the user's choice.
        ChargedConductorListener ccl = new ChargedConductorListener();
        ChargedConductorSelector.addActionListener(ccl);
        //The combobox shouldn't be editable and should start from a blank selection.
        ChargedConductorSelector.setSelectedIndex(-1);
        ChargedConductorSelector.setEditable(false);
        //The combobox is added to the top panel.
        topPanel.add(ChargedConductorSelector);

        //This label informs the user that he has to choose the number of cores in the combobox.
        MultiCoreLabel = new JLabel("Είδος καλωδίου:");
        //This label should be invisible as a default.
        MultiCoreLabel.setVisible(false);
        //The label is added to the middle panel.
        hiddenComponentsPanel.add(MultiCoreLabel);

        //The type 1 combobox refers to cables from either the build-in class, or the wall mounted class.
        //It includes either multi core cables or no specified number of cores cables.
        String[] MultiCoreItemsType1 = {"Μονωμένοι αγωγοί σε σωλήνα", "Πολυπολικά καλώδια"};
        MultiCoreSelectorType1 = new JComboBox<>(MultiCoreItemsType1);
        //There is also a listener that performs actions depending on the user's choice.
        MultiCoreType1Listener mcl1 = new MultiCoreType1Listener();
        MultiCoreSelectorType1.addActionListener(mcl1);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        MultiCoreSelectorType1.setSelectedIndex(-1);
        MultiCoreSelectorType1.setEditable(false);
        MultiCoreSelectorType1.setVisible(false);
        MultiCoreSelectorType1.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(MultiCoreSelectorType1);

        //The type 2 combobox refers to cables from aerial cable class.
        //It includes either single core or multi core cables.
        String[] MultiCoreItemsType2 = {"Μονοπολικά καλώδια", "Πολυπολικά καλώδια"};
        MultiCoreSelectorType2 = new JComboBox<>(MultiCoreItemsType2);
        //There is also a listener that performs actions depending on the user's choice.
        MultiCoreType2Listener mcl2 = new MultiCoreType2Listener();
        MultiCoreSelectorType2.addActionListener(mcl2);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        MultiCoreSelectorType2.setSelectedIndex(-1);
        MultiCoreSelectorType2.setEditable(false);
        MultiCoreSelectorType2.setVisible(false);
        MultiCoreSelectorType2.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(MultiCoreSelectorType2);


        //This label informs the user that he has to set the existance of a pipe combobox.
        PipeLabel = new JLabel("Υπαρξη σωλήνα:");
        //This label should be invisible as a default.
        PipeLabel.setVisible(false);
        //The label is added to the middle panel.
        hiddenComponentsPanel.add(PipeLabel);

        //This combobox includes whether a pipe exists or not.
        String[] PipeItems = {"Γυμνό", "Σε σωλήνα"};
        PipeSelector = new JComboBox<>(PipeItems);
        //There is also a listener that performs actions depending on the user's choice.
        PipeListener pipel = new PipeListener();
        PipeSelector.addActionListener(pipel);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        PipeSelector.setSelectedIndex(-1);
        PipeSelector.setEditable(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(PipeSelector);


        //This label informs the user that he has to set the whether the cables are in contact to one another.
        //It's invisible as default.
        ContactLabel = new JLabel("Γειτνίαση:");
        ContactLabel.setVisible(false);
        hiddenComponentsPanel.add(ContactLabel);

        //This combobox includes whether a pipe the cables are in contact or not to one another.
        String[] ContactItems = {"Σε επαφή μεταξύ τους", "Σε απόσταση μεταξύ τους"};
        ContactSelector = new JComboBox<>(ContactItems);
        //There is also a listener that performs actions depending on the user's choice.
        ContactListener cncl = new ContactListener();
        ContactSelector.addActionListener(cncl);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        ContactSelector.setSelectedIndex(-1);
        ContactSelector.setEditable(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(ContactSelector);


        //This label informs the user that he has to set the cable set-up.
        //It's invisible as default.
        TriangleSetUpLabel = new JLabel("Διάταξη:");
        TriangleSetUpLabel.setVisible(false);
        hiddenComponentsPanel.add(TriangleSetUpLabel);

        //This combobox includes whether the set=up of the cables is horizontal/vertical or triangular.
        String[] triangleSetUpItems = {"∆ιάταξη επίπεδη οριζόντια ή κατακόρυφη", "∆ιάταξη τριγωνική"};
        TriangleSetUpSelector = new JComboBox<>(triangleSetUpItems);
        //There is also a listener that performs actions depending on the user's choice.
        TriangleSetUpListener tsul = new TriangleSetUpListener();
        TriangleSetUpSelector.addActionListener(tsul);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        TriangleSetUpSelector.setSelectedIndex(-1);
        TriangleSetUpSelector.setEditable(false);
        TriangleSetUpSelector.setVisible(false);
        TriangleSetUpSelector.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(TriangleSetUpSelector);


        //This label informs the user that he has to set the cable set-up.
        //It's invisible as default.
        HorizontalSetUpLabel = new JLabel("Διάταξη:");
        HorizontalSetUpLabel.setVisible(false);
        hiddenComponentsPanel.add(HorizontalSetUpLabel);

        //This combobox includes whether the set=up of the cables is horizontal or vertical.
        String[] horizontalSetUpItems = {"∆ιάταξη επίπεδη οριζόντια", "∆ιάταξη επίπεδη κατακόρυφη"};
        HorizontalSetUpSelector = new JComboBox<>(horizontalSetUpItems);
        //There is also a listener that performs actions depending on the user's choice.
        HorizontalSetUpListener hsul = new HorizontalSetUpListener();
        HorizontalSetUpSelector.addActionListener(hsul);
        //The combobox shouldn't be editable, should start from a blank selection and should be invisible as a default.
        HorizontalSetUpSelector.setSelectedIndex(-1);
        HorizontalSetUpSelector.setEditable(false);
        HorizontalSetUpSelector.setVisible(false);
        HorizontalSetUpSelector.setEnabled(false);
        //The combobox is added to the middle panel.
        hiddenComponentsPanel.add(HorizontalSetUpSelector);

        //This label shows the user the final result of his choices.
        // It's initialized here because it is needed by the following listeners.
        ResultLabel = new JLabel();

        //This label informs the user that he has to set the cross-section size.
        //It's invisible as a default.
        CrossSectionLabel = new JLabel("Διατομή αγωγών σε mm"+"\u00b2"+":");
        CrossSectionLabel.setVisible(false);
        topPanel.add(CrossSectionLabel);

        //This combobox shows a list of choices that belong to the tables 52-K1 and 52-K3 for Copper conductor.
        //Basically it's for wall-mounted cables,build-in cables and on-ground cables.
        String[] crossSectionArrayType1Copper = new String[]{"1.5", "2.5", "4", "6", "10", "16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300"};
        CrossSectionType1CopperSelector = new JComboBox<>(crossSectionArrayType1Copper);
        //There is also a listener that performs actions depending on the user's choice.
        CrossSectionType1CopperListener cst1cl = new CrossSectionType1CopperListener();
        CrossSectionType1CopperSelector.addActionListener(cst1cl);
        //The combobox shouldn't be editable, a default selection must be available and should be invisible as a default.
        CrossSectionType1CopperSelector.setSelectedIndex(0);
        CrossSectionType1CopperSelector.setEditable(false);
        CrossSectionType1CopperSelector.setVisible(false);
        CrossSectionType1CopperSelector.setEnabled(false);
        //The combobox is added to the top panel.
        topPanel.add(CrossSectionType1CopperSelector);

        //This combobox shows a list of choices that belong to the tables 52-K1 and 52-K3 for Aluminum conductor.
        //Basically it's for wall-mounted cables,build-in cables and on-ground cables.
        String[] crossSectionArrayType1Aluminum = new String[]{"16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300"};
        CrossSectionType1AluminumSelector = new JComboBox<>(crossSectionArrayType1Aluminum);
        //There is also a listener that performs actions depending on the user's choice.
        CrossSectionType1AluminumListener cst1al = new CrossSectionType1AluminumListener();
        CrossSectionType1AluminumSelector.addActionListener(cst1al);
        //The combobox shouldn't be editable, a default selection must be available and should be invisible as a default.
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
        CrossSectionType1AluminumSelector.setEditable(false);
        CrossSectionType1AluminumSelector.setVisible(false);
        CrossSectionType1AluminumSelector.setEnabled(false);
        //The combobox is added to the top panel.
        topPanel.add(CrossSectionType1AluminumSelector);

        //This combobox shows a list of choices that belong to the table 52-K2 Copper conductor.
        //Basically it's for aerial cables.
        String[] crossSectionArrayType2Copper = new String[]{"1.5", "2.5", "4", "6", "10", "16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300", "400", "500", "630"};
        CrossSectionType2CopperSelector = new JComboBox<>(crossSectionArrayType2Copper);
        //There is also a listener that performs actions depending on the user's choice.
        CrossSectionType2CopperListener cst2cl = new CrossSectionType2CopperListener();
        CrossSectionType2CopperSelector.addActionListener(cst2cl);
        //The combobox shouldn't be editable, a default selection must be available and should be invisible as a default.
        CrossSectionType2CopperSelector.setSelectedIndex(0);
        CrossSectionType2CopperSelector.setEditable(false);
        CrossSectionType2CopperSelector.setVisible(false);
        CrossSectionType2CopperSelector.setEnabled(false);
        //The combobox is added to the top panel.
        topPanel.add(CrossSectionType2CopperSelector);

        //This combobox shows a list of choices that belong to the table 52-K2 Aluminum conductor.
        //Basically it's for aerial cables.
        String[] crossSectionArrayType2Aluminum = new String[]{"16", "25", "35", "50", "70", "95", "120", "150", "185", "240", "300", "400", "500", "630"};
        CrossSectionType2AluminumSelector = new JComboBox<>(crossSectionArrayType2Aluminum);
        //There is also a listener that performs actions depending on the user's choice.
        CrossSectionType2AluminumListener cst2al = new CrossSectionType2AluminumListener();
        CrossSectionType2AluminumSelector.addActionListener(cst2al);
        //The combobox shouldn't be editable, a default selection must be available and should be invisible as a default.
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
        CrossSectionType2AluminumSelector.setEditable(false);
        CrossSectionType2AluminumSelector.setVisible(false);
        CrossSectionType2AluminumSelector.setEnabled(false);
        //The combobox is added to the top panel.
        topPanel.add(CrossSectionType2AluminumSelector);


        //This button creates the object needed to show the final result.
        CurrentCalculatorButton = new JButton("Υπολογισμός");
        CurrentCalculatorButtonListener ccbl = new CurrentCalculatorButtonListener();
        CurrentCalculatorButton.addActionListener(ccbl);
        //It's added int the bottom panel.
        bottomPanel.add(CurrentCalculatorButton);

        //This label inform the user that the result will be shown in the next label.
        LabelofResultLabel = new JLabel("Μέγιστο ρεύμα:");
        bottomPanel.add(LabelofResultLabel);

        //This label was initialized earlier and shows the user tha final result.
        //It's invisible by default.
        bottomPanel.add(ResultLabel);
        ResultLabel.setVisible(false);

        this.setContentPane(framePanel);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setTitle("Μέγιστα επιτρεπόμενα ρεύματα (σε A).");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //This listener sets "cableIndex" depending on the user's choice
    //Every time the user makes a new choice all comboboxes and labels are reset in their default condition.
    //Depending on the user's choice a different MultiCoreSelectorType combobox appears.
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

    //This listener sets the String "insulation" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    class InsulationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = InsulationSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "PVC"
                case 0:
                    ResultLabel.setVisible(false);
                    insulation = "PVC";
                    break;
                //case 1 is "EPR or XLPE"
                case 1:
                    ResultLabel.setVisible(false);
                    insulation = "EPR or XLPE";
                    break;

            }
        }
    }

    //This listener sets the String "conductor" depending on the user's choice and the cableIndex.
    //It also resets all CrossSection comboboxes to their default condition.
    //Then depending on the user's choice and cableIndex it chooses the appropriate CrossSection combobox.
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

    //This listener sets the "chargedConductorsNum" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    class ChargedConductorListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = ChargedConductorSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "2"
                case 0:
                    ResultLabel.setVisible(false);
                    chargedConductorsNum = 2;
                    break;
                //case 1 is "3"
                case 1:
                    ResultLabel.setVisible(false);
                    chargedConductorsNum = 3;
                    break;
            }
        }
    }

    //This listener sets the String "multicore" depending on the user's choice.
    //It also resets PipeSelector,ContactSelector,TriangleSetUpSelector and HorizontalSetUpSelector
    //comboboxes to their default condition.
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
                        //If this choice is made by the user the PipeSelector combobox is set for usage.
                        setPipe();
                        resetContact();
                        resetHorizontalSetUp();
                        resetTriangleSetUp();
                    break;
            }
        }
    }

    //This listener sets the String "multicore" depending on the user's choice.
    //It also resets PipeSelector,ContactSelector,TriangleSetUpSelector and HorizontalSetUpSelector
    //comboboxes to their default condition.
    class MultiCoreType2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = MultiCoreSelectorType2.getSelectedIndex();
            switch (i) {
                //case 0 "Μονοπολικά καλώδια"
                case 0:
                    multicore = "Single Core";
                    resetContact();
                    resetPipe();
                    //If this choice is made by the user the ContactSelector combobox is set for usage.
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

    //This listener sets the String "pipe" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    class PipeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = PipeSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Γυμνό"
                case 0:
                    ResultLabel.setVisible(false);
                    pipe = "Naked cable";
                    break;
                //case 1 is "Σε σωλήνα"
                case 1:
                    ResultLabel.setVisible(false);
                    pipe = "Cable in pipe";
                    break;
            }
        }
    }

    //This listener sets the String "contact" depending on the user's choice.
    //It also resets TriangleSetUpSelector and HorizontalSetUpSelector
    //comboboxes to their default condition.
    class ContactListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = ContactSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "Σε επαφή μεταξύ τους"
                case 0:
                    contact = "Cables in contact";
                    resetTriangleSetUp();
                    //If this choice is made by the user the TriangleSetUpSelector combobox is set for usage.
                    setTriangleSetUp();
                    resetHorizontalSetUp();
                    break;
                //case 1 is "Σε απόσταση μεταξύ τους"
                case 1:
                    contact = "Cables not in contact";
                    resetTriangleSetUp();
                    resetHorizontalSetUp();
                    //If this choice is made by the user the HorizontalSetUpSelector combobox is set for usage.
                    setHorizontalSetUp();
                    break;
            }
        }
    }

    //This listener sets the String "triangleSetUp" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    class TriangleSetUpListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = TriangleSetUpSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "∆ιάταξη τριγωνική"
                case 0:
                    ResultLabel.setVisible(false);
                    triangleSetUp = "Cables in triangle setup";
                    break;
                //case 1 is "∆ιάταξη επίπεδη οριζόντια ή κατακόρυφη"
                case 1:
                    ResultLabel.setVisible(false);
                    triangleSetUp = "Cables in horizontal or vertical setup";
                    break;
            }
        }
    }

    //This listener sets the String "horizontalSetUp" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    class HorizontalSetUpListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = HorizontalSetUpSelector.getSelectedIndex();
            switch (i) {
                //case 0 is "∆ιάταξη επίπεδη οριζόντια"
                case 0:
                    ResultLabel.setVisible(false);
                    horizontalSetUp = "Cables in horizontal setup";
                    break;
                //case 1 is "∆ιάταξη επίπεδη  κατακόρυφη"
                case 1:
                    ResultLabel.setVisible(false);
                    horizontalSetUp = "Cables in vertical setup";
                    break;
            }
        }
    }


    //This listener sets the String "crossSectionIndex" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    //CrossSectionType1Copper refers to wall-mounted,build-in and on ground cables
    //with a Copper conductor material.
    class CrossSectionType1CopperListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType1CopperSelector.getSelectedIndex();
            ResultLabel.setVisible(false);
        }
    }

    //This listener sets the String "crossSectionIndex" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    //CrossSectionType1Aluminum refers to wall-mounted,build-in and on ground cables
    //with a Aluminum conductor material.
    class CrossSectionType1AluminumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            crossSectionIndex= CrossSectionType1AluminumSelector.getSelectedIndex();
            ResultLabel.setVisible(false);
        }
    }

    //This listener sets the String "crossSectionIndex" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    //CrossSectionType2Copper refers to aerial cables with a Copper conductor material.
    class CrossSectionType2CopperListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType2CopperSelector.getSelectedIndex();
            ResultLabel.setVisible(false);
        }
    }

    //This listener sets the String "crossSectionIndex" depending on the user's choice.
    //It also turns the final result label invisible if the user makes a new choice.
    //CrossSectionType2Aluminum refers to aerial cables with a Aluminum conductor material.
    class CrossSectionType2AluminumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            crossSectionIndex = CrossSectionType2AluminumSelector.getSelectedIndex();
            ResultLabel.setVisible(false);
        }
    }

    //This listener creates a new "Cable" object depending on the user's choices and the cableIndex.
    //In each case an error check is run in order to make sure that all the required parameters are valid.
    //If everything is in order the label "ResultLabel" will be set to visible and show the user the result.
    class CurrentCalculatorButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            switch (cableIndex){
                case 0:
                if (buildInOrWallMountedCablesErrorCheck())
                    JOptionPane.showMessageDialog(framePanel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else{
                    binc = new BuildInCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    binc.setMulticore(multicore);
                    binc.setPipe(pipe);
                    ResultLabel.setText(binc.getMaxCurrent());
                    ResultLabel.setVisible(true);
                }
                    break;
                case 1:
                if (buildInOrWallMountedCablesErrorCheck())
                    JOptionPane.showMessageDialog(framePanel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else {
                    wmc = new WallMountedCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    wmc.setMulticore(multicore);
                    wmc.setPipe(pipe);
                    ResultLabel.setText(wmc.getMaxCurrent());
                    ResultLabel.setVisible(true);
                }
                    break;
                case 2:
                if (aerialCableErrorCheck())
                    JOptionPane.showMessageDialog(framePanel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else {
                    ac = new AerialCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    ac.setMulticore(multicore);
                        ac.setContact(contact);
                        ac.setTriangleSetUp(triangleSetUp);
                        ac.setHorizontalSetUp(horizontalSetUp);
                        ResultLabel.setText(ac.getMaxCurrent());
                        ResultLabel.setVisible(true);
                }
                    break;
                case 3:
                if (onGroundCableErrorCheck())
                    JOptionPane.showMessageDialog(framePanel, "Συμπληρώστε όλα τα πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                else {
                    ogc = new OnGroundCable(conductor, insulation, chargedConductorsNum, crossSectionIndex);
                    ResultLabel.setText(ogc.getMaxCurrent());
                    ResultLabel.setVisible(true);
                }
                    break;
            }

        }
    }

    //This method is used to make MultiCoreLabel,ResultLabel labels and MultiCoreSelectorType1 comboboxes invisible to
    //the user.Also it forces the selected index of the MultiCoreSelectorType1 combobox to -1 and sets
    //chargedConductorsNum to 0 essentially resetting them to a default condition.
    private void resetMultiCoreType1() {
        MultiCoreLabel.setVisible(false);
        MultiCoreSelectorType1.setVisible(false);
        MultiCoreSelectorType1.setEnabled(false);
        ResultLabel.setVisible(false);
        MultiCoreSelectorType1.setSelectedIndex(-1);
        chargedConductorsNum = 0;
    }

    private void setMultiCoreType1() {
        MultiCoreLabel.setVisible(true);
        MultiCoreSelectorType1.setVisible(true);
        MultiCoreSelectorType1.setEnabled(true);
        MultiCoreSelectorType1.setSelectedIndex(-1);
    }
    //This method is used to make MultiCoreLabel,ResultLabel labels and MultiCoreSelectorType2 comboboxes invisible to
    //the user. Also it forces the selected index of the MultiCoreSelectorType2 combobox to -1 and sets
    //chargedConductorsNum to 0 essentially resetting them to a default condition.
    private void resetMultiCoreType2() {
        MultiCoreLabel.setVisible(false);
        MultiCoreSelectorType2.setVisible(false);
        MultiCoreSelectorType2.setEnabled(false);
        ResultLabel.setVisible(false);
        MultiCoreSelectorType2.setSelectedIndex(-1);
        chargedConductorsNum = 0;
    }

    private void setMultiCoreType2() {
        MultiCoreLabel.setVisible(true);
        MultiCoreSelectorType2.setVisible(true);
        MultiCoreSelectorType2.setEnabled(true);
        MultiCoreSelectorType2.setSelectedIndex(-1);
    }

    //This method is used to make PipeLabel,ResultLabel labels and PipeSelector comboboxes invisible to the user.
    //Also it forces the selected index of the PipeSelector combobox to -1 and String "pipe" to null essentially
    //resetting them to a default condition.
    private void resetPipe() {
        PipeLabel.setVisible(false);
        PipeSelector.setVisible(false);
        PipeSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        PipeSelector.setSelectedIndex(-1);
        pipe = null;
    }

    private void setPipe() {
        PipeLabel.setVisible(true);
        PipeSelector.setVisible(true);
        PipeSelector.setEnabled(true);
        PipeSelector.setSelectedIndex(-1);
    }

    //This method is used to make ContactLabel,ResultLabel labels and ContactSelector comboboxes invisible to the user.
    //Also it forces the selected index of the ContactSelector combobox to -1 and String "pipe" to null essentially
    //resetting them to a default condition.
    private void resetContact() {
        ContactLabel.setVisible(false);
        ContactSelector.setVisible(false);
        ContactSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        ContactSelector.setSelectedIndex(-1);
        contact = null;
    }

    private void setContact() {
        ContactLabel.setVisible(true);
        ContactSelector.setVisible(true);
        ContactSelector.setEnabled(true);
        ContactSelector.setSelectedIndex(-1);
    }

    //This method is used to make TriangleSetUpLabel,ResultLabel labels and TriangleSetUpSelector comboboxes invisible
    //to the user. Also it forces the selected index of the TriangleSetUpSelector combobox to -1 and String
    //"triangleSetUp" to null essentially resetting them to a default condition.
    private void resetTriangleSetUp() {
        TriangleSetUpLabel.setVisible(false);
        TriangleSetUpSelector.setVisible(false);
        TriangleSetUpSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        TriangleSetUpSelector.setSelectedIndex(-1);
        triangleSetUp=null;
    }

    private void setTriangleSetUp() {
        TriangleSetUpLabel.setVisible(true);
        TriangleSetUpSelector.setVisible(true);
        TriangleSetUpSelector.setEnabled(true);
        TriangleSetUpSelector.setSelectedIndex(-1);

    }

    //This method is used to make HorizontalSetUpLabel,ResultLabel labels and HorizontalSetUpSelector comboboxes invisible
    //to the user. Also it forces the selected index of the HorizontalSetUpSelector combobox to -1 and String
    //"horizontalSetUp" to null essentially resetting them to a default condition.
    private void resetHorizontalSetUp() {
        HorizontalSetUpLabel.setVisible(false);
        HorizontalSetUpSelector.setVisible(false);
        HorizontalSetUpSelector.setEnabled(false);
        ResultLabel.setVisible(false);
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
        ResultLabel.setVisible(false);
        CrossSectionType1CopperSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType1Copper() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType1CopperSelector.setVisible(true);
        CrossSectionType1CopperSelector.setEnabled(true);
        CrossSectionType1CopperSelector.setSelectedIndex(0);
        pack();
    }

    private void resetCrossSectionType1Aluminum() {
        CrossSectionLabel.setVisible(false);
        CrossSectionType1AluminumSelector.setVisible(false);
        CrossSectionType1AluminumSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType1Aluminum() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType1AluminumSelector.setVisible(true);
        CrossSectionType1AluminumSelector.setEnabled(true);
        CrossSectionType1AluminumSelector.setSelectedIndex(0);
        pack();
    }

    private void resetCrossSectionType2Copper() {
        HorizontalSetUpLabel.setVisible(false);
        CrossSectionType2CopperSelector.setVisible(false);
        CrossSectionType2CopperSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        CrossSectionType2CopperSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType2Copper() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType2CopperSelector.setVisible(true);
        CrossSectionType2CopperSelector.setEnabled(true);
        CrossSectionType2CopperSelector.setSelectedIndex(0);
        pack();
    }

    private void resetCrossSectionType2Aluminum() {
        CrossSectionLabel.setVisible(false);
        CrossSectionType2AluminumSelector.setVisible(false);
        CrossSectionType2AluminumSelector.setEnabled(false);
        ResultLabel.setVisible(false);
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
        crossSectionIndex = 0;
    }

    private void setCrossSectionType2Aluminum() {
        CrossSectionLabel.setVisible(true);
        CrossSectionType2AluminumSelector.setVisible(true);
        CrossSectionType2AluminumSelector.setEnabled(true);
        CrossSectionType2AluminumSelector.setSelectedIndex(0);
        pack();
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


    //The following methods check whether any of the parameters needed are valid.
    //If any of the parameters are null(In case of String) or 0 (in case of int)
    //return that the value true [This means that there is an error(error=true)].

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



