# Звіт з лабораторної роботи № 1
## ІС-34 Корнєєв Михайло |**Варіант - 1**|  

**Тема:** Дослідження роботи з елементами керування.  

**Дисципліна:** Розробка мобільних застосунків під Android

---

## 1. Мета роботи
Дослідити створення простого застосунку під платформу Андроїд
та набути практичні навички з використання елементів керування інтерфейсу, мов
програмування Java чи Kotlin.  

## 2. Постановка завдання
Написати програму під платформу Андроїд, яка має інтерфейс для введення
або/та вибору даних згідно варіанту 1 і відображає результат взаємодії з цим
інтерфейсом у деяке текстове поле цього інтерфейсу. Передбачити наступне: якщо не
всі дані введені або обрані, а користувач натискає кнопку для отримання результату,
то відобразити вікно, що спливає, з повідомленням завершити введення всіх даних.  

<img width="970" height="154" alt="image" src="https://github.com/user-attachments/assets/229cd840-b5c7-4bb5-8600-4866cfd3a06b" />

## 3. Опис виконання роботи

### 3.1. Створення елементів програми:
- **Текстові поля інформації для користувача та виводу результату**
***
```xml
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Оберіть колір:"
        android:textSize="18sp" />
```
<img width="633" height="46" alt="image" src="https://github.com/user-attachments/assets/5ad1e697-8bd2-481e-a4b9-535a4ff738b5" />

***

```xml
<TextView
        android:id="@+id/resultField"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textAlignment="center" />
```
<img width="864" height="61" alt="image" src="https://github.com/user-attachments/assets/cbc88264-310b-45e3-afe2-58e3f76fac76" />

***


- **Радіо-батони для вибору кольору**
***
```xml
<RadioGroup
        android:id="@+id/colorGroup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="15dp">

        <RadioButton
            android:id="@+id/radioRed"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Червоний" />

        <RadioButton
            android:id="@+id/radioGreen"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Зелений" />

        <RadioButton
            android:id="@+id/radioBlue"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Синій" />
    </RadioGroup>

```
<img width="874" height="108" alt="image" src="https://github.com/user-attachments/assets/9becfd2e-01e4-48c9-81a6-4d63718d05c5" />

***

- **Текстове поле для введення інформації**
***
```xml
<EditText
        android:id="@+id/inputField"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Введіть текст тут"
        android:layout_marginBottom="15dp" />
```
<img width="867" height="62" alt="image" src="https://github.com/user-attachments/assets/11f56c98-537c-4d98-95be-0b568da4d837" />

***

- **Кнопки**
***
```xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnOk"
            android:backgroundTint="#03611F"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="OK" />

        <Button
            android:id="@+id/btnCancel"
            android:backgroundTint="#C50505"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Cancel" />
    </LinearLayout>
```
<img width="863" height="67" alt="image" src="https://github.com/user-attachments/assets/8015aaf6-7e75-4dfc-8da5-b40af5b1e911" />

***
- **Фінальний результат вигляду**
***
<img width="430" height="318" alt="image" src="https://github.com/user-attachments/assets/e3f65659-cc4e-4e9b-8287-862cbd27f2d7" />

***

### 3.2. Код додатка
1. Створення змінних для елементів інтерфейсу.
```java
private RadioGroup colorGroup;
    private EditText inputField;
    private TextView resultField;
    private Button btnOk, btnCancel;
```
2. Зв'язування змінних з елементами з xml.
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorGroup = findViewById(R.id.colorGroup);
        inputField = findViewById(R.id.inputField);
        resultField = findViewById(R.id.resultField);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
```
3. Логіка кнопки ОК.

    3.1. Перевірка якщо текст порожній або не вибрано колір.
    ```java
    btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputField.getText().toString().trim();
                int selectedId = colorGroup.getCheckedRadioButtonId();

                if (text.isEmpty() || selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Введіть всі дані!", Toast.LENGTH_SHORT).show();
                    return;
                }
    ```
    3.2. Визначення кольору.
    ```java
    int color = Color.BLACK;
                if (selectedId == R.id.radioRed) {
                    color = Color.RED;
                } else if (selectedId == R.id.radioGreen) {
                    color = Color.GREEN;
                } else if (selectedId == R.id.radioBlue) {
                    color = Color.BLUE;
                }
    ```
    3.3. Вивід результату.
    ```java
    resultField.setText(text);
    resultField.setTextColor(color);
    ```
4. Логіка кнопки Cancel.
```java
btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText("");
                resultField.setText("");
                colorGroup.clearCheck();
            }
        });
```

---

### 3.3. Тестування програми
1. Перевірка роботи всіх кольорів.
***
<img width="358" height="245" alt="image" src="https://github.com/user-attachments/assets/30ac7731-32ae-4b5a-a0b2-530c5d10b1bb" />

***
<img width="359" height="248" alt="image" src="https://github.com/user-attachments/assets/285b9981-a962-4818-9d19-5a79f18b5350" />

***
<img width="362" height="249" alt="image" src="https://github.com/user-attachments/assets/2df5e14e-366d-4006-9038-435847c584b1" />

***

2. Перевірка, якщо не вибрано радіо-батон.
***
<img width="360" height="745" alt="image" src="https://github.com/user-attachments/assets/6ca64f39-9aa1-407e-949d-8e08e13b8981" />

***
3. Перевірка, якщо не написаний текст.
***
<img width="362" height="745" alt="image" src="https://github.com/user-attachments/assets/ffa8658a-fa2a-4497-8ec1-4651c67b8a2c" />

***
6. Перевірка кнопки cancel.
***
<img width="357" height="225" alt="image" src="https://github.com/user-attachments/assets/aa36c5f0-57eb-4371-8e9a-61669ca05f43" />

***
## Висновки
У результаті виконання роботи було досліджено процес створення базового мобільного застосунку для платформи Android та набуто практичних навичок роботи в середовищі розробки Android Studio з використанням мови програмування Java. Під час реалізації проєкту було опановано методику побудови інтерфейсу користувача за допомогою XML-розмітки, де ключову роль відіграло використання контейнера LinearLayout для впорядкування елементів керування.
Особливу увагу було приділено роботі з інтерактивними компонентами, такими як текстові поля EditText, групи перемикачів RadioGroup та кнопки Button. На програмному рівні за допомогою Java реалізовано логіку обробки подій та зв’язку між візуальними елементами та кодом через метод findViewById. Важливим етапом стало впровадження механізму валідації даних, який запобігає некоректному виконанню операцій при незаповнених полях шляхом виведення інформаційних повідомлень Toast. Таким чином, було успішно закріплено знання про життєвий цикл Activity та принципи взаємодії користувача з інтерфейсом у мобільних операційних системах.
## Відповіді на контрольні питання
### 1. Архітектура Android-додатку є «фреймворк-орієнтованою» (framework based), що передбачає розширення класів або реалізацію інтерфейсів, наданих фреймворком.

Застосунок не може бути запущений поза фреймворком або без нього.

Додаток не має єдиної точки входу (як метод main() у Java), а складається з набору компонентів.

Взаємодія між інтерфейсом (UI) та логікою зазвичай слідує шаблону MVVM (Model-View-ViewModel).

Інтерфейс користувача реалізується за допомогою XML-розмітки, а логіка — як компонент ViewModel.

### 2. Загальний огляд компонентів застосунку
До основних компонентів Android-додатку належать:

* **Діяльність (Activity):** візуальний інтерфейс для однієї дії користувача. 
* **Служба (Service):** компонент для роботи у фоновому режимі без інтерфейсу. 
* **Приймач широкомовних намірів (Broadcast Receiver):** отримує та реагує на зовнішні події системи або інших програм. 
* **Контент-провайдер (Content Provider):** забезпечує доступ до даних програми для інших застосунків. 

### 3. Життєвий цикл компоненту «Діяльність»
Діяльність проходить через серію станів, керованих методами зворотного виклику:

* **onCreate():** викликається один раз при створенні для налаштування інтерфейсу та служб.
* **onStart():** робить вікно видимим для користувача.
* **onResume():** передає фокус введення, активуючи взаємодію.
* **onPause():** викликається при переході до іншого вікна; тут зупиняються ресурсомісткі дії та зберігаються дані.
* **onStop():** викликається, коли вікно стає невидимим.
* **onRestart():** спрацьовує при повторному запуску після зупинки.
* **onDestroy():** викликається перед знищенням для звільнення всіх ресурсів.

### 4. Життєвий цикл компоненту «Служба»
Служба може існувати у двох формах:

* **Запущена (Started):** активується методом startService(), викликає onStartCommand() і працює, поки не зупинить себе (stopSelf()) або не буде зупинена іншим компонентом (stopService()).
* **Прив'язана (Bound):** створюється через bindService(), викликає onBind() і працює, поки до неї прив'язаний хоча б один клієнт.

В обох випадках при створенні викликається onCreate(), а при завершенні — onDestroy(). 

### 5. Опис процесів платформи Андроїд
Кожна програма виконується в окремому процесі з мінімальними привілеями. Системи пріоритетів процесів (від найважливішого): 

* **Активний процес:** з яким користувач взаємодіє прямо зараз. 
* **Видимий процес:** має видиму Діяльність, але без фокусу введення. 
* **Сервісний процес:** містить запущену Службу. 
* **Фоновий процес:** містить невидиму Діяльність; завершується першим при нестачі пам'яті за принципом "останній запущений — закривається останнім". 
* **Порожній процес:** не має активних компонентів, служить "кешем". 

### 6. Як активуються компоненти застосунку
Компоненти Activity, Service та Broadcast Receiver активуються через асинхронні повідомлення — Наміри (Intents).

* **Явні наміри** визначають адресата за іменем класу. 
* **Неявні наміри** не вказують адресата; система підбирає компонент через Фільтри-Намірів. 
* **Контент-провайдер** активується запитом від класу ContentResolver.

### 7. Призначення та структура файлу маніфесту
AndroidManifest.xml надає системі основну інформацію про програму:

* Визначає унікальне ім'я пакета.
* Декларує всі компоненти: `<activity>`, `<service>`, `<receiver>`, `<provider>`. 
* Містить списки необхідних дозволів (permissions).
* Вказує мінімальний рівень Android API.
* Перераховує зв'язані бібліотеки.

### 8. Поняття ресурсу та їх визначення
Ресурси дозволяють змінювати частини програми (текст, зображення) без редагування коду та оптимізувати додаток під різні пристрої:

* **Типи ресурсів:** зображення, шари GUI (XML), меню (XML), текстові рядки.
* **Визначення:** для кожного ресурсу автоматично генерується унікальний цілочисельний ідентифікатор у файлі R.java.

У коді доступ до ресурсів здійснюється через цей ID (наприклад, R.id.text), а в XML — через посилання типу @string/name.
