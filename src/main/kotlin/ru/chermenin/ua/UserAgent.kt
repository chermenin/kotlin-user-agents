package ru.chermenin.ua

import ua_parser.Parser

class UserAgent private constructor(private val userAgentString: String) {

    companion object {
        val parser: Parser = Parser()

        fun parse(userAgentString: String): UserAgent {
            return UserAgent(userAgentString)
        }
    }

    private val client = parser.parse(userAgentString)

    val os = OS(
        client.os.family,
        Version(
            client.os.major,
            client.os.minor,
            client.os.patch,
            client.os.patchMinor
        )
    )

    val browser = Browser(
        client.userAgent.family,
        Version(
            client.userAgent.major,
            client.userAgent.minor,
            client.userAgent.patch
        )
    )

    val device = if (isPC()) "PC" else client.device.family ?: ""

    private fun isAndroidTablet(): Boolean {
        return !userAgentString.contains("Mobile Safari") && browser.family != "Firefox Mobile"
    }

    private fun isBlackberryTouchCapableDevice(): Boolean {
        return device.let {
            it.contains("Blackberry 95") || it.contains("Blackberry 99")
        }
    }

    fun isTablet(): Boolean {
        return TABLET_DEVICE_FAMILIES.contains(device) ||
                (os.family == "Android" && isAndroidTablet()) ||
                (os.family == "Windows" && os.version.major?.startsWith("RT") ?: false) ||
                (os.family == "Firefox OS" && !browser.family.contains("Mobile"))
    }

    fun isMobile(): Boolean {
        return MOBILE_DEVICE_FAMILIES.contains(device) ||
                MOBILE_BROWSER_FAMILIES.contains(browser.family) ||
                ((os.family == "Android" || os.family == "Firefox OS") && !isTablet()) ||
                (os.family == "BlackBerry OS" && device != "Blackberry Playbook") ||
                MOBILE_OS_FAMILIES.contains(os.family) ||
                userAgentString.contains("J2ME") ||
                userAgentString.contains("MIDP") ||
                userAgentString.contains("iPhone;") ||
                userAgentString.contains("Googlebot-Mobile") ||
                (device == "Spider" && browser.family.contains("Mobile")) ||
                (userAgentString.contains("NokiaBrowser") && userAgentString.contains("Mobile"))
    }

    fun isTouchCapable(): Boolean {
        return TOUCH_CAPABLE_OS_FAMILIES.contains(os.family) ||
                TOUCH_CAPABLE_DEVICE_FAMILIES.contains(device) ||
                (os.family == "Windows" && (
                        (os.version.major?.let {
                            it.startsWith("RT") || it.startsWith("CE")
                        } ?: false) ||
                                ((os.version.major?.startsWith("8") ?: false) &&
                                        userAgentString.contains("Touch"))
                        )) ||
                (os.family.contains("BlackBerry") && isBlackberryTouchCapableDevice())
    }

    fun isPC(): Boolean {
        return (userAgentString.contains("Windows NT") && !isTablet()) ||
                PC_OS_FAMILIES.contains(os.family) ||
                (os.family == "Windows" && os.version.major == "ME") ||
                (os.family == "Mac OS X" && !userAgentString.contains("Silk")) ||
                (userAgentString.contains("Linux") && userAgentString.contains("X11") && !userAgentString.contains("Maemo")) ||
                os.family.contains("Chrome OS")
    }

    fun isBot(): Boolean {
        return device == "Spider"
    }

    fun isEmailClient(): Boolean {
        return EMAIL_PROGRAM_FAMILIES.contains(browser.family)
    }

    override fun toString(): String {
        return "$device / $os / $browser"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserAgent

        if (os != other.os) return false
        if (browser != other.browser) return false
        if (device != other.device) return false

        return true
    }

    override fun hashCode(): Int {
        var result = os.hashCode()
        result = 31 * result + browser.hashCode()
        result = 31 * result + (device.hashCode())
        return result
    }
}
