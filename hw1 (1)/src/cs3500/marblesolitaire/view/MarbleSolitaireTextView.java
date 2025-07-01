package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is a class that represents an {@code MarbleSolitaireTextView}. This class had a model state
 * of type {@code MarbleSolitaireModelState} and aids in viewing the game board.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  MarbleSolitaireModelState modelState;

  /**
   * Constructor that takes in a model state.
   *
   * @param modelState a version of a model state
   * @throws IllegalArgumentException when the given model state is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState)
          throws IllegalArgumentException {
    if (modelState == null) {
      throw new IllegalArgumentException("Provided model is null.");
    }
    this.modelState = modelState;
  }

  private boolean offBoard(int pos) {
    return pos + 1 >= this.modelState.getBoardSize();
  }

  @Override
  public String toString() {
    String str = "";

    for (int i = 0; i < this.modelState.getBoardSize(); i++) {
      for (int j = 0; j < this.modelState.getBoardSize(); j++) {

        if (this.modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          if (j + 1 == this.modelState.getBoardSize()) {
            str = str + "_";
            break;
          }
          if (this.modelState.getSlotAt(i, j + 1) == MarbleSolitaireModelState.SlotState.Invalid) {
            str = str + "_";
            break;
          } else {
            str = str + "_ ";
          }
        } else if (this.modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble
                && (j != this.modelState.getBoardSize() - 1)
                && (j + 1 < this.modelState.getBoardSize())
                && this.modelState.getSlotAt(i, j + 1)
                == MarbleSolitaireModelState.SlotState.Invalid) {
          str = str + "O";
          break;
        } else if (this.modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          if (j != this.modelState.getBoardSize() - 1) {
            str = str + "O ";
          } else {
            str = str + "O";
          }
        } else {
          str = str + "  ";
        }
      }
      if (i != this.modelState.getBoardSize() - 1) {
        str = str + "\n";
      }
    }
    return str;
  }
}

