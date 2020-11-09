
package sklepinternetowy;


public class SklepInternetowy {

    public static void main(String[] args) {

        // tworzenie sklepu
        storehouse store1 = new storehouse();
        // tworzenie towaru
        Towar exam= new Towar("Chleb", (float)2.90);
        Towar exam2 = new Towar("Kajzerka",(float) 0.50);
        Towar exam3 = new Towar("Bagieta",1);

        System.out.println(exam);

        // powiązanie obiektów towarów z obiektem magazynu
        /*
        podpinanie towaru do kolejki odbywa się wewnątrz metody add_storehouse
        tworzona jest tam za każdym razem kolejna instancja klasy position, to której wpisywana jest ilość
        i podpinany towar (z nazwą i ceną)
         */
        store1.add_storehouse(exam, 10);
        store1.add_storehouse(exam2, 20);
        store1.add_storehouse(exam3, 5);

        // tworzymy koszyk
        Basket basket1 = new Basket(store1); // podajemy do konstruktora koszyka sklep jako parametr
        // wyszukujemy pozycje z towarem o danej nazwie
        position position_to_add_to_basket = store1.find_by_name("Bagieta");//szuka obiektu w kolejce
        // see() może zwrócić null, jeżeli nie znajdzie towaru o danej nazwie w magazynie
        if (null != position_to_add_to_basket) {
            System.out.println(position_to_add_to_basket.towar.getName());
            // dodajemy do koszyka 3 sztuki (zostają 2)
            basket1.add_Basket( position_to_add_to_basket, 3);
            // próba dodania kolejnych trzech (są tylko 2) skutkuje komunikatem o niepowodzeniu - brak zmian w koszyku i magazynie
            basket1.add_Basket( position_to_add_to_basket, 3);///ile dodajemy do koszyka
        } else {
            System.out.println("nie znaleziono towaru");
        }

        position_to_add_to_basket = store1.find_by_name("Chleb");//szuka obiektu w kolejce
        if (null != position_to_add_to_basket) {
            System.out.println(position_to_add_to_basket.towar.getName());
            basket1.add_Basket( position_to_add_to_basket, 1);///ile dodajemy do koszyka
        } else {
            System.out.println("nie znaleziono towaru");
        }
        basket1.pozycjeKoszyka();
        basket1.zaplac();
        basket1.pozycjeKoszyka();

        //znalezienie pozycji do usunięcia po nazwie
        position pos_to_remove = store1.find_by_name("Bagieta");
        //usunięcie pozycji
        store1.remove_from_storehouse(pos_to_remove);

        store1.pozycjeSklepu();

        // zmiana ceny jest możliwa, bo price jest public
        exam.setPrice((float)2.70);
        // zmiana ilości jest możliwa, bo quantity jest public
        position pos_to_increase_quantity = store1.find_by_name("Chleb");
        pos_to_increase_quantity.quantity += 10;

        basket1.add_store_position_to_Basket(2, 2);
        basket1.pozycjeKoszyka();

        store1.pozycjeSklepu();
    }

}
