Втора лабораториска вежба по Софтверско инженерство

Ања Стевковска, бр. на индекс 223114

2.Control Flow Graph 


3.Цикломатската комплексност

Цикломатската комплексност на дадениот код може да се пресмета со формулата:

V(G)=E-N+2P

Каде што:
V(G) е цикломатската комплексност
E е бројот на ребра во CFG
N е бројот на јазли во CFG
P е бројот на компоненти на поврзаниост во CFG

Ги имаме следните блокови:
- Почетен блок (Start)
- Условниот блок за проверка на allItems
- Циклусниот блок за секој предмет
- Условниот блок за проверка на name
- Условниот блок за проверка на barcode
- Циклусниот блок за секој карактер во barcode
- Условниот блок за проверка на валидност на карактерот во barcode
- Условниот блок за пресметка на сумата со попуст
- Условниот блок за пресметка на сумата без попуст
- Условниот блок за дополнителен попуст
- Крајен блок

Број на ребра (E): 27
Број на јазли (N): 15
Број на компоненти на поврзаниост (P): 1 (целиот граф е една компонента)

Можеме да ги пресметаме:
V(G)=27−15+2×1=14

4.Every Branch критериум


public class SILab2Test {

    // Тест случај кога allItems е null
    @Test(expected = RuntimeException.class)
    public void testCheckCart_AllItemsNull() {
        SILab2.checkCart(null, 100);
    }

    // Тест случај кога името на предметот е null
    @Test
    public void testCheckCart_ItemNameIsNull() {
        Item item = new Item(null, "34527", 150, 0.1f);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertTrue(SILab2.checkCart(items, 200));
    }

    // Тест случај кога barcode на предметот е валиден
    @Test
    public void testCheckCart_ValidBarcode() {
        Item item = new Item("Item1", "34527", 150, 0.1f);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertTrue(SILab2.checkCart(items, 200));
    }

    // Тест случај кога barcode на предметот е null
    @Test(expected = RuntimeException.class)
    public void testCheckCart_ItemBarcodeIsNull() {
        Item item = new Item("Item1", null, 150, 0.1f);
        List<Item> items = new ArrayList<>();
        items.add(item);
        SILab2.checkCart(items, 200);
    }

    // Тест случај кога barcode на предметот содржи невалиден карактер
    @Test(expected = RuntimeException.class)
    public void testCheckCart_InvalidBarcodeCharacter() {
        Item item = new Item("Item1", "12@*45", 150, 0.1f);
        List<Item> items = new ArrayList<>();
        items.add(item);
        SILab2.checkCart(items, 200);
    }

    // Тест случај кога price > 300, има попуст и првиот карактер во barcode е '0'
    @Test
    public void testCheckCart_PriceDiscountBarcode() {
        Item item = new Item("Item1", "01456", 400, 0.2f);
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertTrue(SILab2.checkCart(items, 350));
    }

    // Тест случај кога price <= 300 или нема попуст или првиот карактер во barcode не е '0'
    @Test
    public void testCheckCart_OtherCases() {
        Item item1 = new Item("Item1", "34527", 200, 0.1f);
        Item item2 = new Item("Item2", "567879", 400, 0);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        assertTrue(SILab2.checkCart(items, 500));
    } }

5.Multiple Condition критериум


public class SILab2MultipleConditionTest {


    // Тест случај кога сите услови се исполнети
    @Test
    public void testCheckCart_AllConditionsTrue() {
        Item item = new Item("Item1", "0123984", 400, 0.2f);
        assertTrue(SILab2.checkCart(List.of(item), 350));
    }

    // Тест случај кога price е помал од 300
    @Test
    public void testCheckCart_PriceLessThan300() {
        Item item = new Item("Item1", "07634", 200, 0.1f);
        assertFalse(SILab2.checkCart(List.of(item), 200));
    }

    // Тест случај кога discount е 0
    @Test
    public void testCheckCart_DiscountIsZero() {
        Item item = new Item("Item1", "08734", 400, 0);
        assertFalse(SILab2.checkCart(List.of(item), 350));
    }

    // Тест случај кога првиот карактер од barcode не е '0'
    @Test
    public void testCheckCart_FirstCharOfBarcodeNotZero() {
        Item item = new Item("Item1", "18765", 400, 0.2f);
        assertFalse(SILab2.checkCart(List.of(item), 350));
    }

    // Тест случај кога сите услови не се исполнети
    @Test
    public void testCheckCart_NoConditionsTrue() {
        Item item = new Item("Item1", "172945", 200, 0);
        assertFalse(SILab2.checkCart(List.of(item), 200));
    } }

6.Објаснување на напишаните unit tests

Every Branch критериум

1.Тест случај кога allItems е null

-Проверува како функцијата се однесува кога параметарот allItems е null. Очекуваме да фрли RuntimeException поради невалиден влез.

2.Тест случај кога името на предметот е null

-Проверува како функцијата се однесува кога името на предметот е null. Во овој случај, не очекуваме да фрли исклучок и очекуваме да врати true, бидејќи оваа ситуација е поправена во кодот (името на предметот е поставено на "unknown").

3.Тест случај кога barcode на предметот е валиден

-Проверува како функцијата се однесува кога barcode на предметот е валиден (не е null и не содржи невалидни карактери). Очекуваме да врати true.

4.Тест случај кога barcode на предметот е null

-Проверува како функцијата се однесува кога barcode на предметот е null. Очекуваме да фрли RuntimeException поради невалиден влез.

5.Тест случај кога barcode на предметот содржи невалиден карактер

-Проверува како функцијата се однесува кога barcode на предметот содржи невалиден карактер (карактер кој не е цифра). Очекуваме да фрли RuntimeException поради невалиден карактер во barcode.

6.Тест случај кога price > 300, има попуст и првиот карактер во barcode е '0'

-Очекуваме да врати true, бидејќи сите услови за поголемо променливата sum се исполнети.

7.Тест случај кога price <= 300 или нема попуст или првиот карактер во barcode не е '0'

-Очекуваме да врати true, бидејќи нема ниту еден од условите за намалување на променливата sum да биде исполнет.

Multiple Condition критериум

1.Тест случај кога сите услови се исполнети

-Во овој случај, цената е поголема од 300, попустот е поголем од 0, а првиот карактер од barcode е '0'. Очекуваме функцијата да врати true.

2.Тест случај кога price е помал од 300

-Очекуваме функцијата да врати false, бидејќи првиот услов не е исполнет.

3.Тест случај кога discount е 0

-Очекуваме функцијата да врати false, бидејќи вториот услов не е исполнет.

4.Тест случај кога првиот карактер од barcode не е '0'

-Очекуваме функцијата да врати false, бидејќи третиот услов не е исполнет.

5.Тест случај кога сите услови не се исполнети

-Очекуваме функцијата да врати false дека ништо не е исполнето.


