package com.rroyo.appcafes.modelo

import com.rroyo.appcafes.enums.Region

class Coofee (

    val name: String,
    val region: Region,
    val score: Int = 0,
    var aromaticNotes: String = "",
    val productor: String

) {
}