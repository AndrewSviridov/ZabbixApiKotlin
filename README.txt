������� ��������� ������� ZabbixApi. � ����������� �������� url zabbix api, ����� ������������ � ������. �� ����� ������������ � ����� ������������� ��������.
����� ����� ����� �������� � ���� ��������, ����� ������� ��������� � ������� ������� ����� ���������� ������ ��������� �� ��� �������������, ���� ������ ����� �� �������������, �� ���������� ��������������� � ZabbixApi ��������� ������ ���������� � ����������� zabbixApi ��� �������� �������.

����� ��������� ��������� ������ � ZabbixApi, ����� ��������� ��������� ������ ����� ������ ������� logout.����� �� ��������� ������ �����������.
zabbixApi.logout()
����� ������ true, ���� ��� ������ ������

����� ����� �� ��������� ������ ��� ����� ������ ������ ZabbixApi, ����� ������ ������ � api. ������������ ����� login(login: String,password: String).
� ����� ����� �������� ����� ���� String � ������ ���� String. ���� ������ �������� ������ ������ �� ����� ������� ������������.
login(login: String,password: String)
����� ������ sessionid ���� String, ���� ��� ������ ������

val zabbixApi=ZabbixApi()
����� �������� ����� �� ���� Host, ����� ������� ����� getAllHosts()
zabbixApi.getAllHosts()
����� ������ ������ �������� ResponseHost.Result 

����� �������� c����� ��������� �� ��� �������� <�������� Host,Id Host>, ����� ������� ����� zabbixApi.getHostIdsAndNames()
zabbixApi.getHostIdsAndNames()
����� ������ ������ ��� ��������. ArrayList<Pair<String,String>

����� �������� ��� Item ����������� Host, ����� ������� �����  zabbixApi.getAllItem("idHost") � �������� id Host ���� ������
zabbixApi.getAllItem("10084")
����� ������ ������ �������� ResponseItem.Result 


����� �������� ��� Event ����������� Host �� ������ �������, ����� ������� �����  zabbixApi.getEventsForPeriod("idHost",timeFrom,timeTill) � �������� idHost ���� ������ � �����, timeFrom ���� Long,timeTill ���� Long.
����� ��� �������� ������ ���� � ������� timestamp, � ��������������� ���� � �������� � ������� timestamp  
zabbixApi.getEventsForPeriod("18004",1280947920,1596819665)
����� ������ ������ �������� ResponseEvent.Result 


����� �������� History ����������� Item �� ������ �������, ����� ������� ����� getHistoryItem("idItem",timeFrom,timeTill) � �������� idItem ���� ������ � �����, timeFrom ���� Long,timeTill ���� Long.
����� ��� �������� ������ ���� � ������� timestamp, � ��������������� ���� � �������� � ������� timestamp  
zabbixApi.getHistoryItem("31414",1280947920,1596819665)
����� ������ ������ �������� ResponseHistory.Result 


����� �������� ������ ������ ���� �� �������� Zabbix Api, ������� � �������� �������������� ���������, ����� ������� �������������� ������ ��� ������ � ���.
����������� ������ ��� ������ � ���������: Item,Host,History,Event,User,Event. ���� ������� �� ��������� ��� ������ ������� ������������ Zabbix Api, �� ����������� �� ��� �������� ���������� ����� get(), ������� ������������ ������������ ������� � Api.
������.

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
		����� ��� �������� ������ ���� � ������� timestamp, � ��������������� ���� � �������� � ������� timestamp 
        zabbixApi.getHistoryItem("31414",(date1.time / 1000),(date2.time / 1000))
		MutableList<ResponseHistory.Result>
      
	  zabbixApi.getEventsForPeriod("18004",(date1.time / 1000),(date2.time / 1000))
		 MutableList<ResponseEvent.Result>
		 name","acknowledged","clock","ns","severity","source"
*/