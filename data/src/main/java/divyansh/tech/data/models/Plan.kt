package divyansh.tech.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/*
* data plan class for user
* */
data class Plan(
    @Json(name = "collaborators")
    val collaborators: Int, // 0
    @Json(name = "name")
    val name: String, // Medium
    @Json(name = "private_repos")
    val privateRepos: Int, // 20
    @Json(name = "space")
    val space: Int // 400
)