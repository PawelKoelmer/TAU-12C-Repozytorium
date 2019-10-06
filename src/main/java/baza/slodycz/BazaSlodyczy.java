package baza.slodycz;

import java.util.ArrayList;
import java.util.List;

public class BazaSlodyczy {

    private ArrayList<Slodycz> slodycze = new ArrayList();
    Slodycz slodycz;

    public void insert(Slodycz slodycz) {
            slodycze.add(slodycz);
    }

    public List<Slodycz> getAll() {
        return slodycze;
    }

    public Slodycz getSingle(int id) {

        slodycz = slodycze.get(id);

        return slodycz;
    }

    public void renameSlodycz(int id, String name) {
        slodycz =slodycze.get(id);
        slodycz.setNazwa(name);
    }

    public void deleteSlodycz(int id) {
        slodycze.remove(id);
    }
}
