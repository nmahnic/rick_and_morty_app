package com.nicomahnic.domain.model

const val DEFAULT_ITEMS_COUNT = 5

fun <T> getSome(
    itemsCount: Int = DEFAULT_ITEMS_COUNT,
    builder: (index: Int) -> T
): List<T> {
    return List(itemsCount) { index ->
        builder(index)
    }
}