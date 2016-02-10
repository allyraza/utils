package decision;

/**
 * Created by mkhanwalkar on 2/5/16.
 */
public class CompleteDecision {

    public static final int MAXMAPPERS = 20 ;


    public static final int FRAUDNET = 0;
    public static final int HUNTER = 1;
    public static final int PRECISEID = 2;
    public static final int PROVEID = 3;
    public static final int IDAUTHENTICATE = 4;
    public static final int BANKWIZARD = 5;


    SpecificDecision[]  specificDecision = new SpecificDecision[MAXMAPPERS];   // common across all the applications .

    GenericDecision[] genericDecisions = new GenericDecision[MAXMAPPERS];

    // this is the object that gets passed to the SM as the object is built .




}
