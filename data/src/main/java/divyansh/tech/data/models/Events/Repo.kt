package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Repo(
    @Json(name = "id")
    val id: Int, // 292307038
    @Json(name = "name")
    val name: String, // justdvnsh/mentorship-android
    @Json(name = "url")
    val url: String // https://api.github.com/repos/justdvnsh/mentorship-android
)