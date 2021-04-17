package divyansh.tech.data.models

import com.squareup.moshi.Json

data class AuthToken(
    @field:Json(name = "access_token")
    val access_token: String,
    @field:Json(name = "token_type")
    val token_type: String
)
