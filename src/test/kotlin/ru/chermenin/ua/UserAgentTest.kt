package ru.chermenin.ua

import org.junit.Assert.*
import org.junit.Test
import ru.chermenin.ua.UserAgent.Companion.parse

class UserAgentTest {

    // User agents strings
    private val iPhoneString = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3"
    private val iPadString = "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10"
    private val galaxyTabString = "Mozilla/5.0 (Linux; U; Android 2.2; en-us; SCH-I800 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
    private val galaxyS3String = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"
    private val kindleFireString = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.1.0-80) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true"
    private val playbookString = "Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.0.1; en-US) AppleWebKit/535.8+ (KHTML, like Gecko) Version/7.2.0.1 Safari/535.8+"
    private val nexus7String = "Mozilla/5.0 (Linux; Android 4.1.1; Nexus 7 Build/JRO03D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19"
    private val windowsPhoneString = "Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; SAMSUNG; SGH-i917)"
    private val blackberryTorchString = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; zh-TW) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.448 Mobile Safari/534.8+"
    private val blackberryBoldString = "BlackBerry9700/5.0.0.862 Profile/MIDP-2.1 Configuration/CLDC-1.1 VendorID/331 UNTRUSTED/1.0 3gpp-gba"
    private val blackberryBoldTouchString = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9930; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.241 Mobile Safari/534.11+"
    private val windowsRtString = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; ARM; Trident/6.0)"
    private val j2meOperaString = "Opera/9.80 (J2ME/MIDP; Opera Mini/9.80 (J2ME/22.478; U; en) Presto/2.5.25 Version/10.54"
    private val ieString = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)"
    private val ieTouchString = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Touch)"
    private val macSafariString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/537.13+ (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2"
    private val windowsIeString = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)"
    private val ubuntuFirefoxString = "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:15.0) Gecko/20100101 Firefox/15.0.1"
    private val googleBotString = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"
    private val nokiaN97String = "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/12.0.024; Profile/MIDP-2.1 Configuration/CLDC-1.1; en-us) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.12344"
    private val androidFirefoxAuroraString = "Mozilla/5.0 (Android; Mobile; rv:27.0) Gecko/27.0 Firefox/27.0"
    private val thunderbirdString = "Mozilla/5.0 (X11; Linux x86_64; rv:38.0) Gecko/20100101 Thunderbird/38.2.0 Lightning/4.0.2"
    private val outlookString = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/6.0; Microsoft Outlook 15.0.4420)"
    private val chromebookString = "Mozilla/5.0 (X11; CrOS i686 0.12.433) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.77 Safari/534.30"

    // Parsed user agents
    private val iPhone = parse(iPhoneString)
    private val iPad = parse(iPadString)
    private val galaxyTab = parse(galaxyTabString)
    private val galaxyS3 = parse(galaxyS3String)
    private val kindleFire = parse(kindleFireString)
    private val playbook = parse(playbookString)
    private val nexus7 = parse(nexus7String)
    private val windowsPhone = parse(windowsPhoneString)
    private val windowsRt = parse(windowsRtString)
    private val blackberryTorch = parse(blackberryTorchString)
    private val blackberryBold = parse(blackberryBoldString)
    private val blackberryBoldTouch = parse(blackberryBoldTouchString)
    private val j2meOpera = parse(j2meOperaString)
    private val ie = parse(ieString)
    private val ieTouch = parse(ieTouchString)
    private val macSafari = parse(macSafariString)
    private val windowsIe = parse(windowsIeString)
    private val ubuntuFirefox = parse(ubuntuFirefoxString)
    private val googleBot = parse(googleBotString)
    private val nokiaN97 = parse(nokiaN97String)
    private val androidFirefoxAurora = parse(androidFirefoxAuroraString)
    private val chromebook = parse(chromebookString)
    private val thunderbird = parse(thunderbirdString)
    private val outlook = parse(outlookString)

    @Test
    fun isTabletTest() {
        assertFalse(iPhone.isTablet())
        assertTrue(iPad.isTablet())
        assertFalse(galaxyTab.isTablet())
        assertFalse(galaxyS3.isTablet())
        assertTrue(kindleFire.isTablet())
        assertTrue(playbook.isTablet())
        assertTrue(nexus7.isTablet())
        assertFalse(windowsPhone.isTablet())
        assertTrue(windowsRt.isTablet())
        assertFalse(blackberryTorch.isTablet())
        assertFalse(blackberryBold.isTablet())
        assertFalse(blackberryBoldTouch.isTablet())
        assertFalse(j2meOpera.isTablet())
        assertFalse(ie.isTablet())
        assertFalse(ieTouch.isTablet())
        assertFalse(macSafari.isTablet())
        assertFalse(windowsIe.isTablet())
        assertFalse(ubuntuFirefox.isTablet())
        assertFalse(googleBot.isTablet())
        assertFalse(nokiaN97.isTablet())
        assertFalse(androidFirefoxAurora.isTablet())
    }

    @Test
    fun isMobileTest() {
        assertTrue(iPhone.isMobile())
        assertFalse(iPad.isMobile())
        assertTrue(galaxyTab.isMobile())
        assertTrue(galaxyS3.isMobile())
        assertFalse(kindleFire.isMobile())
        assertFalse(playbook.isMobile())
        assertFalse(nexus7.isMobile())
        assertTrue(windowsPhone.isMobile())
        assertFalse(windowsRt.isMobile())
        assertTrue(blackberryTorch.isMobile())
        assertTrue(blackberryBold.isMobile())
        assertTrue(blackberryBoldTouch.isMobile())
        assertTrue(j2meOpera.isMobile())
        assertFalse(ie.isMobile())
        assertFalse(ieTouch.isMobile())
        assertFalse(macSafari.isMobile())
        assertFalse(windowsIe.isMobile())
        assertFalse(ubuntuFirefox.isMobile())
        assertFalse(googleBot.isMobile())
        assertTrue(nokiaN97.isMobile())
        assertTrue(androidFirefoxAurora.isMobile())
    }

    @Test
    fun isTouchCapableTest() {
        assertTrue(iPhone.isTouchCapable())
        assertTrue(iPad.isTouchCapable())
        assertTrue(galaxyTab.isTouchCapable())
        assertTrue(galaxyS3.isTouchCapable())
        assertTrue(kindleFire.isTouchCapable())
        assertTrue(playbook.isTouchCapable())
        assertTrue(nexus7.isTouchCapable())
        assertTrue(windowsPhone.isTouchCapable())
        assertTrue(windowsRt.isTouchCapable())
        assertTrue(blackberryTorch.isTouchCapable())
        assertFalse(blackberryBold.isTouchCapable())
        assertTrue(blackberryBoldTouch.isTouchCapable())
        assertFalse(j2meOpera.isTouchCapable())
        assertFalse(ie.isTouchCapable())
        assertTrue(ieTouch.isTouchCapable())
        assertFalse(macSafari.isTouchCapable())
        assertFalse(windowsIe.isTouchCapable())
        assertFalse(ubuntuFirefox.isTouchCapable())
        assertFalse(googleBot.isTouchCapable())
        assertFalse(nokiaN97.isTouchCapable())
        assertTrue(androidFirefoxAurora.isTouchCapable())
    }

    @Test
    fun isPCTest() {
        assertFalse(iPhone.isPC())
        assertFalse(iPad.isPC())
        assertFalse(galaxyTab.isPC())
        assertFalse(galaxyS3.isPC())
        assertFalse(kindleFire.isPC())
        assertFalse(playbook.isPC())
        assertFalse(nexus7.isPC())
        assertFalse(windowsPhone.isPC())
        assertFalse(windowsRt.isPC())
        assertFalse(blackberryTorch.isPC())
        assertFalse(blackberryBold.isPC())
        assertFalse(blackberryBoldTouch.isPC())
        assertFalse(j2meOpera.isPC())
        assertTrue(ie.isPC())
        assertTrue(ieTouch.isPC())
        assertTrue(macSafari.isPC())
        assertTrue(windowsIe.isPC())
        assertTrue(ubuntuFirefox.isPC())
        assertFalse(googleBot.isPC())
        assertFalse(nokiaN97.isPC())
        assertFalse(androidFirefoxAurora.isPC())
        assertTrue(chromebook.isPC())
    }

    @Test
    fun isBotTest() {
        assertFalse(iPhone.isBot())
        assertFalse(iPad.isBot())
        assertFalse(galaxyTab.isBot())
        assertFalse(galaxyS3.isBot())
        assertFalse(kindleFire.isBot())
        assertFalse(playbook.isBot())
        assertFalse(nexus7.isBot())
        assertFalse(windowsPhone.isBot())
        assertFalse(windowsRt.isBot())
        assertFalse(blackberryTorch.isBot())
        assertFalse(blackberryBold.isBot())
        assertFalse(blackberryBoldTouch.isBot())
        assertFalse(j2meOpera.isBot())
        assertFalse(ie.isBot())
        assertFalse(ieTouch.isBot())
        assertFalse(macSafari.isBot())
        assertFalse(windowsIe.isBot())
        assertFalse(ubuntuFirefox.isBot())
        assertTrue(googleBot.isBot())
        assertFalse(nokiaN97.isBot())
        assertFalse(androidFirefoxAurora.isBot())
        assertFalse(chromebook.isBot())
    }

    @Test
    fun isEmailClientTest() {
        assertFalse(iPhone.isEmailClient())
        assertFalse(iPad.isEmailClient())
        assertFalse(galaxyTab.isEmailClient())
        assertFalse(galaxyS3.isEmailClient())
        assertFalse(kindleFire.isEmailClient())
        assertFalse(playbook.isEmailClient())
        assertFalse(nexus7.isEmailClient())
        assertFalse(windowsPhone.isEmailClient())
        assertFalse(windowsRt.isEmailClient())
        assertFalse(blackberryTorch.isEmailClient())
        assertFalse(blackberryBold.isEmailClient())
        assertFalse(blackberryBoldTouch.isEmailClient())
        assertFalse(j2meOpera.isEmailClient())
        assertFalse(ie.isEmailClient())
        assertFalse(ieTouch.isEmailClient())
        assertFalse(macSafari.isEmailClient())
        assertFalse(windowsIe.isEmailClient())
        assertFalse(ubuntuFirefox.isEmailClient())
        assertFalse(googleBot.isEmailClient())
        assertFalse(nokiaN97.isEmailClient())
        assertFalse(androidFirefoxAurora.isEmailClient())
        assertFalse(chromebook.isEmailClient())
        assertTrue(thunderbird.isEmailClient())
        assertTrue(outlook.isEmailClient())
    }
    
    @Test
    fun toStringTest() {
        assertEquals("iPhone / iOS 5.1 / Mobile Safari 5.1", iPhone.toString())
        assertEquals("iPad / iOS 3.2 / Mobile Safari 4.0.4", iPad.toString())
        assertEquals("Samsung SCH-I800 / Android 2.2 / Android 2.2", galaxyTab.toString())
        assertEquals("Samsung GT-I9300 / Android 4.0.4 / Android 4.0.4", galaxyS3.toString())
        assertEquals("Kindle / Android / Amazon Silk 1.1.0-80", kindleFire.toString())
        assertEquals("BlackBerry Playbook / BlackBerry Tablet OS 2.0.1 / BlackBerry WebKit 2.0.1", playbook.toString())
        assertEquals("Asus Nexus 7 / Android 4.1.1 / Chrome 18.0.1025", nexus7.toString())
        assertEquals("Samsung SGH-i917 / Windows Phone 7.5 / IE Mobile 9.0", windowsPhone.toString())
        assertEquals("Other / Windows RT / IE 10.0", windowsRt.toString())
        assertEquals("BlackBerry 9800 / BlackBerry OS 6.0.0.448 / BlackBerry WebKit 6.0.0", blackberryTorch.toString())
        assertEquals("BlackBerry 9700 / BlackBerry OS 5.0.0.862 / BlackBerry 9700", blackberryBold.toString())
        assertEquals("BlackBerry 9930 / BlackBerry OS 7.0.0.241 / BlackBerry WebKit 7.0.0", blackberryBoldTouch.toString())
        assertEquals("Generic Feature Phone / Other / Opera Mini 9.80", j2meOpera.toString())
        assertEquals("PC / Windows 8 / IE 10.0", ie.toString())
        assertEquals("PC / Windows 8 / IE 10.0", ieTouch.toString())
        assertEquals("PC / Mac OS X 10.6.8 / WebKit Nightly 537.13", macSafari.toString())
        assertEquals("PC / Windows 7 / IE 9.0", windowsIe.toString())
        assertEquals("PC / Ubuntu / Firefox 15.0.1", ubuntuFirefox.toString())
        assertEquals("Spider / Other / Googlebot 2.1", googleBot.toString())
        assertEquals("Nokia N97 / Symbian OS 9.4 / Nokia Browser 7.1.12344", nokiaN97.toString())
        assertEquals("Generic Smartphone / Android / Firefox Mobile 27.0", androidFirefoxAurora.toString())
    }
}
