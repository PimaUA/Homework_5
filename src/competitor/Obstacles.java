package competitor;

public interface Obstacles {

    void overcome(Participant participant);

    //method to check conditions for disqualification for all participants
    default void quitCompetition(Participant participant, Treadmill treadmill, Wall wall) {
        if (participant.maxRunDistance < treadmill.lengthOfTreadmill
                && participant.maxJumpHeight < wall.heightOfWall) {
            Obstacles.runAndJumpFailed(this, participant, wall, treadmill);  /*if everything failed*/
        } else if (participant.maxRunDistance < treadmill.lengthOfTreadmill) {
            Obstacles.runFailed(participant, treadmill);                                  /*if run not passed*/
        } else if (participant.maxJumpHeight < wall.heightOfWall) {
            Obstacles.jumpFailed(participant, wall);                                      /*if jump not passed*/
        }
    }

    // run failed case output
    static void runFailed(Participant participant, Treadmill treadmill) {
        System.out.println(participant.getClass().getSimpleName() + " "
                + participant.name + " hasn't passed treadmill "
                + "with distance of "
                + treadmill.lengthOfTreadmill
                + ((treadmill.lengthOfTreadmill == 1) ? " meter." : " meters. ")
                + "Passed " + participant.maxRunDistance
                + ((participant.maxRunDistance == 1) ? " meter." : " meters. ")
                + participant.name + " disqualified.");
    }

    //jump failed case output
    static void jumpFailed(Participant participant, Wall wall) {
        System.out.println(participant.getClass().getSimpleName() + " " + participant.name
                + " hasn't passed wall " + "with height of "
                + wall.heightOfWall + ((wall.heightOfWall == 1) ? " meter." : " meters. ")
                + "Jumped " + participant.maxJumpHeight
                + ((participant.maxJumpHeight == 1) ? " meter." : " meters. ")
                + participant.name + " disqualified.");
    }

    //all obstacles failed case output
    static void runAndJumpFailed(Obstacles arrayOfObstacles, Participant participant,
                                 Wall wall, Treadmill treadmill) {
        if (arrayOfObstacles instanceof Treadmill) {
            System.out.println(participant.getClass().getSimpleName() + " " + participant.name
                    + " failed to pass any of obstacles. " + participant.maxRunDistance
                    + ((treadmill.lengthOfTreadmill == 1) ? " meter " : " meters ") + "passed."
                    + participant.name + " disqualified.");
        } else {
            System.out.println(participant.getClass().getSimpleName() + " " + participant.name
                    + " failed to pass any of obstacles. " + participant.maxJumpHeight
                    + ((wall.heightOfWall == 1) ? " meter " : " meters ") + "jumped."
                    + participant.name + " disqualified.");
        }
    }
}




