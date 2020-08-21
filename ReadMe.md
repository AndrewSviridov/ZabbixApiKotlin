# ZabbixApiApp
### Создать экземпляр ZabbixApi
Создаем экземпляр класса ZabbixApi. В конструктор передаем ***url zabbix api, логин пользователя и пароль***. От этого пользователя и будут производиться действия.
После этого можно работать с этим объектом, любые запросы вызванные с помощью объекта будут продлевать сессию созданную им при инициализации, если сессия стала не действительна, то произойдет перелогирование в ZabbixApi используя данные переданные в конструктор *zabbixApi* при создании объекта.
```kotlin
val zabbixApi=ZabbixApi(url, user, password)
```
### logout
- Чтобы правильно закончить работы с ZabbixApi, нужно стараться завершать сессию путем вызова функции *logout*.Чтобы не создавать лишние подключения.
```kotlin
zabbixApi.logout()
```
метод вернет ***true***, если все прошло удачно

### login
- Также чтобы не создавать каждый раз новый объект класса ZabbixApi, чтобы начать работу с api. Предусмотрен метод *login(login: String,password: String)*.
В метод нужно передать ***логин типа String и пароль типа String***. Если хотите например начать работу от имени другого пользователя.
```kotlin
login(login: String,password: String)
```
метод вернет ***sessionid типа String***, если все прошло удачно

### getAllHosts
- Чтобы получить данные по всем Host, нужно вызвать метод *getAllHosts()*
```kotlin 
zabbixApi.getAllHosts()
```
метод вернет список объектов ***ResponseHost.Result***

### getHostIdsAndNames
- Чтобы получить список состоящий из ***пар значений <Название Host,IdHost>***, нужно вызвать метод *getHostIdsAndNames()*
```kotlin 
zabbixApi.getHostIdsAndNames()
```
метод вернет список пар значений. ***ArrayList<Pair<String,String>***

### getAllItem
- Чтобы получить все Item конкретного Host, нужно вызвать метод  *getAllItem("idHost")* и ***передать id Host типа строка***
```kotlin 
zabbixApi.getAllItem("10084")
```
метод вернет список объектов ***ResponseItem.Result***

### getEventsForPeriod
- Чтобы получить все Event конкретного Host за период времени, нужно вызвать метод  *getEventsForPeriod("idHost",timeFrom,timeTill)* и ***передать idHost типа строка и время, timeFrom типа Long,timeTill типа Long***.
**Время для запросов должно быть в формате timestamp**, и возвращаются поля с временем в формате timestamp  
```kotlin 
zabbixApi.getEventsForPeriod("18004",1280947920,1596819665)
```
метод вернет список объектов ***ResponseEvent.Result***

### getHistoryItem
- Чтобы получить History конкретного Item за период времени, нужно вызвать метод *getHistoryItem("idItem",timeFrom,timeTill)* и ***передать idItem типа строка и время, timeFrom типа Long,timeTill типа Long***.
**время для запросов должно быть в формате timestamp**, и возвращаются поля с временем а формате timestamp  
```kotlin 
zabbixApi.getHistoryItem("31414",1280947920,1596819665)
```
метод вернет список объектов ***ResponseHistory.Result***


- Чтобы получить данные какого либо из объектов Zabbix Api, передав в запросе дополнительные параметры, нужно создать соответствующий объект для работы с ним.
Реализованы классы для работы с объектами: **Item,Host,History,Event,User,Event.** Пока объекты не содержать все методы которые поддерживает Zabbix Api, но большинство из них содержит реализацию метод get(), который соответствует одноименному запросу в Api.
Пример.
```kotlin 
val requestHost = RequestHost()
requestHost.params.editable = true
val responseHost=zabbixApi.host().get(requestHost)
```


