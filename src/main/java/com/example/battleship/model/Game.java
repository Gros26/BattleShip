package com.example.battleship.model;

/**
 * Game class representing the logic and state of a Battleship game.
 * Manages the turn count and provides methods to manipulate and retrieve game state.
 *
 * @author Grosman Garcia
 * @version 1
 */
public class Game {
    /**
     * The current turn count in the game.
     */
    private int turn;

    /**
     * Constructs a new Game instance with initial values for turn and sunk ships.
     */
    public Game() {
        this.turn = 0;
    }

    /**
     * Increments the turn count by one.
     */
    public void setTurn() {
        this.turn += 1;
    }

    /**
     * Returns the current turn count.
     *
     * @return the current turn count
     */
    public int getTurn() {
        return this.turn;
    }
}

