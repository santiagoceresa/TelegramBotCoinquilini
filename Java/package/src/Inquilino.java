package modules;

public class Inquilino {
    private final InquilinoType tipo;
    private int punti;

    public Inquilino(InquilinoType tipo, int punti){
        this.tipo = tipo;
        this.punti = punti;
    }
    public InquilinoType getTipo(){
        return tipo;
    }

    public int getPunti(){
        return punti;
    }

    public void print(){
        System.out.println("Ciao! " + tipo.getName() + ", hai: " + punti + "punti");
    }
}