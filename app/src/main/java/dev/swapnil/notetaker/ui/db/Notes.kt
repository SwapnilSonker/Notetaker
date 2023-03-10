package dev.swapnil.notetaker.ui.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title:String,
    var subtitle:String,
    var notes:String,
    var date:String,
    var priority:String

):Parcelable
