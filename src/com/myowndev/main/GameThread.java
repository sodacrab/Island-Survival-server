package com.myowndev.main;

import com.myowndev.main.Entities.GroundEntities.Player;
import com.myowndev.main.VarContainer.GlobalVars;

class GameThread extends Thread {

    @Override
    public void run() {
        while (true) {

            // Players:
            for (Player p : GlobalVars.players) {
                if (p.isAliveCheck()) {
                    p.boundChecker();
                    p.coverChecker();
                    System.out.println(GlobalVars.players[0].isCoveredCheck() + " " + GlobalVars.players[0].getX() + ' ' + GlobalVars.players[0].getY());
                }
            }

            // Raindrops:
            for (int i = 0; i < GlobalVars.raindrops.size(); i++) {
                if (GlobalVars.raindrops.get(i).getX() == 0 || GlobalVars.raindrops.get(i).getY() > 320) {
                    GlobalVars.raindrops.get(i).setX(GlobalVars.rand.nextInt(290));
                    GlobalVars.raindrops.get(i).setY(GlobalVars.rand.nextInt(60) * -1);
                }
                GlobalVars.raindrops.get(i).setY(GlobalVars.raindrops.get(i).getY() + 1);
                for (int j = 0; j < GlobalVars.players.length; j++) {
                    if (GlobalVars.players[j].intersects(GlobalVars.raindrops.get(i))) {
                        if (!GlobalVars.players[j].isCoveredCheck()) {
                            GlobalVars.players[j].setAlive(false);
                            System.out.println("Player " + j + " just get sopped wet");
                        }
                    }
                }
            }
            // Bananas:
            

            // Technical:
            try {
                Thread.sleep(GlobalVars.sleepTime); // TODO: rethink
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
