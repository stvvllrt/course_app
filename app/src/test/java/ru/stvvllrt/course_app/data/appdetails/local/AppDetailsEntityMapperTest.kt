package ru.stvvllrt.course_app.data.appdetails.local

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.stvvllrt.course_app.domain.appdetails.AppDetails

class AppDetailsEntityMapperTest {

    private val mapper = AppDetailsEntityMapper()

    @Test
    fun `toEntity maps domain to entity correctly`() {
        val domain = AppDetails(
            id = "1", name = "App", developer = "Dev", category = "Cat",
            ageRating = 3, size = 10f, iconUrl = "url", screenshotUrlList = listOf("s1"),
            description = "Desc", isInWishlist = true
        )

        val result = mapper.toEntity(domain)

        assertEquals(domain.id, result.id)
        assertEquals(domain.name, result.name)
        assertEquals(domain.developer, result.developer)
        assertEquals(domain.category, result.category)
        assertEquals(domain.ageRating, result.ageRating)
        assertEquals(domain.size, result.size)
        assertEquals(domain.iconUrl, result.iconUrl)
        assertEquals(domain.description, result.description)
        assertEquals(domain.isInWishlist, result.isInWishlist)
    }

    @Test
    fun `toDomain maps entity to domain correctly`() {
        val entity = AppDetailsEntity(
            id = "1", name = "App", developer = "Dev", category = "Cat",
            ageRating = 3, size = 10f, iconUrl = "url", screenshots = null,
            description = "Desc", isInWishlist = true
        )

        val result = mapper.toDomain(entity)

        assertEquals(entity.id, result.id)
        assertEquals(entity.name, result.name)
        assertEquals(entity.developer, result.developer)
        assertEquals(entity.category, result.category)
        assertEquals(entity.ageRating, result.ageRating)
        assertEquals(entity.size, result.size)
        assertEquals(entity.iconUrl, result.iconUrl)
        assertEquals(entity.description, result.description)
        assertEquals(entity.isInWishlist, result.isInWishlist)
    }

    @Test
    fun `toEntity preserves wishlist status`() {
        val domain = AppDetails(
            id = "1", name = "A", developer = "D", category = "C",
            ageRating = 0, size = 0f, iconUrl = "I", screenshotUrlList = null,
            description = "D", isInWishlist = false
        )
        assertEquals(false, mapper.toEntity(domain).isInWishlist)
        assertEquals(true, mapper.toEntity(domain.copy(isInWishlist = true)).isInWishlist)
    }

    @Test
    fun `toDomain handles null screenshots in entity`() {
        val entity = AppDetailsEntity(
            id = "1", name = "A", developer = "D", category = "C",
            ageRating = 0, size = 0f, iconUrl = "I", screenshots = null,
            description = "D", isInWishlist = false
        )
        val result = mapper.toDomain(entity)
        assertEquals(null, result.screenshotUrlList)
    }

    @Test
    fun `toEntity maps all fields for complex data`() {
        val domain = AppDetails(
            id = "ID-999", name = "Complex Name!", developer = "Dev & Co", category = "Social",
            ageRating = 18, size = 999.99f, iconUrl = "https://icon.com/1.png",
            screenshotUrlList = null, description = "Multi\nline\ndescription", isInWishlist = true
        )
        val result = mapper.toEntity(domain)
        assertEquals("ID-999", result.id)
        assertEquals(18, result.ageRating)
        assertEquals(999.99f, result.size)
    }
}
