package crf.android.U7E5;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
	private String mDATA;
	public MyParcelable(Parcel in) {
		mDATA = in.readString();
		
	}
	public int describeContents() {
		return 0;
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mDATA);
	}
	public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
		public MyParcelable createFromParcel(Parcel in){
			return new MyParcelable(in);
		}
		public MyParcelable[] newArray(int size) {
			return new MyParcelable[size];
		}
	};
}