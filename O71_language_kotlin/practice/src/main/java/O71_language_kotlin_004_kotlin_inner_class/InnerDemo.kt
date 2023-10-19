package O71_language_kotlin_004_kotlin_inner_class

class Car {
    lateinit var make: String
    lateinit var model: String
    var year: Int = 0

    inner class Engine {
        var horsepower: Int = 0
        var cylinders: Int = 0

        fun getEngineInfo(): String {
            return "$horsepower horsepower, $cylinders cylinders, in a $make $model"
        }
    }

    fun getInfo(): String{
        return "$make $model, year $year"
    }
}

fun main(){
    val myCar = Car()
    myCar.make = "Toyota"
    myCar.model = "Camry"
    myCar.year = 2020

    println(myCar.getInfo())

    val engine = myCar.Engine()
    engine.horsepower = 250
    engine.cylinders = 6

    println(engine.getEngineInfo())
}