package competitor;

public class Main {

    // main logic method to pass all obstacles by each participant
    public static void passObstacles(Participant[] arrayOfCompetitors,
                                     Obstacles[] arrayOfObstacles) {
        for (Participant eachParticipant : arrayOfCompetitors)
            for (Obstacles arrayOfObstacle : arrayOfObstacles) {
                eachParticipant.overcomeObstacle(arrayOfObstacle);
                if (eachParticipant.isDisqualified()) {
                    break;
                }
            }
    }

    public static void main(String[] args) {
        Participant human = new Human("Max", 70, 2);
        Participant robot = new Robot("Robocop", 50, 5);
        Participant cat = new Cat("Garfield", 50, 2);
        Participant cat2 = new Cat("Murzik", 70, 5);
        Participant[] arrayOfCompetitors = new Participant[]{human, robot, cat, cat2};

        Obstacles treadmill = new Treadmill(60);
        Obstacles wall = new Wall(3);
        Obstacles treadmill2 = new Treadmill(40);
        Obstacles wall2 = new Wall(4);
        Obstacles[] arrayOfObstacles = new Obstacles[]{treadmill, wall, treadmill2, wall2};

        passObstacles(arrayOfCompetitors, arrayOfObstacles);
    }
}
