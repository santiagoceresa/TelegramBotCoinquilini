package modules;

public enum SottoAzione {
    CESTINI("cestini", 1),
    LAVASTOVIGLIE("lavastoviglie",2),
    ENTRATA("l'entrata e corridoio",4),
    SALA("la sala",1),
    CUCINA("la cucina",1),
    QUADRI("i quadri e i battiscopa",3),
    TAVOLO("il tavolo",2);

    private final String name;
    private final int peso;

    //costruttore privato enum
    SottoAzione(String name, int peso){ //privato e non pubblico perchè non consentito
        this.name = name;
        this.peso = peso;
    }

    public String getName(){
        return name;
    }

    public int getPeso(){
        return peso;
    }
}