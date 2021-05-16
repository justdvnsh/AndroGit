package divyansh.tech.data.models.pullRequests


import com.google.gson.annotations.SerializedName

data class Pulls(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean, // false
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int // 66
)