package goosegame;

import goosegame.boards.ClassicalBoard;

public class GameMain {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java goosegame.GameMain NUM");
            return;
        }

        int numberOfPlayers;
        try {
            numberOfPlayers = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.err.println("First argument must be an int");
            return;
        }

        Board board = new ClassicalBoard();
        Game game = new Game(board);

        try {
            for (int i = 0; i < numberOfPlayers; ++i) {
                Player player = new Player("player" + String.valueOf(i), null);
                game.addPlayer(player);
            }
            game.play();
        }
        catch (NoPlayerException e) {
            System.out.println("Cannot play: no player");
        }
        catch (UnknownCellException e) {
            System.out.println("Game aborted: unknown cell");
        }
    }
}
