package O71_language_kotlin_004_kotlin_inner_class

class OuterClass {
    var outerField = 10;

    class InnerClass{
        fun printOuterField(){
            // This line will result in a compilation error:
            // Unresolved reference: outerField
            //TODO
//            println("Outer Field: $outerField")
        }
    }
}


fun main() {
    val outer = OuterClass()

    // Creating an instance of the inner class
    val inner = OuterClass.InnerClass()

    // Attempting to access outerField from the inner class
    inner.printOuterField()
}
