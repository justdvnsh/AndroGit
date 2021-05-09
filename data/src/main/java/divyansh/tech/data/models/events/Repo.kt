package divyansh.tech.data.models.events


import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    val id: Int, // 360027658
    @SerializedName("name")
    val name: String, // justdvnsh/Bhagwad-Geeta
    @SerializedName("url")
    val url: String // https://api.github.com/repos/justdvnsh/Bhagwad-Geeta
)