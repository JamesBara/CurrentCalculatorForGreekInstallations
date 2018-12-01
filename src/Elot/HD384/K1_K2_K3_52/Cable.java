package Elot.HD384.K1_K2_K3_52;
public abstract class Cable {

    private String conductor;
    private String insulation;
    private int chargedConductorsNum;

    public Cable(String conductor, String insulation, int chargedConductorsNum){
        this.conductor = conductor;
        this.insulation=insulation;
        this.chargedConductorsNum = chargedConductorsNum;
    }

    //Cable insulation is either PVC or XLPE
    public String getInsulation() {
        return insulation;
    }
    //The amount of charged cables either 2 or 3.
    public int getChargedConductorsNum() {
        return chargedConductorsNum;
    }

    //Cables are made either of copper or aluminum.
    public String getConductor() {
        return conductor;
    }

    public abstract double[] CrossSection();
    //Could become int
    public abstract void MaxCurrent();


}
