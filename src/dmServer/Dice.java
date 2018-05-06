package dmServer;

import java.util.Map;

import dmServer.Card.FaceIds;

public class Dice {
    private Map<FaceIds, Face> faces;

    public Dice(Map<FaceIds, Face> f) {
        faces = f;
    }
    public String toString() {
        String returnValue = "";
        for (Face face : faces.values()) {
            returnValue = returnValue.concat(face.toString());
        }
        return returnValue;
    }
}
