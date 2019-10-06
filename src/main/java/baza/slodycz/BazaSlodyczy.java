package baza.slodycz;

import java.util.ArrayList;
import java.util.List;

public class BazaSlodyczy {

    ArrayList<Slodycz> slodycze = new ArrayList();
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
}
