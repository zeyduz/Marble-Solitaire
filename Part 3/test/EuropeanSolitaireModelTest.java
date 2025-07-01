import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Testing European Solitaire Model.
 */
public class EuropeanSolitaireModelTest {

  private EuropeanSolitaireModel model;
  private EuropeanSolitaireModel model1;
  private EuropeanSolitaireModel model2;
  private EuropeanSolitaireModel model3;
  private EuropeanSolitaireModel model4;
  private EuropeanSolitaireModel model5;
  private EuropeanSolitaireModel model6;
  private EuropeanSolitaireModel model7;
  private EuropeanSolitaireModel model8;
  private EuropeanSolitaireModel model9;


  @Before
  public void init() {
    this.model = new EuropeanSolitaireModel();
    this.model1 = new EuropeanSolitaireModel(3, 4, 5);
    this.model2 = new EuropeanSolitaireModel();
    this.model3 = new EuropeanSolitaireModel(4, 4);
    this.model4 = new EuropeanSolitaireModel(5, 5, 5);
    this.model5 = new EuropeanSolitaireModel(7);
    this.model6 = new EuropeanSolitaireModel(9, 5, 7);
    this.model7 = new EuropeanSolitaireModel(11, 27, 18);
    this.model8 = new EuropeanSolitaireModel(3, 1, 4);
    this.model9 = new EuropeanSolitaireModel(3, 2, 3);
  }

  //////////////////////// START OF CONSTRUCTOR EXCEPTION TESTING ////////////////////////////////


  // when arm thickness is less than three
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessLessThanThree() {
    this.model = new EuropeanSolitaireModel(1);
  }

  // when arm thickness is even
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessEven() {
    this.model = new EuropeanSolitaireModel(4);
  }

  // when arm thickness is even AND less than 3
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessLessThanThreeAndEven() {
    this.model = new EuropeanSolitaireModel(2);
  }

  // when arm thickness is less than 3 in a 3 argument constructor
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessLessThanThree3Args() {
    this.model = new EuropeanSolitaireModel(1, 3, 3);
  }

  // when arm thickness is even in a 3 argument constructor
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessEven3Args() {
    this.model = new EuropeanSolitaireModel(4, 3, 3);
  }

  // when arm thickness is even in a 3 argument constructor
  @Test(expected = IllegalArgumentException.class)
  public void testArmThicknessLessThanThreeAndEven3Args() {
    this.model = new EuropeanSolitaireModel(2, 3, 3);
  }

  /////////////////////////////// 2-ARGUMENT CONSTRUCTOR /////////////////////////////////////////

  // when the row of the position is less than the lower bound, but the column is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionRow2Args() {
    this.model = new EuropeanSolitaireModel(-1, 3);
  }

  // when the column of the position is less than the lower bound, but the row is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionColumn2Args() {
    this.model = new EuropeanSolitaireModel(3, -1);
  }

  // when the column is greater than the upper bound, but the row is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionColumn2ArgsOutOfBound() {
    this.model = new EuropeanSolitaireModel(3, 8);
  }

  // when the row is greater than the upper bound, but the column is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionRow2ArgsOutOfBound() {
    this.model = new EuropeanSolitaireModel(8, 3);
  }

  // when both the row and the column is greater than the upper bound
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsBothInvalidLower() {
    this.model = new EuropeanSolitaireModel(-1, -1);
  }

  // when both the row and the column is less than the lower bound
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsBothInvalidUpper() {
    this.model = new EuropeanSolitaireModel(10, 10);
  }

  // when the row,column is in the top-left invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsTopLeft() {
    this.model = new EuropeanSolitaireModel(1, 0);
  }

  // when the row,column is in the top-right invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsTopRight() {
    this.model = new EuropeanSolitaireModel(1, 8);
  }

  // when the row,column is in the bottom-left invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsBottomLeft() {
    this.model = new EuropeanSolitaireModel(6, 1);
  }

  // when the row,column is in the bottom-right invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition2ArgsBottomRight() {
    this.model = new EuropeanSolitaireModel(6, 8);
  }

  /////////////////////////////// 3-ARGUMENT CONSTRUCTOR /////////////////////////////////////////

  // when the row of the position is less than the lower bound, but the column is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionRow3Args() {
    this.model = new EuropeanSolitaireModel(3, -1, 3);
  }

  // when the column of the position is less than the lower bound, but the row is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionColumn3Args() {
    this.model = new EuropeanSolitaireModel(3, 3, -1);
  }

  // when the column is greater than the upper bound, but the row is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionColumn3ArgsOutOfBound() {
    this.model = new EuropeanSolitaireModel(3, 3, 8);
  }

  // when the row is greater than the upper bound, but the column is inbounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionRow3ArgsOutOfBound() {
    this.model = new EuropeanSolitaireModel(3, 8, 3);
  }

  // when both the row and the column is greater than the upper bound
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsBothInvalidLower() {
    this.model = new EuropeanSolitaireModel(3, -1, -1);
  }

  // when both the row and the column is less than the lower bound
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsBothInvalidUpper() {
    this.model = new EuropeanSolitaireModel(3, 10, 10);
  }

  // when the row,column is in the top-left invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsTopLeft() {
    this.model = new EuropeanSolitaireModel(0);
  }

  // when the row,column is in the top-right invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsTopRight() {
    this.model = new EuropeanSolitaireModel(3, 1, 8);
  }

  // when the row,column is in the bottom-left invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsBottomLeft() {
    this.model = new EuropeanSolitaireModel(3, 6, 1);
  }

  // when the row,column is in the bottom-right invalid position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPosition3ArgsBottomRight() {
    this.model = new EuropeanSolitaireModel(3, 6, 8);
  }
  ///////////////////////......................

  // all invalid
  @Test(expected = IllegalArgumentException.class)
  public void testAllInvalid3Arg() {
    this.model = new EuropeanSolitaireModel(2, -1, -1);
  }

  //////////////////////////// END OF CONSTRUCTOR EXCEPTIONS TESTING ///////////////////////////

  //////////////////////////// TESTING VALID CONSTRUCTORS ///////////////////////////

  //default
  @Test
  public void testDefaultConstructor() {
    this.model = new EuropeanSolitaireModel();
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 3 && j == 3) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(i, j));
        } else if ((i <= 1 || i >= 5) && (j == 0 || j == 6)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
        } else if ((i == 0 || i == 6) && (j == 1 || j == 5)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
        } else if (i == 1) {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
        } else if (i >= 2 && i <= 4) {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void testValid2ParamConstructor() {
    this.model = new EuropeanSolitaireModel(4, 2);
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 4 && j == 2) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(i, j));
        } else if (i == 0 || i == 6) {
          if (j <= 1 || j >= 5) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 1 || i == 5) {
          if (j == 0 || j == 6) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void testValid1Constructor() {
    this.model = new EuropeanSolitaireModel(5);
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 13; j++) {
        if (i == 6 && j == 6) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(i, j));
        } else if (i == 0 || i == 12) {
          if (j <= 3 || j >= 9) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 1 || i == 11) {
          if (j <= 2 || j >= 10) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 2 || i == 10) {
          if (j <= 1 || j >= 11) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 3 || i == 9) {
          if (j == 0 || j == 12) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void testValid3ArgConstructor() {
    this.model = new EuropeanSolitaireModel(7, 0, 7);
    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (i == 0 && j == 7) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(i, j));
        } else if (i == 0 || i == 18) {
          if (j <= 5 || j >= 13) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 1 || i == 17) {
          if (j <= 4 || j >= 14) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 2 || i == 16) {
          if (j <= 3 || j >= 15) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 3 || i == 15) {
          if (j <= 2 || j >= 16) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 4 || i == 14) {
          if (j <= 1 || j >= 17) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else if (i == 5 || i == 13) {
          if (j == 0 || j == 18) {
            assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(i, j));
          } else {
            assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
          }
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(i, j));
        }
      }
    }
  }

  ///////////////////////////////// Testing getScore ///////////////////////////////////
  @Test
  public void testGetScore() {
    // arm thickness 3, empty (4,5)
    assertEquals(36, this.model1.getScore());

    // classic a=3 empty=center(3,3)
    assertEquals(36, this.model.getScore());
    this.model.move(3, 1, 3, 3);
    assertEquals(35, this.model.getScore());
    this.model.move(3, 4, 3, 2);
    assertEquals(34, this.model.getScore());
    this.model.move(3, 6, 3, 4);
    this.model.move(5, 3, 3, 3);
    this.model.move(2, 3, 4, 3);
    assertEquals(31, this.model.getScore());


    // a=3, empty=(4,4)
    assertEquals(36, this.model3.getScore());
    this.model3.move(6, 4, 4, 4);
    assertEquals(35, this.model3.getScore());
    this.model3.move(3, 4, 5, 4);
    assertEquals(34, this.model3.getScore());

    // a=5, empty=(5,5)
    assertEquals(128, this.model4.getScore());
    this.model4.move(5, 7, 5, 5);
    assertEquals(127, this.model4.getScore());
    this.model4.move(7, 7, 5, 7);
    assertEquals(126, this.model4.getScore());


    // a=7, empty=center
    assertEquals(276, this.model5.getScore());
    this.model5.move(9, 7, 9, 9);
    this.model5.move(9, 10, 9, 8);
    assertEquals(274, this.model5.getScore());

    // a=9, empty=(5,7)
    assertEquals(480, this.model6.getScore());
    this.model6.move(3, 7, 5, 7);
    assertEquals(479, this.model6.getScore());
    this.model6.move(3, 5, 3, 7);
    this.model6.move(3, 8, 3, 6);
    assertEquals(477, this.model6.getScore());

    // a=11 empty=(27,18)
    assertEquals(740, this.model7.getScore());
    this.model7.move(27, 20, 27, 18);
    this.model7.move(29, 20, 27, 20);
    this.model7.move(27, 17, 27, 19);
    this.model7.move(27, 20, 27, 18);
    assertEquals(736, this.model7.getScore());
  }

  ///////////////////////////////// Testing getBoardSize ///////////////////////////////////
  @Test
  public void testGetBoardSize() {
    assertEquals(7, this.model.getBoardSize());
    assertEquals(7, this.model1.getBoardSize());
    assertEquals(7, this.model2.getBoardSize());
    assertEquals(7, this.model3.getBoardSize());
    assertEquals(13, this.model4.getBoardSize());
    assertEquals(19, this.model5.getBoardSize());
    assertEquals(25, this.model6.getBoardSize());
    assertEquals(31, this.model7.getBoardSize());
  }

  ///////////////////////////////// Testing getSlotAt ///////////////////////////////////
  // when arm thickness is 3

  @Test(expected = IllegalArgumentException.class)
  public void testBothColGreaterThanBoardRowLessThanZero() {
    this.model.getSlotAt(-1, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowGreaterThanBoardColLessThanZero() {
    this.model.getSlotAt(10, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColGreaterThanBoard() {
    this.model.getSlotAt(10, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColLessThanZero() {
    this.model.getSlotAt(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowGreaterThanBoard() {
    this.model.getSlotAt(3, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowLessThanZero() {
    this.model.getSlotAt(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnLessThanZero() {
    this.model.getSlotAt(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnGreaterThanBoard() {
    this.model.getSlotAt(0, 7);
  }

  // when arm thickness is 5

  @Test(expected = IllegalArgumentException.class)
  public void testBothColGreaterThanBoardRowLessThanZeroA5() {
    this.model4.getSlotAt(-1, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowGreaterThanBoardColLessThanZeroA5() {
    this.model4.getSlotAt(10, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColGreaterThanBoardA5() {
    this.model4.getSlotAt(22, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColLessThanZeroA5() {
    this.model4.getSlotAt(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowGreaterThanBoardA5() {
    this.model4.getSlotAt(3, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowLessThanZeroA5() {
    this.model4.getSlotAt(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnLessThanZeroA5() {
    this.model4.getSlotAt(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnGreaterThanBoardA5() {
    this.model4.getSlotAt(0, 17);
  }

  // when arm thickness is 9

  @Test(expected = IllegalArgumentException.class)
  public void testBothColGreaterThanBoardRowLessThanZeroA9() {
    this.model6.getSlotAt(-1, 27);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowGreaterThanBoardColLessThanZeroA9() {
    this.model6.getSlotAt(26, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColGreaterThanBoardA9() {
    this.model6.getSlotAt(29, 29);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBothRowColLessThanZeroA9() {
    this.model6.getSlotAt(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowGreaterThanBoardA9() {
    this.model6.getSlotAt(25, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRowLessThanZeroA9() {
    this.model6.getSlotAt(-3, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnLessThanZeroA9() {
    this.model6.getSlotAt(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testColumnGreaterThanBoardA9() {
    this.model6.getSlotAt(0, 400);
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(0, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(1, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(5, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(5, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(5, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(5, 6));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(6, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(6, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(6, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(6, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model.getSlotAt(6, 6));

    this.model.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model1.getSlotAt(4, 5));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model4.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model4.getSlotAt(6, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model4.getSlotAt(5, 5));
    this.model4.move(7, 5, 5, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model4.getSlotAt(7, 5));
    this.model4.move(7, 7, 7, 5);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model4.getSlotAt(7, 5));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model7.getSlotAt(0, 15));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model7.getSlotAt(27, 18));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model7.getSlotAt(27, 21));
    this.model7.move(27, 16, 27, 18);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model7.getSlotAt(27, 18));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model7.getSlotAt(27, 16));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model7.getSlotAt(27, 17));
  }

  ///////////////////////////////// Testing Move ///////////////////////////////////
  // note: move has been tested extensively throughout this test class

  // moving to same space
  @Test(expected = IllegalArgumentException.class)
  public void testMovingToSameSpace() {
    this.model.move(5, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMovingIrrelevantSanityCheck() {
    this.model.move(3, 1, 3, 1000);
  }

  // moving from one end of the board to the other
  @Test(expected = IllegalArgumentException.class)
  public void testMovingIrrelevant() {
    this.model.move(0, 2, 4, 4);
  }

  // On board of arm length 3 and center 1,4, should not be able to move from (1,2) to (1,3)
  @Test(expected = IllegalArgumentException.class)
  public void testMoveNoMarbleBetweenRow() {
    this.model8.move(1, 2, 1, 3);
  }

  // On board of arm length 3 and center, should not be able to move from (1,2) to (2,2)
  @Test(expected = IllegalArgumentException.class)
  public void testMoveNoMarbleBetweenCol() {
    this.model.move(1, 2, 2, 2);
  }

  // occupied position
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOccupiedPos() {
    this.model9.move(1, 3, 3, 3);
  }

  // On board of arm length 3 and empty cell (1,4), should not be able to move from (1,3) to (1,2)
  @Test(expected = IllegalArgumentException.class)
  public void testMoveToInvalid() {
    this.model8.move(1, 3, 1, 1);
  }


  // On board of arm length 3 and center empty cell, should not be able to move from (3,0) to (3,3)
  @Test(expected = IllegalArgumentException.class)
  public void testMoveMultipleMarblesBetween() {
    this.model.move(3, 0, 3, 3);
  }

  // from does not exist
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromDoesNotExist() {
    this.model.move(0, 1, 0, 2);
  }

  // from does not have a marble
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromNoMarble() {
    this.model.move(3, 3, 5, 3);
  }

  // marble jumps over an empty slot
  @Test(expected = IllegalArgumentException.class)
  public void testMoveJumpOverEmpty() {
    this.model.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameIsOverCannotMove() {
    assertFalse(this.model.isGameOver());
    this.model.move(3, 1, 3, 3);
    this.model.move(3, 4, 3, 2);
    this.model.move(3, 6, 3, 4);
    this.model.move(1, 1, 3, 1);
    this.model.move(3, 1, 3, 3);
    this.model.move(3, 3, 3, 5);
    this.model.move(1, 3, 1, 1);
    this.model.move(1, 5, 1, 3);
    this.model.move(1, 3, 3, 3);
    this.model.move(2, 5, 2, 3);
    this.model.move(2, 2, 2, 4);
    this.model.move(5, 2, 3, 2);
    this.model.move(3, 2, 3, 4);
    this.model.move(3, 4, 3, 6);
    this.model.move(4, 0, 4, 2);
    this.model.move(5, 4, 5, 2);
    this.model.move(5, 1, 5, 3);
    this.model.move(5, 3, 3, 3);
    this.model.move(4, 5, 4, 3);
    this.model.move(4, 3, 4, 1);
    this.model.move(2, 0, 4, 0);
    this.model.move(4, 0, 4, 2);
    assertTrue(this.model.isGameOver());
    this.model.move(0, 3, 3, 3);
  }

  @Test
  public void testMove() {
    // check every position before moving on a classic board with empty middle
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 3 && j == 3) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model.getSlotAt(i, j));
        } else if ((i == 0 || i == 6) && (j <= 1 || j >= 5)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                  this.model.getSlotAt(i, j));
        } else if ((i == 1 || i == 5) && (j == 0 || j == 6)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                  this.model.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble,
                  this.model.getSlotAt(i, j));
        }
      }
    }
    // move twice
    this.model.move(3, 1, 3, 3);
    this.model.move(3, 4, 3, 2);
    // check slots again
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 3 && j == 1) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model.getSlotAt(i, j));
        } else if (i == 3 && j == 3) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model.getSlotAt(i, j));
        } else if (i == 3 && j == 4) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model.getSlotAt(i, j));
        } else if ((i == 0 || i == 6) && (j <= 1 || j >= 5)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                  this.model.getSlotAt(i, j));
        } else if ((i == 1 || i == 5) && (j == 0 || j == 6)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
                  this.model.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble,
                  this.model.getSlotAt(i, j));
        }
      }
    }

    // board of arm thickness 5, check slots before moving
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 13; j++) {
        if (i == 5 && j == 5) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model4.getSlotAt(i, j));
        } else if ((i == 0 || i == 12) && (j <= 3 || j >= 9)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 1 || i == 11) && (j <= 2 || j >= 10)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 2 || i == 10) && (j <= 1 || j >= 11)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 3 || i == 9) && (j == 0 || j == 12)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble,
                  this.model4.getSlotAt(i, j));
        }
      }
    }
    // move
    this.model4.move(7, 5, 5, 5);
    // check slots again
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 13; j++) {
        if (i == 6 && j == 5) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model4.getSlotAt(i, j));
        } else if (i == 7 && j == 5) {
          assertEquals(MarbleSolitaireModelState.SlotState.Empty,
                  this.model4.getSlotAt(i, j));
        } else if ((i == 0 || i == 12) && (j <= 3 || j >= 9)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 1 || i == 11) && (j <= 2 || j >= 10)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 2 || i == 10) && (j <= 1 || j >= 11)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else if ((i == 3 || i == 9) && (j == 0 || j == 12)) {
          assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.model4.getSlotAt(i, j));
        } else {
          assertEquals(MarbleSolitaireModelState.SlotState.Marble,
                  this.model4.getSlotAt(i, j));
        }
      }
    }
  }


  @Test
  public void testMoveTopLeftTriangle() {
    this.model = new EuropeanSolitaireModel(5, 2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,3));
    this.model.move(4,3,2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(4,3));
  }

  @Test
  public void testMoveTopLeftTriangle2() {
    this.model = new EuropeanSolitaireModel(5, 2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,3));
    this.model.move(2,5,2,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,5));
  }

  @Test
  public void testMoveTopRightTriangle() {
    this.model = new EuropeanSolitaireModel(5, 2,8);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,8));
    this.model.move(2,10,2,8);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,10));
  }

  @Test
  public void testMoveBottomLeftTriangle() {
    this.model = new EuropeanSolitaireModel(5, 9,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(9,3));
    this.model.move(9,1,9,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(9,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(9,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(9, 2));
  }

  @Test
  public void testMoveBottomRightTriangle() {
    this.model = new EuropeanSolitaireModel(5, 10, 10);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(10,10));
    this.model.move(8,10,10,10);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(9,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(8,10));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(9, 10));
  }

  @Test
  public void testMoveBottomRightTriangle2() {
    this.model = new EuropeanSolitaireModel(5, 10, 10);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(10,10));
    this.model.move(10,8,10,10);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(10,10));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(10,8));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(10,9));
  }


  ///////////////////////////////// Testing isGameOver ///////////////////////////////////

  @Test(expected = IllegalArgumentException.class)
  public void testIsGameOverInvalidMove() {
    assertFalse(this.model4.isGameOver());
    this.model4.move(0, 4, 0, 5);
    assertFalse(this.model4.isGameOver());
  }

  @Test
  public void testIsGameOverFalseThenTrue() {
    assertFalse(this.model.isGameOver());
    this.model.move(3, 1, 3, 3);
    this.model.move(3, 4, 3, 2);
    this.model.move(3, 6, 3, 4);
    this.model.move(1, 1, 3, 1);
    this.model.move(3, 1, 3, 3);
    this.model.move(3, 3, 3, 5);
    this.model.move(1, 3, 1, 1);
    this.model.move(1, 5, 1, 3);
    this.model.move(1, 3, 3, 3);
    this.model.move(2, 5, 2, 3);
    this.model.move(2, 2, 2, 4);
    this.model.move(5, 2, 3, 2);
    this.model.move(3, 2, 3, 4);
    this.model.move(3, 4, 3, 6);
    this.model.move(4, 0, 4, 2);
    this.model.move(5, 4, 5, 2);
    this.model.move(5, 1, 5, 3);
    this.model.move(5, 3, 3, 3);
    this.model.move(4, 5, 4, 3);
    this.model.move(4, 3, 4, 1);
    this.model.move(2, 0, 4, 0);
    this.model.move(4, 0, 4, 2);
    assertTrue(this.model.isGameOver());
  }

}