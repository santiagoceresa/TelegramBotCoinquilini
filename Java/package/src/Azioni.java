package modules;

public class Azioni {
    private final String name;
    private final int valore;

    public Azioni(String name, int valore){
        this.name = name;
        this.valore = valore;
    }
    public String getName(){
        return name;
    }
    public int getValore(){
        return valore;
    }
}