package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents the view of the Triangle Marble Solitaire. It helps render the baord
 * to look triangular.
 */
public class TriangleSolitaireTextView extends AbstractView {

  /**
   * Constructor that takes in 2 arguments.
   *
   * @param modelState a version of the model state
   * @param ap         appendable object
   * @throws IllegalArgumentException when the given model state or appendable object is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable ap)
          throws IllegalArgumentException {
    super(modelState, ap);
  }

  /**
   * Constructor that takes in a model state.
   *
   * @param modelState a version of a model state
   * @throws IllegalArgumentException when the given model state is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState)
          throws IllegalArgumentException {
    super(modelState);
  }

  @Override
  public String toString() {
    int boardDim = modelState.getBoardSize();
    String out = "";
    String str = "";
    String space;

    // go through board
    for (int i = 0; i < boardDim; i++) {
      for (int j = 0; j < 1 + i; j++) {
        // check what the current slot is
        MarbleSolitaireModelState.SlotState boardState = modelState.getSlotAt(i, j);
        // initialize spacing and adjust
        space = "";
        for (int y = boardDim - 1; y > i; y--) {
          space += " ";
        }

        // when slot is empty, append underscore and adjust spacing accordingly
        switch (boardState) {
          case Empty:
            if (j == 0) {
              str = space + "_";
            } else {
              str = "_";
            }
            if (j < i) {
              str += " ";
            }
            break;

          // when slot is marble, append O and adjust spacing accordingly
          case Marble:
            if (j == 0) {
              str = space + "O";
            } else {
              str = "O";
            }
            if (j < i) {
              str += " ";
            }
            break;

          // when slot is invalid, just add spacing
          case Invalid:
            str = "";
            break;

          // do nothing
          default:
            break;
        }
        // add row
        out += str;
      }
      // new lines every row
      if (i < boardDim - 1) {
        out += "\n";
      }
    }
    return out;
  }
}


