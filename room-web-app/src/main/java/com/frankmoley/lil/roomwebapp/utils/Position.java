package com.frankmoley.lil.roomwebapp.utils;

public enum Position {
    HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE;

    public String toString(){
        switch (this){
            case CONCIERGE:
                return "Concierge";
            case HOUSEKEEPING:
                return "HouseKeeping";
            case FRONT_DESK:
                return "Front Desk";
            case SECURITY:
                return "Security";
        }
       return "";
    }
}
