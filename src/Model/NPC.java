package Model;

public interface NPC {
    int getOx();
    int getOy();
    int getSpeed();
    void Move(int KeyCode);
    int getWidth();
    int getHeight();
    boolean getMark();
    String getName();

}
