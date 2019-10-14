package by.hryharenka.ots.bot;

import by.hryharenka.ots.bot.entity.City;
import by.hryharenka.ots.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TravelBot extends TelegramLongPollingBot {
    private static final String CITY_NOT_FOUND = "Извините город не найден!";

    @Value("${telegram.token}")
    private String token;
    @Value("${telegram.username}")
    private String username;

    @Autowired
    private CityService cityService;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String messageText = update.getMessage().getText();
            City city = cityService.read(messageText);
            long chatId = update.getMessage().getChatId();


            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chatId)
                    .setText(city != null ? city.getAnswer() : CITY_NOT_FOUND);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}