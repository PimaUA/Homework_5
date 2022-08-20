package competitor;

public class Main {

    // main logic method to pass all obstacles by each participant
    public static void passObstacles(Participant[] arrayOfCompetitors,
                                     Obstacles[] arrayOfObstacles, Wall wall, Treadmill treadmill) {
        for (Participant eachParticipant : arrayOfCompetitors) {
            for (int j = 0; j < arrayOfObstacles.length; j++) {
                if ((arrayOfObstacles[j] instanceof Treadmill
                        && eachParticipant.maxRunDistance > treadmill.lengthOfTreadmill)
                        || (arrayOfObstacles[j] instanceof Wall
                        && eachParticipant.maxJumpHeight > wall.heightOfWall)) {
                    eachParticipant.overcomeObstacle(arrayOfObstacles[j]);           /*successful run or jump case*/
                } else if ((arrayOfObstacles[j] instanceof Wall
                        && eachParticipant.maxJumpHeight < wall.heightOfWall)
                        || (arrayOfObstacles[j] instanceof Treadmill
                        && eachParticipant.maxRunDistance < treadmill.lengthOfTreadmill)) {
                    eachParticipant.overcomeObstacle(arrayOfObstacles[j]);          /*unsuccessful run or jump case*/
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Participant human = new Human("Max", 70, 2);
        Participant robot = new Robot("Robocop", 50, 5);
        Participant cat = new Cat("Garfield", 50, 2);
        Participant cat2 = new Cat("Murzik", 70, 5);
        Participant[] arrayOfCompetitors = new Participant[]{human, robot, cat, cat2};

        Treadmill treadmill = new Treadmill(60);
        Wall wall = new Wall(3);
        Obstacles treadmill2 = new Treadmill(40);
        Obstacles wall2 = new Wall(4);
        Obstacles[] arrayOfObstacles = new Obstacles[]{treadmill, wall, treadmill2, wall2};

        passObstacles(arrayOfCompetitors, arrayOfObstacles, wall, treadmill);
    }
}
