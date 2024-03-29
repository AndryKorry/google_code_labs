package com.vynokurov.calc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vynokurov.cupcakeapp.model.OrderViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class AppCupcakeViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.setQuantity(12)
        viewModel.price.observeForever {}
        assertEquals("$27.00", viewModel.price.value)
    }
}