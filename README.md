# TestNP #
Есть массив данных, содержащий маршруты между двумя населенными пунктами вида:  
struct path {  
    char* From;  
    char* To;  
} для C++  
или  
class Path {  
    string From;  
    string To;  
} для C#  
Необходимо написать программу, которая формирует маршрут, включающий посещение всех  
городов из списка.  
## Возможно, что маршруты содержат разрывы и закольцованности. ##
Например,  
Исходные данные: ((‘Москва’, ‘Тюмень’), (‘Тюмень’, ‘Сочи’), (‘Ростов-на-Дону’, ‘Москва’))  
Выходные данные: (‘Ростов-на-Дону’, ‘Москва’, ‘Тюмень’, ‘Сочи’)  
Так же необходимо оценить функцию времени выполнения программы и возможность ее  
оптимизации.  
### Сложность алгоритма O(n!) факториальная, оптимизация невозможна ###  
### Задача схожа с задачей про комивояжера ###
