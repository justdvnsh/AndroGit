package divyansh.tech.data.models.pullRequests


import com.google.gson.annotations.SerializedName

data class Assignee(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/12983742?v=4
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/BenHenning/events{/privacy}
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/BenHenning/followers
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/BenHenning/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/BenHenning/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/BenHenning
    @SerializedName("id")
    val id: Int, // 12983742
    @SerializedName("login")
    val login: String, // BenHenning
    @SerializedName("node_id")
    val nodeId: String, // MDQ6VXNlcjEyOTgzNzQy
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/BenHenning/orgs
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/BenHenning/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/BenHenning/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/BenHenning/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/BenHenning/subscriptions
    @SerializedName("type")
    val type: String, // User
    @SerializedName("url")
    val url: String // https://api.github.com/users/BenHenning
)