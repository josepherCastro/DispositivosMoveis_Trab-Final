package ifpr.tads.josepher.trabfinal.entities.volume.items

import ifpr.tads.josepher.trabfinal.entities.volume.items.outros.AccessInfo
import ifpr.tads.josepher.trabfinal.entities.Book
import ifpr.tads.josepher.trabfinal.entities.volume.items.outros.SaleInfo
import ifpr.tads.josepher.trabfinal.entities.volume.items.outros.SearchInfo
import java.io.Serializable

class Item(
    var kind: String?,
    var ids: String?,
    var etag: String?,
    var selfLink:String?,
    var volumeInfo: Book,
    var saleInfo: SaleInfo,
    var acccesInfo: AccessInfo,
    var searchInfo: SearchInfo
): Serializable