package divyansh.tech.data.models

import com.google.gson.annotations.SerializedName


data class AuthToken(
    @SerializedName( "access_token")
    val access_token: String,
    @SerializedName("token_type")
    val token_type: String
)
