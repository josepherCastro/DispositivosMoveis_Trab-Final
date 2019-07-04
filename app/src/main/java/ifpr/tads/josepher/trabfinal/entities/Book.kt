package ifpr.tads.josepher.trabfinal.entities

import ifpr.tads.josepher.trabfinal.entities.volume.items.book.Althor
import java.io.Serializable

class Book (
    var title: String?,
    var subTitle: String?,
    var althor: List<Althor>?,
    var publishdDate: String?,
    var edition: String?,
    var category: String?,
    var publishingCompany: String,
    var description: String?
): Serializable