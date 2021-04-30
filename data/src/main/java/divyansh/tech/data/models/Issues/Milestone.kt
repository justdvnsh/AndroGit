package divyansh.tech.data.models.Issues


import com.google.gson.annotations.SerializedName

data class Milestone(
    @SerializedName("closed_at")
    val closedAt: Any, // null
    @SerializedName("closed_issues")
    val closedIssues: Int, // 4
    @SerializedName("created_at")
    val createdAt: String, // 2019-08-01T18:35:04Z
    @SerializedName("creator")
    val creator: Creator,
    @SerializedName("description")
    val description: String, // This milestone is tracking all work to productionize the Oppia app and prepare it for global availability. It includes compiling and releasing the full corpus of lessons we want to release with the app, understanding the update flow for lesson content, ensuring app health statistics are being measured in production, ensure the app has been validated in user testing, ensuring we have clear maintenance and onboarding instructions, ensuring we have clear feature and binary release processes, ensuring that we have end-to-end tests in place for both functionality and core health metrics, compatibility testing the app, and stabilizing the app to reach the app health metrics and crash rates that we're satisfied with for launch.Note that this includes all work from the MVP milestone.
    @SerializedName("due_on")
    val dueOn: Any, // null
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/oppia/oppia-android/milestone/4
    @SerializedName("id")
    val id: Int, // 4540939
    @SerializedName("labels_url")
    val labelsUrl: String, // https://api.github.com/repos/oppia/oppia-android/milestones/4/labels
    @SerializedName("node_id")
    val nodeId: String, // MDk6TWlsZXN0b25lNDU0MDkzOQ==
    @SerializedName("number")
    val number: Int, // 4
    @SerializedName("open_issues")
    val openIssues: Int, // 25
    @SerializedName("state")
    val state: String, // open
    @SerializedName("title")
    val title: String, // Global Availability
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-03-30T12:36:43Z
    @SerializedName("url")
    val url: String // https://api.github.com/repos/oppia/oppia-android/milestones/4
)