package Server;

import Server.HttpServer;

public class MainApplication {
    // Домашнее задание:
    // - Добавить логирование
    // - Добавить обработку запросов в параллельных потоках

    public static void main(String[] args) {
        HttpServer server = new HttpServer(Integer.parseInt((String) System.getProperties().getOrDefault("port", "8189")));
        server.start();
    }
}

