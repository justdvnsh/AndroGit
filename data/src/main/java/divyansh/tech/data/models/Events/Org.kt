package divyansh.tech.data.models.Events


import com.google.gson.annotations.SerializedName

data class Org(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/47870548?
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("id")
    val id: Int, // 47870548
    @SerializedName("login")
    val login: String, // anitab-org
    @SerializedName("url")
    val url: String // https://api.github.com/orgs/anitab-org
)