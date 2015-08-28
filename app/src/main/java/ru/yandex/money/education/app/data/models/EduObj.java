package ru.yandex.money.education.app.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.RoundingMode;

public class EduObj {

    public int someInt;
    public String someString;
    public RoundingMode someEnum;

    public EduObj(int someInt, String someString, RoundingMode someEnum) {
        this.someInt = someInt;
        this.someString = someString;
        this.someEnum = someEnum;
    }

    public static class Parc implements Parcelable {

        private final EduObj eduObj;

        public Parc(EduObj eduObj) {
            this.eduObj = eduObj;
        }

        private Parc(Parcel parcel) {
            int someInt = parcel.readInt();
            String someString = parcel.readString();
            RoundingMode someEnum = (RoundingMode) parcel.readSerializable();
            eduObj = new EduObj(someInt, someString, someEnum);
        }

        @Override
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(eduObj.someInt);
            parcel.writeString(eduObj.someString);
            parcel.writeSerializable(eduObj.someEnum);
        }

        public EduObj getEduObj() {
            return eduObj;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Parc> CREATOR = new Creator<Parc>() {
            @Override
            public Parc createFromParcel(Parcel parcel) {
                return new Parc(parcel);
            }

            @Override
            public Parc[] newArray(int size) {
                return new Parc[size];
            }
        };
    }
}
