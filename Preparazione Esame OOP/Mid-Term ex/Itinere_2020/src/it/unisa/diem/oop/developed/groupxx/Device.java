package it.unisa.diem.oop.developed.groupxx;

import java.time.LocalDate;

public  abstract class Device implements Comparable<Device> {
    private String serialNumber;
    private LocalDate releaseDate;
    private int RAMsize;
    private int storageCapacity;

    public Device(String serialNumber, int year, int month , int dayOfMonth ,  int RAMsize, int storageCapacity) {
        this.serialNumber = serialNumber;
        this.releaseDate = LocalDate.of(year , month , dayOfMonth);
        this.RAMsize = RAMsize;
        this.storageCapacity = storageCapacity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getRAMsize() {
        return RAMsize;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }


    public int hashCode(){
        return (serialNumber == null) ? 0 : 78*getSerialNumber().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null)
            if (obj instanceof Device )
                return (((Device) obj).getSerialNumber().equals(this.getSerialNumber()));
        return false;
    }

    public abstract boolean hasTouchScreen();

    public final int compareTo(Device o){
        return getSerialNumber().compareToIgnoreCase(o.getSerialNumber());
    }

    @Override
    public String toString() {
        return "Serial Number= " + getSerialNumber() + "\n" +
                "release Date= " + getReleaseDate().toString() + "\n" +
                "RAMsize= " + getRAMsize() + "\n" +
                "storageCapacity= " + getStorageCapacity() + "\n";
    }
}
