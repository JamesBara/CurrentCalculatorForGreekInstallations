package Elot.HD384.K1_K2_K3_52;

public class AerialCable extends Cable {

    private boolean isMulticore;
    private boolean inContact;
    private boolean isHorizontalOrVerticalSetUp;
    private boolean isHorizontalSetUp;
    private int MaxCurrent;


    private static double[] copperCrossSection={1.5,2.5,4,6,10,16,25,35,50,70,95,120,150,185,240,300,400,500,630};
    private static double[] aluminumCrossSection={16,25,35,50,70,95,120,150,185,240,300,400,500,630};

    public AerialCable(String conductor,String insulation,int chargedConductorsNum,boolean isMulticore){
        super(conductor,insulation,chargedConductorsNum);
        this.isMulticore=isMulticore;
    }

    @Override
    public double[] CrossSection(){
        if (getConductor().equals("Copper"))
            return copperCrossSection;
        else
            return aluminumCrossSection;
    }

    public void MaxCurrent() {
        //if the Conductors are multicore we just need to check the insulation type and the amount of charged conductors
        if (isMulticore) {
            if (getInsulation().equals("PVC")) {
                if (getChargedConductorsNum() == 2)
                    MaxCurrent = 1;
                else
                    MaxCurrent = 2;
            } else {
                if (getChargedConductorsNum() == 2)
                    MaxCurrent = 1;
                else
                    MaxCurrent = 2;
            }
        }
        //If the cables are single core we need to check if they are in contact with each other and their respective setup.
        else {
            if (inContact) {
                if (isHorizontalOrVerticalSetUp) {
                    if (getInsulation().equals("PVC")) {
                        if (getChargedConductorsNum() == 2)
                            MaxCurrent = 1;
                        else
                            MaxCurrent = 2;
                    } else {
                        if (getChargedConductorsNum() == 2)
                            MaxCurrent = 1;
                        else
                            MaxCurrent = 2;
                    }
                }
                else{
                    if (getInsulation().equals("PVC")) {
                    if (getChargedConductorsNum() == 2)
                        //Cannot have 2 conductors need fixing
                        MaxCurrent = 0;
                    else
                        MaxCurrent = 2;
                } else {
                    if (getChargedConductorsNum() == 2)
                        //Cannot have 2 conductors need fixing
                        MaxCurrent = 0;
                    else
                        MaxCurrent = 2;
                }
                }
            }

            else{
                if (isHorizontalSetUp) {
                    if (getInsulation().equals("PVC")) {
                        if (getChargedConductorsNum() == 2)
                            //Cannot have 2 conductors need fixing
                            MaxCurrent = 0;
                        else
                            MaxCurrent = 2;
                    } else {
                        if (getChargedConductorsNum() == 2)
                            //Cannot have 2 conductors need fixing
                            MaxCurrent = 0;
                        else
                            MaxCurrent = 2;
                    }
                }
                else {
                    if (getInsulation().equals("PVC")) {
                        if (getChargedConductorsNum() == 2)
                            //Cannot have 2 conductors need fixing
                            MaxCurrent = 0;
                        else
                            MaxCurrent = 2;
                    } else {
                        if (getChargedConductorsNum() == 2)
                            //Cannot have 2 conductors need fixing
                            MaxCurrent = 0;
                        else
                            MaxCurrent = 2;
                    }
                }
            }
        }
    }
}