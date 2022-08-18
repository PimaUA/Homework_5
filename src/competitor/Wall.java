package competitor;

public class Wall implements Obstacles {
    int heightOfWall;

    public Wall(int heightOfWall) {
        this.heightOfWall = heightOfWall;
    }

    //if jump you can overcome wall
    @Override
    public void overcome(Participant participant) {
        participant.jump(this);
    }
}
