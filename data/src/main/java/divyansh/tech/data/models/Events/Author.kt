package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Author(
    @Json(name = "email")
    val email: String, // 55613721+kartikeysaran@users.noreply.github.com
    @Json(name = "name")
    val name: String // Kartikey Saran
)