package de.syntaxinstitut.happycake.data.model

import com.squareup.moshi.Json

/**
 * Diese Data Klasse steht für einen einzelnen Kontakt im HomeFragment
 * @param name der Name der Torten
 * @param imageResId die resource ID des Bildes der Torten
 *
 * ?@param chatHistory eine Liste aus Message Objekten, in der der Chat Verlauf gespeichert ist
 */

data class Cake(
    // val id: Long,
    val name: String,
    val price: Double,
    val imageSrc: String,
    @Json(name = "Beschreibung") val detail: String
)
