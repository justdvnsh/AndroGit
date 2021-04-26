package divyansh.tech.data.models.Events


import com.google.gson.annotations.SerializedName

data class Commit(
    @SerializedName("author")
    val author: Author,
    @SerializedName("distinct")
    val distinct: Boolean, // true
    @SerializedName("message")
    val message: String, // added bottom bar to the main activity
    @SerializedName("sha")
    val sha: String, // 288517b6e9ea042e5c4568a52e6935e1d43ac598
    @SerializedName("url")
    val url: String // https://api.github.com/repos/justdvnsh/Bhagwad-Geeta/commits/288517b6e9ea042e5c4568a52e6935e1d43ac598
)