package divyansh.tech.androgit.features.home.pull_requests.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import divyansh.tech.data.models.pullRequests.Item

class EpoxyPrController: TypedEpoxyController<List<Item>>() {
    override fun buildModels(data: List<Item>?) {
        data?.let {
            it.forEach {
                epoxyPr {
                    id(it.id)
                    items(it)
                }
            }
        }
    }
}