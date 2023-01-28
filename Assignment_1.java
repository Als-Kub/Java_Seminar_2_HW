/*
Задание 1.
Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.

Входная строка:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

Выходная строка:
select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow" 
*/



public class Assignment_1 {
    public static final String SqlQuiry= "select * from students where ";
    public static final String WherePart = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

    public static void main(String[] args) {
        String whereNew = WherePart.replace('{', ' ').replace('}', ' ');
        String[] where = whereNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(SqlQuiry);
        for (int i = 0; i < where.length; i++) {
            String[] params = where[i].replace('"', ' ').split(":");
            if (!"null".equals(params[1].trim())) {
                stringBuilder.append(params[0].trim()).append(" = ").append("'").append(params[1].trim()).append("'");
                if (i < where.length - 2)
                    stringBuilder.append(" and ");
            }
        }

        System.out.println(stringBuilder);
    }
}