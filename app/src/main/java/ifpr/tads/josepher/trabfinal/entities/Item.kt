package ifpr.tads.josepher.trabfinal.entities

class Item(
    var kind: String?,
    var id: String?,
    var etag: String?,
    var selfLink:String?,
    var volumeInfo: List<Book>
)