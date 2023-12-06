package at.raphael.repository;

import at.raphael.entity.Fighter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FighterRepository {

    private static List<Fighter> fighters = new ArrayList<>();


    public static void add(Fighter f){
        fighters.add(f);
    }

    public static void editFighter(Fighter f){
        fighters.remove(f);
        fighters.add(f);
    }

    public static void deleteFighter(int fId){
        fighters.remove(new Fighter(fId, "", new ArrayList<>()));
    }

    public static Fighter getFighter(int fId){
        for (Fighter f: fighters) {
            if(Objects.equals(f.fId, fId)){
                return f;
            }
        }
        return null;
    }

    public static List<Fighter> getFighters(){
        return fighters;
    }

    public static void removeAll(){
        fighters = new ArrayList<>();
    }

    /*
    public void add(Fighter f){
        Fighter.persist(f);
    }

    public void edit(Fighter f){

        Fighter edit = Fighter.find("fId", f.fId).firstResult();

        edit.cntNights = f.cntNights;
        edit.cntDays = f.cntDays;
        edit.freeDays = f.freeDays;
        f.name = f.name;

        f.persist(f);
    }
    */

}
