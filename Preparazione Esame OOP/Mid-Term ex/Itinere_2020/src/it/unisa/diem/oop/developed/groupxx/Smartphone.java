package it.unisa.diem.oop.developed.groupxx;

import it.unisa.diem.oop.provided.MobileCPUType;

public class Smartphone extends Device{
    private MobileCPUType cpu;
    private float screenSizeInch;

    public Smartphone(MobileCPUType cpu , float screenSizeInch , String serialNumber , int year , int month , int dayOfMonth , int RAMsize , int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.cpu = cpu;
        this.screenSizeInch = screenSizeInch;
    }

    public MobileCPUType getCpu() {
        return cpu;
    }

    public float getScreenSizeInch() {
        return screenSizeInch;
    }

    @Override
    public boolean hasTouchScreen() {
        return true;
    }

    public String toString(){
        return "Smartphone: \n" + super.toString() + "CPU= " + getCpu() + "\n screenSizeInch= " + getScreenSizeInch() + "\n";
    }
}
