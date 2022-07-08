# Задание на практику 3

- [ ] Разработать информационную систему, включая следующие сущности и атрибуты:

    * Инициатор (родительская сущность)
      * Сотрудник (дочерняя сущность)
        * ФИО
        * Отдел
        * Должность
        * Пользователь системы (ссылка на сущность User)
      * Внешний клиент (дочерняя сущность)
      * ФИО 
      * Почта 
    * Отдел 
      * Название 
      * Описание 
    * Заявка 
      * Инициатор 
      * Исполнитель (только Сотрудник)
      * Статус 
      * Описание 
      * Дата открытия 
      * Дата закрытия
      
-  Система должна иметь следующие функции:
  - [ ] Добавление, редактирование удаление сущностей.
  - [ ] Просмотр заявок по каждому клиенту, сотруднику.
  - [ ] Статусная модель заявок (Открыта, на рассмотрении, на согласовании, на утверждении, закрыта).
  - [ ] Если инициатор заявки – сотрудник, то продвижение по статусной модели должно происходить с его подтверждения. Если внешний клиент – исполнитель может самостоятельно продвигать заявку.