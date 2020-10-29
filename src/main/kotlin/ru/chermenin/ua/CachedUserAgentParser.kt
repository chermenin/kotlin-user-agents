package ru.chermenin.ua

/**
 * Implementation of the parser with cached values.
 *
 * @param initialEntries initial size of the cache
 * @param maxEntries max count of entries in the cache
 */
class CachedUserAgentParser(initialEntries: Int = 1000, maxEntries: Int = 5000) {

    private val cache = LRUCache<String, UserAgent>(initialEntries, maxEntries)

    /**
     * Method to parse user agent string and return [UserAgent] object.
     *
     * @param userAgentString user agent string to parse
     * @return [UserAgent] object for the defined string
     */
    fun parse(userAgentString: String): UserAgent {
        return cache.getOrPut(userAgentString) { UserAgent.parse(userAgentString) }
    }
}

/**
 * Simple implementation of LRU cache class.
 *
 * @param initialEntries initial size of the cache
 * @param maxEntries max count of entries in the cache
 */
private class LRUCache<K, V>(private val initialEntries: Int, private val maxEntries: Int) :
    LinkedHashMap<K, V>(initialEntries, 0.8f, true) {

    override fun removeEldestEntry(eldest: Map.Entry<K, V>?): Boolean {
        return size > maxEntries
    }
}
