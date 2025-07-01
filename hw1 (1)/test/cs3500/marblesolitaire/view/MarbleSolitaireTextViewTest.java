package cs3500.marblesolitaire.view;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for testing view methods.
 */
public class MarbleSolitaireTextViewTest {

  @Test
  public void testToString() {

    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel();
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(0, 2);
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(5, 5, 5);
    MarbleSolitaireModel model5 = new EnglishSolitaireModel(0, 4);
    MarbleSolitaireModel model6 = new EnglishSolitaireModel(4, 4);
    MarbleSolitaireModel model7 = new EnglishSolitaireModel(7);
    MarbleSolitaireModel model8 = new EnglishSolitaireModel(9, 12, 5);
    MarbleSolitaireModel model9 = new EnglishSolitaireModel(11, 27, 18);

    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model3);
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(model4);
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(model5);
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(model6);
    MarbleSolitaireView view7 = new MarbleSolitaireTextView(model7);
    MarbleSolitaireView view8 = new MarbleSolitaireTextView(model8);
    MarbleSolitaireView view9 = new MarbleSolitaireTextView(model9);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view.toString());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O _ O\n"
            + "    O O O\n"
            + "    O O O", view1.toString());

    // arm length 3 and empty slot at (0,2)
    assertEquals("    _ O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view3.toString());

    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", view4.toString());

    // arm length 3 and empty slot at (0,4) expected
    assertEquals("    O O _\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", view5.toString());

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ O O\n"
            + "    O O O\n"
            + "    O O O", view6.toString());

    assertEquals("            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O _ O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O\n"
            + "            O O O O O O O", view7.toString());

    assertEquals("                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O _ O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O", view8.toString());

    assertEquals("                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O", view9.toString());

    model9.move(29, 18, 27, 18);

    assertEquals("                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O O O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O _ O O\n"
            + "                    O O O O O O O O O O O", view9.toString());


    // arm length 3 and empty slot at (2,6)
    MarbleSolitaireModel m = new EnglishSolitaireModel(2, 6);
    MarbleSolitaireTextView t = new MarbleSolitaireTextView(m);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O _\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", t.toString());


  }
}