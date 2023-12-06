package at.raphael.boundary.requests;

import at.raphael.entity.Fighter;
import at.raphael.entity.RosterDay;

import java.util.List;

public class RosterRequest {
    public List<RosterDay> planDetails;
    public List<Fighter> fighterDetails;
}
