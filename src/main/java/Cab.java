public class Cab {
    public int cabID;
    public String cabNumber;
    Cab(int cabID,String cabNumber){
        this.cabID=cabID;
        this.cabNumber=cabNumber;
    }
    public int getCabID() {
        return cabID;
    }
    public void setCabID(int cabID) {
        this.cabID = cabID;
    }
    public String getCabNumber() {
        return cabNumber;
    }
    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }
}
