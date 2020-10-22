## Kotlin User Agents

[![Build Status](https://travis-ci.com/chermenin/kotlin-user-agents.svg?branch=master)](https://travis-ci.com/chermenin/kotlin-user-agents)
[![Maven Central](https://img.shields.io/maven-central/v/ru.chermenin/kotlin-user-agents)](https://search.maven.org/search?q=g:ru.chermenin%20AND%20a:kotlin-user-agents)

It's a Kotlin port of the [selwin](//github.com/selwin)'s [Python library](//github.com/selwin/python-user-agents) that provides an easy way to identify/detect devices like mobile phones, tablets and their capabilities by parsing user agent strings. The goal is to reliably detect whether:

- User agent is a mobile, tablet or PC based device
- User agent has touch capabilities (has touch screen)

<!-- todo: Enable block after release

### Installation

Before using the library you have to add the following block to dependencies:

```xml
<dependency>
    <groupId>ru.chermenin</groupId>
    <artifactId>kotlin-user-agents</artifactId>
    <version>x.y.z</version>
</dependency>
```

-->

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

### Changelog

#### Version 0.1.0 <sub><sup>`2020-10-21`</sup></sub>
- Initial verstion (fully corresponds to the `python-user-agents` version 2.2.0)

### License

Copyright © 2020 Alex Chermenin  
Licensed under the MIT License
