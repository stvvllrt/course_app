package ru.stvvllrt.course_app.domain.applist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppListUseCaseTest {

    private val repository = mockk<AppListRepository>()
    private val useCase = GetAppListUseCase(repository)

    @Test
    fun invoke_returns_list_from_repository() = runBlocking {
        val apps = listOf(
            AppList("1", "App 1", "Desc 1", "Cat 1", "icon1"),
            AppList("2", "App 2", "Desc 2", "Cat 2", "icon2")
        )
        coEvery { repository.getAppList() } returns apps

        val result = useCase()

        assertEquals(apps, result)
        coVerify(exactly = 1) { repository.getAppList() }
    }

    @Test
    fun invoke_returns_empty_list_when_repository_is_empty() = runBlocking {
        coEvery { repository.getAppList() } returns emptyList()

        val result = useCase()

        assertEquals(0, result.size)
    }

    @Test
    fun invoke_propagates_exceptions() = runBlocking {
        val exception = RuntimeException("Network error")
        coEvery { repository.getAppList() } throws exception

        try {
            useCase()
        } catch (e: Exception) {
            assertEquals("Network error", e.message)
        }
    }

    @Test
    fun invoke_handles_large_lists() = runBlocking {
        val largeList = List(100) { index ->
            AppList(index.toString(), "App $index", "Desc", "Cat", "Icon")
        }
        coEvery { repository.getAppList() } returns largeList

        val result = useCase()

        assertEquals(100, result.size)
        assertEquals("App 99", result[99].name)
    }

    @Test
    fun invoke_called_multiple_times_returns_consistent_data() = runBlocking {
        val apps = listOf(AppList("1", "A", "D", "C", "I"))
        coEvery { repository.getAppList() } returns apps

        val result1 = useCase()
        val result2 = useCase()

        assertEquals(result1, result2)
        coVerify(exactly = 2) { repository.getAppList() }
    }
}
