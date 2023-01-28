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
        String paramsNew = WherePart.replace('{', ' ').replace('}', ' ');
        String[] params = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(SqlQuiry);
        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append(" = ").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2)
                    stringBuilder.append(" and ");
            }
        }

        System.out.println(stringBuilder);
    }
}