package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Payload(
    @Json(name = "before")
    val before: String, // ed633eab6f98a748d20179bb595b81c29f415956
    @Json(name = "commits")
    val commits: List<Commit>,
    @Json(name = "distinct_size")
    val distinctSize: Int, // 1
    @Json(name = "head")
    val head: String, // db2ba1dd49af70433474e998ee9d5faae348fb98
    @Json(name = "push_id")
    val pushId: Long, // 6928019256
    @Json(name = "ref")
    val ref: String, // refs/heads/feat/credentials_login
    @Json(name = "size")
    val size: Int // 28
)