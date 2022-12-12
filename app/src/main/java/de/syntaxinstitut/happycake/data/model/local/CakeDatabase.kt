package de.syntaxinstitut.happycake.data.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.happycake.data.model.Cake


@Database(entities = [Cake::class], version =1)
abstract class CakeDatabase : RoomDatabase() {

    abstract val cakeDatabaseDao : CakeDatabaseDao
}
private lateinit var INSTANCE:CakeDatabase

fun getDatabase(context: Context): CakeDatabase {
    synchronized(CakeDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CakeDatabase::class.java,
                "cake_database"
            )
                .build()
        }
    }
    return INSTANCE
}
