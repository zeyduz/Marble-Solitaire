package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class is an abstracted view. It aids in displaying various versions of the game.
 */
public abstract class AbstractView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState modelState;
  protected Appendable ap;

  /**
   * Constructor that takes in a model state.
   *
   * @param modelState a version of a model state
   * @throws IllegalArgumentException when the given model state is null
   */
  public AbstractView(MarbleSolitaireModelState modelState) throws IllegalArgumentException {
    this(modelState, System.out);
  }

  /**
   * Constructor that takes in 2 arguments.
   *
   * @param modelState a version of the model state
   * @param ap         appendable object
   * @throws IllegalArgumentException when the given model state or appendable object is null
   */
  public AbstractView(MarbleSolitaireModelState modelState, Appendable ap)
          throws IllegalArgumentException {
    if (ap == null) {
      throw new IllegalArgumentException("Provided Appendable is null");
    }
    if (modelState == null) {
      throw new IllegalArgumentException("Provided model is null.");
    }
    this.modelState = modelState;
    this.ap = ap;
  }


  @Override
  public String toString() {
    String str = "";

    for (int i = 0; i < modelState.getBoardSize(); i++) {
      for (int j = 0; j < modelState.getBoardSize(); j++) {

        if (modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          if (j + 1 == modelState.getBoardSize()) {
            str = str + "_";
            break;
          }
          if (modelState.getSlotAt(i, j + 1) == MarbleSolitaireModelState.SlotState.Invalid) {
            str = str + "_";
            break;
          } else {
            str = str + "_ ";
          }
        } else if (modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble
                && (j != modelState.getBoardSize() - 1)
                && (j + 1 < modelState.getBoardSize())
                && modelState.getSlotAt(i, j + 1)
                == MarbleSolitaireModelState.SlotState.Invalid) {
          str = str + "O";
          break;
        } else if (modelState.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          if (j != modelState.getBoardSize() - 1) {
            str = str + "O ";
          } else {
            str = str + "O";
          }
        } else {
          str = str + "  ";
        }
      }
      if (i != modelState.getBoardSize() - 1) {
        str = str + "\n";
      }
    }
    return str;
  }

  @Override
  public void renderBoard() throws IOException {
    this.ap.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.ap.append(message);
  }
}
