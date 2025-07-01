package cs3500.marblesolitaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Entry point for marble program.
 */
public final class MarbleSolitaire {
  /**
   * Main method starting game with command lines args.
   * @param args commands
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model;
    MarbleSolitaireView view;
    String str = "";
    int size = 0;
    int row = 0;
    int col = 0;
    Readable rd = new BufferedReader(new InputStreamReader(System.in));
    Appendable ap = new PrintStream(System.out);

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "english":
          str = "english";
          break;
        case "european":
          str = "european";
          break;
        case "triangle":
          str = "triangle";
          break;
        case "-size":
          String nextInt = args[i + 1];
          size = (Integer.parseInt(nextInt));
          row = ((size * 3) - 2) / 2;
          col = ((size * 3) - 2) / 2;
          break;
        case "-hole":
          String strRow = args[i + 1];
          String strCol = args[i + 2];
          row = (Integer.parseInt(strRow)) - 1;
          col = (Integer.parseInt(strCol)) - 1;
          break;
        default:
          // ignore if the arg is an invalid input
          break;
      }
    }

    switch (str) {
      case "english":
        model = new EnglishSolitaireModel(size, row, col);
        view = new MarbleSolitaireTextView(model, ap);
        break;
      case "european":
        model = new EuropeanSolitaireModel(size, row, col);
        view = new MarbleSolitaireTextView(model, ap);
        break;
      case "triangle":
        model = new TriangleSolitaireModel(size, row, col);
        view = new TriangleSolitaireTextView(model, ap);
        break;
      default:
        throw new IllegalArgumentException("Board type not supported / invalid.");
    }

    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, view, rd);

    controller.playGame();

  }
}





