# Система обработки заказов (Spring Boot, Spring Data, Gradle, PostgreSQL/MySQL)


ВебСервис 1 (API, Json)
1. Создать заказ
2. Удалить заказ
3. Отправить заказ
4. Добавить товар в заказ (по id товара)
5. Удалить товар из заказа (по id товара)
6. Получить список всех заказов с товарами (или поиск по id заказа)
7. Для изменнения состояния БД нужно сделать http вызов ВебСервис 2

 
ВебСервис 2 (Persistence API, CRUD, Json):
1. Создать заказ
2. Удалить заказ
3. Добавить товар в заказ
4. Удалить товар из заказа
5. Поиск по id товара (использовать кэширование)



# How to run

1.docker build --build-arg JAR_FILE=build/libs/*.jar -t order-api-container .

2.docker-compose up -d

3.Or run test.http
