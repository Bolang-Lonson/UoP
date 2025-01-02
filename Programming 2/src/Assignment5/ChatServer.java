package Assignment5;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static int clientCounter = 0;
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientCounter++;
                ClientHandler clientHandler = new ClientHandler(clientSocket, clientCounter);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private int clientId;
        private PrintWriter out;

        public ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Welcome! Your user ID is " + clientId);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client " + clientId + ": " + message);
                    broadcast("User " + clientId + ": " + message);
                }
            } catch (IOException e) {
                System.out.println("Client " + clientId + " disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(this);
            }
        }

        private void broadcast(String message) {
            synchronized (clients) {
                for (ClientHandler client : clients) {
                    client.out.println(message);
                }
            }
        }
    }
}