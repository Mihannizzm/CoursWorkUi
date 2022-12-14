@all
Feature: Тесты сервиса Яндекс погода

  Scenario Outline: Получение подробного прогноза погоды на 10 дней
    Given Открываю главную страницу сервиса Яндекс погода
    And Закрываю всплывающее окно
    When Ввожу в строку поиска города - '<city>'
    Then Проверяю что отображается выпадающий список населенных пунктов
    And Выбираю первый населенный пункт из списка
    And Нажимаю на 'Подробный прогноз на 10 дней'
    Then Проверяю, что отображаются карточки с подробным прогнозом
    And Вывожу в консоль прогноз погоды за <days> дней

    Examples:
      | city      | days |
      | Москва    | 2    |
      | Челябинск | 6    |
      | Завьялово | 1    |