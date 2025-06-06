package nn.edition.utils.timeformat

data class TimeFormat(
    /**
     * Первая форма времени.
     * Пример: 1 год, 1 месяц.
     */
    val firstFormat: String,
    /**
     * Вторая форма времени.
     * Пример: 2 года, 2 месяца.
     */
    val secondFormat: String,
    /**
     * Третья форма времени.
     * Пример: 10 лет, 10 месяцев.
     */
    val thirdFormat: String,
) {
    /**
     * Форматы времени по умолчанию.
     */
    companion object {
        val yearFormat = TimeFormat("год", "года", "лет")
        val monthFormat = TimeFormat("месяц", "месяца", "месяцев")
        val weekFormat = TimeFormat("неделя", "недели", "недель")
        val dayFormat = TimeFormat("день", "дня", "дней")
        val hourFormat = TimeFormat("час", "часа", "часов")
        val minuteFormat = TimeFormat("минута", "минуты", "минут")
        val secondFormat = TimeFormat("секунда", "секунды", "секунд")
    }
}