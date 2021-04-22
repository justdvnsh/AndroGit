package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Commit(
    @Json(name = "author")
    val author: Author,
    @Json(name = "distinct")
    val distinct: Boolean, // false
    @Json(name = "message")
    val message: String, // chore: delete .travis.yml (#1084)
    @Json(name = "sha")
    val sha: String, // 03786a4a9ea60298b849edaeead5a60e32451011
    @Json(name = "url")
    val url: String // https://api.github.com/repos/justdvnsh/mentorship-android/commits/03786a4a9ea60298b849edaeead5a60e32451011
)