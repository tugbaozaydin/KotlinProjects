package com.tugbaozaydin.retrofitexample

import android.os.Parcel
import android.os.Parcelable

data class User(
    var id: String,
    var name: String,
    var phone: String,
    var email: String,
    var avatar: String,
    var company: String,
    var jobDesc: String,
    var jobTitle: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(phone)
        parcel.writeString(email)
        parcel.writeString(avatar)
        parcel.writeString(company)
        parcel.writeString(jobDesc)
        parcel.writeString(jobTitle)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}