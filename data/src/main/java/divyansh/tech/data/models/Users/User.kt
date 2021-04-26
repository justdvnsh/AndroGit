package divyansh.tech.data.models.Users


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/29144058?v=4
    @SerializedName("bio")
    val bio: String, // Contributing code to Humanity. |Android Developer |Cyber Security , Networking and Machine Learning Enthusiast !
    @SerializedName("blog")
    val blog: String, // https://justdvnsh.github.io
    @SerializedName("collaborators")
    val collaborators: Int, // 3
    @SerializedName("company")
    val company: Any, // null
    @SerializedName("created_at")
    val createdAt: String, // 2017-06-02T11:18:23Z
    @SerializedName("disk_usage")
    val diskUsage: Int, // 506840
    @SerializedName("email")
    val email: String, // justdvnsh2208@gmail.com
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/justdvnsh/events{/privacy}
    @SerializedName("followers")
    val followers: Int, // 27
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/justdvnsh/followers
    @SerializedName("following")
    val following: Int, // 3
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/justdvnsh/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/justdvnsh/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("hireable")
    val hireable: Boolean, // true
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/justdvnsh
    @SerializedName("id")
    val id: Int, // 29144058
    @SerializedName("location")
    val location: Any, // null
    @SerializedName("login")
    val login: String, // justdvnsh
    @SerializedName("name")
    val name: String, // Divyansh Dwivedi
    @SerializedName("node_id")
    val nodeId: String, // MDQ6VXNlcjI5MTQ0MDU4
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/justdvnsh/orgs
    @SerializedName("owned_private_repos")
    val ownedPrivateRepos: Int, // 12
    @SerializedName("plan")
    val plan: Plan,
    @SerializedName("private_gists")
    val privateGists: Int, // 2
    @SerializedName("public_gists")
    val publicGists: Int, // 4
    @SerializedName("public_repos")
    val publicRepos: Int, // 240
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/justdvnsh/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/justdvnsh/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/justdvnsh/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/justdvnsh/subscriptions
    @SerializedName("total_private_repos")
    val totalPrivateRepos: Int, // 13
    @SerializedName("twitter_username")
    val twitterUsername: String, // m4sterpl4gue
    @SerializedName("two_factor_authentication")
    val twoFactorAuthentication: Boolean, // true
    @SerializedName("type")
    val type: String, // User
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-04-26T05:36:40Z
    @SerializedName("url")
    val url: String // https://api.github.com/users/justdvnsh
)