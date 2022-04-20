package net.onyr.koans

import java.util.Calendar

// comparison
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        return (this.year - other.year)*365 +
                (this.month - other.month)*30 +
                this.dayOfMonth - other.dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}

// ranges
fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}

// for loop / iterator
class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current: MyDate = start

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                /* Once you obtain an iterator, it points to the first element
                 * of a collection; calling the next() function returns this element
                 * and moves the iterator position to the following element if it exists.
                 */
                val result = current
                current = current.followingDate() // iterate
                return result
            }

            // WARN: contrary to the name, consider last element has a next element
            // This is because .next() return the current element, not the following one
            override fun hasNext(): Boolean = current <= end
        }
    }
}
operator fun MyDate.rangeTo(other: MyDate): Iterable<MyDate> = DateRange(this, other) // set MyDate.rangeTo

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

// utils and helpers
fun MyDate.followingDate(): MyDate {
    val c = Calendar.getInstance()
    c.set(this.year, this.month, this.dayOfMonth)
    val millisecondsInDay = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + millisecondsInDay
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(
        result.get(Calendar.YEAR),
        result.get(Calendar.MONTH),
        result.get(Calendar.DATE),
    )
}

object ConventionsKoan : Koan("Conventions") {
    override fun run() {
        super.run() // call original run method

        test(
            MyDate(2020, 12, 2),
            MyDate(2020, 11, 19)
        );
        println(checkInRange(
            MyDate(2020, 12, 2),
            MyDate(2020, 11, 19),
            MyDate(2021, 2, 12)
        ))

        iterateOverDateRange(
            MyDate(2020, 11, 19),
            MyDate(2020, 11, 23)
        /* NOTE: Kotlin style guide - Kotlin lambda parameters can
        (and actually should be) outside parentheses. */
        ) { date: MyDate -> println(date) }
    }
}