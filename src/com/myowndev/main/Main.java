package com.myowndev.main;

import java.net.ServerSocket;
import java.net.Socket;

import com.myowndev.main.Entities.Raindrop;
import com.myowndev.main.VarContainer.GlobalVars;

public class Main {

    private Main() {
        // init raindrops:
        for (int i = 0; i < 5; i++) { // TODO: rethink
            GlobalVars.raindrops.add(i, new Raindrop(0, 0));
        }
        try {
            ServerSocket serverSocket = new ServerSocket(9096);
            new GameThread().start();
            while (true) {
                Socket sock = serverSocket.accept();
                for (int i = 0; i < GlobalVars.players.length; i++) {
                    if (GlobalVars.players[i].isBotCheck()) {
                        GlobalVars.players[i].connect();
                        System.out.println("Player " + i + " connected from: " + sock.getInetAddress() + ":" + sock.getPort());
                        new Thread(new ServerInstance(sock, i)).start();
                        break;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
