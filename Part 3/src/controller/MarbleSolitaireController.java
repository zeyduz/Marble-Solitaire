package cs3500.marblesolitaire.controller;

/**
 * This interface represents the operations offered by the marble solitaire
 * controller. One object of the controller represents an initiation and game of marble solitaire.
 */
public interface MarbleSolitaireController {

  /**
   * This method should play a new game of Marble Solitaire.
   *
   * @throws IllegalStateException only if the controller is unable to successfully read input
   *                               or transmit output.
   */
  void playGame() throws IllegalStateException;
}
