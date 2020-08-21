Создаем экземпляр объекта ZabbixApi. В констурктор передаем url zabbix api, логин пользователя и пароль. От этого пользователя и будут производиться действия.
После этого можно работать с этим объектом, любые запросы вызванные с помощью объекта будут продлевать сессию созданную им при инициализации, если сессия стала не действительна, то произойдет перелогирование в ZabbixApi используя данные переданные в констурктор zabbixApi при создании объекта.

Чтобы правильно закончить работы с ZabbixApi, нужно стараться завершать сессию путем вызова функции logout.Чтобы не создавать лишние подключения.
zabbixApi.logout()
метод вернет true, если все прошло удачно

Также чтобы не создавать каждый раз новый объект класса ZabbixApi, чтобы начать работу с api. Предусмотрен метод login(login: String,password: String).
В метод нужно передать логин типа String и пароль типа String. Если хотите например начать работу от имени другого пользователя.
login(login: String,password: String)
метод вернет sessionid типа String, если все прошло удачно

val zabbixApi=ZabbixApi()
Чтобы получить даные по всем Host, нужно вызвать метод getAllHosts()
zabbixApi.getAllHosts()
метод вернет список объектов ResponseHost.Result 

чтобы получить cписок состоящий из пар значений <Название Host,Id Host>, нужно вызвать метод zabbixApi.getHostIdsAndNames()
zabbixApi.getHostIdsAndNames()
метод вернет список пар значений. ArrayList<Pair<String,String>

чтобы получить все Item конкретного Host, нужно вызвать метод  zabbixApi.getAllItem("idHost") и передать id Host типа строка
zabbixApi.getAllItem("10084")
метод вернет список объектов ResponseItem.Result 


чтобы получить все Event конкретного Host за период времени, нужно вызвать метод  zabbixApi.getEventsForPeriod("idHost",timeFrom,timeTill) и передать idHost типа строка и время, timeFrom типа Long,timeTill типа Long.
время для запросов должно быть в формате timestamp, и возвращаетються поля с временем а формате timestamp  
zabbixApi.getEventsForPeriod("18004",1280947920,1596819665)
метод вернет список объектов ResponseEvent.Result 


чтобы получить History конкретного Item за период времени, нужно вызвать метод getHistoryItem("idItem",timeFrom,timeTill) и передать idItem типа строка и время, timeFrom типа Long,timeTill типа Long.
время для запросов должно быть в формате timestamp, и возвращаетються поля с временем а формате timestamp  
zabbixApi.getHistoryItem("31414",1280947920,1596819665)
метод вернет список объектов ResponseHistory.Result 


Чтобы получить данные какого либо из объектов Zabbix Api, передав в запроссе дополнительные параметры, нужно создать соответсвующий объект для работы с ним.
Реализованы классы для работы с объектами: Item,Host,History,Event,User,Event. Пока объекты не содержать все методы которые поддерживает Zabbix Api, но большинство из них содержит реализацию метод get(), который соответсвует одноименному запросу в Api.
Пример.

val requestHost = RequestHost()
requestHost.params.editable = true

val responseHost=zabbixApi.host().get(requestHost)



//------------------------------
/*
 val zabbixApi = ZabbixApi(properties.url, properties.user, properties.password)
  
 getAllHosts(): MutableList<ResponseHost.Result>
  
		zabbixApi
		ArrayList<Pair<String,String>
		"hostid","name")
        zabbixApi.getAllItem("10084")
		MutableList<ResponseItem.Result>
		время для запросов должно быть в формате timestamp, и возвращаетються поля с временем а формате timestamp 
        zabbixApi.getHistoryItem("31414",(date1.time / 1000),(date2.time / 1000))
		MutableList<ResponseHistory.Result>
      
	  zabbixApi.getEventsForPeriod("18004",(date1.time / 1000),(date2.time / 1000))
		 MutableList<ResponseEvent.Result>
		 name","acknowledged","clock","ns","severity","source"
*/