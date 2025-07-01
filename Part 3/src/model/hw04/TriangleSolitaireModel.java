package cs3500.marblesolitaire.model.hw04;


/**
 * This is a class that represents an {@code TriangleSolitaireModel}. The shape of the
 * board is triangular.
 */
public class TriangleSolitaireModel extends AbstractModel {

  /**
   * A default constructor (no parameters) that creates a 5-row game with the empty slot at (0,0).
   */
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * Constructor for Triangle Solitaire Model that takes in the diCreates a game with the
   * specified dimension (number of slots in the bottom-most row) and the empty slot at (0,0).
   *
   * @param dimension dimension of the board
   * @throws IllegalArgumentException if the specified dimension is invalid (non-positive)
   */
  public TriangleSolitaireModel(int dimension) throws IllegalArgumentException {
    super(dimension, 0, 0);
  }

  /**
   * Constructor for Triangle Solitaire Model that takes in the row and column position of the
   * empty cell. Creates a 5-row game with the empty slot at the specified position.
   *
   * @param row the row position of empty slot
   * @param col the column position of empty slot
   * @throws IllegalArgumentException if the specified position is invalid
   */
  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {
    super(5, row, col);
  }

  /**
   * Constructor for Triangle Solitaire Model that takes in a dimension, and row and column of the
   * empty slot. Creates a game with the specified dimension and an empty slot at the specified row
   * and column
   *
   * @param dimension the dimension of the board
   * @param row       the row position of empty slot
   * @param col       the column position of empty slot
   * @throws IllegalArgumentException if the specified dimension is invalid (non-positive) or the
   *                                  specified position is invalid
   */
  public TriangleSolitaireModel(int dimension, int row, int col) throws IllegalArgumentException {
    super(dimension, row, col);
  }

  @Override
  protected void invalidSize(int size) {
    if (size < 0) {
      throw new IllegalArgumentException("Size must be an odd number greater than or equal to 3.");
    }
  }

  @Override
  protected boolean moveablePlay(int row, int col) throws IllegalArgumentException {
    if (this.getSlotAt(row, col) != SlotState.Marble) {
      return false;
    }

    return this.canHopOver(row - 1, col, row - 2, col) ||
            this.canHopOver(row + 1, col + 1, row + 2, col + 2)
            || this.canHopOver(row + 1, col, row + 2, col)
            || this.canHopOver(row, col + 1, row, col + 2)
            || this.canHopOver(row, col - 1, row, col - 2) ||
            this.canHopOver(row - 1, col - 1, row - 2, col - 2);
  }

  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    // check conditions first:
    // from must be a marble, to must be empty, and marble must exist between them
    if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) {
      return false;
    } else if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      return false;
      // side-to-side
    } else if (fromRow == toRow && (Math.abs(fromCol - toCol)) != 2) {
      return false;
    } else if (Math.abs(fromRow - toRow) == 2 && Math.abs(fromRow - toRow) != 2) {
      return false;
    } else if (((double) Math.abs(fromCol - toCol) / (double) Math.abs(fromRow - toRow)) == 0.5) {
      return false;
    }

    return this.canHopOver(fromRow + 1, fromCol, toRow, toCol)
            || this.canHopOver(fromRow - 1, fromCol, toRow, toCol)
            || this.canHopOver(fromRow - 1, fromCol - 1, toRow, toCol)
            || this.canHopOver(fromRow, fromCol + 1, toRow, toCol)
            || this.canHopOver(fromRow, fromCol - 1, toRow, toCol);
  }


  @Override
  protected void setMiddleSlot(int fromRow, int fromCol, int toRow, int toCol) {
    // left to right
    if (fromCol < toCol && fromRow == toRow) {
      this.gameBoard[fromRow][fromCol + 1] = SlotState.Empty;
    }
    // right to left
    else if (toCol < fromCol && fromRow == toRow) {
      this.gameBoard[fromRow][fromCol - 1] = SlotState.Empty;
    }
    // to row and column less than from row and column
    else if (toRow < fromRow && toCol < fromCol) {
      this.gameBoard[fromRow - 1][fromCol - 1] = SlotState.Empty;
    }
    // upwards diagonal
    else if (toRow < fromRow) {
      this.gameBoard[fromRow - 1][fromCol] = SlotState.Empty;
    }
    // downwards diagonal
    else if (fromRow < toRow) {
      this.gameBoard[fromRow + 1][fromCol + 1] = SlotState.Empty;
    }
  }

  @Override
  protected boolean withinValidBounds(int size, int row, int col) {
    return row < size && col <= row;
  }

  @Override
  public int getBoardSize() {
    return size;
  }

}