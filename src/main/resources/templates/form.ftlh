<#ftl encoding="utf-8">
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form</title>
</head>
<body>
<form action="/process" method="post">
    <input type="text" id="name" name="name" placeholder="Введите имя" required/>
    <input type="text" id="surname" name="surname" placeholder="Введите Фамилию" required/>
    <input type="text" id="patronymic" name="patronymic" placeholder="Введите отчество"/>
    <input type="text" id="passport" name="passport" placeholder="Введите паспортные данные" required/>
    <input type="email" id="mail" name="mail" placeholder="Введите почту"/>
    <input type="date" id="date" name="date"
           value="2020-07-22"
           min="1900-01-01" max="2020-10-5"/>
    <p><input  id="type" name="type" type="radio" value="teacher" checked/>Преподаватель</p>
    <p><input  id="type" name="type" type="radio" value="student"/>Студент</p>
    <input type="checkbox" name="proved" value="true"/>
    <input type="submit" value="Отправить">
</form>
</body>
</html>