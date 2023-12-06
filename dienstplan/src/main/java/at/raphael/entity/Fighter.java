package at.raphael.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Fighter extends PanacheEntity {

    public int fId;
    public String name;

    public List<LocalDate> freeDays;

    public int cntDays;
    public int cntNights;


    public Fighter(int fId, String name, List<LocalDate> freeDays) {
        this.name = name;
        this.freeDays = freeDays;
        this.fId = fId;
        cntDays = 0;
        cntNights = 0;
    }

    public Fighter() {
        cntDays = 0;
        cntNights = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return Objects.equals(fId, fighter.fId);
    }


    public int getCntDays() {
        return cntDays;
    }

    public int getCntNights() {
        return cntNights;
    }
}
