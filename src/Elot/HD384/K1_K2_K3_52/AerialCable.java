package Elot.HD384.K1_K2_K3_52;

public class AerialCable extends Cable {

    private String multicore;
    private String contact;
    private String triangleSetUp;
    private String horizontalSetUp;
    private int MaxCurrent;


    private static double[] copperCrossSection={1.5,2.5,4,6,10,16,25,35,50,70,95,120,150,185,240,300,400,500,630};
    private static double[] aluminumCrossSection={16,25,35,50,70,95,120,150,185,240,300,400,500,630};

    public AerialCable(String conductor,String insulation,int chargedConductorsNum,String multicore,String contact,String triangleSetUp,String horizontalSetUp,double crossSection){
        super(conductor,insulation,chargedConductorsNum,crossSection);
        this.multicore=multicore;
        this.contact=contact;
        this.triangleSetUp=triangleSetUp;
        this.horizontalSetUp=horizontalSetUp;

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
        if (multicore.equals("")) {
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
            if (contact.equals("")) {
                if (triangleSetUp.equals("")) {
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
                if (horizontalSetUp.equals("")) {
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