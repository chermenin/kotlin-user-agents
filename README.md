## Kotlin User Agents

[![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/chermenin/kotlin-user-agents/gradle.yml)](https://github.com/chermenin/kotlin-user-agents/actions/workflows/gradle.yml)
[![GitHub Packages](https://img.shields.io/github/v/release/chermenin/kotlin-user-agents)](https://github.com/chermenin/kotlin-user-agents/packages/)

It's a Kotlin port of the [selwin](//github.com/selwin)'s [Python library](//github.com/selwin/python-user-agents) that provides an easy way to identify/detect devices like mobile phones, tablets and their capabilities by parsing user agent strings. The goal is to reliably detect whether:

- User agent is a mobile, tablet or PC based device
- User agent has touch capabilities (has touch screen)

### Installation

Before using the library you have to add something similar to the following block to dependencies:

```xml
<dependency>
    <groupId>ru.chermenin</groupId>
    <artifactId>kotlin-user-agents</artifactId>
    <version>x.y.z</version>
</dependency>
```

### Usage

Here is an example how to use this library:

```kotlin
// iPhone's user agent string
val uaString = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3"
val ua = UserAgent.parse(uaString)

// Accessing user agent's browser attributes
ua.browser                      // Browser(family=Mobile Safari, version=Version(major=5, minor=1, patch=null, patchMinor=null))
ua.browser.family               // "Mobile Safari"
ua.browser.version              // Version(major=5, minor=1, patch=null, patchMinor=null)
ua.browser.version.toString()   // "5.1"

// Accessing user agent's operating system properties
ua.os                      // OS(family=iOS, version=Version(major=5, minor=1, patch=null, patchMinor=null))
ua.os.family               // "iOS"
ua.os.version              // Version(major=5, minor=1, patch=null, patchMinor=null)
ua.os.version.toString()   // "5.1"

// Getting user agent's device type
ua.device   // "iPhone"

// Viewing a pretty string version
ua.toString()   // "iPhone / iOS 5.1 / Mobile Safari 5.1"

// And a few other attributes
ua.isMobile()         // true
ua.isTablet()         // false
ua.isTouchCapable()   // true
ua.isPC()             // false
ua.isBot()            // false
```

The same if to use the library in Java:

```java
// iPhone's user agent string
String uaString = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3";
UserAgent ua = UserAgent.Companion.parse(uaString);

// Accessing user agent's browser attributes
ua.getBrowser();                          // Browser(family=Mobile Safari, version=Version(major=5, minor=1, patch=null, patchMinor=null))
ua.getBrowser().getFamily();              // "Mobile Safari"
ua.getBrowser().getVersion();             // Version(major=5, minor=1, patch=null, patchMinor=null)
ua.getBrowser().getVersion().toString();  // "5.1"

// Accessing user agent's operating system properties
ua.getOs();                          // OS(family=iOS, version=Version(major=5, minor=1, patch=null, patchMinor=null))
ua.getOs().getFamily();              // "iOS"
ua.getOs().getVersion();             // Version(major=5, minor=1, patch=null, patchMinor=null)
ua.getOs().getVersion().toString();  // "5.1"

// Getting user agent's device type
ua.getDevice();  // "iPhone"

// Viewing a pretty string version
ua.toString();  // "iPhone / iOS 5.1 / Mobile Safari 5.1"

// And a few other attributes
ua.isMobile();        // true
ua.isTablet();        // false
ua.isTouchCapable();  // true
ua.isPC();            // false
ua.isBot();           // false
```

#### Caching version

If you need to parse a lot of user agent strings, and they can be repeated you can use the version with a cache:

```kotlin
val parser = CachedUserAgentParser(initialEntries = 1000, maxEntries = 3000)
val ua = parser.parse(uaString)
...
```

### Changelog

#### Version 0.2.2 <sub><sup>`2022-02-08`</sup></sub>
- Some fixes for mobile OS and browsers

#### Version 0.2.1 <sub><sup>`2021-03-30`</sup></sub>
- Fixes for BlackBerry devices

#### Version 0.2.0 <sub><sup>`2020-10-29`</sup></sub>
- Added caching version of the parser

#### Version 0.1.0 <sub><sup>`2020-10-21`</sup></sub>
- Initial version (fully corresponds to the `python-user-agents` version 2.2.0)

### License

Copyright © 2020 Alex Chermenin  
Licensed under the MIT License
