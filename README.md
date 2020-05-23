# Laba_three_part2
Все еще работа с SQLite

Это является продолжением пролраммы по работе с SQLite. Здесь по техническим требованиям была изменена база данных. А именно столбец 
ФИО был разбит на 3 отдельных столбца (не сложно догадаться на какие). А так программа не изменилась, только были изменены прилегающие
к базе данных части кода, чтобы он смог взаимодействовать с новой бд.

Данная программа была залита в отдельный репозиторий, так как по т.з. было необходимо сделать эти изменения в другом приложении.




# Laba_three_part1
Работа с SQLite

Данная программа направлена на работу с SQLite. Для более удобного и безопасного взаимодействия с данной базой данных была 
выбрана стандартная библиотека "android.database.sqlite", а точнее в основном использовалось два класса SQLiteDatabase и абстрактный 
класс SQLiteOpenHelper, от которого наследовался мой класс FeedReaderDbHelper. Для записи в базу данных (далее бд) использовался
класс "android.content.ContentValues", а для считывания пользовался классом "android.database.Cursor". Для более удобного написания кода
было инкапсулирована информация о бд. Говоря более развернето, был создан класс FeedReaderContract. Он имеет две приватные 
строки, которые содержат в себе сдандартные запросы на создание и удаления таблицы. Также, этот класс содержит два публичных класса, один
уже упомянался выше (FeedReaderDbHelper), а второй, FeedEntry, наследует интерфейс BaseColumns и хранит в себе, в моем случае 3 
константных строки, а точнее имя таблицы и названия первой и второй колонки.

По работе самой программы нет ничего сложного, при запуске первого активити создается или открывается бд, бд очищается и туда записывается 
из файла 5 студентов. Также, в первом активити были реализованы 3 кнопки. Первая добавляет очередного студента в бд, если еще не все 
были добавлены. Вторая изменяет последнюю добавленную запись. Третья открывает второе активити, в котором выводится вся информация из бд.

Еще можно упомянуть вывод информации во втором активити, но здесь все довольно просто. Я использовал стандартный RecyclerView. 
Естественно был создан новый адаптер, а точнее класс MyAdapter, который наследует "RecyclerView.Adapter<MyAdapter.MyViewHolder>".
MyAdapter имеет 3 списка с необходимой информацие для вывода, которые он получает через конструктор. Также, внутри этого класса 
реализованы абстрактные функции от наследуемого класса и реализован класс MyViewHolder, который унаследован от "RecyclerView.ViewHolder".
Этот "подкласс" связывается с ".xml" файлом и хранит на них ссылки.