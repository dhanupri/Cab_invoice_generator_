public class Ride {
    public int cabId;
    public int riderID;
    public String riderName;
    public Cab cab;
    public int km;
    public String time;
    Ride(int cabId,int riderID,String riderName,Cab cab,int km,String time) {
        this.cabId=cabId;
        this.riderID=riderID;
        this.riderName=riderName;
        this.cab=cab;
        this.km=km;
        this.time=time;
    }
    public int getCabId() {
        return cabId;
    }
    public void setCabId(int cabId) {
        this.cabId = cabId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getRiderName() {
        return riderName;
    }
    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }
    public int getRiderID() {
        return riderID;
    }
    public void setRiderID(int riderID) {
        this.riderID = riderID;
    }
    public Cab getCab() {
        return cab;
    }
    public void setCab(Cab cab) {
        this.cab = cab;
    }
    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }
}
