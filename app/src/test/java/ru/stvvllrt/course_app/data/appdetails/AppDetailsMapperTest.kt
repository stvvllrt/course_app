package ru.stvvllrt.course_app.data.appdetails

import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailsMapperTest {

    private val mapper = AppDetailsMapper()

    @Test
    fun `toDomain maps DTO to Domain correctly`() {
        val dto = AppDetailsDto(
            id = "1",
            name = "Test App",
            developer = "Dev",
            category = "Tools",
            ageRating = 12,
            size = 50.5f,
            icon = "icon_url",
            screenshots = listOf("s1", "s2"),
            description = "Description"
        )

        val result = mapper.toDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.developer, result.developer)
        assertEquals(dto.category, result.category)
        assertEquals(dto.ageRating, result.ageRating)
        assertEquals(dto.size, result.size)
        assertEquals(dto.icon, result.iconUrl)
        assertEquals(dto.screenshots, result.screenshotUrlList)
        assertEquals(dto.description, result.description)
        assertEquals(false, result.isInWishlist)
    }

    @Test
    fun `toDomain handles empty screenshot list`() {
        val dto = AppDetailsDto(
            id = "1",
            name = "App",
            developer = "Dev",
            category = "Cat",
            ageRating = 0,
            size = 0f,
            icon = "",
            screenshots = emptyList(),
            description = ""
        )

        val result = mapper.toDomain(dto)

        assertEquals(emptyList<String>(), result.screenshotUrlList)
    }

    @Test
    fun `toDomain maps age rating correctly`() {
        val ratings = listOf(0, 3, 7, 12, 16, 18)
        ratings.forEach { rating ->
            val dto = AppDetailsDto(
                id = "1", name = "A", developer = "D", category = "C",
                ageRating = rating, size = 1f, icon = "I", screenshots = emptyList(), description = "D"
            )
            val result = mapper.toDomain(dto)
            assertEquals(rating, result.ageRating)
        }
    }

    @Test
    fun `toDomain maps large size values`() {
        val largeSize = 2048.5f
        val dto = AppDetailsDto(
            id = "1", name = "A", developer = "D", category = "C",
            ageRating = 3, size = largeSize, icon = "I", screenshots = emptyList(), description = "D"
        )
        val result = mapper.toDomain(dto)
        assertEquals(largeSize, result.size)
    }

    @Test
    fun `toDomain handles special characters in description`() {
        val specialDesc = "Line 1\nLine 2\t\"Quoted\" 'Single' & Symbol"
        val dto = AppDetailsDto(
            id = "1", name = "A", developer = "D", category = "C",
            ageRating = 3, size = 1f, icon = "I", screenshots = emptyList(), description = specialDesc
        )
        val result = mapper.toDomain(dto)
        assertEquals(specialDesc, result.description)
    }
}
