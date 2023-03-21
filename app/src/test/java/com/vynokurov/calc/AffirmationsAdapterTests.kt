package com.vynokurov.calc

import android.content.Context
import com.vynokurov.affirmations.adapter.ItemAdapter
import com.vynokurov.affirmations.model.Affirmation
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {

    private val context = mock(Context::class.java)

    @Test
    fun adapterSize(){
        val data = listOf(
            Affirmation(R.string.amazing_service, R.drawable.ic_service),
            Affirmation(R.string.tip_amount, R.drawable.ic_round_up)
        )
        val adapter = ItemAdapter(context, data)
        assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }

}