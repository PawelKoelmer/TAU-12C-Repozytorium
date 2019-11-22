package baza.slodycz.api.domain;

import java.time.Clock;
import java.time.LocalDateTime;

public class Slodycz {

    private int id;
    private String nazwa;
    private String opis;
    private Clock clock = Clock.systemDefaultZone();

    private LocalDateTime createTimestamp;
    private LocalDateTime updateTimestamp;
    private LocalDateTime readTimestamp;



    public Slodycz(int i, String nazwa, String opis) {
        this.id =i;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Slodycz(String name, String description){
        this.nazwa = name;
        this.opis = description;
    }

    public Slodycz() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp() {
        this.createTimestamp = LocalDateTime.now(clock);
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp() {
        this.updateTimestamp = LocalDateTime.now(clock);
    }

    public LocalDateTime getReadTimestamp() {
        return readTimestamp;
    }

    public void setReadTimestamp() {
        this.readTimestamp = LocalDateTime.now(clock);
    }
}
