
package com.onimus.blablasocialmedia.mvvm.extensions

import java.util.regex.Pattern

fun String.patternMatch(pattern: Pattern): Boolean =
    pattern.matcher(this).matches()