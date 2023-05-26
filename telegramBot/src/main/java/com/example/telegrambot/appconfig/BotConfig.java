package com.example.telegrambot.appconfig;

import com.example.telegrambot.TelegramBotWebHook;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;



// @Setter y @Getter son anotaciones de Lombok para generar automáticamente métodos getter y setter para las propiedades de la clase.
@Setter
@Getter

// @Configuration indica que esta clase es una clase de configuración de Spring.
@Configuration

// @ConfigurationProperties indica que las propiedades de configuración se obtendrán de un prefijo específico en el archivo de propiedades.
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    // Propiedades de configuración para el bot
    private String webHookPath;
    private String botUserName;
    private String botToken;

    // Parámetros de configuración del proxy
    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    // @Bean indica que este método debe ser tratado como un bean de Spring y se debe agregar al contexto de la aplicación.
    @Bean
    public TelegramBotWebHook MySuperTelegramBot() {
        // Crear instancia de DefaultBotOptions
        DefaultBotOptions options = new DefaultBotOptions();

        // Configurar las opciones del bot con los valores de configuración
        options.setProxyHost(proxyHost);
        options.setProxyPort(proxyPort);
        options.setProxyType(proxyType);

        // Crear instancia de TelegramBotWebHook
        TelegramBotWebHook telegramBot = new TelegramBotWebHook(options);

        // Establecer las propiedades de configuración en la instancia de TelegramBotWebHook
        telegramBot.setWebHookPath(webHookPath);
        telegramBot.setBotUserName(botUserName);
        telegramBot.setBotToken(botToken);

        return telegramBot;
    }
}