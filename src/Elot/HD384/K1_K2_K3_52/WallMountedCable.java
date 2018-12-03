package Elot.HD384.K1_K2_K3_52;

public class WallMountedCable extends Cable {

    private String multicore;
    private String pipe;
    private int MaxCurrent;
    private static double[] copperCrossSection={1.5,2.5,4,6,10,16,25,35,50,70,95,120,150,185,240,300};
    private static double[] aluminumCrossSection={16,25,35,50,70,95,120,150,185,240,300};

    public WallMountedCable(String conductor,String insulation,int chargedConductorsNum,String multicore,String pipe,double crossSection){
        super(conductor,insulation,chargedConductorsNum,crossSection);
        this.multicore=multicore;
        this.pipe=pipe;

    }

    @Override
    public double[] CrossSection(){
        if (getConductor().equals("Copper"))
            return copperCrossSection;
        else
            return aluminumCrossSection;
    }

    public void MaxCurrent() {
        if (multicore.equals("")) {
            if (pipe.equals("")) {
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
            } else {
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
        } else {
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
    }
}
