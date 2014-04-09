package com.example.servicepassobject;

import android.os.Parcel;
import android.os.Parcelable;

public class MyObject implements Parcelable {
	
	private int mNumber1;
	
	private int mNumber2;
	
	public MyObject(int num1, int num2) {
		mNumber1 = num1;
		mNumber2 = num2;
	}
	
	public MyObject(Parcel p) {
		mNumber1 = p.readInt();
		mNumber2 = p.readInt();
	}
	
	public int getResult() {
		return mNumber1 + mNumber2;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel p, int arg1) {
		p.writeInt(mNumber1);
		p.writeInt(mNumber2);
	}
	
	public static Parcelable.Creator<MyObject> CREATOR = new Creator<MyObject>() {
		
		@Override
		public MyObject[] newArray(int size) {
			return new MyObject[size];
		}
		
		@Override
		public MyObject createFromParcel(Parcel source) {
			return new MyObject(source);
		}
	};

}
