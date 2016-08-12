package com.myowndev.main;

import com.myowndev.main.Entities.GroundEntities.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.myowndev.main.VarContainer.GlobalVars.*;

public class ServerInstance implements Runnable {

    private Socket clientSocket;

    private int player_ID = 0; // server's local player id

    private BufferedReader in = null;

    private PrintWriter out = null;
    private String input = null;
    private Thread sender;

    public ServerInstance(Socket clientSocket, int ID) {
        this.clientSocket = clientSocket;
        this.player_ID = ID;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true); // send response to client
            sender = new Thread() {
                String msg = "";
                public void run() {
                    while (true) {
                        msg = String.join(",",
                                players[0].getVector(),
                                players[1].getVector(),
                                players[2].getVector(),
                                players[3].getVector(),
                                raindrops.get(0).getVector(),
                                raindrops.get(1).getVector(),
                                raindrops.get(2).getVector(),
                                raindrops.get(3).getVector(),
                                raindrops.get(4).getVector()
                                );
                        //System.out.println(msg); // DEBUG
                        out.println(msg);
                        try {
                            Thread.sleep(sleepTime); // TODO: rethink
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            sender.start();
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // read from client
            while((input = in.readLine()) != null) {
                if (input.equals("UP"))
                    players[player_ID].setY(players[player_ID].getY() - 1);
                if (input.equals("LEFT"))
                    players[player_ID].setX(players[player_ID].getX() - 1);
                if (input.equals("DOWN"))
                    players[player_ID].setY(players[player_ID].getY() + 1);
                if (input.equals("RIGHT"))
                    players[player_ID].setX(players[player_ID].getX() + 1);
                if (input.equals("SPACE")) {
                    for (Player p : players) {
                        if (players[player_ID].intersects(p) && !p.isMale()) {
                            // TODO
                        }
                    }
                    if (players[player_ID].intersects(banana)) {
                        // TODO
                    }
                    //players[player_ID].setX(players[player_ID].getX() + 1);
                }
            }
        } catch(IOException e) {
            //e.printStackTrace();
            System.out.println("Player " + player_ID + " left");
            players[player_ID].disconnect();
        }
    }
}
