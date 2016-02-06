package decision;

/**
 * Created by mkhanwalkar on 2/5/16.
 */
public class CompleteDecision {

    public static final int MAXMAPPERS = 20 ;


    SpecificDecision specificDecision ;   // common across all the applications .

    GenericDecision[] genericDecisions = new GenericDecision[MAXMAPPERS];

    // this is the object that gets passed to the SM as the object is built .




}
