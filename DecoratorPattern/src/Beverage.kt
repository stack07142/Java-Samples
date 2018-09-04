abstract class Beverage {
    abstract var description: String
    abstract fun cost(): Int

    override fun toString(): String {
        return "$description (${cost()})"
    }
}

class Coffee : Beverage() {
    override var description: String = "[Coffee]"
    override fun cost(): Int {
        return 1000
    }
}

class Tea : Beverage() {
    override var description: String = "[Tea]"
    override fun cost(): Int {
        return 500
    }
}

class Decaf : Beverage() {
    override var description: String = "[Decaf]"
    override fun cost(): Int {
        return 1500
    }
}

abstract class Decorator : Beverage() {
    abstract val beverage: Beverage
}

class Whip(override val beverage: Beverage) : Decorator() {
    override var description: String = beverage.description + "_Whip"
    override fun cost(): Int = beverage.cost() + 300
}

class Mocha(override val beverage: Beverage) : Decorator() {
    override var description: String = beverage.description + "_Mocha"
    override fun cost(): Int = beverage.cost() + 200
}

class Milk(override val beverage: Beverage) : Decorator() {
    override var description: String = beverage.description + "_Milk"
    override fun cost(): Int = beverage.cost() + 400
}

/**
 * 클래스는 확장에 대해서는 열려 있어야 하지만 코드 변경에 대해서는 닫혀 있어야 한다.
 */
fun main(args: Array<String>) {

    var myBeverage: Beverage = Coffee()
    myBeverage = Whip(myBeverage)
    myBeverage = Mocha(myBeverage)
    myBeverage = Mocha(myBeverage)
    myBeverage = Milk(myBeverage)

    println(myBeverage)
}