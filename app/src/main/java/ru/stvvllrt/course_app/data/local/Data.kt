package ru.stvvllrt.course_app.data.local

object Data {
    data class Apps(
        val name: String,
        val category: String,
        val icon: String,
        val description: String,
    )

    const val RuStoreIcon = "https://static.rustore.ru/rustore-strapi/6/logo_color_30_px_2_fa2039288f.svg"
    const val YandexIcon = "https://static.rustore.ru/imgproxy/bZNt9jiZUOVXXOG0JdJQleTYIB2cFeE3MaWk7o897jE/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp"
    const val SberIcon = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp"
    const val MailIcon = "https://static.rustore.ru/imgproxy/2wnsbc-wCmdbFYEdpH8uL3Jl4db6i7HE9Vj5079oh6Q/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp"
    const val YandexMapsIcon = "https://static.rustore.ru/imgproxy/kN8NuYdJ6YTyb8oR90TnHIesgx8g2OUJg0ktaqwkM84/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/586431/content/ICON/a5f2fe7d-cd63-4f3f-a2f8-40d997c1d6f4.png@webp"
    const val MTSIcon = "https://static.rustore.ru/imgproxy/uAJeOzFbun_tDiquzvvs_kieJ8ihjODiwCb7LGISdos/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp"
    const val YandexMarketIcon = "https://static.rustore.ru/imgproxy/17_1bG1m4U-hSWWmsyteg6Mdh7kj0SeEHxzvRlCsziw/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/3/5/d8/apk/600511/content/ICON/ea4280ef-3625-4c04-abbe-0ddd553b4ff5.png@webp"

    val appList = listOf(
        Apps(
            icon = YandexIcon,
            name = "Яндекс.Браузер - с Алисой",
            description = "Быстрый и безопасный браузер",
            category = "Инструменты"
        ),
        Apps(
            icon = MailIcon,
            name = "Почта Mail.ru",
            description = "Почтовый клиент для любых ящиков",
            category = "Инструменты"
        ),
        Apps(
            icon = SberIcon,
            name = "СберБанк Онлайн",
            description = "Больше чем банк",
            category = "Финансы"
        ),
        Apps(
            icon = YandexMapsIcon,
            name = "Яндекс Карты",
            description = "Карты под рукой",
            category = "Транспорт"
        ),
        Apps(
            icon = MTSIcon,
            name = "Мой МТС",
            description = "Мобильный оператор",
            category = "Инструменты"
        ),
        Apps(
            icon = YandexMarketIcon,
            name = "Яндекс Маркет",
            description = "Все ваши покупки - здесь",
            category = "Финансы"
        ),
        Apps(
            icon = SberIcon,
            name = "СберБанк Онлайн",
            description = "Больше чем банк",
            category = "Финансы"
        ),
        Apps(
            icon = YandexMapsIcon,
            name = "Яндекс Карты",
            description = "Карты под рукой",
            category = "Транспорт"
        ),
        Apps(
            icon = MTSIcon,
            name = "Мой МТС",
            description = "Мобильный оператор",
            category = "Инструменты"
        ),
        Apps(
            icon = YandexMarketIcon,
            name = "Яндекс Маркет",
            description = "Все ваши покупки - здесь",
            category = "Финансы"
        )
    )
}