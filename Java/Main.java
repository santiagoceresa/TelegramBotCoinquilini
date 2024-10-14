import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import modules.AzioniType;
import modules.InquilinoType;
import modules.SottoAzione;
import bot.TelegramBot;

public class Main {
    public static void main(String[] args) {
        boolean continua = true;
        int var = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Chi sei? SANT, LUCA o TOM?");
        String input = scanner.nextLine().toUpperCase();
        //parte input da telegram
        InquilinoType nome = InquilinoType.valueOf(input);

        getNome(nome);

        //richiesta azione
        while (continua) {
            int mult = 1;
            System.out.print("Che hai fatto? "); //EMPTY, ASPIRATO O PULITO
            input = scanner.nextLine().toUpperCase();
            AzioniType azione = AzioniType.valueOf(input);

            System.out.println("Hai: " + azione.getDescrizione() + "cosa?");
            //Lavastoviglie, cestini, cucina, entrata, corridoio, quadri, cucina
            input = scanner.nextLine().toUpperCase();
            SottoAzione sottoAzione = SottoAzione.valueOf(input);

            //nel caso siano cestini faccio
            if (sottoAzione == SottoAzione.CESTINI) {
                System.out.print("Quanti cestini hai svuotato?");// 1,2,3,4 ?
                int x = scanner.nextInt();
                mult *= x;
                scanner.nextLine();//Consuma la newline rimasta dopo nextInt()
            }

            var += mult * sottoAzione.getPeso(); //sommo a var il valore dell'azione svolta

            //controllo se ha fatto altro
            System.out.print("Hai fatto altro?"); // si/ no
            input = scanner.nextLine().toUpperCase();
            if (input.equals("NO")) continua = false;
            //if input.equals("yes") -> continua = true e torna dentro il while
            //non serve specificarlo
        }
        System.out.println("Complimenti " + nome.getName() + "! Hai guadagnato " + var + " punti");

        System.out.print("Situazione di punteggio attuale: ");
        for (InquilinoType inquilino : InquilinoType.values()) {
            System.out.println(inquilino.getName() + " a " + rootNode.get(inquilino.toString()).asInt() + "punti");
        }
    }
    public static void aggiornaPunteggio(InquilinoType nome, int punti, int var) {
        File jsonFile = new File("punteggi.json");
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode rootNode;
            //controllo esistenza del file
            if (jsonFile.exists()) rootNode = mapper.readTree(jsonFile);
            else {
                //creo nuovo se non esiste
                rootNode = mapper.createObjectNode();
                ((ObjectNode) rootNode).put("Santiago", 0);
                ((ObjectNode) rootNode).put("Luca", 0);
                ((ObjectNode) rootNode).put("Tommaso", 0);
            }

            var += rootNode.get(nome.toString()).asInt();//ottengo valore associato al nome
            ((ObjectNode) rootNode).put(nome.toString(), var);

            //salvo file aggiornato
            mapper.writeValue(jsonFile,rootNode);
            System.out.println(nome.getName() + ", ora sei a: " + var + " punti!");
        }
    }
}