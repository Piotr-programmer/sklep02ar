package sklepinternetowy;

import java.util.ArrayList;

public class storehouse {
    private ArrayList<position> lista_towarow; // deklarujemy lista_towarow - to jest wskaźnik na ArrayList<position>

    public storehouse()
    {
        lista_towarow = new ArrayList<position>(); // tworzymy objekt ArrayList<position i podpisujemy pod zadeklarowany wskaźnik
    }

    public int lista_towarow_size() {
        return lista_towarow.size();
    }

    public position get_from_lista_towarow(int index) { // zwracamy element listy towarów o nr index
        if(index >= lista_towarow.size()) {
            System.out.println("W sklepie nie ma tylu pozycji");
            return null;
        }
        return lista_towarow.get(index);
    }

    public void add_storehouse(Towar a, int quantity) {
        position new_position = new position(); // tworzymy pozycje
        new_position.towar = a;
        new_position.quantity = quantity;

        lista_towarow.add(new_position); // dodajemy pozycje

        System.out.println("Dodano do magazynu");
    }

    public void remove_from_storehouse(position pos_to_remove) {
        lista_towarow.remove(pos_to_remove);
    }

    public position find_by_name(String name_to_find) {
        for (position pos_to_find: lista_towarow) {
            if(pos_to_find.towar.getName() == name_to_find) {
                return pos_to_find;
            }
        }

        return null;
    }

    public void pozycjeSklepu (){
        System.out.println("W sklepie jest: ");
        int index = 1;
        for (position current_pos: lista_towarow) {
            System.out.println(index++ + ". " + current_pos.towar.getName() +" cena: " + current_pos.towar.getPrice() +" ilosc: "+ current_pos.quantity);
        }
    }
}

