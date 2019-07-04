package ifpr.tads.josepher.trabfinal.entities.volume.items.outros

import ifpr.tads.josepher.trabfinal.entities.volume.items.outros.Epub
import ifpr.tads.josepher.trabfinal.entities.volume.items.outros.Pdf
import java.io.Serializable

class AccessInfo (
    var country: String,
    var viewability: String,
    var embeddable: Boolean,
    var publicDomain: String,
    var epub: Epub,
    var pdf: Pdf,
    var webReaderLink: String,
    var accessViewStatus: String,
    var quoteSharingAllowed: Boolean
): Serializable