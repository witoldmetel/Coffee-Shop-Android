https://firtman.github.io/intro-kotlin/

# Basic Expressions

Kotlin code looks in its first view as many other languages

1. We can have global expressions without the need of a function or class. However, if you are targeting Android, you will always need a class (Java VM requirement)
2. Semi-colons are optional, not recommended unless two expressions share a line
3. We use (mandatory) curly braces for code blocks following C-syntax.
4. Spaces and new lines are, most of the time, ignored

```
var x = 1; var y = 2

// Boolean conditions need parenthesis
if ((x > 1) && (y < 2)) {

}

while (x < 10) {
    x++
}

print(x)      // println sends a message to the console. Android console buffers it
println(x)    // println sends a message to the console with a new line after
```

## Name style guidelines

```
// Variable, function and package names use camelCase
var name: String = ""
val tax = 7.8
fun printMessage() { }

// Constant names are using UPPER_SNAKE_CASE
object List {
    const val MAX_LENGTH = 4
}

// Data types use TitleCase.
// TitleClase also applies to Singleton variables and Objects!!
class CustomerOrder { }
object MyObject { }
interface MyInterface { }
val SingletonInstance: Any = TODO()

// Valid identifiers: as most languages, but with steroids - Careful on Android
var español = "hola"
var 愛 = "love"

// Conditionals are expressions; replaces the ternary operator from other languages
val result = if (tax>8) "high tax" else "low tax"

// When, replaces the `switch` from other languages
var price: Any = 2
when (price) {
    0 -> println("No price")
    1 -> {
        print("That's ")
        print("cheap!")
    }
    in 2..10 -> println("Still cheap")
    11, 12, 13 -> println("Getting expensive")
    is String -> println("What's that!?")
    else -> println("Expensive!")
}

// Loops: standard while and for-in
for (i in 0..10) {
    println(i)
}
```

# Variables and Types

Kotlin is a statically typed language, but it's also flexible and support type inference

```
// Mutable Variables use the keyword `var`
var data = 3
data = 5
data = 7

// Immutable Variables use the keyword `val` (value)
// We want to use val as much as possible
val notMutableObject = String()

// Constants use `const val` and they can only be applied to top-level structures
object TaxCalculator {
    const val SALES_TAX = 8.2
}

// Types are defined with colon after name, but they can be inferred by its initial value
var price: Double
var otherPrice = 325.99
// Sometimes we want to explicitly define the data type
var aThirdPrice = 23.0  // is it a Double? -> Yes

if (price==aThirdPrice) {}  // Structural equality
if (price===aThirdPrice) {} // Referencial equality

// Core Data Types
val string: String
var char: Char
val integer: Int      // also Byte, Short, Long
val double: Double    // also Float
val boolean: Boolean  // values are true and false
var what: Any         // avoid Any as much as possible

// String Literals, double quotes
print("Hello World")
// Multi-line literal strings
var multiline ="""
{

}
"""

// Every string can have template expressions using $ or ${}
// expression result will be converted to string
val message = "The $price price is ${otherPrice * 1.1}"
```

# Collections

Kotlin includes several collections ready to use, here just the ones we will use

```
// Lists, we use List<Type> and the type of the collection inside the generic
// The literal uses the listOf constructor
val countries: List<String> = listOf("Argentina", "Brazil", "Canada", "Denmark")
// countries is IMMUTABLE!

// If you want a mutable List, you have to use MutableList and mutableListOf constructor
val cities: MutableList<String> = mutableListOf("Alameda", "Buenos Aires", "Cali")
cities.add("Dali")

// We also have sets and maps (dictionaries)
// When we talk to the Android SDK sometimes we need to use Java arrays
val strings = hashSetOf("a", "b", "c", "c")
val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
val javaArray = arrayOf(countries)
```

# Null Safety

A String must have a string value, but a String? accepts null

```
var myName: String        // What's the value? Null? IMPOSSIBLE
var myLastname: String?   // It can handle a null value

// Null operators
// **************
print(myLastname.length)   // it doesn't work!

// not-null assertion operator
val lengthForSure = myLastname!!.length

// Safe calls
val length = myLastname?.length

// Default values
val lengthOrDefault = name?.count ?: 0   // What's the name of the ?: operator?

if name?.count is null, lengthOrDefault return 0

in JS we have ??

?: This is Elvis operator
```

# Functions

```
fun aFunction() {
    print("I'm a function")
}

fun aFunctionReturning(): String {
    return "I'm a function"
}

fun aFunctionReturning2(): String = "I'm a function"

// Arguments
fun sum(a: Int, b: Int): Int {
    return a+b
}

// How do you call sum?
sum(4, 1)
sum(a=4, b=1) // if you use this syntax you can change order of arguments like:
sum(b=1, a=4)
```

## Extension functions

You can add functions to any Type! Careful OOP extremists!

```
fun Int.isEven() : Boolean {
    return this % 2 == 0
}
```

# Lambda functions

Type is (arguments) -> ReturnType
if no return is expected, we use Unit (In Swift we have Void)

```
val myFunction: () -> Unit {

}
// implicit `it` argument when there is only one argument
// you can still name it if you want to
val greet: (String) -> String
greet = {
    return "Hello $it"
}

val myCalc: (Int, Int) -> Int = a,b -> a+b
```
