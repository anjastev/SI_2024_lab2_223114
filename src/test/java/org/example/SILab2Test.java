import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class SILab2Test {

    @Test
    public void Every_Statement() {

        //null items
        List<Item> allItems = null;
        RuntimeException exc;
        exc = Assertions.assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 100));
        Assertions.assertTrue(exc.getMessage().contains("List can't be null"));

        //bez ime
        List<Item> itemsWithNameNull = Arrays.asList(
                new Item(null, "54353", 50, 0.1F),
                new Item("", "94532", 150, 0.0F)
        );
        Assertions.assertDoesNotThrow(() -> SILab2.checkCart(itemsWithNameNull, 100));
        Assertions.assertFalse(() -> SILab2.checkCart(itemsWithNameNull, 100));

        //null barkod
        List<Item> itemsWithBarcodeNull = Arrays.asList(
                new Item("Item1", null, 50, 0.1F),
                new Item("Item2", "", 150, 0.1F)

        );
        exc = Assertions.assertThrows(RuntimeException.class, () -> SILab2.checkCart(itemsWithBarcodeNull, 100));
        Assertions.assertTrue(ex.getMessage().contains("Enter barcode"));

        //nevaliden barkod
        List<Item> itemsWithInvalidBarcode = Arrays.asList(
                new Item("Item1", "123A45", 50, 0.1F),
                new Item("Item2", "6789B", 150, 0.0F)
        );
        exc = Assertions.assertThrows(RuntimeException.class, () -> SILab2.checkCart(itemsWithInvalidBarcode, 100));
        Assertions.assertTrue(ex.getMessage().contains("Invalid character"));

        //spec diskont
        List<Item> itemsForSpecialDiscount = Arrays.asList(
                new Item("Item1", "78935", 600, 0.1F),
                new Item("Item2", "24532", 300, 0.1F)
        );
        Assertions.assertTrue(SILab2.checkCart(itemsForSpecialDiscount, 900));

    }

    @Test
    public void testSpecialDiscountCondition(){
        List<Item> allItems = Arrays.asList(
        new Item("Item 1", "78935", 600, 0.2f),
        new Item("Item 2", "24532", 300, 0.1f),
        new Item("Item 3", "65345", 500, 0.25f)
        );

        float krajnasuma = (float) ((600*0.2F)-30 + (300*0.1F) + (500*0.25)-30);
        
        Assertions.assertTrue(SILab2.checkCart(allItems,(int)krajnasuma));

    }

}