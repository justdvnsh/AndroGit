package divyansh.tech.androgit.features.home.issues.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import divyansh.tech.data.models.issues.Issue

class EpoxyIssueController(): TypedEpoxyController<List<Issue>>() {
    override fun buildModels(data: List<Issue>?) {
        data?.let {
            it.forEach {
                epoxyIssue {
                    id(it.id)
                    issues(it)
                }
            }
        }
    }
}