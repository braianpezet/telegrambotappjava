package com.example.telegrambot.controller;


import com.example.telegrambot.TelegramBotWebHook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class TelegramBotWebHookController {

    private final TelegramBotWebHook telegramBot;

    public TelegramBotWebHookController(TelegramBotWebHook telegramBot) {
        this.telegramBot = telegramBot;
    }

    // Maneja las solicitudes POST en la ruta raíz ("/") para recibir actualizaciones de Telegram
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        // Llama al método onWebhookUpdateReceived del bot TelegramBotWebHook y pasa la actualización
        return telegramBot.onWebhookUpdateReceived(update);
    }

}