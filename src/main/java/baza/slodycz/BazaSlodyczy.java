package baza.slodycz;

import baza.slodycz.api.domain.Slodycz;

import java.util.ArrayList;
import java.util.List;


public class BazaSlodyczy implements BazaSlodyczyService{


    private List<Slodycz> slodycze = new ArrayList();
    Slodycz slodycz;

    public List<Slodycz> getAll() {
        for(Slodycz x : slodycze){
            x.setReadTimestamp();
        }
        return slodycze;
    }

    @Override
    public Slodycz getSingle(int id) {
        slodycz = slodycze.stream().filter(s->s.getId() ==id).findAny().orElse(null);
        slodycz.setReadTimestamp();
        return slodycz ;
    }

    public Slodycz getSingle_byName(String name) {
        slodycz = slodycze.stream().filter(s -> s.getNazwa().equals(name)).findAny().orElse(null);
        slodycz.setReadTimestamp();
        return slodycz;
    }

    @Override
    public void insert(Slodycz slodycz) {
        slodycz.setCreateTimestamp();
        slodycze.add(slodycz);

    }
    @Override
    public void rename(int id, String name) {
        slodycz = getSingle(id);
        slodycz.setUpdateTimestamp();
        slodycz.setNazwa(name);
    }

    @Override
    public void delete(int id) {
        for (Slodycz x: slodycze) {
            if(x.getId() == id){
                slodycz = x;
                break;
            }
        }
        slodycze.remove(slodycz);
    }
    @Override
    public void changeId(int id, int newid) {
        slodycz = getSingle(id);
        slodycz.setUpdateTimestamp();
        slodycz.setId(newid);
    }
    @Override
    public void changeDescription(int id, String newOpis) {
        slodycz = getSingle(id);
        slodycz.setUpdateTimestamp();
        slodycz.setOpis(newOpis);
    }

    public Slodycz getSingle_byDescription(String description) {
        slodycz = slodycze.stream().filter(s -> s.getOpis().equals(description)).findAny().orElse(null);
        slodycz.setReadTimestamp();
        return slodycz;
    }
}
