/*
Problem Link: https://leetcode.com/problems/design-parking-system/
*/

class ParkingSystem {

    int bigVehicles;
    int mediumVehicles;
    int smallVehicles;

    public ParkingSystem(int big, int medium, int small) {
        bigVehicles = big;
        mediumVehicles = medium;
        smallVehicles = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (bigVehicles > 0) {
                    bigVehicles--;
                    return true;
                } else {
                    return false;
                }

            case 2:
                if (mediumVehicles > 0) {
                    mediumVehicles--;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (smallVehicles > 0) {
                    smallVehicles--;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */