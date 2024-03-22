/*
 * Copyright 2019-2020 JetBrains s.r.o.
 * Use of this source code is governed by the Apache 2.0 License that can be found in the LICENSE.txt file.
 */

package kotlinx.datetime

/**
 * The enumeration class representing the days of the week.
 *
 * Usually acquired from [LocalDate.dayOfWeek], but can be constructed using the `DayOfWeek` factory function that
 * accepts the ISO 8601 day number. This number can be obtained from the [isoDayNumber] property.
 */
public expect enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

/**
 * The ISO 8601 number of the given day of the week. Monday is 1, Sunday is 7.
 */
public val DayOfWeek.isoDayNumber: Int get() = ordinal + 1

/**
 * Returns the [DayOfWeek] instance for the given ISO 8601 week day number. Monday is 1, Sunday is 7.
 *
 * @throws IllegalArgumentException if the day number is not in the range 1..7
 */
public fun DayOfWeek(isoDayNumber: Int): DayOfWeek {
    require(isoDayNumber in 1..7)
    return DayOfWeek.entries[isoDayNumber - 1]
}
