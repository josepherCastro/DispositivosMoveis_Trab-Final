package ifpr.tads.josepher.trabfinal.entities

import java.io.Serializable

class Book (
    var title: String?,
    var subTitle: String?,
    var althor: List<String>?,
    var publishdDate: String?,
    var edition: String?,
    var category: String?,
    var publishingCompany: String,
    var description: String?
): Serializable