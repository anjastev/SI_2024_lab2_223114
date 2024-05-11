package org.example;

public class SILab2Test {

    @Test
    public void testCheckCart_NullItemList_ThrowsException() {
        List<Item> itemList = null;
        int payment = 100;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(itemList, payment));
    }

    @Test
    public void testCheckCart_EmptyItemList_ReturnsFalse() {
        List<Item> itemList = new ArrayList<>();
        int payment = 100;
        boolean result = SILab2.checkCart(itemList, payment);

        assertFalse(result);
    }
}

