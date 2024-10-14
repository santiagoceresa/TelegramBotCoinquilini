package modules;

public enum InquilinoType {
    SANT("Santiago"),
    LUCA("Luca"),
    TOM("Tommaso");

    private final String name;

    InquilinoType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}