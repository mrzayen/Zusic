package app.vitune.android.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class YouTubeDLResponse(
    val id: String,
    @SerialName("format_id")
    val formatId: String? = null,
    val url: String? = null,
    val formats: List<Format>? = null,
    @SerialName("filesize")
    val fileSize: Long
) {
    companion object {
        val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
        fun fromString(str: String) = json.decodeFromString<YouTubeDLResponse>(str)
    }

    @Serializable
    data class Format(
        @SerialName("format_id")
        val formatId: String,
        val url: String? = null,
        val abr: Double? = null
    )
}
