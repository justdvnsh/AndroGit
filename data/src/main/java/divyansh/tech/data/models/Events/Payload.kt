package divyansh.tech.data.models.Events


import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("before")
    val before: String, // 3944a2e3ef5905addb724608198e36be06609ba2
    @SerializedName("commits")
    val commits: List<Commit>,
    @SerializedName("distinct_size")
    val distinctSize: Int, // 1
    @SerializedName("head")
    val head: String, // 288517b6e9ea042e5c4568a52e6935e1d43ac598
    @SerializedName("push_id")
    val pushId: Long, // 6954297418
    @SerializedName("ref")
    val ref: String, // refs/heads/develop
    @SerializedName("size")
    val size: Int // 1
)