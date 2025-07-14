package nn.edition.utils.format.time

/**
 * Утилитарный класс для форматирования времени с поддержкой русской локализации.
 *
 * Этот объект предоставляет методы для преобразования времени (в секундах) в читаемый
 * текстовый формат с правильным склонением единиц времени согласно правилам русского языка.
 *
 * Поддерживаемые единицы времени:
 * - Годы (365 дней)
 * - Месяцы (30 дней)
 * - Недели (7 дней)
 * - Дни (24 часа)
 * - Часы (60 минут)
 * - Минуты (60 секунд)
 * - Секунды
 */
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

    /**
     * Форматирует время, переданное в виде строки.
     *
     * @param time Время в секундах в виде строки
     * @return Отформатированное время в виде строки
     * @throws NumberFormatException если строка не может быть преобразована в число
     */
    fun format(time: String) = format(time.toLong())

    /**
     * Форматирует время, переданное в виде целого числа.
     *
     * @param time Время в секундах в виде Int
     * @return Отформатированное время в виде строки
     */
    fun format(time: Int) = format(time.toLong())

    /**
     * Форматирует время в полный текстовый формат со всеми единицами времени.
     *
     * Метод преобразует время в секундах в читаемый формат, включающий все
     * необходимые единицы времени от лет до секунд. Нулевые значения не отображаются.
     *
     * Используемые приближения:
     * - 1 год = 365 дней
     * - 1 месяц = 30 дней
     * - 1 неделя = 7 дней
     * - 1 день = 24 часа
     * - 1 час = 60 минут
     * - 1 минута = 60 секунд
     *
     * @param time Время в секундах
     * @return Отформатированное время в виде строки с правильными склонениями
     */
    fun format(time: Long) = buildString {
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
    }

    /**
     * Форматирует время в секундах с использованием указанного формата.
     *
     * @param time Время в секундах
     * @param format Формат для отображения секунд. По умолчанию используется [secondFormat]
     * @return Отформатированное время в секундах
     */
    fun formatSeconds(time: Long, format: TimeFormat = secondFormat) =
        "$time ${getPluralForm(time, format)}"

    /**
     * Форматирует время в минутах, преобразуя секунды в минуты.
     *
     * @param time Время в секундах
     * @param format Формат для отображения минут. По умолчанию используется [minuteFormat]
     * @return Отформатированное время в минутах
     */
    fun formatMinutes(time: Long, format: TimeFormat = minuteFormat) = (time / 60).let { minutes ->
        "$minutes ${getPluralForm(minutes, format)}"
    }

    /**
     * Форматирует время в часах, преобразуя секунды в часы.
     *
     * @param time Время в секундах
     * @param format Формат для отображения часов. По умолчанию используется [hourFormat]
     * @return Отформатированное время в часах
     */
    fun formatHours(time: Long, format: TimeFormat = hourFormat) = (time / (60 * 60)).let { hours ->
        "$hours ${getPluralForm(hours, format)}"
    }

    /**
     * Форматирует время в днях, преобразуя секунды в дни.
     *
     * @param time Время в секундах
     * @param format Формат для отображения дней. По умолчанию используется [dayFormat]
     * @return Отформатированное время в днях
     */
    fun formatDays(time: Long, format: TimeFormat = dayFormat) = (time / (24 * 60 * 60)).let { days ->
        "$days ${getPluralForm(days, format)}"
    }

    /**
     * Форматирует время в неделях, преобразуя секунды в недели.
     *
     * @param time Время в секундах
     * @param format Формат для отображения недель. По умолчанию используется [weekFormat]
     * @return Отформатированное время в неделях
     */
    fun formatWeeks(time: Long, format: TimeFormat = weekFormat) = (time / (7 * 24 * 60 * 60)).let { weeks ->
        "$weeks ${getPluralForm(weeks, format)}"
    }

    /**
     * Форматирует время в месяцах, преобразуя секунды в месяцы.
     *
     * Использует приближение: 1 месяц = 30 дней = 2,592,000 секунд.
     *
     * @param time Время в секундах
     * @param format Формат для отображения месяцев. По умолчанию используется [monthFormat]
     * @return Отформатированное время в месяцах
     */
    fun formatMonths(time: Long, format: TimeFormat = monthFormat) = (time / (30 * 24 * 60 * 60)).let { months ->
        "$months ${getPluralForm(months, format)}"
    }

    /**
     * Форматирует время в годах, преобразуя секунды в годы.
     *
     * Использует приближение: 1 год = 365 дней = 31,536,000 секунд.
     *
     * @param time Время в секундах
     * @param format Формат для отображения лет. По умолчанию используется [yearFormat]
     * @return Отформатированное время в годах
     */
    fun formatYears(time: Long, format: TimeFormat = yearFormat) = (time / (365 * 24 * 60 * 60)).let { years ->
        "$years ${getPluralForm(years, format)}"
    }

    /**
     * Определяет правильную форму склонения для заданного числа согласно правилам русского языка.
     *
     * Логика склонения:
     * - Для чисел от 11 до 19: используется третья форма (много)
     * - Для чисел, оканчивающихся на 1: используется первая форма (один)
     * - Для чисел, оканчивающихся на 2, 3, 4: используется вторая форма (несколько)
     * - Для всех остальных: используется третья форма (много)
     *
     * @param number Число для которого нужно получить форму склонения
     * @param format Объект [TimeFormat] с нужными форматами склонения
     * @return Правильная форма склонения в виде строки
     */
    fun getPluralForm(number: Long, format: TimeFormat): String {
        val n = number % 100
        return when {
            n in 11..19 -> format.third
            n % 10 == 1L -> format.first
            n % 10 in 2..4 -> format.second
            else -> format.third
        }
    }
}