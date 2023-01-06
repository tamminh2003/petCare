package util;

public class VetAssignment {
    private int ID;
    private int vetID;
    private int spotID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getVetID() {
        return vetID;
    }

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    public int getSpotID() {
        return spotID;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public VetAssignment(int ID, int vetID, int spotID) {
        this.ID = ID;
        this.vetID = vetID;
        this.spotID = spotID;
    }

    public VetAssignment(int spotID) {
        this.spotID = spotID;
    }
}
