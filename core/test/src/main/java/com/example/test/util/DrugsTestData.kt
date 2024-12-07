package com.example.test.util

import com.example.core.network.model.response.Drug
import com.example.core.network.model.response.DrugsResponse

object DrugsTestData {

    fun drugResponse(): DrugsResponse = DrugsResponse (
        drugs = result()
    )

    fun result(): List<Drug> = listOf(
        Drug(
            name = "aspirin",
            dose = "1 tablet",
            strength = "500 mg"
        ),
        Drug(
            name = "ibuprofen",
            dose = "1 tablet",
            strength = "200 mg"
        ),
        Drug(
            name = "paracetamol",
            dose = "1 tablet",
            strength = "500 mg"
        ),
        Drug(
            name = "omeprazole",
            dose = "1 capsule",
            strength = "20 mg"
        )
    )

    fun testDrug(): Drug = Drug(
        name = "omeprazole",
        dose = "1 capsule",
        strength = "20 mg"
    )
}

