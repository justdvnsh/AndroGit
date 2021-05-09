package divyansh.tech.data.models.events


import com.google.gson.annotations.SerializedName

data class UserEventItem(
    @SerializedName("actor")
    val actor: Actor,
    @SerializedName("created_at")
    val createdAt: String, // 2021-04-21T05:54:09Z
    @SerializedName("id")
    val id: String, // 16023634695
    @SerializedName("org")
    val org: Org,
    @SerializedName("payload")
    val payload: Payload,
    @SerializedName("public")
    val `public`: Boolean, // true
    @SerializedName("repo")
    val repo: Repo,
    @SerializedName("type")
    val type: String // PushEvent
)