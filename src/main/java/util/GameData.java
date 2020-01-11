package util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;

public class GameData {
    public static String gameData;
    public static boolean FMSConnected = DriverStation.getInstance().isFMSAttached();

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

    public static boolean isTestMode() {
        return DriverStation.getInstance().isTest();
    }

    public static boolean isAutoMode() {
        return DriverStation.getInstance().isAutonomous();
    }

    public static boolean isTeleop() {
        return DriverStation.getInstance().isOperatorControl();
    }

    public static int getMatchNumber() {
        return DriverStation.getInstance().getMatchNumber();
    }

    public static double getMatchTime() {
        return DriverStation.getInstance().getMatchTime();
    }

    public static String getMatchType() {
        if(DriverStation.getInstance().getMatchType() == MatchType.Elimination) {
            return "Elims";
        } else if(DriverStation.getInstance().getMatchType() == MatchType.Qualification) {
            return "Quals";
        } else if(DriverStation.getInstance().getMatchType() == MatchType.Practice) {
            return "Prac";
        } else {
            return "N/A";
        }
    }
}
