package br.com.fiap.pokedex.data.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonPayload(
    @SerializedName("name") val nome: String,
    val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String,
    val other: SpriteOther
)

data class SpriteOther(
    @SerializedName("dream_world")  val dreamWorld: SpriteOtherDreamWorld,
    @SerializedName("official_artwork") val oficialArtWork: SpriteOficialArtWork
)

data class SpriteOtherDreamWorld(
    @SerializedName("front_default") val frontDefault: String
)

data class SpriteOficialArtWork(
    @SerializedName("front_default") val frontDefault: String
)