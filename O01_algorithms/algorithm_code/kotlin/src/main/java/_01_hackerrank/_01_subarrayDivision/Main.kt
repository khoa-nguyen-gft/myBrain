package _01_hackerrank._01_subarray_division


fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var count = 0
    for (i in 0..s.size - m) {
        var sub = s.sliceArray(i until i + m)
        if(sub.sum() == d){
            count++
        }
    }
    return count;
}

fun main(args: Array<String>) {
    println(birthday(arrayOf(2, 2, 1, 3, 2), 4, 2))
}

