package O71_language_kotlin_003_kotlin_type_array

class Main {

}

fun main(args: Array<String>) {
    val arrayName = Array(5) { i -> i * 1 }
    arrayName.forEach { i -> print("item: $i ") }
}