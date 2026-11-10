package com.rroyo.app.appcafes.model

import com.rroyo.app.appcafes.enums.Region

class Coffee (

    val name: String,
    val region: Region,
    val score: Int = 0,
    var aromaticNotes: String = "",
    val productor: String

) {
}