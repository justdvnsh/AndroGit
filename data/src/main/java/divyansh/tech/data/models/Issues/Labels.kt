package divyansh.tech.data.models.Issues

import com.google.gson.annotations.SerializedName

data class Labels (

	@SerializedName("id") val id : Long,
	@SerializedName("node_id") val node_id : String,
	@SerializedName("url") val url : String,
	@SerializedName("name") val name : String,
	@SerializedName("color") val color : String,
	@SerializedName("default") val default : Boolean,
	@SerializedName("description") val description : String
)