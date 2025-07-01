package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is a class that represents an {@code MarbleSolitaireTextView}. This class had a model state
 * of type {@code MarbleSolitaireModelState} and aids in viewing the game board.
 */
public class MarbleSolitaireTextView extends AbstractView {

  /**
   * Constructor that takes in a model state.
   *
   * @param modelState a version of a model state
   * @throws IllegalArgumentException when the given model state is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState) {
    super(modelState);
  }

  /**
   * Constructor that takes in 2 arguments.
   *
   * @param modelState a version of the model state
   * @param ap         appendable object
   * @throws IllegalArgumentException when the given model state or appendable object is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable ap)
          throws IllegalArgumentException {
    super(modelState, ap);
  }

}

