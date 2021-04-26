package divyansh.tech.data.models.Issues

import com.google.gson.annotations.SerializedName
import divyansh.tech.data.models.Events.Repo
import divyansh.tech.data.models.Users.User

data class Issue (

    @SerializedName("url") val url : String,
    @SerializedName("repository_url") val repository_url : String,
    @SerializedName("labels_url") val labels_url : String,
    @SerializedName("comments_url") val comments_url : String,
    @SerializedName("events_url") val events_url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("number") val number : Int,
    @SerializedName("title") val title : String,
    @SerializedName("user") val user : User,
    @SerializedName("labels") val labels : List<Labels>,
    @SerializedName("state") val state : String,
    @SerializedName("locked") val locked : Boolean,
    @SerializedName("assignee") val assignee : Assignee,
    @SerializedName("assignees") val assignees : List<Assignees>,
    @SerializedName("milestone") val milestone : String,
    @SerializedName("comments") val comments : Int,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("closed_at") val closed_at : String,
    @SerializedName("author_association") val author_association : String,
    @SerializedName("active_lock_reason") val active_lock_reason : String,
    @SerializedName("repository") val repository : Repo,
    @SerializedName("body") val body : String,
    @SerializedName("performed_via_github_app") val performed_via_github_app : String
)