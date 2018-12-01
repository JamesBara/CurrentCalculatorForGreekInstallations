package Elot.HD384.K1_K2_K3_52;

public class OnGroundCable extends Cable {

    private static double[] copperCrossSection={1.5,2.5,4,6,10,16,25,35,50,70,95,120,150,185,240,300};
    private static double[] aluminumCrossSection={16,25,35,50,70,95,120,150,185,240,300};
    private int MaxCurrent;
    public OnGroundCable(String conductor,String insulation,int chargedConductorsNum){
        super(conductor,insulation,chargedConductorsNum);
    }


    public double[] CrossSection(){
        if (getConductor().equals("Copper"))
            return copperCrossSection;
        else
            return aluminumCrossSection;
    }

    public void MaxCurrent(){

        if (getInsulation().equals("PVC")){
            if (getChargedConductorsNum()==2)
                MaxCurrent = 1;
            else
                MaxCurrent=2;
        }
        else {
            if (getChargedConductorsNum() == 2)
                MaxCurrent = 1;
            else
                MaxCurrent = 2;
        }
    }



}
