package divyansh.tech.data.models.Users


import com.squareup.moshi.Json
import java.io.Serializable

/*
* User data class
* */
data class User(
    @Json(name = "avatar_url")
    val avatarUrl: String, // https://github.com/images/error/octocat_happy.gif
    @Json(name = "bio")
    val bio: String, // There once was...
    @Json(name = "blog")
    val blog: String, // https://github.com/blog
    @Json(name = "collaborators")
    val collaborators: Int, // 8
    @Json(name = "company")
    val company: String, // GitHub
    @Json(name = "created_at")
    val createdAt: String, // 2008-01-14T04:33:35Z
    @Json(name = "disk_usage")
    val diskUsage: Int, // 10000
    @Json(name = "email")
    val email: String, // octocat@github.com
    @Json(name = "events_url")
    val eventsUrl: String, // https://api.github.com/users/octocat/events{/privacy}
    @Json(name = "followers")
    val followers: Int, // 20
    @Json(name = "followers_url")
    val followersUrl: String, // https://api.github.com/users/octocat/followers
    @Json(name = "following")
    val following: Int, // 0
    @Json(name = "following_url")
    val followingUrl: String, // https://api.github.com/users/octocat/following{/other_user}
    @Json(name = "gists_url")
    val gistsUrl: String, // https://api.github.com/users/octocat/gists{/gist_id}
    @Json(name = "gravatar_id")
    val gravatarId: String,
    @Json(name = "hireable")
    val hireable: Boolean, // false
    @Json(name = "html_url")
    val htmlUrl: String, // https://github.com/octocat
    @Json(name = "id")
    val id: Int, // 1
    @Json(name = "location")
    val location: String, // San Francisco
    @Json(name = "login")
    val login: String, // octocat
    @Json(name = "name")
    val name: String, // monalisa octocat
    @Json(name = "node_id")
    val nodeId: String, // MDQ6VXNlcjE=
    @Json(name = "organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/octocat/orgs
    @Json(name = "owned_private_repos")
    val ownedPrivateRepos: Int, // 100
    @Json(name = "plan")
    val plan: Plan,
    @Json(name = "private_gists")
    val privateGists: Int, // 81
    @Json(name = "public_gists")
    val publicGists: Int, // 1
    @Json(name = "public_repos")
    val publicRepos: Int, // 2
    @Json(name = "received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/octocat/received_events
    @Json(name = "repos_url")
    val reposUrl: String, // https://api.github.com/users/octocat/repos
    @Json(name = "site_admin")
    val siteAdmin: Boolean, // false
    @Json(name = "starred_url")
    val starredUrl: String, // https://api.github.com/users/octocat/starred{/owner}{/repo}
    @Json(name = "subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/octocat/subscriptions
    @Json(name = "total_private_repos")
    val totalPrivateRepos: Int, // 100
    @Json(name = "twitter_username")
    val twitterUsername: String, // monatheoctocat
    @Json(name = "two_factor_authentication")
    val twoFactorAuthentication: Boolean, // true
    @Json(name = "type")
    val type: String, // User
    @Json(name = "updated_at")
    val updatedAt: String, // 2008-01-14T04:33:35Z
    @Json(name = "url")
    val url: String // https://api.github.com/users/octocat
): Serializable