package Utility.Autocast;

public enum VarbitForSpells {

    WIND_STRIKE(1),
    WATER_STRIKE(2),
    EARTH_STRIKE(3),
    FIRE_STRIKE(4),
    WIND_BOLT(5),
    WATER_BOLT(6),
    EARTH_BOLT(7),
    FIRE_BOLT(8),
    WIND_BLAST(9),
    WATER_BLAST(10),
    EARTH_BLAST(11),
    FIRE_BLAST(12),
    WIND_WAVE(13),
    WATER_WAVE(14),
    EARTH_WAVE(15),
    FIRE_WAVE(16),
    WIND_SURGE(17),
    WATER_SURGE(18),
    EARTH_SURGE(19),
    FIRE_SURGE(20);

    private int varbit;

    VarbitForSpells(int varbit) {
        this.varbit = varbit;
    }

    public int getVarbit() {
        return this.varbit;
    }
}