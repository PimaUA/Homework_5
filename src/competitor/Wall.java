package competitor;

public class Wall implements Obstacles {
    int heightOfWall;

    public Wall(int heightOfWall) {
        this.heightOfWall = heightOfWall;
    }

    @Override
    public void overcome(Participant participant) {

        if (participant.maxJumpHeight < heightOfWall) {
            jumpFailed(participant);
        } else if (participant.maxJumpHeight > heightOfWall) {
            jumpSuccess(participant);
        }
    }

    //jump success case output
    void jumpSuccess(Participant participant) {
        System.out.println(participant.getClass().getSimpleName() + " " + participant.name + " jumped "
                + participant.maxJumpHeight
                + ((participant.maxJumpHeight == 1) ? " meter " : " meters ") + "over the wall of "
                + heightOfWall + ((heightOfWall == 1) ? " meter " : " meters ") + "high.");
    }

    // jump failed case output
    void jumpFailed(Participant participant) {
        System.out.println(participant.getClass().getSimpleName() + " " + participant.name
                + " hasn't passed wall " + "with height of "
                + heightOfWall + ((heightOfWall == 1) ? " meter." : " meters. ")
                + "Jumped " + participant.maxJumpHeight
                + ((participant.maxJumpHeight == 1) ? " meter." : " meters. ")
                + participant.name + " disqualified.");
    }
}
