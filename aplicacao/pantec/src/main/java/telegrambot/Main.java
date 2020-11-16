package telegrambot;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public void chat(String mensagem) {
        BotTelegram bt = new BotTelegram("1419072807:AAEEPuWLsXwlm8r3FBgmyvaO5hroGBYkwnU");
        try {
            bt.sendMessage(-373942159, mensagem);
        } catch (UnirestException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}