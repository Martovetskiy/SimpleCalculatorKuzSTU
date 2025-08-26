# SimpleCalculatorKuzSTU

Простой калькулятор на Jetpack Compose для Android.

## Возможности
- Сложение, вычитание, умножение, деление, проценты
- Автоматический подсчёт результата выражения
- Смена темы (тёмная/светлая)
- Реактивный UI на базе ViewModel и StateFlow

## Установка и запуск
1. Клонируйте репозиторий:
   ```sh
   git clone <repo-url>
   ```
2. Откройте проект в Android Studio.
3. Синхронизируйте Gradle (автоматически или через меню).
4. Запустите приложение на эмуляторе или устройстве.

## Используемые технологии
- Kotlin
- Jetpack Compose
- Android ViewModel
- StateFlow
- EvalEx (вычисление выражений)

## Структура проекта
- `app/src/main/java/me/bodnarsg/simplecalculatorkuzstu/ui/views/CalculatorView.kt` — UI калькулятора
- `app/src/main/java/me/bodnarsg/simplecalculatorkuzstu/domain/CalculatorViewModel.kt` — логика и состояние
- `app/src/main/java/me/bodnarsg/simplecalculatorkuzstu/ui/theme/Theme.kt` — оформление и темы
- `app/build.gradle.kts` — зависимости и настройки сборки

## Как работает смена темы
- Кнопка "SW" переключает между светлой и тёмной темой
- Состояние темы хранится во ViewModel и реактивно применяется к MaterialTheme

## Как работает вычисление выражения
- При нажатии "=" выражение вычисляется через библиотеку EvalEx
- В случае ошибки отображается "Ошибка"

## Лицензия
MIT

