package divyansh.tech.data.models.PullRequests


import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("diff_url")
    val diffUrl: String, // https://github.com/anitab-org/mentorship-android/pull/1129.diff
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/anitab-org/mentorship-android/pull/1129
    @SerializedName("patch_url")
    val patchUrl: String, // https://github.com/anitab-org/mentorship-android/pull/1129.patch
    @SerializedName("url")
    val url: String // https://api.github.com/repos/anitab-org/mentorship-android/pulls/1129
)