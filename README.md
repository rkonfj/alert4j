# alert4j
The `alert4j` is the [alertmanager](https://github.com/prometheus/alertmanager) v2 api Java SDK.

### Usage
```java
// Create a singleton AlertManagerV2 Client
AlertManagerV2 v2 = new AlertManagerV2("http://10.1.0.2:9093");

// New CPU Alert
PostableAlert alert1 = new PostableAlert();
alert1.labels().add("alertname", "Alert for cpu overheating");
alert1.setStartsAt(LocalDateTime.now().plusMinutes(-2));
alert1.setEndsAt(LocalDateTime.now());

// New Memory Alert
PostableAlert alert2 = new PostableAlert();
alert2.labels().add("alertname", "Alert for memory greater than 70%");
alert2.setStartsAt(LocalDateTime.now().plusMinutes(-2));
alert2.setEndsAt(LocalDateTime.now());

// Alert to AlertManager
v2.alertsManager().createAlerts(Arrays.asList(alert1, alert2));
```
