package divyansh.tech.data.models.pullRequests


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("color")
    val color: String, // cadd4e
    @SerializedName("default")
    val default: Boolean, // false
    @SerializedName("description")
    val description: String, // PR needs an additional review or a maintainer's review.
    @SerializedName("id")
    val id: Long, // 2047507995
    @SerializedName("name")
    val name: String, // Status: Needs Review
    @SerializedName("node_id")
    val nodeId: String, // MDU6TGFiZWwyMDQ3NTA3OTk1
    @SerializedName("url")
    val url: String // https://api.github.com/repos/anitab-org/mentorship-android/labels/Status:%20Needs%20Review
)