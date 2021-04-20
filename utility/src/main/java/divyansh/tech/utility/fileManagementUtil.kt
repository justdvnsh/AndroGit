package divyansh.tech.utility

import android.content.Context

object fileManagementUtil {

    fun createCacheFile(
        context: Context
    ) = context.cacheDir.createNewFile()
}