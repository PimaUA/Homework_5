package competitor;

public abstract class Participant implements Competitor {
    protected String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;
    private boolean isDisqualified;

    //method to check actions depends on type of obstacle
    void overcomeObstacle(Obstacles obstacles) {
        if (obstacles instanceof Treadmill) {
            this.run(obstacles);
        } else if (obstacles instanceof Wall) {
            this.jump(obstacles);
        }
    }

    //method with actions for successful and unsuccessful runs
    @Override
    public void run(Obstacles obstacles) {
        if (obstacles.overcome(maxRunDistance)) {
            isDisqualified = false;
            System.out.println(getClass().getSimpleName() + " " + name
                    + " passed treadmill at distance of "
                    + obstacles.getObstaclesOutput());
        } else {
            isDisqualified = true;
            System.out.println(getClass().getSimpleName() + " "
                    + name + " hasn't passed treadmill "
                    + "with distance of "
                    + obstacles.getObstaclesOutput()
                    + "Passed " + maxRunDistance
                    + ((maxRunDistance == 1) ? " meter." : " meters. ")
                    + name + " disqualified.");
        }
    }

    //method with actions for successful and unsuccessful jumps
    @Override
    public void jump(Obstacles obstacles) {
        if (obstacles.overcome(maxJumpHeight)) {
            isDisqualified = false;
            System.out.println(getClass().getSimpleName() + " " + name + " jumped "
                    + maxJumpHeight
                    + ((maxJumpHeight == 1) ? " meter " : " meters ") + "over the wall of "
                    + obstacles.getObstaclesOutput());
        } else {
            isDisqualified = true;
            System.out.println(getClass().getSimpleName() + " " + name
                    + " hasn't passed wall " + "with height of "
                    + obstacles.getObstaclesOutput()
                    + "Jumped " + maxJumpHeight
                    + ((maxJumpHeight == 1) ? " meter." : " meters. ")
                    + name + " disqualified.");
        }
    }

    public boolean isDisqualified() {
        return isDisqualified;
    }
}


