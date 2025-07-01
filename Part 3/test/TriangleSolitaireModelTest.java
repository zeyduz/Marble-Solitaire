import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Testing Triangle Solitaire Model.
 */
public class TriangleSolitaireModelTest {

  private TriangleSolitaireModel model;


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSizeConstructor1Arg() {
    this.model = new TriangleSolitaireModel(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSizeConstructor3Arg() {
    this.model = new TriangleSolitaireModel(0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmptyConstructor3Arg() {
    this.model = new TriangleSolitaireModel(7, -1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmptyConstructor3Arg2() {
    this.model = new TriangleSolitaireModel(7, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSizeConstructor2() {
    this.model = new TriangleSolitaireModel(-6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorWith2ArgsInvalidPos() {
    this.model = new TriangleSolitaireModel(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorWith2ArgsInvalidPos2() {
    this.model = new TriangleSolitaireModel(0, 2);
  }

  @Test
  public void testValid3ArgConstructor() {
    this.model = new TriangleSolitaireModel(3,1,1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,2));





  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleSolitaireMove2() {
    this.model.move(2, 1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromDNE() {
    this.model.move(0,1,2,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveToDNE() {
    this.model.move(0,0,1,2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromNoMarble() {
    this.model.move(0,0,2,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveJumpOverEmpty() {
    this.model = new TriangleSolitaireModel(2,0);
    this.model.move(1,0, 3, 0);
  }

  @Test
  public void testTriangleSolitaireMove3() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1, 0));
    this.model.move(2, 0, 0, 0); // diagonal up right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(1, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 1));
    this.model.move(2, 2, 2, 0); // right to left side
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 3));
    this.model.move(4, 4, 2, 2); // diagonal up right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 2));
    this.model.move(4, 3, 2, 1); // diagonal up left
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 1));
    this.model.move(3, 0, 3, 2); // left to right side
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3,2));
    this.model.move(2, 1, 4, 3); // diagonal down right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,2));
    this.model.move(1, 1, 3, 3); // diagonal down right
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3,2));

  }

  @Test
  public void testMoveDiagonalDownLeft() {
    this.model = new TriangleSolitaireModel(2, 0);

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(3,0));
    this.model.move(4, 0, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.model.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.model.getSlotAt(3,0));

  }

  @Test
  public void testGetScore() {
    assertEquals(14, this.model.getScore());
    this.model.move(2, 0, 0, 0); // diagonal up right
    this.model.move(2, 2, 2, 0); // right to left side
    this.model.move(4, 4, 2, 2); // diagonal up right
    assertEquals(11, this.model.getScore());
    this.model.move(4, 3, 2, 1); // diagonal up left
    this.model.move(3, 0, 3, 2); // left to right side
    this.model.move(2, 1, 4, 3); // diagonal down right
    this.model.move(1, 1, 3, 3); // diagonal down right
    assertEquals(7, this.model.getScore());
  }

  @Test
  public void testGetScoreBiggerTriangleCustomEmpty() {
    TriangleSolitaireModel model2 = new TriangleSolitaireModel(7, 4, 2);
    assertEquals(27, model2.getScore());
    model2.move(2,2,4,2);
    assertEquals(26, model2.getScore());
    model2.move(2, 0, 2, 2);
    model2.move(4,2,2,0);
    assertEquals(24, model2.getScore());
  }

  @Test
  public void testGameOverFalse() {
    assertFalse(this.model.isGameOver());
    this.model.move(2,0,0,0);
    this.model.move(2,2,2,0);
    this.model.move(4,2,2,2);
    this.model.move(3,0,3,2);
    this.model.move(3,3,3,1);
    this.model.move(4,0,4,2);
    this.model.move(4,3,4,1);
    this.model.move(1,1,3,3);
    this.model.move(4,1,2,1);
    this.model.move(2,0,2,2);
    this.model.move(3,3,1,1);
    assertFalse(this.model.isGameOver());
  }

  @Test
  public void testGameOverTrue() {
    this.model = new TriangleSolitaireModel(3);
    assertFalse(this.model.isGameOver());
    this.model.move(2,2,0,0);
    this.model.move(2, 0, 2,2);
    this.model.move(0,0,2,0);
    this.model.move(2,0,0,0);
    assertTrue(this.model.isGameOver());
  }


}
