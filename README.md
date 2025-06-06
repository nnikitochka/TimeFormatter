    ███╗   ██╗ ███╗   ██╗   ███████╗ ██████╗  ██╗ ████████╗ ██╗  ██████╗  ███╗   ██╗
    ████╗  ██║ ████╗  ██║   ██╔════╝ ██╔══██╗ ██║ ╚══██╔══╝ ██║ ██╔═══██╗ ████╗  ██║
    ██╔██╗ ██║ ██╔██╗ ██║   █████╗   ██║  ██║ ██║    ██║    ██║ ██║   ██║ ██╔██╗ ██║
    ██║╚██╗██║ ██║╚██╗██║   ██╔══╝   ██║  ██║ ██║    ██║    ██║ ██║   ██║ ██║╚██╗██║
    ██║ ╚████║ ██║ ╚████║   ███████╗ ██████╔╝ ██║    ██║    ██║ ╚██████╔╝ ██║ ╚████║
    ╚═╝  ╚═══╝ ╚═╝  ╚═══╝   ╚══════╝ ╚═════╝  ╚═╝    ╚═╝    ╚═╝  ╚═════╝  ╚═╝  ╚═══╝
    Разработчик в вк/тг/дс/гитхаб - @nnikitochka
    Дискорд сообщество https://dsc.gg/nnedition
    Телеграм канал https://t.me/nnedition

---

## 📦 Немного информации

TimeFormatter — это простая утилита на Kotlin для форматирования времени в секундах в строковый формат с поддержкой склонений.

---

## 🚀 Начало работы

Выберите подходящею версию из доступного [списка версий](https://github.com/nnikitochka/TimeFormatter/releases) и добавьте зависимость в ваш проект:

### Gradle

Добавьте следующие зависимости в ваш `build.gradle.kts`:

```kt
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.nnikitochka:TimeFormatter:Тэг")
}
```


### Maven

Добавьте следующие зависимости в ваш `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.nnikitochka</groupId>
        <artifactId>TimeFormatter</artifactId>
        <version>Тэг</version>
    </dependency>
</dependencies>
```

### Использование

Пример использования:

```kotlin
import nn.edition.utils.format.time.TimeFormatter

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val time = 6000L

        println(TimeFormatter.formatMinutes(time))

        println(TimeFormatter.formatHours(time))

        println(TimeFormatter.format(time))
    }
}
```

Вывод программы:

```
100 минут
1 час
1 час 40 минут
```

---

## Настройка

При надобности вы сможете изменить форматы времени по умолчанию в `TimeFormatter`

---

## TODO:
- [ ] Сохранение логов в файл
- [ ] Придумать описание для LoggerFactory#terminalWriter