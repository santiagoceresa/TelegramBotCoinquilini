package modules;

public enum AzioniType {
    EMPTY("Svuotato", new SottoAzione[]{SottoAzione.CESTINI,SottoAzione.LAVASTOVIGLIE}),
    ASPIRATO("Aspirato", new SottoAzione[]{SottoAzione.SALA,SottoAzione.ENTRATA}),
    PULITO("Pulito", new SottoAzione[]{SottoAzione.CUCINA,SottoAzione.QUADRI, SottoAzione.TAVOLO});

    private final String descrizione;
    private final SottoAzione[] subAzioni; //azioni associate all'enum

    AzioniType(String descrizione, SottoAzione[] subAzioni){
        this.descrizione = descrizione;
        this.subAzioni = subAzioni;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public SottoAzione[] getSubAzioni(){
        return subAzioni;
    }
}