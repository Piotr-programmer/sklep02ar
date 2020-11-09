package sklepinternetowy;

import java.util.ArrayList;

public class Basket {
    //    private Towar first;
    private ArrayList<position> lista_towarow; // deklarujemy lista_towarow - to jest wskaźnik na ArrayList<position>
    private storehouse store;

    public Basket(storehouse s){ // podany sklep zostaje zapisany jako prywatne pole, aby z tego sklepu kożystać przy dodawaniu do koszyka
        this.store = s;
        lista_towarow = new ArrayList<position>();
    }

    public void add_Basket(position a, int quantity) {
        // co jeśli towar już jest w koszyku? -> zwiększamy ilość a nie dodajemy pozycje

        if(a.quantity < quantity) {
            System.out.println("Nie moge dodado koszyka "+ quantity+" towaru , w sklepie jest tylko: "+a.quantity);
            return;
        }

        position new_position = new position();
        new_position.quantity = quantity;
        a.quantity -= quantity;

        new_position.towar = a.towar;

        lista_towarow.add(new_position);
        System.out.println("Dodano do koszyka");
    }

    public void add_store_position_to_Basket(int pozycja_ze_sklepu , int quantity) {
        pozycja_ze_sklepu--;

        if(pozycja_ze_sklepu < 1) {
            System.out.println("nie ma pozycji o takim numerze");
            return;
        }

        if(store.lista_towarow_size() <= pozycja_ze_sklepu) {
            System.out.println("nie ma pozycji o takim numerze");
            return;
        }

        position store_position = store.get_from_lista_towarow(pozycja_ze_sklepu);
        if(store_position.quantity < quantity) {
            System.out.println("Nie moge dodado koszyka "+ quantity+" towaru , w sklepie jest tylko: "+store_position.quantity);
            return;
        }

        position new_position = new position();
        new_position.quantity = quantity;
        new_position.towar = store_position.towar;
        lista_towarow.add(new_position);
        store_position.quantity -= quantity;
        System.out.println("Dodano do koszyka");
    }

    /*6. Sklep internetowy Aktorzy: użytkownik, administrator; Zakres obowiązków:
    Użytkownik: wyszukanie i wybór z listy towarów w magazynie, dodanie do koszyka, zapłata;
    Administrator: obsługa listy towarów w magazynie (dodawanie i usuwanie towarów do listy). */
    public void pozycjeKoszyka (){
        float sum = (float)0;
        System.out.println("Koszyk zawiera: ");
        int index = 1;
        for (position current_pos: lista_towarow) {
            sum += (float)(current_pos.quantity * current_pos.towar.getPrice());
            System.out.println(index++ + ". " + current_pos.towar.getName() +" cena: " + current_pos.towar.getPrice() +" ilosc: "+ current_pos.quantity);
        }
        System.out.println("Suma do zaplaty: " + sum);
    }

    public void oproznij() {
        lista_towarow.clear();
    }

    public void zaplac() {
        if( 0 == lista_towarow.size() ) {
            System.out.println("Koszyk jest pusty!");
            return;
        }

        float sum = (float)0;
        for (position current_pos: lista_towarow) {
            sum += (float)(current_pos.quantity * current_pos.towar.getPrice());
        }
        System.out.println("Zaplacono laczna kwote: " + sum);
        this.oproznij();
    }
}
