package nn.edition.utils.timeformat

data class TimeFormat(
    val firstFormat: String,
    val secondFormat: String,
    val thirdFormat: String,
) {
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