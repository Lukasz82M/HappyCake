package de.syntaxinstitut.happycake.data.model

/**
 * Diese Data Klasse steht für einen einzelnen Kontakt im HomeFragment
 * @param name der Name des Kontakts
 * @param imageResId die resource ID des Bildes des Kontakts
 * @param chatHistory eine Liste aus Message Objekten, in der der Chat Verlauf gespeichert ist
 */
data class Cake(
    val name: String,
    val imageResId: Int,
    val chatHistory: MutableList<Cake>
)
