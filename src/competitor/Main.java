package competitor;

public class Main {

    public static void main(String[] args) {
        Participant human = new Human("Max", 20, 5);
        Participant robot = new Robot("Robocop", 70, 1);
        Participant cat = new Cat("Garfield", 50, 2);
        Participant cat2 = new Cat("Murzik", 70, 5);
        Participant[] arrayOfParticipants = new Participant[]{human, robot, cat, cat2};

        Treadmill treadmill = new Treadmill(60);
        Wall wall = new Wall(3);
        Treadmill treadmill2 = new Treadmill(40);
        Wall wall2 = new Wall(4);
        Obstacles[] arrayOfObstacles = new Obstacles[]{treadmill, wall, treadmill2, wall2};

        Participant.passObstacles(arrayOfParticipants, arrayOfObstacles, treadmill, wall);
    }
}
