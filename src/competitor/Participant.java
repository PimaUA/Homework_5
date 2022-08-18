package competitor;

public abstract class Participant implements Competitor {
    protected String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;

    //run method for each participant
    @Override
    public void run(Treadmill treadmill) {
        System.out.println(getClass().getSimpleName() + " " + name + " passed treadmill at distance of "
                + treadmill.lengthOfTreadmill
                + ((treadmill.lengthOfTreadmill == 1) ? " meter." : " meters."));
    }

    //jump method for each participant
    @Override
    public void jump(Wall wall) {
        System.out.println(getClass().getSimpleName() + " " + name + " jumped " + maxJumpHeight
                + ((maxJumpHeight == 1) ? " meter " : " meters ") + "over the wall of "
                + wall.heightOfWall + ((wall.heightOfWall == 1) ? " meter " : " meters ") + "high.");
    }

    // main logic method to pass all obstacles for all participants
    public static void passObstacles(Participant[] arrayOfParticipants,
                                     Obstacles[] arrayOfObstacles, Treadmill treadmill, Wall wall) {
        for (Participant eachParticipant : arrayOfParticipants) {
            for (int j = 0; j < arrayOfObstacles.length; j++) {
                if ((arrayOfObstacles[j] instanceof Treadmill
                        && eachParticipant.maxJumpHeight < wall.heightOfWall
                        && eachParticipant.maxRunDistance < treadmill.lengthOfTreadmill)
                        || (arrayOfObstacles[j] instanceof Wall
                        && eachParticipant.maxJumpHeight < wall.heightOfWall
                        && eachParticipant.maxRunDistance < treadmill.lengthOfTreadmill)) {
                    arrayOfObstacles[j].quitCompetition(eachParticipant, treadmill, wall);
                    break;                                                             /*all failed obstacles case*/
                } else if ((arrayOfObstacles[j] instanceof Treadmill
                        && eachParticipant.maxRunDistance > treadmill.lengthOfTreadmill)
                        || (arrayOfObstacles[j] instanceof Wall
                        && eachParticipant.maxJumpHeight > wall.heightOfWall)) {
                    arrayOfObstacles[j].overcome(eachParticipant);                    /*successful run or jump case*/
                } else if ((arrayOfObstacles[j] instanceof Wall
                        && eachParticipant.maxJumpHeight < wall.heightOfWall)
                        || (arrayOfObstacles[j] instanceof Treadmill
                        && eachParticipant.maxRunDistance < treadmill.lengthOfTreadmill)) {
                    arrayOfObstacles[j].quitCompetition(eachParticipant, treadmill, wall);
                    break;                                                           /*unsuccessful jump or run case*/
                }
            }
        }
    }
}

