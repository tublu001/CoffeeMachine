package coffeeMachine.entity;

import lombok.Data;

@Data
public class Outlet {
    private int id;
    private int pipeSize;
    private int outletNumber;
    private OutletType outletType;


    public Outlet(int pipeSize, int outletNumber, OutletType outletType) {
        this.pipeSize = pipeSize;
        this.outletNumber = outletNumber;
        this.outletType = outletType;
    }

    public int getPipeSize() {
        return pipeSize;
    }

    public void setPipeSize(int pipeSize) {
        this.pipeSize = pipeSize;
    }

    public int getOutletNumber() {
        return outletNumber;
    }

    public void setOutletNumber(int outletNumber) {
        this.outletNumber = outletNumber;
    }

    public OutletType getOutletType() {
        return outletType;
    }

    public void setOutletType(OutletType outletType) {
        this.outletType = outletType;
    }
}
