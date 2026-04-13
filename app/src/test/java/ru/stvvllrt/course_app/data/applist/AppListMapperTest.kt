package ru.stvvllrt.course_app.data.applist

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.stvvllrt.course_app.domain.applist.AppList

class AppListMapperTest {

    private val mapper = AppListMapper()

    @Test
    fun `toDomain maps DTO to Domain correctly`() {
        val dto = AppListDto(
            id = "1",
            name = "App Name",
            description = "Description",
            category = "Category",
            icon = "icon_url"
        )

        val result = mapper.toDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.description, result.description)
        assertEquals(dto.category, result.category)
        assertEquals(dto.icon, result.icon)
    }

    @Test
    fun `toDomain handles empty values`() {
        val dto = AppListDto(
            id = "",
            name = "",
            description = "",
            category = "",
            icon = ""
        )

        val result = mapper.toDomain(dto)

        assertEquals("", result.id)
        assertEquals("", result.name)
    }

    @Test
    fun `toDomain preserves special characters`() {
        val dto = AppListDto(
            id = "ID_!@#",
            name = "Name with spaces and symbols $",
            description = "\nNew line and \t tab",
            category = "Cat&egory",
            icon = "http://example.com/icon?size=large"
        )

        val result = mapper.toDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.description, result.description)
        assertEquals(dto.category, result.category)
        assertEquals(dto.icon, result.icon)
    }

    @Test
    fun `toDomain maps numeric strings correctly`() {
        val dto = AppListDto(
            id = "123",
            name = "456",
            description = "789",
            category = "0",
            icon = "321"
        )

        val result = mapper.toDomain(dto)

        assertEquals("123", result.id)
        assertEquals("456", result.name)
    }

    @Test
    fun `toDomain handles long strings`() {
        val longString = "a".repeat(1000)
        val dto = AppListDto(
            id = "id",
            name = longString,
            description = longString,
            category = "cat",
            icon = "icon"
        )

        val result = mapper.toDomain(dto)

        assertEquals(longString, result.name)
        assertEquals(longString, result.description)
    }
}
