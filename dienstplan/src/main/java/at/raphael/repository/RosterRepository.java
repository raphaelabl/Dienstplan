package at.raphael.repository;

import at.raphael.entity.Fighter;
import at.raphael.entity.RosterDay;
import at.raphael.entity.RosterDayType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class RosterRepository {


    @Inject
    Logger log;

    public List<RosterDay> getRoster(List<RosterDay> monthDetails){

        RosterDay lastDay = new RosterDay();

        for (int i = 0; i < monthDetails.size(); i++) {
            monthDetails.set(i, getAvailableFighters(lastDay, monthDetails.get(i), FighterRepository.getFighters()));
            lastDay = monthDetails.get(i);
        }


        for(Fighter f: FighterRepository.getFighters()) {
            log.info("-------------------------------------");
            log.info(f.cntDays + ":" + f.cntNights);
        }
        
        return monthDetails;
    }

    public RosterDay getAvailableFighters(RosterDay lastDay, RosterDay day, List<Fighter> fighters){

        int neededFighters = 10;

        List<Fighter> available = new ArrayList<>();

        for (Fighter f : fighters) {
            if (!f.freeDays.contains(day.date) && !lastDay.onDutyNight.contains(f)) {
                available.add(f);
                if(neededFighters != 0) {
                    neededFighters--;
                }
            }
        }

        if(available.size() < 10){
            day.toFewFighters = true;
        }


        //region Standard Duty
        if(day.type == RosterDayType.Norm || day.type == RosterDayType.Ausbildung) { // Standard Duty: 6 Day, 4 Night

            available.sort(Comparator.comparingInt(Fighter::getCntNights));

            for(int i = 0; i < 4; i++){

                Fighter tmp = available.get(0);
                day.onDutyNight.add(available.get(0));
                tmp.cntNights ++;
                available.remove(0);
            }

            available.sort(Comparator.comparingInt(Fighter::getCntDays));

            for (int i = 1; i <= 6 - neededFighters; i++) { // Select 6 Day Fighters
                Fighter tmp = available.get(0);
                day.onDutyDay.add(available.get(0));
                tmp.cntDays ++;
                available.remove(0);
            }

        }
        //endregion

        //region Ulf Duty

        if(day.type == RosterDayType.Ulf) {
            day.toFewFighters = false;

            available.sort(Comparator.comparingInt(Fighter::getCntNights));

            for(int i = 0; i < 4; i++){

                Fighter tmp = available.get(0);
                day.onDutyNight.add(available.get(0));
                tmp.cntNights ++;
                available.remove(0);
            }
        }

        //endregion

        //region Ausbildung Duty
        day.toFewFighters = false;

        if(day.type == RosterDayType.Ausbildung) {
            for (Fighter f:fighters) {
                day.onDutyLesson.add(f);
                f.cntDays++;
            }
        }
        //endregion


        return day;
    }


}
