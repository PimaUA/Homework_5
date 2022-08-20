package competitor;

public class Treadmill implements Obstacles {
    int lengthOfTreadmill;

    public Treadmill(int lengthOfTreadmill) {
        this.lengthOfTreadmill = lengthOfTreadmill;
    }

    @Override
    public void overcome(Participant participant) {
        if (participant.maxRunDistance < lengthOfTreadmill) {

            runFailed(participant);
        } else if (participant.maxRunDistance > lengthOfTreadmill) {
            runSuccess(participant);
        }
    }

    //run success case output
    void runSuccess(Participant participant) {
        System.out.println(participant.getClass().getSimpleName() + " " + participant.name
                + " passed treadmill at distance of "
                + lengthOfTreadmill
                + ((lengthOfTreadmill == 1) ? " meter." : " meters."));
    }

    // run failed case output
    void runFailed(Participant participant) {
        System.out.println(participant.getClass().getSimpleName() + " "
                + participant.name + " hasn't passed treadmill "
                + "with distance of "
                + lengthOfTreadmill
                + ((lengthOfTreadmill == 1) ? " meter." : " meters. ")
                + "Passed " + participant.maxRunDistance
                + ((participant.maxRunDistance == 1) ? " meter." : " meters. ")
                + participant.name + " disqualified.");
    }
}