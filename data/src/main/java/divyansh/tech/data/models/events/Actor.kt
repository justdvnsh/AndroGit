package divyansh.tech.data.models.events


import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/29144058?
    @SerializedName("display_login")
    val displayLogin: String, // justdvnsh
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("id")
    val id: Int, // 29144058
    @SerializedName("login")
    val login: String, // justdvnsh
    @SerializedName("url")
    val url: String // https://api.github.com/users/justdvnsh
)