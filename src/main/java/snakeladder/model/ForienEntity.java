package main.java.snakeladder.model;

public abstract class ForienEntity {
    private EntityType type;
    private int from;
    private int to;

    public ForienEntity(EntityType type, int from, int to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public EntityType getType() {
        return type;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
