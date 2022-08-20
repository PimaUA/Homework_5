package competitor;

public abstract class Participant implements Competitor {
    protected String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;

    void overcomeObstacle(Obstacles obstacles) {
        if (obstacles instanceof Treadmill) {
            this.run(obstacles);
        } else if (obstacles instanceof Wall) {
            this.jump(obstacles);
        }
    }

    @Override
    public void run(Obstacles obstacles) {
        obstacles.overcome(this);
    }

    @Override
    public void jump(Obstacles obstacles) {
        obstacles.overcome(this);
    }
}


