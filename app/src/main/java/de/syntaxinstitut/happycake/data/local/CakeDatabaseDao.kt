
package de.syntaxinstitut.happycake.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.syntaxinstitut.happycake.data.model.Cake


@Dao
interface CakeDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cakeList: List<Cake>)

    @Query("SELECT * from Cake")
    fun getAll(): LiveData<List<Cake>>

    @Query("DELETE from Cake")
    fun deleteAll()
}

