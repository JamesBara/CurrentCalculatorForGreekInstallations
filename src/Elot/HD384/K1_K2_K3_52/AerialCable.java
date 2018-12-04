package Elot.HD384.K1_K2_K3_52;

public class AerialCable extends Cable {

    private String multicore;
    private String contact;
    private String triangleSetUp;
    private String horizontalSetUp;
    private int MaxCurrent;
    private double[][] MaxCurrentArrayCopper={{18.5,22,26,-1,-1,-1,-1,-1,-1},{25,30,36,-1,-1,-1,-1,-1,-1},{34,40,49,-1,-1,-1,-1,-1,-1},{43,51,63,-1,-1,-1,-1,-1,-1},{60,70,86,-1,-1,-1,-1,-1,-1},{80,94,115,-1,-1,-1,-1,-1,-1},{101,119,149,110,130,135,141,161,182},{126,148,185,137,162,169,176,200,226},{153,180,225,167,196,207,216,242,275},{196,232,289,216,251,268,279,310,353},{238,282,352,264,304,328,341,377,430},{276,328,410,308,352,383,396,437,500},{319,379,473,356,406,444,456,504,577},{364,434,542,409,463,510,521,575,661},{430,514,641,485,546,607,615,679,781},{497,593,741,561,629,703,709,783,902},{-1,-1,-1,656,754,823,852,940,1085},{-1,-1,-1,749,868,946,982,1083,1253},{-1,-1,-1,855,1005,1088,1138,1254,1454}};
    private double[][] MaxCurrentArrayAluminum={{61,73,91,-1,-1,-1,-1,-1,-1},{78,89,108,84,98,103,107,121,138},{96,111,135,105,122,129,135,150,172},{117,135,164,128,149,159,165,184,210},{150,173,211,166,192,206,215,237,271},{183,210,257,203,235,253,264,289,332},{212,244,300,237,273,296,308,337,387},{245,282,346,274,316,343,356,389,448},{280,322,397,315,363,395,407,447,515},{330,380,470,375,430,471,482,530,611},{381,439,543,434,497,547,557,613,708},{-1,-1,-1,526,600,663,671,740,856},{-1,-1,-1,610,694,770,775,856,991},{-1,-1,-1,711,808,899,900,996,1154}};



    public AerialCable(String conductor,String insulation,int chargedConductorsNum,int crossSectionIndex){
        super(conductor,insulation,chargedConductorsNum,crossSectionIndex);

    }

    public void setMulticore(String multicore) {
        this.multicore = multicore;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTriangleSetUp(String triangleSetUp) {
        this.triangleSetUp = triangleSetUp;
    }

    public void setHorizontalSetUp(String horizontalSetUp) {
        this.horizontalSetUp = horizontalSetUp;
    }

    @Override
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