package competitor;

public class Treadmill implements Obstacles {
    int lengthOfTreadmill;

    public Treadmill(int lengthOfTreadmill) {
        this.lengthOfTreadmill = lengthOfTreadmill;
    }

    //if run you can overcome treadmill
    @Override
    public void overcome(Participant participant) {
        participant.run(this);
    }
}
