public class ParcelTrackerMain {
    public static void main(String[] args) {
        
        Parcel parcel1 = new Parcel("P15233","Ava","Rosie","XYZ Lane");
        Parcel parcel2 = new Parcel("P14733","Ava","Jane","XYZ Lane");
        
        try {
            ParcelTracker parcelTracker1 = new ParcelTracker(parcel1);
            ParcelTracker parcelTracker2 = new ParcelTracker(parcel2);

            parcelTracker1.addCheckpoint("In Transit","Waiting to be picked by delivery person" );
            parcelTracker1.trackParcel();

            parcelTracker2.markParcelLost();
            parcelTracker2.trackParcel();

        } 
        catch (ParcelLostException e) {
            System.out.println(e);
        }
    }
}
