package util;

import edu.wpi.first.wpilibj.DriverStation;

public class GameData {
    public static String gameData;

    public static void refreshGameData() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
    }

    public static String getWheelColor() {
        if(gameData.length() > 0) {
            switch(gameData.charAt(0)) {
                case 'R':
                    return "red";
                case 'G':
                    return "green";
                case 'B':
                    return "blue";
                case 'Y':
                    return "yellow";
                default:
                    return "null";
            }
            
        } else {
            return "null";
        }
    }
}
