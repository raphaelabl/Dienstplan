package at.raphael.boundary;

import at.raphael.boundary.requests.RosterRequest;
import at.raphael.entity.Fighter;
import at.raphael.entity.RosterDay;
import at.raphael.entity.RosterDayType;
import at.raphael.repository.FighterRepository;
import at.raphael.repository.RosterRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("plan")
public class RosterResource {

    @Inject
    RosterRepository rosterRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPlan(RosterRequest rosterRequest){

        for (Fighter f: rosterRequest.fighterDetails) {
            FighterRepository.add(f);
        }

        return Response.ok(this.rosterRepository.getRoster(rosterRequest.planDetails)).build();
    }

    @GET
    @Path("/dev")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDevPlan(){



        List<RosterDay> planDetails = new ArrayList<>();


        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ausbildung));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));

        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ausbildung));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));

        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ausbildung));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));

        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ausbildung));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Norm));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));
        planDetails.add(new RosterDay(getNextDate(), RosterDayType.Ulf));


        List<LocalDate> raphael = new ArrayList<>();
        raphael.add(LocalDate.now().plusDays(4));
        raphael.add(LocalDate.now().plusDays(10));
        raphael.add(LocalDate.now().plusDays(11));
        raphael.add(LocalDate.now().plusDays(17));

        FighterRepository.add(new Fighter(1, "Raphael Ablinger", raphael));

        List<LocalDate> handel = new ArrayList<>();
        handel.add(LocalDate.now().plusDays(3));
        handel.add(LocalDate.now().plusDays(7));
        handel.add(LocalDate.now().plusDays(10));
        handel.add(LocalDate.now().plusDays(12));

        FighterRepository.add(new Fighter(2, "Christoph Handel", handel));

        List<LocalDate> emil = new ArrayList<>();
        emil.add(LocalDate.now().plusDays(5));
        emil.add(LocalDate.now().plusDays(10));
        emil.add(LocalDate.now().plusDays(23));
        emil.add(LocalDate.now().plusDays(34));
        FighterRepository.add(new Fighter(3, "Emil Kaimberger", emil));

        List<LocalDate> jakob = new ArrayList<>();
        jakob.add(LocalDate.now().plusDays(4));
        jakob.add(LocalDate.now().plusDays(7));
        jakob.add(LocalDate.now().plusDays(23));
        jakob.add(LocalDate.now().plusDays(27));
        FighterRepository.add(new Fighter(4 ,"Jakob Riener", jakob));

        for (int i = 5; i <= 26; i++) {
            FighterRepository.add(new Fighter(i, "Rekr " + i, new ArrayList<>()));
        }

        return Response.ok(this.rosterRepository.getRoster(planDetails)).build();
    }

    private static int plusDays = -6;

    static LocalDate getNextDate(){
        plusDays += 1;
        return LocalDate.now().plusDays(plusDays);
    }

}
