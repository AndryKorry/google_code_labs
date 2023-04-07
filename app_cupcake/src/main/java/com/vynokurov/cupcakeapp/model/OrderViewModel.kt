package com.vynokurov.cupcakeapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 2.0
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.0

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    private val _flavor = MutableLiveData<String>()
    private val _date = MutableLiveData<String>()
    private val _price = MutableLiveData<Double>()

    val quantity: LiveData<Int> = _quantity
    val flavor: LiveData<String> = _flavor
    val date: LiveData<String> = _date
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }
    val dateOptions = getPickupOptions()

    init {
        resetOrder()
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    private fun updatePrice() {
        var calculatePrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        if (dateOptions[0] == _date.value) {
            calculatePrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatePrice
    }

    fun setQuantity(qty: Int) {
        _quantity.value = qty
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickedDate: String) {
        _date.value = pickedDate
        updatePrice()
    }

    fun isHasNoFlavorSet() = _flavor.value.isNullOrEmpty()
    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
}