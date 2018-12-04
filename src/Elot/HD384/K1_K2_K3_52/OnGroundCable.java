package Elot.HD384.K1_K2_K3_52;

public class OnGroundCable extends Cable {


    private int MaxCurrent;
    private double[][] MaxCurrentArrayCopper={{22,18,26,22},{29,24,34,29},{38,31,44,37},{47,39,56,46},{63,52,73,61},{81,67,95,79},{104,86,121,101},{125,103,146,122},{148,122,173,144},{183,151,2,13,178},{216,179,252,211},{246,203,287,240},{278,230,324,271},{312,258,363,304},{361,297,419,351},{408,336,474,396}};
    private double[][] MaxCurrentArrayAluminum={{62,52,73,61},{80,66,93,78},{96,80,112,94},{113,94,132,112},{140,117,163,138},{166,138,193,164},{189,157,220,186},{213,178,249,210},{240,200,279,236},{277,230,322,272},{313,260,364,308}};





    public OnGroundCable(String conductor,String insulation,int chargedConductorsNum,int crossSectionIndex){
        super(conductor,insulation,chargedConductorsNum,crossSectionIndex);
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
