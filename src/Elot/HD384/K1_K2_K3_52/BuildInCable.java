package Elot.HD384.K1_K2_K3_52;

public class BuildInCable extends Cable {

    private String multicore;
    private String pipe;

    private int arrayRows;
    private int arrayColumns;
    private double tempMaxCurrent;

    private double[][] maxCurrentArrayCopper={{13,13.5,14.5,15.5,17,19,20,22,23},{17.5,18,19.5,21,23,26,28,30,31},{23,24,26,28,31,35,37,40,42},{29,31,34,36,40,44,48,51,54},{39,42,46,50,54,60,66,69,75},{52,56,61,68,73,80,88,91,100},{68,73,80,89,95,105,117,119,133},{83,89,99,109,117,128,144,146,164},{99,108,118,130,141,154,175,175,198},{125,136,149,164,179,194,222,221,253},{150,164,179,197,216,233,269,265,306},{172,188,206,227,249,268,312,305,354},{196,216,240,259,285,318,-1,371,441},{223,245,273,295,324,362,-1,424,506},{261,286,321,346,380,424,-1,500,599},{298,328,367,396,435,486,-1,576,693}};
    private double[][] maxCurrentArrayAluminum={{41,43,48,53,58,64,71,72,79},{53,57,62,70,73,84,93,90,101},{65,70,77,86,90,103,116,112,126},{78,84,92,104,110,124,140,136,154},{98,107,116,131,140,156,179,174,198},{118,129,139,157,170,188,217,211,241},{135,149,160,180,197,216,251,245,280},{155,170,189,206,226,253,-1,283,324},{185,176,194,215,233,256,288,-1,323,371},{207,227,252,273,300,338,-1,382,439},{237,261,289,313,344,387,-1,440,508}};

    public BuildInCable(String conductor,String insulation,int chargedConductorsNum,int crossSectionIndex){
        super(conductor,insulation,chargedConductorsNum,crossSectionIndex);
}

    public void setPipe(String pipe) {
        this.pipe = pipe;
    }

    public void setMulticore(String multicore) {
        this.multicore = multicore;
    }

    @Override
    public String getMaxCurrent() {
        //CrossSectionIndex is equivalent to the row number of our arrays.
        arrayRows = getCrossSectionIndex();

        //First we check the number of cores(multicore) if it's "Multi Core", we check the insulation type and the number of charged conductors.
        if (multicore.equals("Multi Core")) {
            if (pipe.equals("Naked cable")) {
                if (getInsulation().equals("PVC")) {
                    if (getChargedConductorsNum() == 2)
                        arrayColumns = 2;
                    else if(getChargedConductorsNum() == 3)
                        arrayColumns = 1;
                } else if(getInsulation().equals("EPR or XLPE")) {
                    if (getChargedConductorsNum() == 2)
                        arrayColumns = 5;
                    else if(getChargedConductorsNum() == 3)
                        arrayColumns = 4;
                }
            } else if (pipe.equals("Cable in pipe")){
                if (getInsulation().equals("PVC")) {
                    if (getChargedConductorsNum() == 2)
                        arrayColumns = 1;
                    else if(getChargedConductorsNum() == 3)
                        arrayColumns = 0;
                } else if(getInsulation().equals("EPR or XLPE")){
                    if (getChargedConductorsNum() == 2)
                        arrayColumns = 4;
                    else if(getChargedConductorsNum() == 3)
                        arrayColumns = 3;
                }
            }
        } else if(multicore.equals("none")){
            if (getInsulation().equals("PVC")) {
                if (getChargedConductorsNum() == 2)
                    arrayColumns = 2;
                else if(getChargedConductorsNum() == 3)
                    arrayColumns = 1;
            } else if(getInsulation().equals("EPR or XLPE")){
                if (getChargedConductorsNum() == 2)
                    arrayColumns = 4;
                else if(getChargedConductorsNum() == 3)
                    arrayColumns = 4;
            }
        }

        //Now we need to choose the correct array depending on the user's input on conductor.
        if (getConductor().equals("Copper"))
            tempMaxCurrent = maxCurrentArrayCopper[arrayRows][arrayColumns];
        else if (getConductor().equals("Aluminum"))
            tempMaxCurrent = maxCurrentArrayAluminum[arrayRows][arrayColumns];

        //In case there is no valid result(-1) in the array we return "Δεν υπάρχει αποτέλεσμα γι'αυτες τις τιμές.".
        //Otherwise we return the value as a String.
        if (tempMaxCurrent==-1)
            return "Δεν υπάρχει αποτέλεσμα γι'αυτες τις τιμές.";
        else
            return Double.toString(tempMaxCurrent);
    }
}











