package de.syntaxinstitut.happycake.data.model

import com.squareup.moshi.Json

/**
 * Diese Data Klasse steht für einen einzelnen Kontakt im HomeFragment
 * @param name der Name der Torten
 * @param imageSrc die resource ID des Bildes der Torten
 * @param price die resource ID der Preis der Torten
 *  @param detail die resource ID die Beschreibungen der Torten
 */

data class Cake(
    // val id: Long,
    val name: String,
    val price: Double,
    val imageSrc: String,
    // wenn im API es unter einer anderen Bezeichnung steht kann man es so umgehen.
    @Json(name = "Beschreibung") val detail: String
)
