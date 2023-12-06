package at.raphael.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RosterDay extends PanacheEntity {
    public LocalDate date;

    public RosterDayType type;

    @OneToMany
    public List<Fighter> onDutyDay;

    @OneToMany
    public List<Fighter> onDutyNight;

    @OneToMany
    public List<Fighter> onDutyLesson;

    public boolean toFewFighters;

    public RosterDay(LocalDate date, RosterDayType type) {
        this.date = date;
        this.type = type;
        this.onDutyDay = new ArrayList<>();
        this.onDutyNight = new ArrayList<>();
        this.onDutyLesson = new ArrayList<>();
    }

    public RosterDay() {
        this.onDutyDay = new ArrayList<>();
        this.onDutyNight = new ArrayList<>();
        this.onDutyLesson = new ArrayList<>();
    }
}
