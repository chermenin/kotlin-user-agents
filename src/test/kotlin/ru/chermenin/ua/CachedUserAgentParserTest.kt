package ru.chermenin.ua

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CachedUserAgentParserTest {

    private val iPhoneString = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3"
    private val iPadString = "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10"
    private val galaxyTabString = "Mozilla/5.0 (Linux; U; Android 2.2; en-us; SCH-I800 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
    private val galaxyS3String = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"

    @Test
    fun testCachedParser() {
        val parser = CachedUserAgentParser(1, 3)

        val iPhone = parser.parse(iPhoneString)
        val iPad = parser.parse(iPadString)
        val galaxyTab = parser.parse(galaxyTabString)

        assertTrue("iPhone UA object must be the same") { iPhone === parser.parse(iPhoneString) }
        assertTrue("iPad UA object must be the same") { iPad === parser.parse(iPadString) }
        assertTrue("galaxyTab UA object must be the same") { galaxyTab === parser.parse(galaxyTabString) }

        val galaxyS3 = parser.parse(galaxyS3String)

        assertTrue("iPad UA object must be the same") { iPad === parser.parse(iPadString) }
        assertTrue("galaxyTab UA object must be the same") { galaxyTab === parser.parse(galaxyTabString) }
        assertTrue("galaxyS3 UA object must be the same") { galaxyS3 === parser.parse(galaxyS3String) }
        assertFalse("iPhone UA object already must not be the same") { iPhone === parser.parse(iPhoneString) }
    }
}
