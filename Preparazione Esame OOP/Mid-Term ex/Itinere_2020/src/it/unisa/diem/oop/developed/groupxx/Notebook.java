package it.unisa.diem.oop.developed.groupxx;

import it.unisa.diem.oop.provided.CPUType;
import it.unisa.diem.oop.provided.NBScreenType;
public class Notebook extends Device{
    private CPUType type;
    private NBScreenType screenType;
    private boolean touchScreen;

    public Notebook(CPUType type , NBScreenType screenType , boolean touchScreen , String serialNumber , int year , int month , int dayOfMonth , int RAMsize , int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = touchScreen;
    }
    public Notebook(CPUType type , NBScreenType screenType , String serialNumber , int year , int month , int dayOfMonth , int RAMsize , int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = false;
    }

    public CPUType getType() {
        return type;
    }

    public NBScreenType getScreenType() {
        return screenType;
    }
    @Override
    public boolean hasTouchScreen() {
        return touchScreen;
    }

    @Override
    public String toString() {
        String s ;
        if (hasTouchScreen())
            s = new String("touchScreen available" + "\n") ;
        else
            s = null;
        return "Notebook \n" + super.toString() +
                "CPU= " + getType() + "\n" +
                "screen Type= " + getScreenType() + "\n" + s ;
    }
}
