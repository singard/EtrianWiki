package com.ynov.projectfragment.model

import java.io.Serializable

//json
data class CharacterClass (val name: String,val profile: String, val strengths: String, val weaknesses: String, val imgId: String) :
    Serializable

