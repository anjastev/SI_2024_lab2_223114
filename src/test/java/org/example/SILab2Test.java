import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class SILab2Test {
    private List<Item> create(Item...items){
        return new ArrayList<Item>(Arrays.asList(items));
    }
    @Test
    void checkEveryBranch(){
        RuntimeException exc;
        exc = assertThrows(RuntimeException.class, () ->
            SILab2.checkCart(null, 0));
        assertTrue(exc.getMessage().contains("List can' t be null"));

        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));

        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));

        exc = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(create(new Item(" ", null, 40, 0.5f)), 1));
        assertTrue(exc.getMessage().contains("No barcode"));

        assertFalse(SILab2.checkCart(create(new Item(" ", "05897", 2400, 0.5f)), 2));

        exc = assertThrows(RuntimeException.class, ()->
                SILab2.checkCart(create(new Item("Anjas", "285B4", 200, 0.5f)), 1));
        assertTrue(exc.getMessage().contains("Invalid character in item barcode"));


        assertFalse(SILab2.checkCart(create(new Item("Anjas", "2526", 35, -1)), 2));
    }

    @Test
    void checkMultipleCondition(){

        assertTrue(SILab2.checkCart(create(new Item("Anja1", "0583", 280, 0.5f)), 2));
        assertFalse(SILab2.checkCart(create(new Item("Anja1", "7562", 280, 0.5f)), 2));
        assertFalse(SILab2.checkCart(create(new Item("Anja1", "8353", 280, 0.5f)), 2));
        assertFalse(SILab2.checkCart(create(new Item("Anja1", "4646", 28, 0.5f)), 2));


    }
}
