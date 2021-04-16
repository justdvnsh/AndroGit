package divyansh.tech.androgit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroGitApplication: Application() {
    override fun onCreate() = super.onCreate()
}