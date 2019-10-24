package baza.slodycz;

import java.time.LocalDateTime;

public interface BazaSlodyczyService {
    Slodycz getSingle(int id);
    void insert(Slodycz slodycz);
    void rename(int id, String name);
    void delete(int id);
    void changeId(int id, int newid);
    void changeDescription(int i, String newOpis);
}
