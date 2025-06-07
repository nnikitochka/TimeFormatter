package nn.edition.utils.format.time

object TimeFormatter {
    /**
     * Форматы времени по умолчанию, использующиеся методами класса.
     * При надобности могут быть изменены.
     */
    var yearFormat = TimeFormat.yearFormat
    var monthFormat = TimeFormat.monthFormat
    var weekFormat = TimeFormat.weekFormat
    var dayFormat = TimeFormat.dayFormat
    var hourFormat = TimeFormat.hourFormat
    var minuteFormat = TimeFormat.minuteFormat
    var secondFormat = TimeFormat.secondFormat


    fun format(time: String) = format(time.toLong())
    fun format(time: Int) = format(time.toLong())

    /**
     * @param time - время в секундах
     *
     * @return String, содержащею отформатированное время
     */
    fun format(time: Long) = StringBuilder().apply {
        var remainingTime = time

        val years = remainingTime / (365 * 24 * 60 * 60)
        remainingTime %= (365 * 24 * 60 * 60)

        val months = remainingTime / (30 * 24 * 60 * 60)
        remainingTime %= (30 * 24 * 60 * 60)

        val days = remainingTime / (24 * 60 * 60)
        remainingTime %= (24 * 60 * 60)

        val hours = remainingTime / (60 * 60)
        remainingTime %= (60 * 60)

        val minutes = remainingTime / 60
        val seconds = remainingTime % 60

        if (years > 0) append("$years ${getPluralForm(years, yearFormat)} ")
        if (months > 0) append("$months ${getPluralForm(months, monthFormat)} ")
        if (days > 0) append("$days ${getPluralForm(days, dayFormat)} ")
        if (hours > 0) append("$hours ${getPluralForm(hours, hourFormat)} ")
        if (minutes > 0) append("$minutes ${getPluralForm(minutes, minuteFormat)}")
        if (seconds > 0) append(" $seconds ${getPluralForm(seconds, secondFormat)}")
    }.toString()

    /**
     * @param time - время в секундах
     * @param format - формат секунд.
     *
     * @return отформатированное время в секундах.
     */
    fun formatSeconds(time: Long, format: TimeFormat = secondFormat) =
        "$time ${getPluralForm(time, format)}"

    /**
     * @param time - время в секундах
     * @param format - формат минут.
     *
     * @return отформатированное время в минутах.
     */
    fun formatMinutes(time: Long, format: TimeFormat = minuteFormat) = (time / 60).let { minutes ->
        "$minutes ${getPluralForm(minutes, format)}"
    }

    /**
     * @param time - время в секундах
     * @param format - формат часов.
     *
     * @return отформатированное время в часах.
     */
    fun formatHours(time: Long, format: TimeFormat = hourFormat) = (time / (60 * 60)).let { hours ->
        "$hours ${getPluralForm(hours, format)}"
    }

    /**
     * @param time - время в секундах
     * @param format - формат дней.
     *
     * @return отформатированное время в днях.
     */
    fun formatDays(time: Long, format: TimeFormat = dayFormat) = (time / (24 * 60 * 60)).let { days ->
        "$days ${getPluralForm(days, format)}"
    }

    /**
     * @param time - время в секундах
     * @param format - формат недель.
     *
     * @return отформатированное время в неделях.
     */
    fun formatWeeks(time: Long, format: TimeFormat = weekFormat) = (time / (7 * 24 * 60 * 60)).let { weeks ->
        "$weeks ${getPluralForm(weeks, format)}"
    }

    /**
     * @param time - время в секундах
     * @param format - формат месяцев.
     *
     * @return отформатированное время в месяцах.
     */
    fun formatMonths(time: Long, format: TimeFormat = monthFormat) = (time / (30 * 24 * 60 * 60)).let { months ->
        "$months ${getPluralForm(months, format)}"
    }

    /**
     * @param time - время в секундах
     * @param format - формат лет.
     *
     * @return отформатированное время в годах.
     */
    fun formatYears(time: Long, format: TimeFormat = yearFormat) = (time / (365 * 24 * 60 * 60)).let { years ->
        "$years ${getPluralForm(years, format)}"
    }

    /**
     * @param number - число для которого нужно получить форму.
     * @param format - объект [TimeFormat] с нужными форматами.
     *
     * @return формат со склонения в String.
     */
    fun getPluralForm(number: Long, format: TimeFormat): String {
        val n = number % 100
        return when {
            n in 11..19 -> format.thirdFormat
            n % 10 == 1L -> format.firstFormat
            n % 10 in 2..4 -> format.secondFormat
            else -> format.thirdFormat
        }
    }
}