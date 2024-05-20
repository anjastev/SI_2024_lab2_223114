Втора лабораториска вежба по Софтверско инженерство


Ања Стевковска, бр. на индекс 223114


2.Control Flow Graph 

Обоените се предикатни јазли

![Control Flow Graph drawio](https://github.com/anjastev/SI_2024_lab2_223114/assets/135065807/6a86043d-50cf-4a4c-bbd6-8a0083dfa34f)


3.Цикломатската комплексност

Формулата е P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност е 10

4.Every Branch критериум

Прв тест 

AllItems=null; payment=any 

Се фрла исклучок и излегува од програма


Втор тест 

AllItems=[]; payment=0 

Се праќа празна листа и 0


Трет тест 

Allitems=[]; payment=-1 

Се праќа празна листа и негативна вредност за payment


Четврт тест 

AllItems[{name="",barcode=null,price"40",discount="0.5"}], payment=any 

Се праќа еден објект кај што вредноста за barcode е null и името е празен стринг


Петти тест 

AllItems[{name="",barcode="25807",price="2400",discount="0.5"}], payment=2 

Се праќа еден објект со barcode со 0 и цена над 300


Шести тест 

AllItems[{name="Anjas",barcode="285B4",price"200",discount="0.5"}], payment=any 

Се праќа објект со име и barcode кој содржи букви


Седми тест 

AllItems[{name="Anjas",barcode="2526",price"55",discount="-1"}], payment=any 

Се праќа објект со цена помала од 300 и discount негативна вредност


![Screenshot 2024-05-20 163253](https://github.com/anjastev/SI_2024_lab2_223114/assets/135065807/447151a9-6db5-4c32-b5c8-e58f0454276b)



5.Multiple Condition критериум

TTT

price = 280, barcode = 0589, discount = 1 

Сите вредности се точни за сите променливи


TTF

price = 280, discount = 1, barcode = 7562

Имаме точни вредности за цената и дисконтот а неточна за баркодот


TFX

price = 280, discount = 1, barcode = 0589

Точна е вредноста само на цената, неточна е на дисконтот а неважна е на баркодот


FXX

price = 28, discount = 1, barcode = 0589

Неточна е вредноста на цената, а другите две се неважни


6.Објаснување на напишаните unit tests

Every Branch критериум

1.Прв тест

exc = assertThrows(RuntimeException.class, ()->
    SILab2.checkCart(null, 0));
assertTrue(exc.getMessage().contains("List can't be null"));

Овој тест проверува дали се фрла исклучок кога листата на предмети (AllItems) е null и се очекува фрлање на RuntimeException


2.Втор тест 

assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));

Овој тест проверува дали функцијата враќа true кога листата на предмети е празна (AllItems=[]) и payment е 0


3.Трет тест

assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));

Овој тест проверува дали функцијата враќа false кога листата на предмети е празна (AllItems=[]) и payment е негативен


4.Четврт тест

exc = assertThrows(RuntimeException.class, ()->
        SILab2.checkCart(create(new Item(" ", null, 40, 0.5f)), 1));
assertTrue(exc.getMessage().contains("No barcode"));

Овој тест фрла исклучок кога barcode e null и името е празно


5.Петти тест 

assertFalse(SILab2.checkCart(create(new Item(" ", "05897", 2400, 0.5f)), 2));

Овој тест проверува дали враќа false кога barcode е валиден и цената е поголема од 300


6.Шести тест

exc = assertThrows(RuntimeException.class, ()->
        SILab2.checkCart(create(new Item("Anjas", "285B4", 200, 0.5f)), 1));
assertTrue(exc.getMessage().contains("Invalid character in item barcode"));

Овој тест фрла исклучок кога barcode содржи букви/невалидни карактери 


7.Седми тест 

assertFalse(SILab2.checkCart(create(new Item("Anjas", "2526", 35, -1)), 2));

Овој тест проверува дали враќа false кога цената е помаала од 300 и discount има негативна вредност



Multiple Condition критериум

1.ТТТ

assertTrue(SILab2.checkCart(create(new Item("Anja1", "0583", 280, 0.5f)), 2));

Сите вредности се валидни


2.TTF

assertFalse(SILab2.checkCart(create(new Item("Anja1", "7562", 280, 0.5f)), 2));

Точни вредности за цената и дисконтот а неточна за баркодот


3.TFX

assertFalse(SILab2.checkCart(create(new Item("Anja1", "8353", 280, 0.5f)), 2));

Точна е вредноста само на цената, неточна е на дисконтот а неважна е на баркодот


4.FXX

assertFalse(SILab2.checkCart(create(new Item("Anja1", "4646", 28, 0.5f)), 2));

Неточна е вредноста на цената, а другите две се неважни

