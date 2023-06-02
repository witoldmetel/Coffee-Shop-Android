package witoldmetel.coffeeshop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class DataManager {
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    fun cartAdd(product: Product) {
        var found = false

        cart.forEach {
            if (product.id == it.product.id) {
                it.quantity++
                found = true
            }

            if (!found) {
                // * means that you make a copy of array
                cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
            }
        }
    }

    fun carClear() {
        cart = listOf()
    }

    fun cartRemove(product: Product) {
        val aux = cart.toMutableList()

        aux.removeAll {
            it.product.id == product.id
        }

        cart = listOf(*aux.toTypedArray())
    }
}