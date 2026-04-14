package ru.stvvllrt.course_app.data.applist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class AppListRepositoryImplTest {

    private val api = mockk<AppListApi>()
    private val repository = AppListRepositoryImpl(api)

    @Test
    fun getAppList_returns_list_from_api() {
        runBlocking {
            val dtos = listOf(
                AppListDto("1", "App 1", "Desc 1", "Cat 1", "icon1"),
                AppListDto("2", "App 2", "Desc 2", "Cat 2", "icon2")
            )
            coEvery { api.getApps() } returns dtos

            val result = repository.getAppList()

            assertEquals(2, result.size)
            assertEquals("App 1", result[0].name)
            assertEquals("1", result[0].id)
            coVerify(exactly = 1) { api.getApps() }
        }
    }

    @Test
    fun getAppList_returns_empty_list_when_api_is_empty() {
        runBlocking {
            coEvery { api.getApps() } returns emptyList()

            val result = repository.getAppList()

            assertEquals(0, result.size)
        }
    }

    @Test
    fun getAppList_maps_all_fields_correctly() {
        runBlocking {
            val dto = AppListDto("ID", "Name", "Desc", "Cat", "Icon")
            coEvery { api.getApps() } returns listOf(dto)

            val result = repository.getAppList()[0]

            assertEquals(dto.id, result.id)
            assertEquals(dto.name, result.name)
            assertEquals(dto.description, result.description)
            assertEquals(dto.category, result.category)
            assertEquals(dto.icon, result.icon)
        }
    }

    @Test
    fun getAppList_handles_api_exceptions() {
        runBlocking {
            coEvery { api.getApps() } throws RuntimeException("API Error")

            try {
                repository.getAppList()
            } catch (e: Exception) {
                assertEquals("API Error", e.message)
            }
        }
    }

    @Test
    fun getAppList_handles_null_values_if_allowed_by_DTO() {
        runBlocking {
            val dtos = listOf(AppListDto("1", "App", "", "", ""))
            coEvery { api.getApps() } returns dtos

            val result = repository.getAppList()

            assertEquals("", result[0].description)
        }
    }
}
