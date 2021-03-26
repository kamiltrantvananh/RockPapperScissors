package com.company.service;

import com.company.component.Item;
import com.company.component.Player;

import java.util.Scanner;

public class Game {

    private final Scanner keyboard = new Scanner(System.in);

    public void play() {

        System.out.println("You are playing game ROCK, PAPER, SCISSOR.");
        System.out.println("For PAPER press key 'P'.");
        System.out.println("For ROCK press key 'R'.");
        System.out.println("For SCISSOR press key 'S'.");
        System.out.println("For Exit game press 'Q'.");

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        int i = 1;
        while (true) {
            System.out.println("-- Start game number " + i++);
            getPlayerChoice(player1);
            getPlayerChoice(player2);
            evaluateWinner(player1, player2);
        }
    }

    private void getPlayerChoice(Player player) {
        boolean choose = false;
        do {
            System.out.println("Player " + player.getId() + ", your choice:");
            switch (keyboard.nextLine()) {
                case "P":
                    player.setItem(Item.PAPER);
                    choose = true;
                    break;
                case "R":
                    player.setItem(Item.ROCK);
                    choose = true;
                    break;
                case "S":
                    player.setItem(Item.SCISSOR);
                    choose = true;
                    break;
                case "Q":
                    System.out.println("Thank you for playing this game.");
                    System.exit(0);
                default:
                    System.out.println("Wrong key!");
            }
        } while (!choose);
    }

    private void evaluateWinner(Player player1, Player player2) {
        // draw
        if ( player1.getItem() == player2.getItem()) {
            System.out.println("It's a draw!");
            return;
        }

        // player 1 win
        if ((player1.getItem() == Item.ROCK && player2.getItem() == Item.SCISSOR) ||
                (player1.getItem() == Item.PAPER && player2.getItem() == Item.ROCK) ||
                (player1.getItem() == Item.SCISSOR && player2.getItem() == Item.PAPER)) {
            System.out.println("Player 1 with " + player1.getItem() + " beats player 2 with " + player2.getItem() + ".");
        // player 2 win
        } else {
            System.out.println("Player 2 with " + player2.getItem() + " beats player 1 with " + player1.getItem() + ".");
        }
    }
}
