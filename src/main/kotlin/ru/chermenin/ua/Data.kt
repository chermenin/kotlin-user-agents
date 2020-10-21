package ru.chermenin.ua

data class Version(
    val major: String? = null,
    val minor: String? = null,
    val patch: String? = null,
    val patchMinor: String? = null
) {

    override fun toString(): String {
        return listOf(major, minor, patch, patchMinor)
            .filter { it?.isNotBlank() ?: false }
            .joinToString(".")
    }
}

data class OS(val family: String, val version: Version) {

    override fun toString(): String {
        return "$family $version".trim()
    }
}

data class Browser(val family: String, val version: Version) {

    override fun toString(): String {
        return "$family $version".trim()
    }
}

////////////////////////////////////////////////////////////////////////////////

val TABLET_DEVICE_FAMILIES = listOf(
    "iPad",
    "BlackBerry Playbook",
    "Blackberry Playbook",
    "Kindle",
    "Kindle Fire",
    "Kindle Fire HD",
    "Galaxy Tab",
    "Xoom",
    "Dell Streak",
)

val MOBILE_DEVICE_FAMILIES = listOf(
    "iPhone",
    "iPod",
    "Generic Smartphone",
    "Generic Feature Phone",
    "PlayStation Vita",
    "iOS-Device"
)

val MOBILE_OS_FAMILIES = listOf(
    "Windows Phone",
    "Windows Phone OS",
    "Symbian OS",
    "Bada",
    "Windows CE",
    "Windows Mobile",
    "Maemo",
)

val MOBILE_BROWSER_FAMILIES = listOf(
    "IE Mobile",
    "Opera Mobile",
    "Opera Mini",
    "Chrome Mobile",
    "Chrome Mobile WebView",
    "Chrome Mobile iOS",
)


val PC_OS_FAMILIES = listOf(
    "Windows 95",
    "Windows 98",
    "Solaris",
)

val TOUCH_CAPABLE_OS_FAMILIES = listOf(
    "iOS",
    "Android",
    "Windows Phone",
    "Windows CE",
    "Windows Mobile",
    "Firefox OS",
    "MeeGo",
)

val TOUCH_CAPABLE_DEVICE_FAMILIES = listOf(
    "BlackBerry Playbook",
    "Blackberry Playbook",
    "Kindle Fire",
)

val EMAIL_PROGRAM_FAMILIES = listOf(
    "Outlook",
    "Windows Live Mail",
    "AirMail",
    "Apple Mail",
    "Outlook",
    "Thunderbird",
    "Lightning",
    "ThunderBrowse",
    "Windows Live Mail",
    "The Bat!",
    "Lotus Notes",
    "IBM Notes",
    "Barca",
    "MailBar",
    "kmail2",
    "YahooMobileMail"
)
