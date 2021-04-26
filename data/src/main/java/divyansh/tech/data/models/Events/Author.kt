package divyansh.tech.data.models.Events


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("email")
    val email: String, // justdvnsh2208@gmail.com
    @SerializedName("name")
    val name: String // Divyansh Dwivedi
)