package divyansh.tech.data.models.pullRequests


import com.google.gson.annotations.SerializedName
import divyansh.tech.data.models.users.User

data class Item(
    @SerializedName("active_lock_reason")
    val activeLockReason: Any, // null
    @SerializedName("assignee")
    val assignee: Any, // null
    @SerializedName("assignees")
    val assignees: List<Assignee>,
    @SerializedName("author_association")
    val authorAssociation: String, // CONTRIBUTOR
    @SerializedName("body")
    val body: String, // ### DescriptionAdded task Comment Feature as described in  issue #776 Fixes #776 ### Type of Change:- Code- User Interface**Code/Quality Assurance Only**- This change requires a documentation update (software upgrade on readme file)- New feature (non-breaking change which adds functionality pre-approved by mentors)### Checklist:- [x] My PR follows the style guidelines of this project- [x] I have performed a self-review of my own code or materials- [x] I have commented my code or provided relevant documentation, particularly in hard-to-understand areas- [x] I have made corresponding changes to the documentation- [x] Any dependent changes have been merged- [x] I have written Kotlin Docs whenever is applicable**Code/Quality Assurance Only**- [x] My changes generate no new warnings- [x] My PR currently breaks something (fix or feature that would cause existing functionality to not work as expected)- [x] I have added tests that prove my fix is effective or that my feature works- [x] New and existing unit tests pass locally with my changes- [x] Any dependent changes have been published in downstream modules
    @SerializedName("closed_at")
    val closedAt: Any, // null
    @SerializedName("comments")
    val comments: Int, // 2
    @SerializedName("comments_url")
    val commentsUrl: String, // https://api.github.com/repos/anitab-org/mentorship-android/issues/1129/comments
    @SerializedName("created_at")
    val createdAt: String, // 2021-04-23T12:51:24Z
    @SerializedName("draft")
    val draft: Boolean, // false
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/repos/anitab-org/mentorship-android/issues/1129/events
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/anitab-org/mentorship-android/pull/1129
    @SerializedName("id")
    val id: Int, // 866082367
    @SerializedName("labels")
    val labels: List<Label>,
    @SerializedName("labels_url")
    val labelsUrl: String, // https://api.github.com/repos/anitab-org/mentorship-android/issues/1129/labels{/name}
    @SerializedName("locked")
    val locked: Boolean, // false
    @SerializedName("milestone")
    val milestone: Any, // null
    @SerializedName("node_id")
    val nodeId: String, // MDExOlB1bGxSZXF1ZXN0NjIyMDQ1Njgz
    @SerializedName("number")
    val number: Int, // 1129
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any, // null
    @SerializedName("pull_request")
    val pullRequest: PullRequest,
    @SerializedName("repository_url")
    val repositoryUrl: String, // https://api.github.com/repos/anitab-org/mentorship-android
    @SerializedName("score")
    val score: Double, // 1.0
    @SerializedName("state")
    val state: String, // open
    @SerializedName("title")
    val title: String, // Added task comment feature
    @SerializedName("updated_at")
    val updatedAt: String, // 2021-04-25T12:43:03Z
    @SerializedName("url")
    val url: String, // https://api.github.com/repos/anitab-org/mentorship-android/issues/1129
    @SerializedName("user")
    val user: User
)