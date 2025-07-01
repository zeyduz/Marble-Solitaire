package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This is a class that represents an {@code MarbleSolitaireControllerImpl}. This class uses model,
 * view, and readable to initiate the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  enum BoardStates { Play, InvalidMove, InvalidPos, Quit, GameOver }

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable rd;

  /**
   * Constructor for Marble Solitaire Controller to initiate game.
   *
   * @param model given model to implement game
   * @param view  given view to show game
   * @param rd    readable for input
   * @throws IllegalArgumentException if any of the parameters are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable rd) throws IllegalArgumentException {
    if (model == null || view == null || rd == null) {
      throw new IllegalArgumentException("The model, view, and readable cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.rd = rd;
  }

  /**
   * Aids in rendering board and messages.
   *
   * @param boardState the various board states during the game
   * @throws IllegalStateException If transmission of board or message fails
   */
  private void renderBoardState(BoardStates boardState) throws IllegalStateException {
    switch (boardState) {
      case Play:
        try {
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + this.model.getScore() + "\n");
          this.view.renderMessage("Enter the row and column of the from and to positions." + "\n");
        } catch (IOException io) {
          throw new IllegalStateException("Failed transmission to appendable.");
        }
        break;
      case InvalidMove:
        try {
          this.view.renderMessage("Invalid move. Play again." + "\n");
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + this.model.getScore() + "\n");
        } catch (IOException io) {
          throw new IllegalStateException("Failed transmission to appendable.");
        }
        break;
      case InvalidPos:
        try {
          this.view.renderMessage("Enter a valid integer." + "\n");
        } catch (IOException io) {
          throw new IllegalStateException("Failed transmission to appendable.");
        }
        break;
      case Quit:
        try {
          this.view.renderMessage("Game quit!" + "\n");
          this.view.renderMessage("State of game when quit:" + "\n");
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + this.model.getScore() + "\n");
        } catch (IOException io) {
          throw new IllegalStateException("Failed transmission to appendable.");
        }
        break;
      case GameOver:
        try {
          this.view.renderMessage("Game over!" + "\n");
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + this.model.getScore() + "\n");
        } catch (IOException io) {
          throw new IllegalStateException("Failed transmission to appendable.");
        }
        break;
      default:
        break;
    }
  }

  /**
   * Retrieves the next valid integer value from the given scanner.
   *
   * @param scan the current scanner for this game
   * @return the next valid integer value, or -1 if quit
   * @throws IllegalStateException if the scanner runs out of items to scan
   */
  private int getVal(Scanner scan) throws IllegalStateException {
    int nextInt = 0;
    boolean hasValue = false;

    while (!hasValue) {
      if (scan.hasNext()) {
        // any integer value the user enters is handled here
        if (scan.hasNextInt()) {
          int currInt = scan.nextInt();
          if (currInt < 0) { //|| currInt > this.model.getBoardSize()
            renderBoardState(BoardStates.InvalidPos);
          } else {
            nextInt = currInt - 1; //subtract 1 to match indeces
            hasValue = true;
          }

          // if what the user enters is not an integer
        } else {
          String unknown = scan.next();
          if (unknown.equals("q") || unknown.equals("Q")) {
            // design documentation: a value of -1 represents the game being quit
            // by returning -1, this method tells the playGame method that the user has quit
            nextInt = -1;
            hasValue = true;
          } else {
            renderBoardState(BoardStates.InvalidPos);
          }
        }

      } else {
        throw new IllegalStateException("Scanner ran out of inputs.");
      }
    }
    return nextInt;
  }


  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.rd);
    boolean quit = false;

    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;

    while (!this.model.isGameOver()) {
      if (!quit) {
        renderBoardState(BoardStates.Play);
      }

      for (int i = 0; i < 4; i++) {
        if (scan.hasNext()) {
          int currVal = getVal(scan);
          if (currVal == -1) {
            renderBoardState(BoardStates.Quit);
            return;
          }
          switch (i) {
            case 0:
              fromRow = currVal;
              break;
            case 1:
              fromCol = currVal;
              break;
            case 2:
              toRow = currVal;
              break;
            case 3:
              toCol = currVal;
              break;
            default:
              break;
          }
        } else {
          throw new IllegalStateException("No more inputs.");
        }
      }

      try {
        this.model.move(fromRow, fromCol, toRow, toCol);
        quit = false;
      } catch (IllegalArgumentException e) {
        renderBoardState(BoardStates.InvalidMove);
        quit = true;
      }
    }

    // when the game is over, draw the final state of the game at the moment it ended
    renderBoardState(BoardStates.GameOver);
  }
}
